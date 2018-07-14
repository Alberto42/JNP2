package main.java.test;//import  javax.main.java.xml.rpc.encoding.TypeMappingRegistry

import main.java.weatherClient.*;

/*
Klasa do przetestowania za pomocą debuggera czy odpowiednia ForecastData sie wczytuje.
Kazdego dnia jest inna prognoza pogody wiec nie pisalem automatycznych testow.
 */
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
