package di.putaditagridviewrecyclerview.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import di.putaditagridviewrecyclerview.R;
import di.putaditagridviewrecyclerview.interfaces.IOnClickOpcionMenu;
import di.putaditagridviewrecyclerview.pojo.OpcionMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link IOnClickOpcionMenu}
 * interface.
 */
public class OpcionMenuFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 3;
    private IOnClickOpcionMenu mListener;
    List<OpcionMenu> list;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public OpcionMenuFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static OpcionMenuFragment newInstance(int columnCount) {
        OpcionMenuFragment fragment = new OpcionMenuFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        list.add(new OpcionMenu(R.drawable.ic_email_black_24dp,"Recibidos"));
        list.add(new OpcionMenu(R.drawable.ic_access_time_black_24dp,"Pospuestos"));
        list.add(new OpcionMenu(R.drawable.ic_done_black_24dp,"Completados"));
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_opcionmenu_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new OpcionMenuAdapter(list, mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IOnClickOpcionMenu) {
            mListener = (IOnClickOpcionMenu) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement IOnClickOpcionMenu");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}
