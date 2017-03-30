package di.ftpservice.pojo;

import java.io.File;

import di.ftpservice.Constantes;

/**
 * Created by jmpuentenueva on 16/12/2016.
 */

@Parcel
public class Archivo {
    File archivo;
    String nombre;
    String tipo;
    String tamanyo;

    public Archivo(File archivo) {
        this.archivo = archivo;
        this.nombre = archivo.getName();

        if(archivo.isDirectory()){
            this.tipo = Constantes.TYPE_DIRECTORIO;
        } else {
            this.tipo = archivo.getName().split(".")[1];
        }

        if ((archivo.length() / 1024) > 1024) {
            this.tamanyo = Math.round(((archivo.length() / 1024) / 1024)) + " Mb";
        }else {
            this.tamanyo = Math.round((archivo.length() / 1024)) + " Kb";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(String tamanyo) {
        this.tamanyo = tamanyo;
    }

}
