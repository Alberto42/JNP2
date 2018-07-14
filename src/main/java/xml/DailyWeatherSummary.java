package main.java.xml;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "provider")
public class DailyWeatherSummary {

    @XmlAttribute
    private int day;
    @XmlElement
    private Providers providers;

    @XmlElement(name="avgMinTemperature")
    private double avgMinTemperature;
    @XmlElement(name="avgMaxTemperature")
    private double avgMaxTemperature;
    @XmlElement
    private double minAmplitude;
    @XmlElement
    private double maxAmplitude;

    public DailyWeatherSummary(int day, Providers providers, double avgMinTemperature, double avgMaxTemperature, double minAmplitude, double maxAmplitude) {
        this.day = day;
        this.providers = providers;
        this.avgMinTemperature = avgMinTemperature;
        this.avgMaxTemperature = avgMaxTemperature;
        this.minAmplitude = minAmplitude;
        this.maxAmplitude = maxAmplitude;
    }

    public DailyWeatherSummary() {
    }
}
