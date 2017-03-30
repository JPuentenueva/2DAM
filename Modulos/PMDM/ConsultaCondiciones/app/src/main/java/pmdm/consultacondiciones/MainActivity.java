package pmdm.consultacondiciones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.campoNombre);
        btn = (Button) findViewById(R.id.consultar);
    }

    public void consultarCondiciones(View view) {
        String nom = et.getText().toString();

        if (nom == null){
            Toast.makeText(this,"No indicó nombre en el registro",Toast.LENGTH_SHORT);
        }else{
            Intent i = new Intent(this,CondicionesActivity.class);

            i.putExtra("nombre",nom);
            startActivityForResult(i,1);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){

        if(resultCode == RESULT_OK){
            Toast.makeText(this,"Aceptó las condiciones de registro",Toast.LENGTH_SHORT);
        } else{
            Toast.makeText(this,"Rechazó las condiciones de registro",Toast.LENGTH_SHORT);
        }
    }
}
