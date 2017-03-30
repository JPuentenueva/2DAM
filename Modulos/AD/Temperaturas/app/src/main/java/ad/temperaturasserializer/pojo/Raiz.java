package ad.temperaturasserializer.pojo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Jose on 08/11/2016.
 */
@Root
public class Raiz {
    @Element
    String nombre;
    @Element
    String provincia;
    @ElementList
    Prediccion prediccion;

    public Raiz(String nombre, String provincia, Prediccion prediccion) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.prediccion = prediccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Prediccion getPrediccion() {
        return prediccion;
    }

    public void setPrediccion(Prediccion prediccion) {
        this.prediccion = prediccion;
    }
}
