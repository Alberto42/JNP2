package xml;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "weatherSummary")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeatherSummary {
    @XmlElements(@XmlElement(name="dailyWeather"))

    private List<DailyWeatherSummary> summaries;

    public WeatherSummary(List<DailyWeatherSummary> summaries) {
        this.summaries = summaries;
    }

    public WeatherSummary() {
    }
}
