package webservice;

import javax.jws.WebService;

@WebService(targetNamespace = "http://www.example.org/WeatherComparator/",
	serviceName = "WeatherComparator",
	portName = "WeatherComparatorSOAP",
	endpointInterface = "webservice.WeatherComparator",
	wsdlLocation = "WEB-INF/wsdl/WeatherComparator.wsdl")
public class WeatherComparatorImpl implements WeatherComparator {
	public int mul(int arg1, int arg2) {
		return arg1 * arg2;
	}

}