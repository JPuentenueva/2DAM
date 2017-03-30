package ad.serializerbasico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;

import ad.serializerbasico.pojo.Coche;

public class MainActivity extends AppCompatActivity {
    Coche car;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        car = new Coche("Audi A3","verde");

    }

    public void serializar(View view) {
        Serializer serializer = new Persister();

        try {
            serializer.write(car, openFileOutput("coche.xml", MODE_PRIVATE));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Toast.makeText(this, "xml creado", Toast.LENGTH_SHORT).show();
        }
    }
}
