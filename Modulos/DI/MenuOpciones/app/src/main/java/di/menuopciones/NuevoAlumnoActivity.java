package di.menuopciones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.parceler.Parcels;

import di.menuopciones.pojo.Alumno;

public class NuevoAlumnoActivity extends AppCompatActivity {
    EditText editNombre;
    EditText editCurso;
    EditText editNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_alumno);

        editNombre = (EditText) findViewById(R.id.editNombre);
        editCurso = (EditText) findViewById(R.id.editCurso);
        editNota = (EditText) findViewById(R.id.editNota);

    }

    public void matricular(View view) {
        Alumno alumno;

        if (editNombre.getText().toString().isEmpty() ||
                editCurso.getText().toString().isEmpty() ||
                editNota.getText().toString().isEmpty()) {
            Toast.makeText(this, "Faltan campos por rellenar", Toast.LENGTH_SHORT).show();
        } else {
            alumno = new Alumno(editNombre.getText().toString(), editCurso.getText().toString(), editNota.getText().toString());
            Intent i = getIntent();
            i.putExtra("AlumnoNuevo",Parcels.wrap(alumno));

            setResult(RESULT_OK, i);
            finish();
        }
    }

    public void cancelar(View view) {
        Intent i = getIntent();

        setResult(RESULT_CANCELED, i);
        finish();
    }

}
