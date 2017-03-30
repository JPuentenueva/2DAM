package pmdm.graficaalumnos.pojo;

/**
 * Created by jmpuentenueva on 10/11/2016.
 */

public class Alumno {
    String nombre;
    double nota;

    public Alumno(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
