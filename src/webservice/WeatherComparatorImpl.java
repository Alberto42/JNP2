package webservice;

import xml.DailyWeatherSummary;
import xml.ManyInts;
import xml.WeatherSummary;

import javax.jws.WebService;
import java.util.ArrayList;

@WebService(targetNamespace = "http://www.example.org/WeatherComparator/",
	serviceName = "WeatherComparator",
	portName = "WeatherComparatorSOAP",
	endpointInterface = "webservice.WeatherComparator",
	wsdlLocation = "WEB-INF/wsdl/WeatherComparator.wsdl")
public class WeatherComparatorImpl implements WeatherComparator {
	public void compareForecast(ManyInts args, javax.xml.ws.Holder<WeatherSummary> result) {
		ArrayList<DailyWeatherSummary> dailyWeatherSummaries = new ArrayList<DailyWeatherSummary>();
		dailyWeatherSummaries.add(new DailyWeatherSummary());
		dailyWeatherSummaries.add(new DailyWeatherSummary());
		result.value = new WeatherSummary(dailyWeatherSummaries);
	}

}