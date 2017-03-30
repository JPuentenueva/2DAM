package ad.temperaturasserializer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ad.temperaturasserializer.interfaces.IOnClickDia;
import ad.temperaturasserializer.pojo.Dia;
import ad.temperaturasserializer.pojo.Prediccion;
import ad.temperaturasserializer.pojo.Raiz;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Dia} and makes a call to the
 * specified {@link IOnClickDia}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyDiasRecyclerViewAdapter extends RecyclerView.Adapter<MyDiasRecyclerViewAdapter.ViewHolder> {

    private final List<Dia> mValues;
    private final IOnClickDia mListener;
    private String ciudad;

    public MyDiasRecyclerViewAdapter(Raiz predic, IOnClickDia listener) {
        ciudad = predic.getNombre();
        mValues = predic.getPrediccion().getDias();
        mListener = listener;
    }

    public MyDiasRecyclerViewAdapter(List<Dia> listaDias, IOnClickDia mListener, Context context) {
        this.mValues = listaDias;
        this.mListener = mListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_dia, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mCiudadView.setText(ciudad);
        Date date = holder.mItem.getFecha();
        Calendar gc = Calendar.getInstance();
        gc.setTime(date);
        holder.mFechaView.setText(gc.DAY_OF_MONTH + "/" + gc.MONTH + "/" + gc.YEAR);
        holder.mMaxView.setText(holder.mItem.getTemperatura().getMaxima());
        holder.mMinView.setText(holder.mItem.getTemperatura().getMinima());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mMaxView;
        public final TextView mMinView;
        public final TextView mCiudadView;
        public final TextView mFechaView;
        public Dia mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mMaxView = (TextView) view.findViewById(R.id.textViewTempMaxima);
            mMinView = (TextView) view.findViewById(R.id.textViewTempMinima);
            this.mCiudadView = (TextView) view.findViewById(R.id.textViewCiudad);
            this.mFechaView = (TextView) view.findViewById(R.id.textViewFecha);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
