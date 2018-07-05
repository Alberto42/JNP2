package xml;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "provider")
public class DailyWeatherSummary {

    @XmlAttribute
    private int day;
    @XmlElement
    private Providers providers;
    public DailyWeatherSummary() {
        ArrayList<ProviderSummary> providerSummaries = new ArrayList<ProviderSummary>();
        providerSummaries.add(new ProviderSummary("name",5,10));
        providerSummaries.add(new ProviderSummary("name2",5,10));
        providers = new Providers(providerSummaries);
        day = 42;
    }
}
