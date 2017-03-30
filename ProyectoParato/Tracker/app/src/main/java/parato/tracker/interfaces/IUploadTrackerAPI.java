package parato.tracker.interfaces;

import okhttp3.ResponseBody;
import parato.tracker.pojo.Tracker;
import parato.tracker.pojo.get.ListaProyectos;
import parato.tracker.pojo.response.GpsBodyResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by jmpuentenueva on 25/01/2017.
 */

public interface IUploadTrackerAPI {
    final String ENDPOINT = "http://172.27.0.136:8080"; //TODO


    @Headers("Accept: application/json")
    @POST("/gps")
    Call<GpsBodyResponse> upload(
            @Body Tracker datos
    );

    /*@Headers("Accept: application/json")
    @POST ("/gps")
    Call<ResponseBody> upload(@Body Tracker datos);*/

    @GET("/proyectos")
    Call<ListaProyectos> obtenerProyecto(@Query("token") String token);
}
