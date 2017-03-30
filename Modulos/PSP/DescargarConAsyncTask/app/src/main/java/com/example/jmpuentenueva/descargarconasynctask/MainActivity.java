package com.example.jmpuentenueva.descargarconasynctask;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Handler hnd = new Handler(){
        @Override
        public void dispatchMessage(Message msg) {
            try {
                DownloadFile.downloadFile((String) msg.obj);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.editUrlDescarga);
        et.setText("http://s9edfd10c06354d7a.jimcontent.com/download/version/1343438298/module/5522504968/name/1.-Juego_de_Tronos_Cancion_de_Hielo_y_Fuego__-_George_RR_Martin.pdf");

    }

    public void descargarArchivo(View view) {
        Message msg = new Message();

        msg.obj = et.getText().toString();
        hnd.dispatchMessage(msg);
    }
}
