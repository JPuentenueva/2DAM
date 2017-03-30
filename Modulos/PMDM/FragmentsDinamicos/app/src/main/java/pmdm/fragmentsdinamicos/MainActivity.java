package pmdm.fragmentsdinamicos;

import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import pmdm.fragmentsdinamicos.fragments.ConfigFragment;
import pmdm.fragmentsdinamicos.fragments.ListaFragment;
import pmdm.fragmentsdinamicos.fragments.UserFragment;

public class MainActivity extends AppCompatActivity {
    Fragment fragment;
    ImageButton ib1;
    ImageButton ib2;
    ImageButton ib3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ib1 = (ImageButton) findViewById(R.id.btn_frag1);
        ib2 = (ImageButton) findViewById(R.id.btn_frag2);
        ib3 = (ImageButton) findViewById(R.id.btn_frag3);


        fragment = new ListaFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();
        View v = findViewById(R.id.container);
    }

    public void cambiarFragment1(View view) {
        fragment = new ListaFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();


    }

    public void cambiarFragment2(View view) {
        fragment = new UserFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    public void cambiarFragment3(View view) {
        fragment = new ConfigFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}
