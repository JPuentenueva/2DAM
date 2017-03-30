package ad.applas.interfaces;

import java.util.List;

import ad.applas.pojo.Pais;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Jose on 24/11/2016.
 */

public interface IRestCountries {
    String ENDPOINT = "https://restcountries.eu";

    @GET("/rest/v1/all")
    Call<List<Pais>> getPaises();

}