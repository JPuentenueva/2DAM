package di.menuopciones;

import android.content.Intent;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.parceler.Parcels;

import di.menuopciones.pojo.Alumno;

public class EditarAlumnoActivity extends AppCompatActivity {
    EditText editNombre;
    EditText editCurso;
    EditText editNota;
    Alumno alumnoAEditar;
    Alumno alumnoEditado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_alumno);

        editNombre = (EditText) findViewById(R.id.editNombre);
        editCurso = (EditText) findViewById(R.id.editCurso);
        editNota = (EditText) findViewById(R.id.editNota);

        alumnoAEditar = Parcels.unwrap(getIntent().getExtras().getParcelable("AlumnoAEditar"));

        editNombre.setText(alumnoAEditar.getNombre());
        editCurso.setText(alumnoAEditar.getCurso());
        editNota.setText(alumnoAEditar.getNotaMedia());
    }

    public void confirmar(View view) {
        Intent i = getIntent();

        alumnoEditado = new Alumno(editNombre.getText().toString(),
                editCurso.getText().toString(),
                editNota.getText().toString());

        i.putExtra("alumnoEditado", Parcels.wrap(alumnoEditado));

        setResult(RESULT_OK, i);
        finish();
    }

    public void cancelar(View view) {
        Intent i = getIntent();

        setResult(RESULT_CANCELED, i);
        finish();
    }
}
