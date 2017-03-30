
package parato.tracker.pojo.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GpsBodyResponse {

    @SerializedName("fecha")
    @Expose
    private Long fecha;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("estado_bateria")
    @Expose
    private Double estado_bateria;
    @SerializedName("_links")
    @Expose
    private Links links;

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

    public Double getEstado_bateria() {
        return estado_bateria;
    }

    public void setEstado_bateria(Double estado_bateria) {
        this.estado_bateria = estado_bateria;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "GpsBodyResponse{" +
                "fecha=" + fecha +
                ", lat=" + lat +
                ", lng=" + lng +
                ", estado_bateria=" + estado_bateria +
                ", links=" + links +
                '}';
    }
}
