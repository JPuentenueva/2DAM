package ad.puentenuevasanchezjosemariaexadt1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText concepto;
    EditText cantidad;
    TextView listadelacompra;
    File lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = new File("listadelacompra.txt");

        concepto = (EditText) findViewById(R.id.editTextConcepto);
        cantidad = (EditText) findViewById(R.id.editTextCantidad);

        listadelacompra = (TextView) findViewById(R.id.textVieWMultiline);

        leerLista();
    }

    public void anyadirProducto(View view) {
        String conceptoStr = concepto.getText().toString();
        String cantidadStr = cantidad.getText().toString();

        try (FileOutputStream fos = openFileOutput(lista.getName(), MODE_APPEND)) {

            OutputStreamWriter osw = new OutputStreamWriter(fos);

            osw.write(cantidadStr + ";" + conceptoStr);
        } catch (Exception e) {
            Toast.makeText(this, "Problemas al escribir", Toast.LENGTH_SHORT).show();
        }

        leerLista();
    }

    public void leerLista() {
        try (FileReader fr = new FileReader(lista)){
            BufferedReader br = new BufferedReader(fr);
            String cadena = "";
            String linea = null;
            do{
                linea = br.readLine();
                if(linea != null) {
                    String lineaDividida[] = linea.split(";");
                    cadena += "[" + lineaDividida[0] + "] " + lineaDividida[1] + "\n";
                }
            }while(linea != null);
            listadelacompra.setText(cadena);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
