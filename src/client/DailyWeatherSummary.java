
package client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dailyWeatherSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dailyWeatherSummary">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="providers" type="{http://www.example.org/WeatherComparator/}providers" minOccurs="0"/>
 *         &lt;element name="avgMinTemperature" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="avgMaxTemperature" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="minAmplitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxAmplitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *       &lt;attribute name="day" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dailyWeatherSummary", propOrder = {
    "providers",
    "avgMinTemperature",
    "avgMaxTemperature",
    "minAmplitude",
    "maxAmplitude"
})
public class DailyWeatherSummary {

    protected Providers providers;
    protected double avgMinTemperature;
    protected double avgMaxTemperature;
    protected double minAmplitude;
    protected double maxAmplitude;
    @XmlAttribute(name = "day", required = true)
    protected int day;

    /**
     * Gets the value of the providers property.
     * 
     * @return
     *     possible object is
     *     {@link Providers }
     *     
     */
    public Providers getProviders() {
        return providers;
    }

    /**
     * Sets the value of the providers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Providers }
     *     
     */
    public void setProviders(Providers value) {
        this.providers = value;
    }

    /**
     * Gets the value of the avgMinTemperature property.
     * 
     */
    public double getAvgMinTemperature() {
        return avgMinTemperature;
    }

    /**
     * Sets the value of the avgMinTemperature property.
     * 
     */
    public void setAvgMinTemperature(double value) {
        this.avgMinTemperature = value;
    }

    /**
     * Gets the value of the avgMaxTemperature property.
     * 
     */
    public double getAvgMaxTemperature() {
        return avgMaxTemperature;
    }

    /**
     * Sets the value of the avgMaxTemperature property.
     * 
     */
    public void setAvgMaxTemperature(double value) {
        this.avgMaxTemperature = value;
    }

    /**
     * Gets the value of the minAmplitude property.
     * 
     */
    public double getMinAmplitude() {
        return minAmplitude;
    }

    /**
     * Sets the value of the minAmplitude property.
     * 
     */
    public void setMinAmplitude(double value) {
        this.minAmplitude = value;
    }

    /**
     * Gets the value of the maxAmplitude property.
     * 
     */
    public double getMaxAmplitude() {
        return maxAmplitude;
    }

    /**
     * Sets the value of the maxAmplitude property.
     * 
     */
    public void setMaxAmplitude(double value) {
        this.maxAmplitude = value;
    }

    /**
     * Gets the value of the day property.
     * 
     */
    public int getDay() {
        return day;
    }

    /**
     * Sets the value of the day property.
     * 
     */
    public void setDay(int value) {
        this.day = value;
    }

}
