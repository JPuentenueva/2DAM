package ad.serializerbasico.pojo;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by jmpuentenueva on 02/11/2016.
 */
@Root
public class Coche {
    @Element
    String modelo;

    @Attribute
    String color;

    public Coche(String color, String modelo) {
        this.color = color;
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


}
