package di.gestionllamadaslist;

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
 * Created by jmpuentenueva on 26/10/2016.
 */

public class LlamadasAdapter extends ArrayAdapter {
    Context ctx;
    int layout;
    List llamadas;

    public LlamadasAdapter(Context context, int resource, List<Llamada> objects) {
        super(context, resource, objects);
        ctx = context;
        layout = resource;
        llamadas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layout, parent, false);
        Llamada actual = (Llamada) llamadas.get(position);

        TextView contacto = (TextView) v.findViewById(R.id.textViewContacto);
        TextView fechaYHora = (TextView) v.findViewById(R.id.textViewFechaHora);
        TextView duracion = (TextView) v.findViewById(R.id.textViewDuracion);
        ImageView tipo = (ImageView) v.findViewById(R.id.imageViewTipoLlamada);

        if (actual.getNombreContacto() != null){
            contacto.setText(actual.getNombreContacto());
        } else {
            contacto.setText(actual.getNumContacto());
        }

        fechaYHora.setText(actual.getFecha() + ", " + actual.getHoraInicio());

        int minutos;
        int segundos;

        minutos = actual.getDuracion() / 60;
        segundos = actual.getDuracion() % 60;

        duracion.setText(minutos+"m "+segundos+"s");

        if(actual.getTipo() == "recibida"){
            tipo.setImageResource(R.drawable.ic_llamadarecibida);
        }else if (actual.getTipo() == "enviada") {
            tipo.setImageResource(R.drawable.ic_llamadaenviada);
        }else{
            tipo.setImageResource(R.drawable.ic_llamadanorecibida);

        }

        return v;
    }
}
