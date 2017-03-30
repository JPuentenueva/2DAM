package psp.imagedownloader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnAs;
    Button btnHand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAs = (Button) findViewById(R.id.btnAsync);
        btnHand = (Button) findViewById(R.id.btnHandler);

        btnAs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AsyncActivity.class);
                startActivity(i);
            }
        });

        btnHand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, HandlerActivity.class);
                startActivity(i);
            }
        });
    }

}
