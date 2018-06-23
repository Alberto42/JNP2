import org.w3c.dom.Document;
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
import java.util.List;

public class YahooDriver implements Driver{
    private static final String link = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22Seattle%22)&format=xml&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
    public ForecastData getForecastData() {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(link);
            String xml = target.request(MediaType.APPLICATION_XML).get(String.class);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringElementContentWhitespace(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = Common.loadXMLFromString(xml);

            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();

            XPathExpression expr = xpath.compile("*//forecast");
            NodeList s = (NodeList)expr.evaluate(doc, XPathConstants.NODESET);

            List<Double> maxTemperatures = new ArrayList<Double>();
            List<Double> minTemperatures = new ArrayList<Double>();

            for(int i=0;i<s.getLength();i++) {
                Node node = s.item(i);
                String lowT = node.getAttributes().getNamedItem("low").getNodeValue();
                String highT = node.getAttributes().getNamedItem("high").getNodeValue();
                minTemperatures.add(Common.fahrenheitToCelsius(Double.parseDouble(lowT)));
                maxTemperatures.add(Common.fahrenheitToCelsius(Double.parseDouble(highT)));
            }

            if (minTemperatures.size() > Common.days)
                minTemperatures = minTemperatures.subList(0,Common.days);
            if (maxTemperatures.size() > Common.days)
                maxTemperatures = maxTemperatures.subList(0,Common.days);

            return new ForecastData(minTemperatures,maxTemperatures);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
