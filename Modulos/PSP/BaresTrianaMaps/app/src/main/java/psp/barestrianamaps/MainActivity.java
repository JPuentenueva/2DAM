package psp.barestrianamaps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import psp.barestrianamaps.interfaces.BuscadorBarTriana;
import psp.barestrianamaps.pojo.Bar;
import psp.barestrianamaps.pojo.Busqueda;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    EditText nameET;
    EditText radiusET;
    List<Bar> listaBares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameET = (EditText) findViewById(R.id.editTextNombre);
        radiusET = (EditText) findViewById(R.id.editTextRadio);

    }


    public void buscarBares(View view) {
        String nombre = null;
        String radio = null;

        nombre = nameET.getText().toString();
        radio = radiusET.getText().toString();

        if(nombre != null && radio != null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BuscadorBarTriana.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            final BuscadorBarTriana service = retrofit.create(BuscadorBarTriana.class);

            Call<Busqueda> call = service.getBares(nombre, radio);

            call.enqueue(new Callback<Busqueda>() {
                @Override
                public void onResponse(Response<Busqueda> response, Retrofit retrofit) {
                    if (response.isSuccess()) {
                        listaBares = response.body().getResults();
                    } else {
                        Toast.makeText(MainActivity.this, "Error code " + response.code(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });


        } else {
            Toast.makeText(this, "Introduzca los datos requeridos", Toast.LENGTH_SHORT).show();
        }
    }
}
