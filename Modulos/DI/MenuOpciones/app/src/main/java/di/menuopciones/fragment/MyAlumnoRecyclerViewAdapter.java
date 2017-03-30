package di.menuopciones.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import di.menuopciones.R;
import di.menuopciones.interfaces.IAlumnoListener;
import di.menuopciones.pojo.Alumno;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Alumno} and makes a call to the
 * specified {@link IAlumnoListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyAlumnoRecyclerViewAdapter extends RecyclerView.Adapter<MyAlumnoRecyclerViewAdapter.ViewHolder> {

    private final List<Alumno> mValues;
    private final IAlumnoListener mListener;

    public MyAlumnoRecyclerViewAdapter(List<Alumno> items, IAlumnoListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_alumno, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.mNombreView.setText(holder.mItem.getNombre());
        holder.mCursoView.setText(holder.mItem.getCurso());
        holder.mNotaView.setText(holder.mItem.getNotaMedia());

        holder.mEditarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClickEditarAlumno(holder.mItem);
            }
        });

        holder.mEliminarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClickEliminarAlumno(holder.mItem);
            }
        });

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    //mListener.onClicklAlumno(holder.mItem);
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
        public final TextView mCursoView;
        public final TextView mNotaView;
        public final ImageButton mEditarBtn;
        public final ImageButton mEliminarBtn;

        public Alumno mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNombreView = (TextView) view.findViewById(R.id.nombre);
            mCursoView = (TextView) view.findViewById(R.id.curso);
            mNotaView = (TextView) view.findViewById(R.id.nota);
            mEditarBtn = (ImageButton) view.findViewById(R.id.btnEditar);
            mEliminarBtn = (ImageButton) view.findViewById(R.id.btnEliminar);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
