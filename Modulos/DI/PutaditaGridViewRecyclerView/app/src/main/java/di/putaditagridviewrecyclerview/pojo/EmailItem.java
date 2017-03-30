package di.putaditagridviewrecyclerview.pojo;

/**
 * Created by jmpuentenueva on 10/11/2016.
 */

public class EmailItem {
    String asunto;
    String contenido;
    char letra;
    boolean favorito;

    public EmailItem(String descripcionMail, String nombreMail, boolean favorito) {
        this.contenido = descripcionMail;
        this.asunto = nombreMail;
        this.letra = nombreMail.toCharArray()[0];
        this.favorito = favorito;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
}
