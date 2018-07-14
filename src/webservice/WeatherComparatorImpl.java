package webservice;

import weatherClient.*;
import xml.*;

import javax.jws.WebService;
import javax.xml.ws.Holder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.stream.DoubleStream;

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
            double avgMinTemperature = calcMinAverage(providerSummaries);
            double avgMaxTemperature = calcMaxAverage(providerSummaries);
            double minAmplitude = calcMinAmplitude(providerSummaries);
            double maxAmplitude = calcMaxAmplitude(providerSummaries);
            DailyWeatherSummary weather = new DailyWeatherSummary(day,providers,avgMinTemperature,
                    avgMaxTemperature,minAmplitude,maxAmplitude);
            dailyWeatherSummaries.add(weather);
        }
        result.value = new WeatherSummary(dailyWeatherSummaries);
    }

    @Override
    public void compareForecastPeriod(int day, Holder<WeatherSummary> summary) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=day;i++) {
            list.add(i);
        }
        ManyDays days = new ManyDays(list);
        compareForecast(days,summary);
    }

    private double calcAverage(List<ProviderSummary> providerSummaries,
                               ToDoubleFunction<ProviderSummary> providerSummaryToDoubleFunction) {
        return providerSummaries.stream().mapToDouble(providerSummaryToDoubleFunction).average()
                .orElseThrow(() -> new RuntimeException("No data!"));
    }

    private double calcMinAverage(List<ProviderSummary> providerSummaries) {
        return calcAverage(providerSummaries,p -> p.getMinTemperature());
    }
    private double calcMaxAverage(List<ProviderSummary> providerSummaries) {
        return calcAverage(providerSummaries,p -> p.getMaxTemperature());
    }

    private double calcAmplitude(List<ProviderSummary> providerSummaries,
                                 ToDoubleFunction<ProviderSummary> providerSummaryToDoubleFunction) {
        Double max = providerSummaries.stream().mapToDouble(providerSummaryToDoubleFunction).max()
                .orElseThrow(() -> new RuntimeException("No data!"));
        Double min = providerSummaries.stream().mapToDouble(providerSummaryToDoubleFunction).min()
                .orElseThrow(() -> new RuntimeException("No data!"));
        return max - min;
    }

    private double calcMinAmplitude(List<ProviderSummary> providerSummaries) {
        return calcAmplitude(providerSummaries,p -> p.getMinTemperature());
    }

    private double calcMaxAmplitude(List<ProviderSummary> providerSummaries) {
        return calcAmplitude(providerSummaries,p -> p.getMaxTemperature());
    }

}