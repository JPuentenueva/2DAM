package di.conecta4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView dialogo;
    Button btnReinicio;

    LinearLayout fila1;
    LinearLayout fila2;
    LinearLayout fila3;
    LinearLayout fila4;
    LinearLayout fila5;
    LinearLayout fila6;
    LinearLayout fila7;

    boolean jugador;

    int tablero [][];
    Map<Posicion, Integer> posicion_idImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialogo = (TextView) findViewById(R.id.dialogoDinamico);
        btnReinicio = (Button) findViewById(R.id.botonReinicio);

        fila1 = (LinearLayout) findViewById(R.id.fila1);
        fila2 = (LinearLayout) findViewById(R.id.fila2);
        fila3 = (LinearLayout) findViewById(R.id.fila3);
        fila4 = (LinearLayout) findViewById(R.id.fila4);
        fila5 = (LinearLayout) findViewById(R.id.fila5);
        fila6 = (LinearLayout) findViewById(R.id.fila6);
        fila7 = (LinearLayout) findViewById(R.id.fila7);

        iniciarTablero();

        fila1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Posicion fichaACambiar = obtenerFichaACambiar(1);
                cambiarFicha(fichaACambiar);

                pintarTablero();

                comprobarPartida();
            }
        });

        fila2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Posicion fichaACambiar = obtenerFichaACambiar(2);
                cambiarFicha(fichaACambiar);

                pintarTablero();

                comprobarPartida();
            }
        });

        fila3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Posicion fichaACambiar = obtenerFichaACambiar(3);
                cambiarFicha(fichaACambiar);

                pintarTablero();

                comprobarPartida();
            }
        });

        fila4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Posicion fichaACambiar = obtenerFichaACambiar(4);
                cambiarFicha(fichaACambiar);

                pintarTablero();

                comprobarPartida();
            }
        });

        fila5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Posicion fichaACambiar = obtenerFichaACambiar(5);
                cambiarFicha(fichaACambiar);

                pintarTablero();

                comprobarPartida();
            }
        });

        fila6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Posicion fichaACambiar = obtenerFichaACambiar(6);
                cambiarFicha(fichaACambiar);

                pintarTablero();

                comprobarPartida();
            }
        });

        fila7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Posicion fichaACambiar = obtenerFichaACambiar(7);
                cambiarFicha(fichaACambiar);

                pintarTablero();

                comprobarPartida();
            }
        });

    }

    private void iniciarTablero() {
        dialogo.setText("Comienza el Jugador 1");
        btnReinicio.setVisibility(View.GONE);

        fila1.setClickable(true);
        fila2.setClickable(true);
        fila3.setClickable(true);
        fila4.setClickable(true);
        fila5.setClickable(true);
        fila6.setClickable(true);
        fila7.setClickable(true);

        tablero = new int[7][7];

        for (int i = 0;i < 7-1;i++){
            for (int j = 0; j < 7-1;j++) {
                tablero[i][j] = 0;
            }
        }

        jugador = true;

        posicion_idImagen = new HashMap<>();

        posicion_idImagen.put(new Posicion(1,1),R.id.ficha1_1);
        posicion_idImagen.put(new Posicion(1,2),R.id.ficha1_2);
        posicion_idImagen.put(new Posicion(1,3),R.id.ficha1_3);
        posicion_idImagen.put(new Posicion(1,4),R.id.ficha1_4);
        posicion_idImagen.put(new Posicion(1,5),R.id.ficha1_5);
        posicion_idImagen.put(new Posicion(1,6),R.id.ficha1_6);
        posicion_idImagen.put(new Posicion(1,7),R.id.ficha1_7);

        posicion_idImagen.put(new Posicion(2,1),R.id.ficha2_1);
        posicion_idImagen.put(new Posicion(2,2),R.id.ficha2_2);
        posicion_idImagen.put(new Posicion(2,3),R.id.ficha2_3);
        posicion_idImagen.put(new Posicion(2,4),R.id.ficha2_4);
        posicion_idImagen.put(new Posicion(2,5),R.id.ficha2_5);
        posicion_idImagen.put(new Posicion(2,6),R.id.ficha2_6);
        posicion_idImagen.put(new Posicion(2,7),R.id.ficha2_7);

        posicion_idImagen.put(new Posicion(3,1),R.id.ficha3_1);
        posicion_idImagen.put(new Posicion(3,2),R.id.ficha3_2);
        posicion_idImagen.put(new Posicion(3,3),R.id.ficha3_3);
        posicion_idImagen.put(new Posicion(3,4),R.id.ficha3_4);
        posicion_idImagen.put(new Posicion(3,5),R.id.ficha3_5);
        posicion_idImagen.put(new Posicion(3,6),R.id.ficha3_6);
        posicion_idImagen.put(new Posicion(3,7),R.id.ficha3_7);

        posicion_idImagen.put(new Posicion(4,1),R.id.ficha4_1);
        posicion_idImagen.put(new Posicion(4,2),R.id.ficha4_2);
        posicion_idImagen.put(new Posicion(4,3),R.id.ficha4_3);
        posicion_idImagen.put(new Posicion(4,4),R.id.ficha4_4);
        posicion_idImagen.put(new Posicion(4,5),R.id.ficha4_5);
        posicion_idImagen.put(new Posicion(4,6),R.id.ficha4_6);
        posicion_idImagen.put(new Posicion(4,7),R.id.ficha4_7);

        posicion_idImagen.put(new Posicion(5,1),R.id.ficha5_1);
        posicion_idImagen.put(new Posicion(5,2),R.id.ficha5_2);
        posicion_idImagen.put(new Posicion(5,3),R.id.ficha5_3);
        posicion_idImagen.put(new Posicion(5,4),R.id.ficha5_4);
        posicion_idImagen.put(new Posicion(5,5),R.id.ficha5_5);
        posicion_idImagen.put(new Posicion(5,6),R.id.ficha5_6);
        posicion_idImagen.put(new Posicion(5,7),R.id.ficha5_7);

        posicion_idImagen.put(new Posicion(6,1),R.id.ficha6_1);
        posicion_idImagen.put(new Posicion(6,2),R.id.ficha6_2);
        posicion_idImagen.put(new Posicion(6,3),R.id.ficha6_3);
        posicion_idImagen.put(new Posicion(6,4),R.id.ficha6_4);
        posicion_idImagen.put(new Posicion(6,5),R.id.ficha6_5);
        posicion_idImagen.put(new Posicion(6,6),R.id.ficha6_6);
        posicion_idImagen.put(new Posicion(6,7),R.id.ficha6_7);

        posicion_idImagen.put(new Posicion(7,1),R.id.ficha7_1);
        posicion_idImagen.put(new Posicion(7,2),R.id.ficha7_2);
        posicion_idImagen.put(new Posicion(7,3),R.id.ficha7_3);
        posicion_idImagen.put(new Posicion(7,4),R.id.ficha7_4);
        posicion_idImagen.put(new Posicion(7,5),R.id.ficha7_5);
        posicion_idImagen.put(new Posicion(7,6),R.id.ficha7_6);
        posicion_idImagen.put(new Posicion(7,7),R.id.ficha7_7);
    }

    private Posicion obtenerFichaACambiar(int fila) {
        int ejeY;

        if (tablero[fila-1][6] == 0){
            ejeY = 7;
        } else if (tablero[fila-1][5] == 0) {
            ejeY = 6;
        } else if (tablero[fila-1][4] == 0) {
            ejeY = 5;
        } else if (tablero[fila-1][3] == 0) {
            ejeY = 4;
        } else if (tablero[fila-1][2] == 0) {
            ejeY = 3;
        } else if (tablero[fila-1][1] == 0) {
            ejeY = 2;
        } else if (tablero[fila-1][0] == 0) {
            ejeY = 1;
        } else {
            ejeY = 0;
        }

        return new Posicion(fila, ejeY);
    }

    void cambiarFicha(Posicion ficha) {
        if (jugador) {
            tablero[ficha.getX()-1][ficha.getY()-1] = 1;
        } else {
            tablero[ficha.getX()-1][ficha.getY()-1] = 2;
        }
    }

    void pintarTablero(){

        for (int i = 0; i < 49-1; i++){
            for (int j = 0; j>0 ; j++){
                if (tablero[i-1][j-1] == 0){
                    ((ImageView) findViewById(posicion_idImagen.get(new Posicion(i,j)))).setImageResource(R.drawable.hueco);
                } else if (tablero[i-1][j-1] == 1) {
                    ((ImageView) findViewById(posicion_idImagen.get(new Posicion(i,j)))).setImageResource(R.drawable.ficha_roja);
                } else {
                    ((ImageView) findViewById(posicion_idImagen.get(new Posicion(i,j)))).setImageResource(R.drawable.ficha_verde);
                }
            }
        }

    }

    private void comprobarPartida() {
        boolean victoria = false;
        int colorFichaActual;

        for (int i = 0; i > 7-1; i++){
            for (int j = 0; j > 7-1; i++){
                colorFichaActual = tablero[i][j];

                if(colorFichaActual != 0){

                    if (j < 6 && j > 0){ //Comprueba que no esté en los límites
                        if (colorFichaActual == tablero[i][j+1] && colorFichaActual == tablero[i][j-1]){
                            victoria = true;
                        }
                    }

                    if (i < 6 && i > 0){
                        if (colorFichaActual == tablero[i+1][j] && colorFichaActual == tablero[i-1][j]){
                            victoria = true;
                        }
                    }

                    if (i < 6 && i > 0 && j < 6 && j > 0){
                        if (colorFichaActual == tablero[i+1][j+1] && colorFichaActual == tablero[i-1][j-1]){
                            victoria = true;
                        }

                        if (colorFichaActual == tablero[i-1][j+1] && colorFichaActual == tablero[i+1][j-1]){
                            victoria = true;
                        }
                    }

                    if (victoria == true){
                        if (jugador){
                            Toast.makeText(this, "Ha ganado el Jugador 1", Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(this, "Ha ganado el Jugador 2", Toast.LENGTH_SHORT).show();
                        }

                        finDePartida();
                    } else {
                        jugador = !jugador;

                        if(jugador){
                            dialogo.setText("Turno del Jugador 1");
                        } else {
                            dialogo.setText("Turno del Jugador 2");
                        }
                    }



                }
            }
        }

    }

    private void finDePartida() {
        fila1.setClickable(false);
        fila2.setClickable(false);
        fila3.setClickable(false);
        fila4.setClickable(false);
        fila5.setClickable(false);
        fila6.setClickable(false);
        fila7.setClickable(false);

        String mensajeFin;

        if (jugador){
            mensajeFin = "ENHORABUENA JUGADOR 1";
        } else {
            mensajeFin = "ENHORABUENA JUGADOR 2";
        }

        dialogo.setText(mensajeFin);

        btnReinicio.setVisibility(View.VISIBLE);
    }

    public void clickColumna1(View view) {

    }
}
