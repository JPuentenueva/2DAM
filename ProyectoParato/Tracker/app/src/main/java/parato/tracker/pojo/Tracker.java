
package parato.tracker.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tracker {

    @SerializedName("estado_bateria")
    @Expose
    private Double estado_bateria;
    @SerializedName("fecha")
    @Expose
    private Long fecha;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("proyecto")
    @Expose
    private String proyecto;

    public Double getEstado_bateria() {
        return estado_bateria;
    }

    public void setEstado_bateria(Double estado_bateria) {
        this.estado_bateria = estado_bateria;
    }

    public Long getFecha() {
        return fecha;
    }

    public void setFecha(Long fecha) {
        this.fecha = fecha;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "Tracker{" +
                "estado_bateria=" + estado_bateria +
                ", fecha=" + fecha +
                ", lat=" + lat +
                ", lng=" + lng +
                ", proyecto='" + proyecto + '\'' +
                '}';
    }
}
