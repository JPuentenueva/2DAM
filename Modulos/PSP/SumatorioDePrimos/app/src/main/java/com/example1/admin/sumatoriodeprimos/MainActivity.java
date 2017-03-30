package com.example1.admin.sumatoriodeprimos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
        TextView prim1;
        TextView prim2;
        TextView sumPrim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prim1 = (TextView) findViewById(R.id.primo1);
        prim2 = (TextView) findViewById(R.id.primo2);
        sumPrim = (TextView) findViewById(R.id.sumaDePrimos);

    }

    public void calcularPrimo1(View view) {
        EnSegundoPlano proceso1 = new EnSegundoPlano();
        prim1.setText(proceso1.doInBackground());
    }

    public void calcularPrimo2(View view) {
        EnSegundoPlano proceso2 = new EnSegundoPlano();
        prim2.setText(proceso2.doInBackground());
    }

    public void sumarPrimos(View view) {
        SumaEnSegundoPlano proceso3 = new SumaEnSegundoPlano();
        sumPrim.setText(proceso3.doInBackground(prim1.getText().toString(),prim2.getText().toString()));
    }
}
