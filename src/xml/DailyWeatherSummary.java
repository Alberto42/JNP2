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

    public DailyWeatherSummary(int day, Providers providers) {
        this.day = day;
        this.providers = providers;
    }

    public DailyWeatherSummary() {
    }
}
