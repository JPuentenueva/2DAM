package di.gestionllamadaslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    LlamadasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listViewLlamadas);

        List<Llamada> lista = new ArrayList<>();

        lista.add(new Llamada("perdida", "654981895", "Antonio", "Mar 6", "15:50", 0));
        lista.add(new Llamada("enviada", "654981895", "Antonio", "Mar 6", "16:23", 400));
        lista.add(new Llamada("perdida", "684458875", "Mar 8", "11:06", 0));
        lista.add(new Llamada("recibida", "669458413", "Manu", "Mar 8", "15:50", 250));
        lista.add(new Llamada("recibida", "644688555", "Mar 11", "15:50", 69));

        adapter = new LlamadasAdapter(this, R.layout.llamada_layout, lista);

        listView.setAdapter(adapter);
    }
}
