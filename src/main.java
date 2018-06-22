public class main {
    public static void main(String [] args) {
        Driver apixuDriver = new OpenWeatherAPIDriver();
        ForecastData forecastData = apixuDriver.getForecastData();
        int i = 5;
    }
}
