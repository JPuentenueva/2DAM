package pmdm.reproductordemusica.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pmdm.reproductordemusica.R;
import pmdm.reproductordemusica.interfaces.ICancionesListener;
import pmdm.reproductordemusica.pojo.Cancion;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link ICancionesListener}
 * interface.
 */
public class CancionesFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private ICancionesListener mListener;
    List<Cancion> canciones;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CancionesFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CancionesFragment newInstance(int columnCount) {
        CancionesFragment fragment = new CancionesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        canciones = new ArrayList<>();
        canciones.add(new Cancion(R.drawable.piezas_y_jayder_mal_ejemplo_g1,
                "Piezas - Malicia (con Legendario)",
                "http://dl.mp3xd.eu/xd/YyqZgKKmom24/malicia-piezas-y-jayder-ft.mp3"));

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
            }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cancion_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new CancionesAdapter(canciones, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ICancionesListener) {
            mListener = (ICancionesListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ICancionesListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
