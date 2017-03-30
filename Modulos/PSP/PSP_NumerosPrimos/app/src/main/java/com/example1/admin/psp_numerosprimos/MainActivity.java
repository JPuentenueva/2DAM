package com.example1.admin.psp_numerosprimos;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public boolean verificarSiNoPrimo(int valor)
    {
        int cont=0;
        for (int p=1; p<=valor; p++)
        {

            if (valor % p ==0)
                cont++;
        }
        if (cont<=2)
            return true;
        else
            return false;
    }

    public void onClickGenerarAleatorio(View view) {
        BigInteger num;

        //do{
            num = BigInteger.probablePrime(2048,new Random());
        //}while(!verificarSiNoPrimo(num));

        tv = (TextView) findViewById(R.id.botonAlea);

        tv.setText((CharSequence) num);
    }

    private class MyAsyncTask extends AsyncTask <Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... params) {
            return null;
        }
    }
}

