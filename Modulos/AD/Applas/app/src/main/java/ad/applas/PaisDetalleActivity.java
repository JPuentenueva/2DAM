package ad.applas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ad.applas.pojo.Pais;

public class PaisDetalleActivity extends AppCompatActivity {
    TextView pais;
    TextView capital;
    TextView region;
    TextView subregion;
    TextView alpha2Code;
    TextView alpha3Code;
    ListView zonasHorarias;
    ListView listaIdiomas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pais_detalle);

        pais = (TextView) findViewById(R.id.textViewPais);
        capital = (TextView) findViewById(R.id.textViewCapitalPais);
        region = (TextView) findViewById(R.id.textViewRegionPais);
        subregion = (TextView) findViewById(R.id.textViewSubregionPais);
        alpha2Code = (TextView) findViewById(R.id.textViewAlpha2CodePais);
        alpha3Code = (TextView) findViewById(R.id.textViewAlpha3CodePais);
        zonasHorarias = (ListView) findViewById(R.id.listViewZonaHorariaPais);
        listaIdiomas = (ListView) findViewById(R.id.listaIdiomas);

        Pais paisActual = getIntent().getExtras().getParcelable("pais");

        pais.setText(paisActual.getName());
        capital.setText(paisActual.getCapital());
        region.setText(paisActual.getRegion());
        subregion.setText((paisActual.getSubregion()));
        alpha2Code.setText(paisActual.getAlpha2Code());
        alpha3Code.setText(paisActual.getAlpha3Code());

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paisActual.getTimezones());
        zonasHorarias.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, paisActual.getLanguages());
        listaIdiomas.setAdapter(adapter2);


    }
}
