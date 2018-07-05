package xml;

import javax.persistence.criteria.CriteriaBuilder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class ProviderSummary {
    private String name;
    private Integer maxTemperature;
    private Integer minTemperature;

    public ProviderSummary(String name, Integer maxTemperature, Integer minTemperature) {
        this.name = name;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
    }
}
