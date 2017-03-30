package ad.applas.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ad.applas.R;
import ad.applas.interfaces.IPaisListener;
import ad.applas.pojo.Pais;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Pais} and makes a call to the
 * specified {@link IPaisListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class PaisesAdapter extends RecyclerView.Adapter<PaisesAdapter.ViewHolder> {

    private final List<Pais> mValues;
    private final IPaisListener mListener;

    public PaisesAdapter(List<Pais> items, IPaisListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_pais, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNombrePaisView.setText(holder.mItem.getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onClickPais(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mNombrePaisView;
        public Pais mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNombrePaisView = (TextView) view.findViewById(R.id.textViewNombrePais);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
