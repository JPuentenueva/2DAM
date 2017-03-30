package psp.galerianasa.pojo;

import android.support.annotation.AttrRes;

import org.parceler.Parcel;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by jmpuentenueva on 04/11/2016.
 */
@Parcel
@Root
public class Enclosure {
    @Attribute
    String url;
    @Attribute (required = false)
    long lenght;
    @Attribute (required = false)
    String type;

    public Enclosure() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
