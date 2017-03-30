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

import java.util.ArrayList;
import java.util.List;

import di.putaditagridviewrecyclerview.R;
import di.putaditagridviewrecyclerview.interfaces.IOnClickEmail;
import di.putaditagridviewrecyclerview.pojo.EmailItem;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link IOnClickEmail}
 * interface.
 */
public class EmailFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private IOnClickEmail mListener;
    List<EmailItem> list;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EmailFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static EmailFragment newInstance(int columnCount) {
        EmailFragment fragment = new EmailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        list.add(new EmailItem("Los Escarabajos","Un viaje mágico, misterioso y granadino, yo que se", false));
        list.add(new EmailItem("TIBCO Jaspersoft","Our Apologies - Seminar invitation", false));
        list.add(new EmailItem("Klout","Your Klout Score went up!", false));
        list.add(new EmailItem("Google AdSense","Nos gustaria conocer tu opinion sobre algo que no se que es", false));
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_email_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new EmailAdapter(list, mListener, context));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IOnClickEmail) {
            mListener = (IOnClickEmail) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement IOnClickEmail");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
