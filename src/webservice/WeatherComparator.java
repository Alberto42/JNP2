package webservice;

import xml.ManyDays;
import xml.WeatherSummary;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(targetNamespace = "http://www.example.org/WeatherComparator/",
	name = "WeatherComparator",
	wsdlLocation = "WEB-INF/wsdl/WeatherComparator.wsdl")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WeatherComparator {

    @WebMethod(action = "http://www.example.org/WeatherComparator/compareForecast")
    public void compareForecast(
            @WebParam(partName = "forecastDays", name = "forecastDays")
                    ManyDays args,
            @WebParam(partName = "result", mode = WebParam.Mode.OUT, name = "result")
                    javax.xml.ws.Holder<WeatherSummary> summary
    );
    @WebMethod(action = "http://www.example.org/WeatherComparator/compareForecastPeriod")
    public void compareForecastPeriod(
            @WebParam(partName = "forecastPeriod", name = "forecastPeriod")
                    int day,
            @WebParam(partName = "result", mode = WebParam.Mode.OUT, name = "result")
                    javax.xml.ws.Holder<WeatherSummary> summary
    );
}
