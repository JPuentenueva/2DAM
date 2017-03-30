package di.footballplayerslistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jmpuentenueva on 24/10/2016.
 */

public class FootballPlayerAdapter extends ArrayAdapter<FootballPlayer> {
    Context ctx;
    int res;
    List<FootballPlayer> list;

    public FootballPlayerAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        ctx = context;
        res = resource;
        list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(res, parent, false);

        // 1. Rescato el elemento actual que estoy dibujando
        // mediante el parámetro position que recibo en este método
        FootballPlayer current = list.get(position);

        // 2. Obtener del layout todos los componentes visuales
        // que tengo que modificar
        TextView nombreTV = (TextView) v.findViewById(R.id.textViewNombre);
        TextView equipoTV = (TextView) v.findViewById(R.id.textViewEquipo);
        TextView edadTV =  (TextView) v.findViewById(R.id.textViewEdad);
        TextView golesTV = (TextView) v.findViewById(R.id.textViewNumGoles);
        TextView copasTV = (TextView) v.findViewById(R.id.textViewNumCopas);

        ImageView star1 = (ImageView) v.findViewById(R.id.imageViewStar1);
        ImageView star2 = (ImageView) v.findViewById(R.id.imageViewStar2);
        ImageView star3 = (ImageView) v.findViewById(R.id.imageViewStar3);
        ImageView star4 = (ImageView) v.findViewById(R.id.imageViewStar4);
        ImageView star5 = (ImageView) v.findViewById(R.id.imageViewStar5);

        if(current.getValoracion() == 5.0){
            star5.setImageResource(R.drawable.ic_star);
        }
        if(current.getValoracion() > 3.5){
            star4.setImageResource(R.drawable.ic_star);
        }
        if(current.getValoracion() > 2.5){
            star3.setImageResource(R.drawable.ic_star);
        }
        if(current.getValoracion() > 1.5){
            star2.setImageResource(R.drawable.ic_star);
        }
        if(current.getValoracion() > 0.5){
            star1.setImageResource(R.drawable.ic_star);
        }

        nombreTV.setText(current.getNombre());
        edadTV.setText(Integer.toString(current.getEdad()) + " años");
        equipoTV.setText(current.getEquipo());
        golesTV.setText(Integer.toString(current.getGoles()));
        copasTV.setText(Integer.toString(current.getCopas()));

        return v;
    }
}
