package pmdm.consultacondiciones;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CondicionesActivity extends AppCompatActivity {
    TextView tv;
    Button btnAcep;
    Button btnRech;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condiciones);

        i = getIntent();
        Bundle extras = i.getExtras();

        String textoBienvenida = "Hola "+extras.getString("nombre")+",\n" +
                "¿Aceptas las condiciones del registro?";

        tv = (TextView) findViewById(R.id.mensajeBienvenida);
        tv.setText(textoBienvenida);
        btnAcep = (Button) findViewById(R.id.aceptarCond);
        btnRech = (Button) findViewById(R.id.rechazarCond);

    }

    public void aceptarCondiciones(View view) {
        setResult(RESULT_OK,i);
        finish();
    }

    public void rechazarCondiciones(View view) {
        setResult(RESULT_CANCELED,i);
        finish();
    }
}
