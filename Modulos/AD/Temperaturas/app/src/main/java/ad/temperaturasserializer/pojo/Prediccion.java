package ad.temperaturasserializer.pojo;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Jose on 08/11/2016.
 */
@Root
public class Prediccion {
    @ElementList (name = "dia")
    List<Dia> dias;

    public Prediccion(List<Dia> dias) {
        this.dias = dias;
    }

    public List<Dia> getDias() {
        return dias;
    }

    public void setDias(List<Dia> dias) {
        this.dias = dias;
    }
}
