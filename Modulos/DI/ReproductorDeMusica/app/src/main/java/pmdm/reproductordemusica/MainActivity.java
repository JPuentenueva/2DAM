package pmdm.reproductordemusica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.parceler.Parcels;

import co.mobiwise.library.MusicPlayerView;
import pmdm.reproductordemusica.interfaces.ICancionesListener;
import pmdm.reproductordemusica.pojo.Cancion;

public class MainActivity extends AppCompatActivity implements ICancionesListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onClickCancion(Cancion cancion) {
        Intent i = new Intent(this, ReproductorActivity.class);
        Bundle extras = new Bundle();
        extras.putParcelable("cancion", Parcels.wrap(cancion));
        i.putExtras(extras);
        startActivity(i);
    }
}