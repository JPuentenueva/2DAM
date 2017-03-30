package com.example.jmpuentenueva.descargarconasynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.editUrlDescarga);
        et.setText("http://s9edfd10c06354d7a.jimcontent.com/download/version/1343438298/module/5522504968/name/1.-Juego_de_Tronos_Cancion_de_Hielo_y_Fuego__-_George_RR_Martin.pdf");

    }

    public void descargarArchivo(View view) {
        if(et.getText().toString() == null){
            Toast.makeText(this, "Debe haber algún URL para descargar", Toast.LENGTH_SHORT).show();
        }else{
            HiloDeDescargas hdd = null;
            hdd.execute(et.getText().toString());
        }

    }

    public class HiloDeDescargas extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String nombreFichero = null;
            try {
                nombreFichero = DownloadFile.downloadFileAndSave(params[0], MainActivity2.this);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return nombreFichero;
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(MainActivity2.this, s, Toast.LENGTH_SHORT).show();

        }
    }


}


