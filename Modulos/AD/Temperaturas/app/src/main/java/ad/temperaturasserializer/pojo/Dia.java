package ad.temperaturasserializer.pojo;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.Date;

/**
 * Created by Jose on 08/11/2016.
 */
@Root
public class Dia {
    @Attribute
    Date fecha;
    @Element
    Temperatura temperatura;

    public Dia(Date fecha, Temperatura temperatura) {
        this.fecha = fecha;
        this.temperatura = temperatura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Temperatura getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Temperatura temperatura) {
        this.temperatura = temperatura;
    }
}
