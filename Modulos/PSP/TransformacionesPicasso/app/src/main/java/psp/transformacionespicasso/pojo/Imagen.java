package psp.transformacionespicasso.pojo;

import org.parceler.Parcel;

/**
 * Created by jmpuentenueva on 08/11/2016.
 */
@Parcel
public class Imagen {
    int url;

    public Imagen() {
    }

    public Imagen(int url) {
        this.url = url;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }
}
