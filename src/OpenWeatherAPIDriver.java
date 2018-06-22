import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OpenWeatherAPIDriver implements Driver {
    private static final String link = "http://api.openweathermap.org/data/2.5/forecast?";
    private static final String key = "3f29fac508f757981a00860845a20f85";
    public static final String XPATH = "/weatherdata/forecast/time";

    public ForecastData getForecastData() {
        try {
            Client client = ClientBuilder.newClient();

            WebTarget target = client.target(link);
            target = target.queryParam("q", Common.cityName + ",us").queryParam("mode", "xml")
                    .queryParam("APPID", key);

            String xml = target.request(MediaType.APPLICATION_XML).get(String.class);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringElementContentWhitespace(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = Common.loadXMLFromString(xml);

            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();

            XPathExpression expr = xpath.compile(XPATH);
            NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            String lastDate = "";

            List<Double> minT = new ArrayList<Double>();
            List<Double> maxT = new ArrayList<Double>();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (isFuture(node)) {

                    String date = getDate(node);
                    NamedNodeMap t = node.getChildNodes().item(4).getAttributes();
                    Double minTemperature = Common.kelvinToCelsius(Double.parseDouble(t.getNamedItem("min").getNodeValue()));
                    Double maxTemperature = Common.kelvinToCelsius(Double.parseDouble(t.getNamedItem("max").getNodeValue()));
                    if (date != lastDate) {
                        minT.add(minTemperature);
                        maxT.add(maxTemperature);
                        lastDate = date;
                    } else {
                        int lastIndex = minT.size() - 1;
                        Double lastMin = minT.get(lastIndex);
                        Double lastMax = maxT.get(lastIndex);
                        minT.set(lastIndex, Math.min(lastMin, minTemperature));
                        maxT.set(lastIndex, Math.max(lastMax, maxTemperature));
                    }
                }
            }
            return new ForecastData(minT,maxT);
        } catch (Exception e) {
            return null;
        }
    }

    private String getDate(Node node) {
        String dateTime = node.getAttributes().getNamedItem("from").getNodeValue();
        Pattern pattern = Pattern.compile("[0-9]*-[0-9]*-[0-9]*(?=T)");
        Matcher matcher = pattern.matcher(dateTime);
        assert (matcher.find());
        String date = matcher.group();
        return date;
    }

    private Boolean isFuture(Node node) {
        String date = getDate(node);
        Pattern pattern = Pattern.compile("(?<=-)[0-9]*$");
        Matcher matcher = pattern.matcher(date);
        assert (matcher.find());
        String day = matcher.group();
        Date today = new Date();
        return today.getDay() < Integer.parseInt(day);
    }
}
