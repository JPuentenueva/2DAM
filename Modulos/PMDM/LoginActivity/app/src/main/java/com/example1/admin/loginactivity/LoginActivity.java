package com.example1.admin.loginactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Admin on 28/09/2016.
 */

public class LoginActivity extends AppCompatActivity {
    private EditText user;
    private EditText pass;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (EditText) findViewById(R.id.usuario);
        pass = (EditText) findViewById(R.id.contraseña);
    }

    public void onClickLogin(View view) { //EL RELLENO DE ESTE METODO ES PARA OTRO PROYECTO
        Intent i = new Intent(LoginActivity.this, MainActivity.class); //Cambio de activity actual a MainActivity
        //en el método putExtra enciamos (nombre_variable, valor)

        if(user.getText().toString().equalsIgnoreCase("admin") && pass.getText().toString().equalsIgnoreCase("1234")){
            i.putExtra("usuario",user.getText().toString());
            i.putExtra("contraseña",pass.getText().toString());

            startActivity(i);
        }else{
            Toast.makeText(this, "Contraseña o usuario no correcto", Toast.LENGTH_LONG); //Mensaje de error
        }

    }
}
