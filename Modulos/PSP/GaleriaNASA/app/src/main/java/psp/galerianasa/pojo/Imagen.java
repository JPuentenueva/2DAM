package psp.galerianasa.pojo;

import org.parceler.Parcel;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by jmpuentenueva on 04/11/2016.
 */

@Parcel
@Root(name = "item")
public class Imagen {
    @Element(name = "title")
    String nombre;
    @Element (required = false)
    String link;
    @Element(name = "description",required = false)
    String descripcion;
    @Element(name = "enclosure")
    Enclosure url;
    @Element (required = false)
    String guid;
    @Element (name = "pubDate")
    String fecha;
    @Element (required = false)
    String source;

    public Imagen() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Enclosure getUrl() {
        return url;
    }

    public void setUrl(Enclosure url) {
        this.url = url;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}