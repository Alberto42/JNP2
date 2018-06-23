import java.util.List;

public class ForecastData {
    List<Double> minTemperatures;
    List<Double> maxTemperatures;

    public ForecastData(List<Double> minTemperatures, List<Double> maxTemperatures) {
        assert(minTemperatures.size() == maxTemperatures.size() && maxTemperatures.size() == Common.days);
        for(int i=0;i<minTemperatures.size();i++) {
            assert(minTemperatures.get(i) <= maxTemperatures.get(i));
        }

        this.minTemperatures = minTemperatures;
        this.maxTemperatures = maxTemperatures;
    }
}
