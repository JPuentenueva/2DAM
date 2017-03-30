package di.contextmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import di.contextmenu.fragments.AlumnoFragment;
import di.contextmenu.pojo.Alumno;

public class MainActivity extends AppCompatActivity {
    ListView listViewAlumnos;
    List<Alumno> alumnos;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO buscar alumno
            }
        });

        alumnos = new ArrayList<>();

        alumnos.add(new Alumno("Elena", "Nito del Bosque"));
        alumnos.add(new Alumno("Aitor", "Tilla"));
        alumnos.add(new Alumno("Donpi", "Topocho"));
        alumnos.add(new Alumno("Marsu", "Pilami"));
        alumnos.add(new Alumno("Rosa", "Melcacho"));
        alumnos.add(new Alumno("Kaiser", "Sosé"));

        fragment = new AlumnoFragment();
        Bundle b = new Bundle();
        b.putParcelable("alumnos", Parcels.wrap(alumnos));

        fragment.setArguments(b);

        listViewAlumnos = (ListView) findViewById(R.id.listViewAlumnos);

        registerForContextMenu(listViewAlumnos);
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_matricular) {
            Intent i = new Intent();
            startActivityForResult(i, Constantes.MATRICULAR_ALUMNO);
            return true;
        } else if (id == R.id.action_matricular) {
            return true;
        } else if (id == R.id.action_logout) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
