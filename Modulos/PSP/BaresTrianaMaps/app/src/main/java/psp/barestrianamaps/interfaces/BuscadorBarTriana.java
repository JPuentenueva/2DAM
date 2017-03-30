package psp.barestrianamaps.interfaces;

import psp.barestrianamaps.pojo.Busqueda;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by jmpuentenueva on 30/11/2016.
 */

public interface BuscadorBarTriana {
    String ENDPOINT = "https://maps.googleapis.com/";

    @GET("maps/api/place/autocomplete/json?location=37.380534, -6.007787&" +
            "radius=500&types=bar&name=triana&key=AIzaSyBwZ60_83Uo8Ry1ohKeI4nEHDJq22GeY5c" +
            "language=es&")
    Call<Busqueda> getBares(@Query("name") String name, @Query("radius") String radius);
}
