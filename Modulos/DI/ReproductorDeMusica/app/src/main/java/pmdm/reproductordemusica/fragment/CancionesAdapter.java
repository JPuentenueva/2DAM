package pmdm.reproductordemusica.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pmdm.reproductordemusica.R;
import pmdm.reproductordemusica.interfaces.ICancionesListener;
import pmdm.reproductordemusica.pojo.Cancion;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Cancion} and makes a call to the
 * specified {@link ICancionesListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class CancionesAdapter extends RecyclerView.Adapter<CancionesAdapter.ViewHolder> {

    private final List<Cancion> mValues;
    private final ICancionesListener mListener;

    public CancionesAdapter(List<Cancion> items, ICancionesListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_cancion, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTituloView.setText(holder.mItem.getTitulo());


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onClickCancion(holder.mItem);
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
        public final TextView mTituloView;
        public Cancion mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTituloView = (TextView) view.findViewById(R.id.txVwNombreCancion);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
