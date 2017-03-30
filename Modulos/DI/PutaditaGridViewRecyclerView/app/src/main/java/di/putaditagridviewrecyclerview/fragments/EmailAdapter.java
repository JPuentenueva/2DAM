package di.putaditagridviewrecyclerview.fragments;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import di.putaditagridviewrecyclerview.R;
import di.putaditagridviewrecyclerview.interfaces.IOnClickEmail;
import di.putaditagridviewrecyclerview.pojo.EmailItem;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link EmailItem} and makes a call to the
 * specified {@link IOnClickEmail}.
 * TODO: Replace the implementation with code for your data type.
 */
public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.ViewHolder> {

    private final List<EmailItem> mValues;
    private final IOnClickEmail mListener;
    private Context ctx;

    public EmailAdapter(List<EmailItem> items, IOnClickEmail listener, Context ctx) {
        mValues = items;
        mListener = listener;
        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_email, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mLetraView.setText(holder.mItem.getLetra());

        if (position == 0){
            holder.mLetraView.setBackgroundColor(ContextCompat.getColor(ctx,R.color.azul_claro));
        } else if (position == 1) {
            holder.mLetraView.setBackgroundColor(ContextCompat.getColor(ctx,R.color.naranja));
        } else  if (position == 2) {
            holder.mLetraView.setBackgroundColor(ContextCompat.getColor(ctx,R.color.violeta));
        } else {
            holder.mLetraView.setBackgroundColor(ContextCompat.getColor(ctx,R.color.rosa));
        }

        holder.mAsuntoView.setText(holder.mItem.getContenido());
        holder.mContenidoView.setText(holder.mItem.getContenido());
        if(holder.mItem.isFavorito()){
            holder.mFavView.setImageResource(R.drawable.ic_star_black_24dp);
        } else{
            holder.mFavView.setImageResource(R.drawable.ic_star_border_black_24dp);
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onClickEmail(holder.mItem);
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
        public final TextView mLetraView;
        public final TextView mAsuntoView;
        public final TextView mContenidoView;
        public final ImageView mFavView;
        public EmailItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mLetraView = (TextView) view.findViewById(R.id.textViewLetra);
            mAsuntoView = (TextView) view.findViewById(R.id.textViewAsunto);
            mContenidoView = (TextView) view.findViewById(R.id.textViewContenido);
            mFavView = (ImageView) view.findViewById(R.id.imageViewFav);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mAsuntoView.getText() + "'";
        }
    }
}
