package psp.galerianasa.fragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import psp.galerianasa.R;
import psp.galerianasa.interfaces.IimagenClickListener;
import psp.galerianasa.pojo.Imagen;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Imagen} and makes a call to the
 * specified {@link MyImagenRecyclerViewAdapter}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyImagenRecyclerViewAdapter extends RecyclerView.Adapter<MyImagenRecyclerViewAdapter.ViewHolder> {

    private final List<Imagen> mValues;
    private final IimagenClickListener mListener;
    private final Context context;

    public MyImagenRecyclerViewAdapter(List<Imagen> items, IimagenClickListener listener, Context context) {
        mValues = items;
        mListener = listener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_imagen, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNombreImagen.setText(mValues.get(position).getNombre());

        Glide.with(context).load(mValues.get(position).getUrl().getUrl())
                .override(80, 80)
                .centerCrop()
                .into(holder.mUrlImagen);
        holder.mFechaImagen.setText(mValues.get(position).getFecha());


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onImagenClick(holder.mItem);
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
        public final TextView mNombreImagen;
        public final ImageView mUrlImagen;
        public final TextView mFechaImagen;
        public Imagen mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            this.mNombreImagen = (TextView) mView.findViewById(R.id.textViewNombreImagen);
            this.mUrlImagen = (ImageView) mView.findViewById(R.id.imageViewElemento);
            this.mFechaImagen = (TextView) mView.findViewById(R.id.textViewFechaImagen);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNombreImagen.getText() + "'";
        }
    }
}
