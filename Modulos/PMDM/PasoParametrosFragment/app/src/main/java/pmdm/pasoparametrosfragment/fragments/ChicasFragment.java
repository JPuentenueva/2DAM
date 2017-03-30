package pmdm.pasoparametrosfragment.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pmdm.pasoparametrosfragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChicasFragment extends Fragment {
    TextView tv;

    public ChicasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_megustas, container, false);
        tv = (TextView) v.findViewById(R.id.textViewMeGustas);

        Bundle extras = getArguments();
        int mg = extras.getInt("meGustas");

        tv.setText(mg+" chicas");
        v.setBackgroundColor(R.color.azul);
        return v;
    }

}
