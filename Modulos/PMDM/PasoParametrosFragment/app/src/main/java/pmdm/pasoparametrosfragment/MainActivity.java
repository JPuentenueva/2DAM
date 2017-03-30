package pmdm.pasoparametrosfragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pmdm.pasoparametrosfragment.fragments.ChicasFragment;
import pmdm.pasoparametrosfragment.fragments.ChicosFragment;

public class MainActivity extends AppCompatActivity {
    int contadorChicos;
    int contadorChicas;
    Button btnChico;
    Button btnChica;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contadorChicos = 0;
        contadorChicas = 0;
        fragment = new ChicosFragment();
        btnChico = (Button) findViewById(R.id.btn_chico);
        btnChica = (Button) findViewById(R.id.btn_chica);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,fragment)
                .commit();
    }


    @SuppressWarnings("ResourceAsColor")
    public void verChicos(View view) {
        contadorChicos++;
        fragment = new ChicosFragment();
        Bundle params = new Bundle();

        params.putInt("meGustas",contadorChicos);

        fragment.setArguments(params);
        btnChico.setBackgroundColor(R.color.rojo);
        btnChica.setBackgroundColor(R.color.gris);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    public void verChicas(View view) {
        contadorChicas++;
        fragment = new ChicasFragment();
        Bundle params = new Bundle();

        params.putInt("meGustas",contadorChicas);

        fragment.setArguments(params);
        btnChica.setBackgroundColor(R.color.azul);
        btnChico.setBackgroundColor(R.color.gris);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}
