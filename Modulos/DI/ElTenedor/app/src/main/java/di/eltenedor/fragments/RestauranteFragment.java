package di.eltenedor.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.parceler.Parcels;

import di.eltenedor.R;
import di.eltenedor.interfaces.IRestauranteListener;
import di.eltenedor.pojo.Restaurante;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link IRestauranteListener}
 * interface.
 */
public class RestauranteFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private IRestauranteListener mListener;
    private List<Restaurante> listaRestaurantes;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestauranteFragment() {

    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RestauranteFragment newInstance(int columnCount) {
        RestauranteFragment fragment = new RestauranteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listaRestaurantes = new ArrayList<>();
        List<String> etiquetas1 = new ArrayList<>();
        List<String> etiquetas2 = new ArrayList<>();
        List<String> etiquetas3 = new ArrayList<>();

        etiquetas1.add("Centro");
        etiquetas1.add("Elegante");
        etiquetas1.add("Catering");
        etiquetas1.add("Tradicional");

        etiquetas2.add("Jungle");
        etiquetas2.add("Copas");
        etiquetas2.add("Calidad");
        etiquetas2.add("Música");

        etiquetas3.add("Tapas");
        etiquetas3.add("Bar");
        etiquetas3.add("Restaurante");
        etiquetas3.add("Cuchareo");


        listaRestaurantes.add(new Restaurante("La Era", "Avda Kansas City, 9; San Pablo Santa Justa, Sevilla",4,etiquetas1,R.drawable.la_era));
        listaRestaurantes.add(new Restaurante("Clorofila", "Calle Santander, 15; Frente a la Torre del Oro, Sevilla",4,etiquetas2,R.drawable.clorofila));
        listaRestaurantes.add(new Restaurante("Entre Dos Hermandades", "Recaredo, 13; Casco Antiguo, Sevilla",3,etiquetas3,R.drawable.entre_dos_hermandades));

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurante_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new RestauranteAdapter(listaRestaurantes, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IRestauranteListener) {
            mListener = (IRestauranteListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement IRestauranteListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
