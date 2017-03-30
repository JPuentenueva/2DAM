package psp.galerianasa;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.parceler.Parcels;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import psp.galerianasa.interfaces.IimagenClickListener;
import psp.galerianasa.pojo.ArchivoRSS;
import psp.galerianasa.pojo.Imagen;

public class MainActivity extends AppCompatActivity implements IimagenClickListener {
    List<Imagen> li;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onImagenClick(Imagen i) {
        Intent intent = new Intent(this,ImagenAmpliadaActivity.class);
        intent.putExtra("foto", Parcels.wrap(i));
        startActivity(intent);
    }


}

