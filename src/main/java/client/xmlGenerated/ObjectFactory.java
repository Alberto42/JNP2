
package main.java.client.xmlGenerated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.weathercomparator package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _WeatherSummary_QNAME = new QName("http://www.example.org/WeatherComparator/", "weatherSummary");
    private final static QName _Provider_QNAME = new QName("http://www.example.org/WeatherComparator/", "provider");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.weathercomparator
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DailyWeatherSummary }
     * 
     */
    public DailyWeatherSummary createDailyWeatherSummary() {
        return new DailyWeatherSummary();
    }

    /**
     * Create an instance of {@link WeatherSummary }
     * 
     */
    public WeatherSummary createWeatherSummary() {
        return new WeatherSummary();
    }

    /**
     * Create an instance of {@link ManyDays }
     * 
     */
    public ManyDays createManyDays() {
        return new ManyDays();
    }

    /**
     * Create an instance of {@link ProviderSummary }
     * 
     */
    public ProviderSummary createProviderSummary() {
        return new ProviderSummary();
    }

    /**
     * Create an instance of {@link Providers }
     * 
     */
    public Providers createProviders() {
        return new Providers();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeatherSummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WeatherComparator/", name = "weatherSummary")
    public JAXBElement<WeatherSummary> createWeatherSummary(WeatherSummary value) {
        return new JAXBElement<WeatherSummary>(_WeatherSummary_QNAME, WeatherSummary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DailyWeatherSummary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WeatherComparator/", name = "provider")
    public JAXBElement<DailyWeatherSummary> createProvider(DailyWeatherSummary value) {
        return new JAXBElement<DailyWeatherSummary>(_Provider_QNAME, DailyWeatherSummary.class, null, value);
    }

}
