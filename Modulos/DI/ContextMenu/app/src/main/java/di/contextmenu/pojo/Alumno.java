package di.contextmenu.pojo;

/**
 * Created by jmpuentenueva on 24/11/2016.
 */
public class Alumno {
    String nombre;
    String apellidos;
    int icono;

    public Alumno(String nombre, String apellidos, int icono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.icono = icono;
    }

    public Alumno(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.icono = 0;
    }

    public Alumno() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }
}
