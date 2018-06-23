package webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(targetNamespace = "http://www.example.org/WeatherComparator/",
	name = "WeatherComparator",
	wsdlLocation = "WEB-INF/wsdl/WeatherComparator.wsdl")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WeatherComparator {

    @WebMethod(action = "http://www.example.org/WeatherComparator/mul")
    @WebResult(name = "result", targetNamespace = "http://www.example.org/WeatherComparator/", partName = "result")
    public int mul(
            @WebParam(partName = "arg1", name = "arg1")
                    int arg1,
            @WebParam(partName = "arg2", name = "arg2")
                    int arg2
    );
}
