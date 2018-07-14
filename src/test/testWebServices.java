package test;//import  javax.xml.rpc.encoding.TypeMappingRegistry

import weatherClient.*;

public class testWebServices {
    public static void main(String [] args) {
        Driver apixuDriver = new ApixuDriver();
        Driver openWeatherAPIDriver = new OpenWeatherAPIDriver();
        Driver yahooDriver = new YahooDriver();
//        ForecastData forecastDataApixu = apixuDriver.getForecastData();
//        ForecastData forecastDataOpenWeather = openWeatherAPIDriver.getForecastData();
//        ForecastData forecastDataYahoo = yahooDriver.getForecastData();
//        int i = 5;
    }
}
