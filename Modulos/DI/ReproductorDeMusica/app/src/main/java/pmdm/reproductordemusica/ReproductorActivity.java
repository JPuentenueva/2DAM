package pmdm.reproductordemusica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.parceler.Parcels;

import co.mobiwise.library.MusicPlayerView;
import pmdm.reproductordemusica.pojo.Cancion;

public class ReproductorActivity extends AppCompatActivity implements View.OnClickListener {
    Intent i;
    MusicPlayerView musicPlayerView;
    Cancion currentCancion;
    boolean pausado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);

        currentCancion = Parcels.unwrap(getIntent().getExtras().getParcelable("cancion"));

        musicPlayerView = (MusicPlayerView) findViewById(R.id.mpv);
        musicPlayerView.setOnClickListener(this);
        musicPlayerView.setAutoProgress(true);
        musicPlayerView.setCoverDrawable(currentCancion.getCaratula());

        i = new Intent(this,ServicioMusica.class);

    }

    @Override
    public void onClick(View view) {
        if(musicPlayerView.isRotating()) {
            stopService(i);
            pausado = true;
            // La siguiente línea de código para la rotación de la carátula
            musicPlayerView.stop();
        } else {
            musicPlayerView.start();
            if(pausado) {
                i.putExtra("tiempo",musicPlayerView.getProgress());
            }
            //TODO: pasar una URL de una canción de Internet en mp3
            i.putExtra("urlCancion", currentCancion.getUrl());
            startService(i);
        }
    }
}
