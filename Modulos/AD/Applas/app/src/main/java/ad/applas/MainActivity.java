package ad.applas;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.parceler.Parcels;

import ad.applas.interfaces.IPaisListener;
import ad.applas.pojo.Pais;

public class MainActivity extends AppCompatActivity implements IPaisListener {
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClickPais(Pais pais) {
        Intent i = new Intent(this, PaisDetalleActivity.class);
        i.putExtra("pais", Parcels.wrap(pais));
        startActivity(i);
    }
}
