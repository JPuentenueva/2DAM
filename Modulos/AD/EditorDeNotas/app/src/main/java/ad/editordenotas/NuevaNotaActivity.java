package ad.editordenotas;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class NuevaNotaActivity extends AppCompatActivity {
    EditText nombreFichero;
    EditText contenidoFichero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_nota);

        nombreFichero = (EditText) findViewById(R.id.editNombreFichero);
        contenidoFichero = (EditText) findViewById(R.id.editContenidoFichero);

    }

    public void guardarFichero(View view) {
        String titulo = nombreFichero.getText().toString();
        String contenido = contenidoFichero.getText().toString();

        try
        {
            File ruta_sd = Environment.getExternalStorageDirectory();

            File f = new File(ruta_sd.getAbsolutePath(), titulo+".txt");

            OutputStreamWriter fout =
                    new OutputStreamWriter(
                            new FileOutputStream(f));

            fout.write(contenido);
            fout.close();
        }
        catch (Exception ex)
        {
            Toast.makeText(this, "Error al escribir fichero a tarjeta SD", Toast.LENGTH_SHORT).show();
        }

        Toast.makeText(this, titulo+".txt creado con éxito", Toast.LENGTH_SHORT).show();
    }
}
