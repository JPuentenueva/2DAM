package di.putaditagridviewrecyclerview.pojo;

/**
 * Created by jmpuentenueva on 10/11/2016.
 */

public class OpcionMenu {
    int imagen;
    String nombre;

    public OpcionMenu(int imagen, String nombre) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
