package xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import java.util.List;

public class Providers {
    public Providers(List<ProviderSummary> providers) {
        this.providers = providers;
    }

    @XmlElements(@XmlElement(name="provider"))
    public List<ProviderSummary> providers;
}
