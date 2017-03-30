package di.putaditagridviewrecyclerview.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import di.putaditagridviewrecyclerview.R;
import di.putaditagridviewrecyclerview.interfaces.IOnClickOpcionMenu;
import di.putaditagridviewrecyclerview.pojo.OpcionMenu;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link OpcionMenu} and makes a call to the
 * specified {@link IOnClickOpcionMenu}.
 * TODO: Replace the implementation with code for your data type.
 */
public class OpcionMenuAdapter extends RecyclerView.Adapter<OpcionMenuAdapter.ViewHolder> {

    private final List<OpcionMenu> mValues;
    private final IOnClickOpcionMenu mListener;

    public OpcionMenuAdapter(List<OpcionMenu> items, IOnClickOpcionMenu listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_opcionmenu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mImageView.setImageResource(holder.mItem.getImagen());
        holder.mOpcionView.setText(holder.mItem.getNombre());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
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
        public final ImageView mImageView;
        public final TextView mOpcionView;
        public OpcionMenu mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (ImageView) view.findViewById(R.id.imageViewOpcion);
            mOpcionView = (TextView) view.findViewById(R.id.textViewAsunto);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
