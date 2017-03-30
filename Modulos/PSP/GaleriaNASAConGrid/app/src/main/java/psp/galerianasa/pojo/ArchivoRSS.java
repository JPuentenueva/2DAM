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
@Root (name = "rss")
public class ArchivoRSS {
    @Element
    Channel channel;

    public ArchivoRSS() {

    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}



