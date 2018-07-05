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

    @XmlElement
    private double avgMinTemperature;
    @XmlElement
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
