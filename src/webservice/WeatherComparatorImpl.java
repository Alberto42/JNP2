package webservice;

import weatherClient.*;
import xml.*;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@WebService(targetNamespace = "http://www.example.org/WeatherComparator/",
	serviceName = "WeatherComparator",
	portName = "WeatherComparatorSOAP",
	endpointInterface = "webservice.WeatherComparator",
	wsdlLocation = "WEB-INF/wsdl/WeatherComparator.wsdl")

public class WeatherComparatorImpl implements WeatherComparator {
    private List<ForecastData> fetchForecasts(Integer maxDay) {
        Driver apixuDriver = new ApixuDriver();
        Driver openWeatherAPIDriver = new OpenWeatherAPIDriver();
        Driver yahooDriver = new YahooDriver();
        ForecastData forecastDataApixu = apixuDriver.getForecastData(maxDay);
        ForecastData forecastDataOpenWeather = openWeatherAPIDriver.getForecastData(maxDay);
        ForecastData forecastDataYahoo = yahooDriver.getForecastData(maxDay);
        return Arrays.asList(forecastDataApixu,forecastDataOpenWeather,forecastDataYahoo);
    }
	public void compareForecast(ManyDays args, javax.xml.ws.Holder<WeatherSummary> result) {
	    Integer maxDay = Collections.max(args.getArg());
        List<ForecastData> forecastDataList = fetchForecasts(maxDay);

        List<DailyWeatherSummary> dailyWeatherSummaries = new ArrayList<>();
        for(Integer day : args.getArg()) {
            Integer index = day -1;
            List<ProviderSummary> providerSummaries = new ArrayList<>();
            for(ForecastData forecastData : forecastDataList) {
                ProviderSummary providerSummary = new ProviderSummary(forecastData.getProviderName(),
                        forecastData.getMinTemperatures().get(index),
                        forecastData.getMaxTemperatures().get(index));
                providerSummaries.add(providerSummary);
            }
            Providers providers = new Providers(providerSummaries);
            DailyWeatherSummary weather = new DailyWeatherSummary(day,providers);
            dailyWeatherSummaries.add(weather);
        }
        result.value = new WeatherSummary(dailyWeatherSummaries);
    }

}