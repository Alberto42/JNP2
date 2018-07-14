package main.java.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ProviderSummary {
    private String name;
    private Double minTemperature;
    private Double maxTemperature;

    public ProviderSummary(String name, Double minTemperature, Double maxTemperature) {
        this.name = name;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }
}
