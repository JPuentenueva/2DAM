package com.example1.admin.loginactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtViewNombre, txtViewApellidos, txtViewEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent i = getIntent(); //EL RELLENO DE ESTE METODO ES PARA OTRO PROYECTO

        Bundle extras = i.getExtras();
        String usuario = extras.getString(Constantes.USER);
        String contraseña = extras.getString(Constantes.PASS);
    }
}
