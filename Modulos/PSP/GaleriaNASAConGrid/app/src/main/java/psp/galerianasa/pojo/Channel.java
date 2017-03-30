package psp.galerianasa.pojo;

import org.parceler.Parcel;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by jmpuentenueva on 04/11/2016.
 */
@Parcel
@Root(name = "channel")
public class Channel {
    @Element(name = "title", required = false)
    String titulo;
    @Element (name = "description", required = false)
    String descripcion;
    @Element (name = "atom:link", required = false)
    String link2;
    @Element (name = "language", required = false)
    String idioma;
    @Element (name = "managingEditor", required = false)
    String editor;
    @Element (required = false)
    String webMaster;
    @Element (required = false)
    String docs;
    @ElementList(name = "item", inline = true)
    List<Imagen> imagenes;

    public Channel() {

    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }
}
