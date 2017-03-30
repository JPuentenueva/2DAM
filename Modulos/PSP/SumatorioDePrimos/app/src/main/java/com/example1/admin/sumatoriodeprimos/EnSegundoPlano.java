package com.example1.admin.sumatoriodeprimos;

import android.os.AsyncTask;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Admin on 07/10/2016.
 */

public class EnSegundoPlano extends AsyncTask<Void,Void,String>{

    @Override
    protected String doInBackground(Void... params) {
        BigInteger b = BigInteger.probablePrime(32,new Random());
        return b.toString();
    }
}
