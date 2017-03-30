package di.eltenedor;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.parceler.Parcels;

import di.eltenedor.pojo.Restaurante;

public class ScrollingActivity extends AppCompatActivity {
    TextView txNombre;
    TextView txDireccion;
    TextView txEtiqueta1;
    TextView txEtiqueta2;
    TextView txEtiqueta3;
    TextView txEtiqueta4;
    ImageView imgEstrella1;
    ImageView imgEstrella2;
    ImageView imgEstrella3;
    ImageView imgEstrella4;
    ImageView imgEstrella5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txNombre = (TextView) findViewById(R.id.txVwNombre);
        txDireccion = (TextView) findViewById(R.id.txVwDireccion);
        txEtiqueta1 = (TextView) findViewById(R.id.etiqueta1);
        txEtiqueta2 = (TextView) findViewById(R.id.etiqueta2);
        txEtiqueta3 = (TextView) findViewById(R.id.etiqueta3);
        txEtiqueta4 = (TextView) findViewById(R.id.etiqueta4);
        imgEstrella1 = (ImageView) findViewById(R.id.estrella1);
        imgEstrella2 = (ImageView) findViewById(R.id.estrella2);
        imgEstrella3 = (ImageView) findViewById(R.id.estrella3);
        imgEstrella4 = (ImageView) findViewById(R.id.estrella4);
        imgEstrella5 = (ImageView) findViewById(R.id.estrella5);

        Restaurante restaurante = Parcels.unwrap(getIntent().getExtras().getParcelable("restaurante"));

        toolbar.setBackgroundResource(restaurante.getImagenDetalle());

        if (restaurante.getValoracion() == 1) {
            imgEstrella1.setImageResource(R.drawable.ic_star_on);

        } else if (restaurante.getValoracion() == 2) {
            imgEstrella1.setImageResource(R.drawable.ic_star_on);
            imgEstrella2.setImageResource(R.drawable.ic_star_on);

        } else if (restaurante.getValoracion() == 3) {
            imgEstrella1.setImageResource(R.drawable.ic_star_on);
            imgEstrella2.setImageResource(R.drawable.ic_star_on);
            imgEstrella3.setImageResource(R.drawable.ic_star_on);

        } else if (restaurante.getValoracion() == 4) {
            imgEstrella1.setImageResource(R.drawable.ic_star_on);
            imgEstrella2.setImageResource(R.drawable.ic_star_on);
            imgEstrella3.setImageResource(R.drawable.ic_star_on);
            imgEstrella4.setImageResource(R.drawable.ic_star_on);

        } else if (restaurante.getValoracion() == 5) {
            imgEstrella1.setImageResource(R.drawable.ic_star_on);
            imgEstrella2.setImageResource(R.drawable.ic_star_on);
            imgEstrella3.setImageResource(R.drawable.ic_star_on);
            imgEstrella4.setImageResource(R.drawable.ic_star_on);
            imgEstrella5.setImageResource(R.drawable.ic_star_on);

        } else {

        }

        txNombre.setText(restaurante.getNombre());
        txDireccion.setText(restaurante.getDireccion());
        txEtiqueta1.setText("#"+restaurante.getEtiquetas().get(0));
        txEtiqueta2.setText("#"+restaurante.getEtiquetas().get(1));
        txEtiqueta3.setText("#"+restaurante.getEtiquetas().get(2));
        txEtiqueta4.setText("#"+restaurante.getEtiquetas().get(3));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
