package di.eltenedor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.parceler.Parcels;

import di.eltenedor.interfaces.IRestauranteListener;
import di.eltenedor.pojo.Restaurante;

public class MainActivity extends AppCompatActivity implements IRestauranteListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClickRestaurante(Restaurante restaurante) {
        Intent i = new Intent(this, ScrollingActivity.class);

        i.putExtra("restaurante", Parcels.wrap(restaurante));

        startActivity(i);
    }
}
