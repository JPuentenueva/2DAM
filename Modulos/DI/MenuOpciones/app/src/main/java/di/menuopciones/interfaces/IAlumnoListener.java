package di.menuopciones.interfaces;

import di.menuopciones.pojo.Alumno;

/**
 * Created by Jose on 10/02/2017.
 */

public interface IAlumnoListener {
    void onClickAlumno(Alumno alumno);
    void onClickEditarAlumno(Alumno alumno);
    void onClickEliminarAlumno(Alumno alumno);
    void onClickBuscarAlumno(String alumnoABuscar);
}
