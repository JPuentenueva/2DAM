package com.example1.admin.pmdm_ejercicioevaluacion1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();

        Bundle extra = i.getExtras();
        txt = (TextView) findViewById(R.id.textoResul);

        txt.setText(extra.getString("textoEnviado"));

    }
}