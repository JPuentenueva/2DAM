package com.example1.admin.a03_inputcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.buttonClickHere);
        btn2 = (Button) findViewById(R.id.buttonClickThere);

        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View button) {
        int id = button.getId();

        switch(id){
            case R.id.buttonClickHere:

                break;
            case R.id.buttonClickThere:

                break;
        }
    }
}
