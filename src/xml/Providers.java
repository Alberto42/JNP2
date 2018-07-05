package xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import java.util.List;

public class Providers {
    @XmlElements(@XmlElement(name = "provider"))
    public List<ProviderSummary> providers;

    public Providers(List<ProviderSummary> providers) {
        this.providers = providers;
    }
}
