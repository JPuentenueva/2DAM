package di.listaversionesandroid;

import android.graphics.Bitmap;

/**
 * Created by jmpuentenueva on 21/10/2016.
 */

public class VersionesAndroid {
    int iconoVersion;
    String nombre;

    public VersionesAndroid(int iconoVersion, String nombre) {
        this.iconoVersion = iconoVersion;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumVersion() {
        return iconoVersion;
    }

    public void setNumVersion(int numVersion) {
        this.iconoVersion = numVersion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
