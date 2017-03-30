package di.menuopciones.pojo;

import org.parceler.Parcel;

/**
 * Created by Jose on 10/02/2017.
 */

@Parcel
public class Alumno {
    private String nombre;
    private String curso;
    private String notaMedia;

    public Alumno() {

    }

    public Alumno(String nombre, String curso, String notaMedia) {
        this.nombre = nombre;
        this.curso = curso;
        this.notaMedia = notaMedia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(String notaMedia) {
        this.notaMedia = notaMedia;
    }
}
