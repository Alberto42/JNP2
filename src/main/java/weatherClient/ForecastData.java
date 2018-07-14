package main.java.weatherClient;

import java.util.List;

public class ForecastData {
    String providerName;
    List<Double> minTemperatures;
    List<Double> maxTemperatures;

    public ForecastData(List<Double> minTemperatures, List<Double> maxTemperatures,Integer days, String providerName) {
        assert(minTemperatures.size() == maxTemperatures.size() && maxTemperatures.size() == days);
        for(int i=0;i<minTemperatures.size();i++) {
            assert(minTemperatures.get(i) <= maxTemperatures.get(i));
        }

        this.minTemperatures = minTemperatures;
        this.maxTemperatures = maxTemperatures;
        this.providerName = providerName;
    }

    public String getProviderName() {
        return providerName;
    }

    public List<Double> getMinTemperatures() {
        return minTemperatures;
    }

    public List<Double> getMaxTemperatures() {
        return maxTemperatures;
    }
}
