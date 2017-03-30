package ad.listacompra;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edProd;
    EditText edCant;
    ListView liView;
    ArrayList<String> listaProductos;
    ArrayAdapter<String> adapter;
    File ficheroLista;
    String nombreFichero = "listaCompras.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edProd = (EditText) findViewById(R.id.editTextConcepto);
        edCant = (EditText) findViewById(R.id.editTextCantidad);
        liView = (ListView) findViewById(R.id.listaProductos);
        ficheroLista = new File(nombreFichero);
        listaProductos = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaProductos);
        liView.setAdapter(adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void anyadirProducto(View view) {
        try (FileOutputStream fos = openFileOutput(nombreFichero, MODE_APPEND)){
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write(edCant.getText().toString() + ";" + edProd.getText().toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pintarLista();
    }

    public void resetear(View view) {
        ficheroLista.delete();
        ficheroLista = new File(nombreFichero);
        adapter.notifyDataSetChanged();
    }

    public void pintarLista() {
        try (FileReader fr = new FileReader(nombreFichero)){
            BufferedReader br = new BufferedReader(fr);
            String linea;

            do {
                linea = br.readLine();
                listaProductos.add(linea);
            } while (linea != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
