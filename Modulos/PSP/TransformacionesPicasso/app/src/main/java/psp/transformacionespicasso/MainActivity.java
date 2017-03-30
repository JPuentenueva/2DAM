package psp.transformacionespicasso;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import psp.transformacionespicasso.fragments.ImagenesFragment;
import psp.transformacionespicasso.interfaces.IOnClickImagen;
import psp.transformacionespicasso.pojo.Imagen;

public class MainActivity extends AppCompatActivity implements IOnClickImagen {
    Fragment fragment;
    List<Imagen> liImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        liImagen = new ArrayList<>();
        liImagen.add(new Imagen(R.drawable.alcazaba_almeria));
        liImagen.add(new Imagen(R.drawable.alcazaba_malaga));
        liImagen.add(new Imagen(R.drawable.alhambra));
        liImagen.add(new Imagen(R.drawable.catedral_jaen));
        liImagen.add(new Imagen(R.drawable.giralda));
        liImagen.add(new Imagen(R.drawable.mezquita_de_cordoba));
        liImagen.add(new Imagen(R.drawable.monasterio_rabida));
        liImagen.add(new Imagen(R.drawable.salvador_ubeda));
        liImagen.add(new Imagen(R.drawable.torre_del_oro));

        fragment = new ImagenesFragment();
        Bundle args = new Bundle();
        args.putParcelable("listaImg", Parcels.wrap(liImagen));
        fragment.setArguments(args);
    }

    @Override
    public void onClickImagen(Imagen i) {

    }
}
