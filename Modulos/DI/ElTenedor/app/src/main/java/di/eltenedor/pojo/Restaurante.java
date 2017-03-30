package di.eltenedor.pojo;

import android.os.Parcelable;

import org.parceler.Parcel;

import java.util.List;

/**
 * Created by Jose on 31/01/2017.
 */
@Parcel
public class Restaurante {
    String nombre;
    String direccion;
    int valoracion;
    List<String> etiquetas;
    int imagenDetalle;

    public Restaurante() {

    }

    public Restaurante(String nombre, String direccion, int valoracion, List<String> etiquetas, int imagenDetalle) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.valoracion = valoracion;
        this.etiquetas = etiquetas;
        this.imagenDetalle = imagenDetalle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public List<String> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<String> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public int getImagenDetalle() {
        return imagenDetalle;
    }

    public void setImagenDetalle(int imagenDetalle) {
        this.imagenDetalle = imagenDetalle;
    }
}
