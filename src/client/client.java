package client;

import javax.xml.ws.Holder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class client {

    private static void printFileContents(String name) throws IOException {
        File file = new File(name);
        FileInputStream fis = new FileInputStream(file);

        int oneByte;
        while ((oneByte = fis.read()) != -1) {
            System.out.write(oneByte);
            // System.out.print((char)oneByte); // could also do this
        }
        System.out.flush();
    }
    private static void exit() throws IOException {
        printFileContents("resources/instruction");
        System.exit(1);
    }
    public static void main(String[] args) throws IOException {
        WeatherComparatorService service = new WeatherComparatorService();
        WeatherComparator port = service.getWeatherComparatorSOAP();

        try {
            if (args.length == 0) {
                exit();
            } else if (args[0].equals("-s") ) {
                List<Integer> days = new ArrayList<Integer>();
                for (int i = 1; i < args.length; i++) {
                    days.add(Integer.parseInt(args[i]));
                }

                Holder<WeatherSummary> result = new Holder<WeatherSummary>();

                port.compareForecast(new ManyDays(days),result);

                for(DailyWeatherSummary dailyWeather : result.value.dailyWeather) {
                    System.out.println("Prognoza pogody dla dnia " + dailyWeather.day);
                    System.out.println("Maksymalna(uśredniona) temperatura: " + dailyWeather.avgMaxTemperature);
                    System.out.println("Minimalna(uśredniona) temperatura: " + dailyWeather.avgMinTemperature);
                    System.out.println("Różnica w maksymalnej temperaturze podawanej przez serwisy " + dailyWeather.maxAmplitude);
                    System.out.println("Różnica w minimalnej temperaturze podawanej przez serwisy " + dailyWeather.minAmplitude);
                    System.out.println("");
                }

            } else {
                exit();
            }
        } catch(NumberFormatException e) {
            exit();
        }

    }
}
