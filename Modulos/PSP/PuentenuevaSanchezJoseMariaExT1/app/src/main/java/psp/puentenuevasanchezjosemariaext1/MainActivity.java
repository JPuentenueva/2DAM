package psp.puentenuevasanchezjosemariaext1;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    Bitmap actual;
    Handler hnd = new Handler(){
        @Override
        public void dispatchMessage(Message msg) {
            Bitmap girado = ImageUtils.rotate90rigth(actual);
            iv.setImageBitmap(girado);
            actual = girado;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.imageViewCentral);

    }

    public void descargarAleatoriamente(View view) {
        new HiloDescarga().execute();
    }

    public void girarImagen(View view) {
        hnd.dispatchMessage(new Message());
    }

    public class HiloDescarga extends AsyncTask<Void,Void,Bitmap> {

        @Override
        protected Bitmap doInBackground(Void... voids) {
            Bitmap bitmap = null;

            try {
                URL url = new URL(ImageUtils.getRandomPhoto());

                bitmap = BitmapFactory.decodeStream(url.openStream());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            actual = bitmap;
            iv.setImageBitmap(bitmap);
        }
    }

}

