
package client.xmlGenerated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for weatherSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="weatherSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dailyWeather" type="{http://www.example.org/WeatherComparator/}dailyWeatherSummary" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "weatherSummary", propOrder = {
    "dailyWeather"
})
public class WeatherSummary {

    protected List<DailyWeatherSummary> dailyWeather;

    /**
     * Gets the value of the dailyWeather property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dailyWeather property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDailyWeather().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DailyWeatherSummary }
     * 
     * 
     */
    public List<DailyWeatherSummary> getDailyWeather() {
        if (dailyWeather == null) {
            dailyWeather = new ArrayList<DailyWeatherSummary>();
        }
        return this.dailyWeather;
    }

}
