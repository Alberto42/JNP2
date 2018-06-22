import java.util.List;

public class ForecastData {
    List<Double> minTemperatures;
    List<Double> maxTemperatures;

    public ForecastData(List<Double> minTemperatures, List<Double> maxTemperatures) {
        this.minTemperatures = minTemperatures;
        this.maxTemperatures = maxTemperatures;
    }
}
