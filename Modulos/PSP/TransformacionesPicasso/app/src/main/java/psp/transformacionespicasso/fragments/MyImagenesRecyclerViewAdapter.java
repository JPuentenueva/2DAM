package psp.transformacionespicasso.fragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.ColorFilterTransformation;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;
import jp.wasabeef.picasso.transformations.gpu.ContrastFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.KuwaharaFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.PixelationFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.SepiaFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.ToonFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.VignetteFilterTransformation;
import psp.transformacionespicasso.R;
import psp.transformacionespicasso.interfaces.IOnClickImagen;
import psp.transformacionespicasso.pojo.Imagen;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Imagen} and makes a call to the
 * specified {@link IOnClickImagen}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyImagenesRecyclerViewAdapter extends RecyclerView.Adapter<MyImagenesRecyclerViewAdapter.ViewHolder> {

    private final List<Imagen> mValues;
    private final IOnClickImagen mListener;
    private Context ctx;

    public MyImagenesRecyclerViewAdapter(List<Imagen> items, IOnClickImagen listener, Context contexto) {
        mValues = items;
        mListener = listener;
        ctx = contexto;
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

        switch(position){
            case 0:
                Picasso.with(ctx).load(holder.mItem.getUrl())
                        .resize(150, 150)
                        .centerCrop()
                        .transform(new ColorFilterTransformation(R.color.colorPrimary))
                        .into(holder.mImageView);
                break;
            case 1:
                Picasso.with(ctx).load(holder.mItem.getUrl())
                        .resize(150, 150)
                        .centerCrop()
                        .transform(new CropCircleTransformation())
                        .into(holder.mImageView);

                break;
            case 2:
                Picasso.with(ctx).load(holder.mItem.getUrl())
                        .resize(150, 150)
                        .centerCrop()
                        .transform(new ContrastFilterTransformation(ctx))
                        .into(holder.mImageView);

                break;
            case 3:
                Picasso.with(ctx).load(holder.mItem.getUrl())
                        .resize(150, 150)
                        .centerCrop()
                        .transform(new RoundedCornersTransformation(20, 2))
                        .into(holder.mImageView);

                break;
            case 4:
                Picasso.with(ctx).load(holder.mItem.getUrl())
                        .resize(150, 150)
                        .centerCrop()
                        .transform(new KuwaharaFilterTransformation(ctx))
                        .into(holder.mImageView);

                break;
            case 5:
                Picasso.with(ctx).load(holder.mItem.getUrl())
                        .resize(150, 150)
                        .centerCrop()
                        .transform(new VignetteFilterTransformation(ctx))
                        .into(holder.mImageView);

                break;
            case 6:
                Picasso.with(ctx).load(holder.mItem.getUrl())
                        .resize(150, 150)
                        .centerCrop()
                        .transform(new PixelationFilterTransformation(ctx))
                        .into(holder.mImageView);

                break;
            case 7:
                Picasso.with(ctx).load(holder.mItem.getUrl())
                        .resize(150, 150)
                        .centerCrop()
                        .transform(new SepiaFilterTransformation(ctx))
                        .into(holder.mImageView);

                break;
            case 8:
                Picasso.with(ctx).load(holder.mItem.getUrl())
                        .resize(150, 150)
                        .centerCrop()
                        .transform(new ToonFilterTransformation(ctx))
                        .into(holder.mImageView);

                break;
        }

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
        public Imagen mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (ImageView) view.findViewById(R.id.imageView);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
