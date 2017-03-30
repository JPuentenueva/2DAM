package di.ftpservice.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import di.ftpservice.R;
import di.ftpservice.interfaces.IArchivoListener;
import di.ftpservice.pojo.Archivo;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Archivo} and makes a call to the
 * specified {@link IArchivoListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ArchivosAdapter extends RecyclerView.Adapter<ArchivosAdapter.ViewHolder> {

    private final List<Archivo> mValues;
    private final IArchivoListener mListener;

    public ArchivosAdapter(List<Archivo> items, IArchivoListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_archivo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNombreView.setText(mValues.get(position).getNombre());

        //TODO holder.mIconoView;

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onClickArchivo(holder.mItem);
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
        public final ImageView mIconoView;
        public final TextView mTamanyoView;
        public Archivo mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNombreView = (TextView) view.findViewById(R.id.nombreArchivo);
            mIconoView = (ImageView) view.findViewById(R.id.iconoArchivo);
            mTamanyoView = (TextView) view.findViewById(R.id.tamanyoArchivo);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
