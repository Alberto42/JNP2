import org.w3c.dom.Document;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.util.ArrayList;
import java.util.List;

public class ApixuDriver implements Driver {
    private static final String link = "http://api.apixu.com/v1/forecast.xml?";
    private static final String key = "3a8ff0e630dc4e4596d150132182206";
    private static final String XPATH_MAX = "*//forecastday[%d]/day/maxtemp_c";
    private static final String XPATH_MIN = "*//forecastday[%d]/day/mintemp_c";

    public ForecastData getForecastData() {
        try {
            Client client = ClientBuilder.newClient();

            WebTarget target = client.target(link);
            target = target.queryParam("key", key).queryParam("q", Common.cityName)
                    .queryParam("days", Common.days+1);

            String xml = target.request(MediaType.APPLICATION_XML).get(String.class);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringElementContentWhitespace(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = Common.loadXMLFromString(xml);

            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();

            List<Double> maxTemperatures = selectTemperatures(doc, xpath,XPATH_MAX);
            List<Double> minTemperatures = selectTemperatures(doc, xpath,XPATH_MIN);

            assert(minTemperatures.size() == maxTemperatures.size());
            for(int i=0;i<minTemperatures.size();i++) {
                assert(minTemperatures.get(i) <= maxTemperatures.get(i));
            }

            return new ForecastData(minTemperatures,maxTemperatures);
        } catch (Exception e) {
            return null;
        }
    }

    private List<Double> selectTemperatures(Document doc, XPath xpath, String xpathPattern) throws XPathExpressionException {
        List<Double> maxTemperatures = new ArrayList<Double>() {};
        for(int i=2;;i++) {
            String xpathq = String.format(xpathPattern,i);

            XPathExpression expr = xpath.compile(xpathq);
            String s = expr.evaluate(doc);
            if (s.equals(""))
                return maxTemperatures;
            Double maxTemperatureCelsius = Double.parseDouble(s);
            maxTemperatures.add(maxTemperatureCelsius);
        }
    }

}
