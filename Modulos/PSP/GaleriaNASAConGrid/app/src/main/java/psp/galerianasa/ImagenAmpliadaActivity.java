package psp.galerianasa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

import psp.galerianasa.pojo.Imagen;

public class ImagenAmpliadaActivity extends AppCompatActivity {
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen_ampliada);

        iv = (ImageView) findViewById(R.id.imageViewAmpliada);

        Imagen img = (Imagen) Parcels.unwrap(getIntent().getParcelableExtra("foto"));

        Glide.with(this).load(img.getUrl().getUrl()).into(iv);
    }
}
