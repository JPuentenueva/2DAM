package pmdm.pruebaevalfragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pmdm.pruebaevalfragments.fragments.SignInFragment;
import pmdm.pruebaevalfragments.fragments.SignUpFragment;

public class MainActivity extends AppCompatActivity {
    Fragment fragment;

    Button btnIn;
    Button btnUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = new SignInFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();

        btnIn = (Button) findViewById(R.id.btn_signIn);
        btnIn.setBackgroundColor(getColor(R.color.blanco));
        btnUp = (Button) findViewById(R.id.btn_signUp);
        btnUp.setBackgroundColor(getColor(R.color.gris));
    }

    public void abrirLogin(View view) {
        fragment = new SignInFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        btnIn.setBackgroundColor(getColor(R.color.blanco));
        btnUp.setBackgroundColor(getColor(R.color.gris));
    }

    public void abrirRegistro(View view) {
        fragment = new SignUpFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        btnIn.setBackgroundColor(getColor(R.color.gris));
        btnUp.setBackgroundColor(getColor(R.color.blanco));
    }
}
