package ad.jsonparseexample;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import ad.jsonparseexample.pojo.Nota;

public class MainActivity extends Activity {


    String json = "{ \"titulo\" : \"Enviar memorando\", " +
            "\"fecha\" : \"19/11/2015\", " +
            "\"cuerpo\": \"No olvidar enviar el memorando sobre el proyecto a Miguel\" }";


    TextView txt_titulo, txt_fecha, txt_cuerpo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_titulo = (TextView) findViewById(R.id.txt_titulo);
        txt_fecha = (TextView) findViewById(R.id.txt_fecha);
        txt_cuerpo = (TextView) findViewById(R.id.txt_cuerpo);


        Gson gson = new Gson();
        Nota n = gson.fromJson(json, Nota.class);

        txt_titulo.setText(n.getTitulo());
        txt_fecha.setText(n.getFecha());
        txt_cuerpo.setText(n.getCuerpo());

        Log.i("SALIDA", n.toString());


        Nota otraNota = new Nota("ASDFG", "01/01/2015","Lorem ipsum dolor sit amet");
        StringBuilder resultado = new StringBuilder();
        gson.toJson(otraNota,resultado);
        Log.i("SALIDA", resultado.toString());


    }

}