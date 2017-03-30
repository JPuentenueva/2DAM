package di.gestionllamadaslist;

/**
 * Created by jmpuentenueva on 26/10/2016.
 */

public class Llamada {
    private String tipo;
    private String numContacto;
    private String nombreContacto;
    private String fecha;
    private String horaInicio;
    private int duracion;

    public Llamada(String tipo, String numContacto, String nombreContacto, String fecha, String horaInicio, int duracion) {
        this.tipo = tipo;
        this.numContacto = numContacto;
        this.nombreContacto = nombreContacto;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.duracion = duracion;
    }

    public Llamada(String tipo, String numContacto, String fecha, String horaInicio, int duracion) {
        this.tipo = tipo;
        this.numContacto = numContacto;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.duracion = duracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumContacto() {
        return numContacto;
    }

    public void setNumContacto(String numContacto) {
        this.numContacto = numContacto;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }


}
