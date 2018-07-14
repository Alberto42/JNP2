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
        printFileContents("instruction");
        System.exit(1);
    }
    public static void main(String[] args) throws IOException {
        WeatherComparatorService service = new WeatherComparatorService();
        WeatherComparator port = service.getWeatherComparatorSOAP();

        try {
            if (args.length == 0) {
                exit();
            } else if (args[0] == "-s") {
                List<Integer> days = new ArrayList<Integer>();
                for (int i = 1; i < args.length; i++) {
                    days.add(Integer.parseInt(args[i]));

                    Holder<WeatherSummary> result = new Holder<WeatherSummary>();

                    port.compareForecast(new ManyDays(days),result);



                }
            } else {
                exit();
            }
        } catch(NumberFormatException e) {
            exit();
        }

    }
}
