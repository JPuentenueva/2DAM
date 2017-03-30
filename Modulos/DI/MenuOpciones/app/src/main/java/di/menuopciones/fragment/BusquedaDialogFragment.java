package di.menuopciones.fragment;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import di.menuopciones.R;
import di.menuopciones.interfaces.IAlumnoListener;
import di.menuopciones.pojo.Alumno;

/**
 * A simple {@link Fragment} subclass.
 */
public class BusquedaDialogFragment extends DialogFragment {
    IAlumnoListener mListener;

    public BusquedaDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_buscar_alumno, null);

        final EditText texto = (EditText) v.findViewById(R.id.editAlumnoABuscar);

        Button btn = (Button) v.findViewById(R.id.btnBuscarAlumno);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Esta línea de código debe ejecutarse cuando haga click en un elemento
                // de la lista
                mListener.onClickBuscarAlumno(texto.getText().toString());
                BusquedaDialogFragment.this.getDialog().cancel();
            }
        });

        builder.setView(v);
        builder.setMessage("Buscar un alumno")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Send the negative button event back to the host activity
                        dialog.dismiss();
                    }
                });

        return null;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IAlumnoListener) {
            mListener = (IAlumnoListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement IAlumnoListener");
        }
    }
}
