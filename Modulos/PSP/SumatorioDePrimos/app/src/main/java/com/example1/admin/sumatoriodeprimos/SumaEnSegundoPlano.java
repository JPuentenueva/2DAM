package com.example1.admin.sumatoriodeprimos;

import android.os.AsyncTask;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Admin on 07/10/2016.
 */

public class SumaEnSegundoPlano extends AsyncTask<String,Void,String>{

    @Override
    protected String doInBackground(String... params) {
        float sumatorio = 0;

        for(int i = 0; i < params.length; i++){
            sumatorio += Float.parseFloat(params[i]);

        }

        return String.valueOf(sumatorio);
    }
}
