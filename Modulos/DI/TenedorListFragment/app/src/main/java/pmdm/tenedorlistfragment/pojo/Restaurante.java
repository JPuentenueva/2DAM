package pmdm.tenedorlistfragment.pojo;

/**
 * Created by jmpuentenueva on 07/11/2016.
 */

public class Restaurante {
    String urlFoto;
    String nombre;
    String ciudad;
    double valoracionMedia;

    public Restaurante(String urlFoto, double valoracionMedia, String ciudad, String nombre) {
        this.urlFoto = urlFoto;
        this.valoracionMedia = valoracionMedia;
        this.ciudad = ciudad;
        this.nombre = nombre;
    }

    public Restaurante() {

    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public double getValoracionMedia() {
        return valoracionMedia;
    }

    public void setValoracionMedia(double valoracionMedia) {
        this.valoracionMedia = valoracionMedia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
