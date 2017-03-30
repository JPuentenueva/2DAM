package psp.galerianasa.fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import psp.galerianasa.R;
import psp.galerianasa.interfaces.IimagenClickListener;
import psp.galerianasa.pojo.ArchivoRSS;
import psp.galerianasa.pojo.Imagen;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link IimagenClickListener}
 * interface.
 */
public class ImagenFragment extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 2;
    private List<Imagen> imgs;
    private IimagenClickListener mListener;
    private RecyclerView recyclerView;
    private Context ctx;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ImagenFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_imagen_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            ctx = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(ctx));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(ctx, mColumnCount));
            }

            String url = "https://www.nasa.gov/rss/dyn/lg_image_of_the_day.rss";
            HiloSerializar hilo = new HiloSerializar();
            hilo.execute(url);


        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IimagenClickListener) {
            mListener = (IimagenClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement IimagenClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public class HiloSerializar extends AsyncTask<String, Void, ArchivoRSS> {

        @Override
        protected ArchivoRSS doInBackground(String... params) {
            Serializer serializer = new Persister();
            ArchivoRSS rss = null;
            URL urlNasa = null;

            try{
                urlNasa = new URL(params[0]);
                rss = serializer.read(ArchivoRSS.class, urlNasa.openStream(), false);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return rss;
        }

        @Override
        protected void onPostExecute(ArchivoRSS rss) {
            imgs = rss.getChannel().getImagenes();
            recyclerView.setAdapter(new MyImagenRecyclerViewAdapter(imgs, mListener, ctx));
        }
    }

}
