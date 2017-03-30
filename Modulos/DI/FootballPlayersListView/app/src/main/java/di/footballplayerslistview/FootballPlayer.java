package di.footballplayerslistview;

/**
 * Created by jmpuentenueva on 24/10/2016.
 */

public class FootballPlayer {
    private String nombre;
    private String equipo;
    private int edad;
    private float valoracion;
    private int goles;
    private int copas;

    public FootballPlayer(String nombre, String equipo, int edad, float valoracion, int goles, int copas) {
        this.copas = copas;
        this.nombre = nombre;
        this.equipo = equipo;
        this.edad = edad;
        this.valoracion = valoracion;
        this.goles = goles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getCopas() {
        return copas;
    }

    public void setCopas(int copas) {
        this.copas = copas;
    }
}
