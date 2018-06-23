import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class Common {
    public static String cityName = "Seattle";
    public static String state = "WA";
    public static Integer days = 5;
    public static Document loadXMLFromString(String xml) throws Exception
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        return builder.parse(is);
    }
    public static Double kelvinToCelsius(Double kelvin) {
        return kelvin - 273.15;
    }
    public static Double fahrenheitToCelsius(Double fahrenheit) {
        return ((fahrenheit - 32)*5)/9;
    }
}
