package com.example1.admin.pmdm_ejercicioevaluacion1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    CheckBox chbx;
    Button btn;
    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chbx = (CheckBox) findViewById(R.id.chek);
        btn = (Button) findViewById(R.id.go);
        txt = (EditText) findViewById(R.id.campoTexto);

    }

    public void verificarPagina(View view) {

        if(chbx.isChecked()){

            Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
            intent.putExtra("textoEnviado", txt.getText().toString());

            startActivity(intent);

        }
    }
}
