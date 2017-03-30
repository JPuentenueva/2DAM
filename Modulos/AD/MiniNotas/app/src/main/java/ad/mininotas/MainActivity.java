package ad.mininotas;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText nombreFichero;
    EditText contenidoFichero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreFichero = (EditText) findViewById(R.id.editNombreFichero);
        contenidoFichero = (EditText) findViewById(R.id.editContenidoFichero);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void guardarFichero(View view) {
        String titulo = nombreFichero.getText().toString();
        String contenido = contenidoFichero.getText().toString();

        FileOutputStream file = null;

        try {
            file = openFileOutput(titulo, Context.MODE_PRIVATE); //Metodo que devuelve un FileOutputStream creado a partir del nombre del archivo y un tipo
            BufferedWriter bfWr = new BufferedWriter(new OutputStreamWriter(file));

            bfWr.write(contenido);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
