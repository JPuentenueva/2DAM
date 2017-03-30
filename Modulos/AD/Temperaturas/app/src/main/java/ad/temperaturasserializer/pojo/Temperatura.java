package ad.temperaturasserializer.pojo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Jose on 08/11/2016.
 */
@Root
public class Temperatura {
    @Element
    String maxima;
    @Element
    String minima;

    public Temperatura(String maxima, String minima) {
        this.maxima = maxima;
        this.minima = minima;
    }

    public String getMaxima() {
        return maxima;
    }

    public void setMaxima(String maxima) {
        this.maxima = maxima;
    }

    public String getMinima() {
        return minima;
    }

    public void setMinima(String minima) {
        this.minima = minima;
    }
}
