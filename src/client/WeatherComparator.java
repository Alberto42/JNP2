package client;

import xml.ManyDays;
import xml.WeatherSummary;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

public interface WeatherComparator {
    @WebMethod
    public void compareForecast(
            @WebParam(partName = "forecastDays", name = "forecastDays")
                    ManyDays args,
            @WebParam(partName = "result", mode = WebParam.Mode.OUT, name = "result")
                    javax.xml.ws.Holder<WeatherSummary> summary
    );
}
