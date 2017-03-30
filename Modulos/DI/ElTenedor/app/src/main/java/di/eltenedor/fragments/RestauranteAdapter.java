package di.eltenedor.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import di.eltenedor.R;
import di.eltenedor.interfaces.IRestauranteListener;
import di.eltenedor.pojo.Restaurante;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Restaurante} and makes a call to the
 * specified {@link IRestauranteListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.ViewHolder> {

    private final List<Restaurante> mValues;
    private final IRestauranteListener mListener;

    public RestauranteAdapter(List<Restaurante> items, IRestauranteListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_restaurante, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.mNombreView.setText(holder.mItem.getNombre());
        holder.mDireccionView.setText(holder.mItem.getDireccion());
        holder.mValoracionView.setText("Valoración: "+holder.mItem.getValoracion()+"/5");

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onClickRestaurante(holder.mItem);
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
        public final TextView mNombreView;
        public final TextView mDireccionView;
        public final TextView mValoracionView;
        public Restaurante mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNombreView = (TextView) view.findViewById(R.id.nombreRestaurante);
            mDireccionView = (TextView) view.findViewById(R.id.direccionRestaurante);
            mValoracionView = (TextView) view.findViewById(R.id.valoracionRestaurante);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
