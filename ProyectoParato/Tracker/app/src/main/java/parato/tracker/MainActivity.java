package parato.tracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import okhttp3.ResponseBody;
import parato.tracker.interfaces.IUploadTrackerAPI;
import parato.tracker.pojo.Tracker;
import parato.tracker.pojo.get.ListaProyectos;
import parato.tracker.pojo.response.GpsBodyResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    String enlaceDelProyecto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String token = "asdfg435cdghs79846h741asdfg435cdg";

        //ANTES DE ESTO SE CAPTA EL TOKEN CON EL CODIGO QR
        setearProyecto(token);
        //enlaceDelProyecto = "http://172.27.0.136:8080/proyectos/1";

    }

    private void setearProyecto(String token) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IUploadTrackerAPI.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IUploadTrackerAPI service =
                retrofit.create(IUploadTrackerAPI.class);

        Call<ListaProyectos> call;

        call = service.obtenerProyecto(token);

        call.enqueue(new Callback<ListaProyectos>() {
            @Override
            public void onResponse(Call<ListaProyectos> call, Response<ListaProyectos> response) {

                Log.i("PROGRESO: ","PETICION COMPLETADA: "+response.body().toString());
                enlaceDelProyecto = response.body().getEmbedded().getProyectos().get(0).getLinks().getProyecto().getHref();
                //enlaceDelProyecto = "http://172.27.0.136:8080/proyectos/1";
                Log.i("PROGRESO: ", enlaceDelProyecto);
            }

            @Override
            public void onFailure(Call<ListaProyectos> call, Throwable t) {
                Toast.makeText(MainActivity.this, "No se pudo obtener el proyecto", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void subirTracker(Tracker datos) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(IUploadTrackerAPI.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IUploadTrackerAPI service =
                retrofit.create(IUploadTrackerAPI.class);

        Call<GpsBodyResponse> call = service.upload(datos);
        //Call<ResponseBody> call = service.upload(datos);

        Log.i("PROGRESO: ", "PREVIA PETICION");

        call.enqueue(new Callback<GpsBodyResponse>() {
        //call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<GpsBodyResponse> call, Response<GpsBodyResponse> response) {
            //public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.i("PROGRESO: ", "PETICION COMPLETADA: " + response.body().toString());
                Toast.makeText(MainActivity.this, "Tracker subido sin problemas, " + response.body().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<GpsBodyResponse> call, Throwable t) {
            //public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.i("PROGRESO: ", "Fallo al subir los datos al API");
                Log.i("PROGRESO: ", t.getMessage());

                Toast.makeText(MainActivity.this, "Ha habido un fallo en la subida", Toast.LENGTH_LONG).show();
            }
        });
    }

    void mandarPeticionEstandar(View view) {
        Tracker datos = new Tracker();

        datos.setLat(24.2323);
        datos.setLng(-25.2323);
        datos.setFecha(System.currentTimeMillis());
        datos.setEstado_bateria(98.0);
        datos.setProyecto(enlaceDelProyecto);

        Log.i("PROGRESO: ", "DATOS SETEADOS");

        subirTracker(datos);

    }
}
