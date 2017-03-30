package com.example1.admin.autoescuela_radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    Button btn;
    RadioGroup respuesta1;
    RadioGroup respuesta2;
    RadioGroup respuesta3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.botonEnvio);
        btn.setVisibility(View.INVISIBLE);

        respuesta1 = (RadioGroup) findViewById(R.id.respuestas1);
        respuesta2 = (RadioGroup) findViewById(R.id.respuestas2);
        respuesta3 = (RadioGroup) findViewById(R.id.respuestas3);

    }

    public void respuestasSeleccionadas() {
        if (respuesta1.isEnabled() && respuesta2.isEnabled() && respuesta3.isEnabled()){
            btn.setVisibility(View.VISIBLE);
         }
    }

    public void enviarResp(View view) {
        RadioButton res1;
        RadioButton res2;
        RadioButton res3;

        res1 = (RadioButton) findViewById(respuesta1.getCheckedRadioButtonId());
        res2 = (RadioButton) findViewById(respuesta2.getCheckedRadioButtonId());
        res3 = (RadioButton) findViewById(respuesta3.getCheckedRadioButtonId());

        int numRespuestasCorrectas = 0;

        if (res1.getText().toString().equalsIgnoreCase(Respuestas.RESPUESTA_CORRECTA_1)){
            numRespuestasCorrectas++;
        }

        if (res2.getText().toString().equalsIgnoreCase(Respuestas.RESPUESTA_CORRECTA_2)){
            numRespuestasCorrectas++;
        }

        if (res3.getText().toString().equalsIgnoreCase(Respuestas.RESPUESTA_CORRECTA_3)){
            numRespuestasCorrectas++;
        }

        if (numRespuestasCorrectas > 0) {
            Toast.makeText(this, "Has contestado " + numRespuestasCorrectas + " preguntas correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Ninguna respuesta correcta", Toast.LENGTH_SHORT).show();
        }

    }
}
