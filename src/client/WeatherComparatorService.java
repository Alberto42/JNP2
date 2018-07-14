package client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherComparatorService extends Service {

    private final static URL WEATHERCOMPARATORSERVICE_WSDL_LOCATION;
    private final static WebServiceException WEATHERCOMPARATORSERVICE_EXCEPTION;
    private static final String NAMESPACE_URI = "http://www.example.org/WeatherComparator/";
    private final static QName WEATHERCOMPARATORSERVICE_QNAME = new QName(NAMESPACE_URI, "WeatherComparatorService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/unnamed/WeatherComparator");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEATHERCOMPARATORSERVICE_WSDL_LOCATION = url;
        WEATHERCOMPARATORSERVICE_EXCEPTION = e;
    }
    protected WeatherComparatorService(URL wsdlDocumentLocation, QName serviceName) {
        super(wsdlDocumentLocation, serviceName);
    }

    protected WeatherComparatorService(URL wsdlDocumentLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlDocumentLocation, serviceName, features);
    }

    public WeatherComparator getWeatherComparatorPort(WebServiceFeature... features) {
        return super.getPort(new QName(NAMESPACE_URI, "WeatherComparatorPort"),
                WeatherComparator.class, features);
    }

    public WeatherComparatorService() {
        super(__getWsdlLocation(), WEATHERCOMPARATORSERVICE_QNAME);
    }

    private static URL __getWsdlLocation() {
        if (WEATHERCOMPARATORSERVICE_EXCEPTION!= null) {
            throw WEATHERCOMPARATORSERVICE_EXCEPTION;
        }
        return WEATHERCOMPARATORSERVICE_WSDL_LOCATION;
    }
}
