package di.menuopciones;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import di.menuopciones.fragment.AlumnoFragment;
import di.menuopciones.fragment.BusquedaDialogFragment;
import di.menuopciones.interfaces.IAlumnoListener;
import di.menuopciones.pojo.Alumno;

public class MainActivity extends AppCompatActivity implements IAlumnoListener{
    List<Alumno> matriculados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        matriculados = new ArrayList<>();
        matriculados.add(new Alumno("Batman","3ºBAT","8.3"));
        matriculados.add(new Alumno("Hermione Granger","5º Magia & Hechicería","10.0"));
        matriculados.add(new Alumno("Yoda","8º de Fuerza","5.5"));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirRegistroUsuario();
            }
        });

        Fragment fragment = new AlumnoFragment();

        Bundle bundle = new Bundle();

        for (int i = 0; i < matriculados.size(); i++) {
            bundle.putParcelable("matriculado"+i, Parcels.wrap(matriculados.get(i)));
        }

        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor, fragment).commit();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_actualizar:
                actualizarLista();
                break;
            case R.id.action_buscar_alumno:
                DialogFragment dialogoBusqueda = new BusquedaDialogFragment();
                dialogoBusqueda.show(getSupportFragmentManager(), "Dialogo");
                dialogoBusqueda.setCancelable(false);
                dialogoBusqueda.onDismiss(new DialogInterface() {
                    @Override
                    public void cancel() {

                    }

                    @Override
                    public void dismiss() {

                    }
                });
                break;
            case R.id.action_logout:
                logOut();
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case Constantes.MATRICULAR_ALUMNO:
                Alumno alumnoNuevo = Parcels.unwrap(data.getExtras().getParcelable("AlumnoNuevo"));
                matriculados.add(alumnoNuevo);
                break;
            case Constantes.EDITAR_ALUMNO:
                if (resultCode == RESULT_OK){
                    editarAlumno((Alumno) Parcels.unwrap(data.getExtras().getParcelable("alumnoEditado")));
                } else {

                }
                break;
        }
    }

    private void abrirRegistroUsuario() {
        Intent i = new Intent(this, NuevoAlumnoActivity.class);

        startActivityForResult(i, Constantes.MATRICULAR_ALUMNO);
    }

    private void logOut() {

    }

    private void editarAlumno(Alumno alumno) {
        int aBorrar = -1;
        List<Alumno> listaAux = matriculados;

        for (int i = 0; i < listaAux.size(); i++){
            if (alumno.getNombre().equalsIgnoreCase(listaAux.get(i).getNombre())){
                aBorrar = i;
            }
        }

        if (aBorrar >= 0){
            matriculados.remove(aBorrar);
            matriculados.add(alumno);
            Toast.makeText(this, listaAux.get(aBorrar).getNombre()+" ha sido editado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Problemas al editar", Toast.LENGTH_SHORT).show();
        }
    }

    private void buscarAlumno(String nombreAlumno) {
        List<Alumno> listaAux = new ArrayList<>();

        for (int i = 0; i < listaAux.size(); i++){
            if (matriculados.get(i).getNombre().contains(nombreAlumno)){
                listaAux.add(matriculados.get(i));
            }
        }

        Fragment fragment = new AlumnoFragment();
        Bundle bundle = new Bundle();

        for (int i = 0; i < listaAux.size(); i++) {
            bundle.putParcelable("matriculado"+i, Parcels.wrap(listaAux.get(i)));
        }

        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment).commit();

    }

    private void desmatricularAlumno(Alumno alumno) {
        List<Alumno> listaAux = matriculados;
        for (int i = 0; i < listaAux.size(); i++){
            if (alumno.getNombre().equalsIgnoreCase(listaAux.get(i).getNombre())){
                matriculados.remove(i);
                Toast.makeText(this, alumno.getNombre()+" ha sido desmatriculado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void actualizarLista() {
        Fragment fragment = new AlumnoFragment();
        Bundle bundle = new Bundle();

        for (int i = 0; i < matriculados.size(); i++) {
            bundle.putParcelable("matriculado"+i, Parcels.wrap(matriculados.get(i)));
        }

        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment).commit();
    }

    @Override
    public void onClickAlumno(Alumno alumno) {

    }

    @Override
    public void onClickEditarAlumno(Alumno alumno) {
        editarAlumno(alumno);

        Intent intent = new Intent(this, EditarAlumnoActivity.class);
        intent.putExtra("AlumnoAEditar", Parcels.wrap(alumno));
        startActivityForResult(intent, Constantes.EDITAR_ALUMNO);

    }

    @Override
    public void onClickEliminarAlumno(Alumno alumno) {
        desmatricularAlumno(alumno);
    }

    @Override
    public void onClickBuscarAlumno(String alumnoABuscar) {
        buscarAlumno(alumnoABuscar);
    }
}
