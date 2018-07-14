package client;

public class client {
    public static void main(String[] args) {
        WeatherComparatorService service = new WeatherComparatorService();
        WeatherComparator port = service.getWeatherComparatorPort();
    }
}
