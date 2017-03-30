package pmdm.concatenarstrings;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StringActivity extends AppCompatActivity {
    EditText et1;
    EditText et2;
    Button btn1;
    Button btn2;
    Button btn3;
    TextView txView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string);

        et1 = (EditText) findViewById(R.id.string1);
        et2 = (EditText) findViewById(R.id.string2);

        btn1 = (Button) findViewById(R.id.concatBtn);
        btn2 = (Button) findViewById(R.id.ordenBtn);
        btn3 = (Button) findViewById(R.id.capitBtn);

        txView = (TextView) findViewById(R.id.stringFinal);

    }

    public void concatenarStrings(View view) {
    }

    public void ordenarStrings(View view) {
    }

    public void capitalizarStrings(View view) {
    }
}
