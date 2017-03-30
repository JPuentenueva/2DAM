package ledjacket.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView fondoIzq;
    ImageView fondoDer;
    ImageView fondoShut;

    Button btnGeneral;
    Button btnIzq;
    Button btnDer;

    boolean derEncendida;
    boolean izqEncendida;
    boolean generalEncendida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGeneral = (Button) findViewById(R.id.btnOnOff);
        btnIzq = (Button) findViewById(R.id.btnLeft);
        btnDer = (Button) findViewById(R.id.btnRight);

        fondoShut = (ImageView) findViewById(R.id.fondoShut);
        fondoIzq = (ImageView) findViewById(R.id.fondoBtnLeft);
        fondoDer = (ImageView) findViewById(R.id.fondoBtnRight);

        setTitle("LEDJacket");

        generalEncendida = false;
    }

    public void encenderIzquierda(View view) {
        if (generalEncendida) {

            btnDer.setBackgroundResource(R.drawable.ic_right_arrow);
            fondoDer.setVisibility(View.INVISIBLE);
            derEncendida = false;

            btnGeneral.setBackgroundResource(R.drawable.ic_shutdown);
            fondoShut.setImageResource(R.drawable.fondo_off);
            generalEncendida = false;

            Toast.makeText(this, "Left On", Toast.LENGTH_SHORT).show();
        } else {

            if (izqEncendida) {
                fondoIzq.setVisibility(View.INVISIBLE);
                btnIzq.setBackgroundResource(R.drawable.ic_left_arrow);

                Toast.makeText(this, "Left Off", Toast.LENGTH_SHORT).show();
            } else {
                fondoIzq.setVisibility(View.VISIBLE);
                btnIzq.setBackgroundResource(R.drawable.ic_left_arrow_on);

                Toast.makeText(this, "Left On", Toast.LENGTH_SHORT).show();
            }

            if (derEncendida) {
                fondoDer.setVisibility(View.INVISIBLE);
                btnDer.setBackgroundResource(R.drawable.ic_right_arrow);
                derEncendida = !derEncendida;

                //TODO detener intermitencia
            }

            izqEncendida = !izqEncendida;

        }
    }

    public void encenderDerecha(View view) {
        // TODO encender LEDs derecha

        if (generalEncendida) {

            btnIzq.setBackgroundResource(R.drawable.ic_left_arrow);
            fondoIzq.setVisibility(View.INVISIBLE);
            izqEncendida = false;

            btnGeneral.setBackgroundResource(R.drawable.ic_shutdown);
            fondoShut.setImageResource(R.drawable.fondo_off);
            generalEncendida = false;

            Toast.makeText(this, "Right On", Toast.LENGTH_SHORT).show();
        } else {
            if (derEncendida) {
                fondoDer.setVisibility(View.INVISIBLE);
                btnDer.setBackgroundResource(R.drawable.ic_right_arrow);

                Toast.makeText(this, "Right Off", Toast.LENGTH_SHORT).show();
            } else {
                fondoDer.setVisibility(View.VISIBLE);
                btnDer.setBackgroundResource(R.drawable.ic_right_arrow_on);

                Toast.makeText(this, "Right On", Toast.LENGTH_SHORT).show();
            }

            if (izqEncendida) {
                fondoIzq.setVisibility(View.INVISIBLE);
                btnIzq.setBackgroundResource(R.drawable.ic_left_arrow);
                izqEncendida = !izqEncendida;

                //TODO detener intermitencia
            }

            derEncendida = !derEncendida;
        }
    }

    public void encender_apagar(View view) {
        if (generalEncendida){
            //TODO apagar LEDs

            fondoShut.setImageResource(R.drawable.fondo_off);
            fondoIzq.setVisibility(View.INVISIBLE);
            fondoDer.setVisibility(View.INVISIBLE);

            btnIzq.setBackgroundResource(R.drawable.ic_left_arrow);
            btnDer.setBackgroundResource(R.drawable.ic_right_arrow);
            btnGeneral.setBackgroundResource(R.drawable.ic_shutdown);

            izqEncendida = false;
            derEncendida = false;

            Toast.makeText(this, "All Off", Toast.LENGTH_SHORT).show();

        } else {
            //TODO encender LEDs

            fondoShut.setImageResource(R.drawable.fondo_on);
            fondoIzq.setVisibility(View.VISIBLE);
            fondoDer.setVisibility(View.VISIBLE);

            btnIzq.setBackgroundResource(R.drawable.ic_left_arrow_on);
            btnDer.setBackgroundResource(R.drawable.ic_right_arrow_on);
            btnGeneral.setBackgroundResource(R.drawable.ic_shutdown_on);

            izqEncendida = true;
            derEncendida = true;

            Toast.makeText(this, "All On", Toast.LENGTH_SHORT).show();

        }

        generalEncendida = !generalEncendida;
    }
}
