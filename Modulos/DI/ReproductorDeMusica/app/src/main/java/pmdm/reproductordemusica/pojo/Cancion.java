package pmdm.reproductordemusica.pojo;

import org.parceler.Parcel;

/**
 * Created by jmpuentenueva on 23/12/2016.
 */
@Parcel
public class Cancion {
    int caratula;
    String titulo;
    String url;

    public Cancion(int caratula, String titulo, String url) {
        this.caratula = caratula;
        this.titulo = titulo;
        this.url = url;
    }

    public Cancion() {
    }

    public int getCaratula() {
        return caratula;
    }

    public void setCaratula(int caratula) {
        this.caratula = caratula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
