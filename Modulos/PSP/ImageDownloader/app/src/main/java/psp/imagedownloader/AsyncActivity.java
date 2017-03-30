package psp.imagedownloader;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;

public class AsyncActivity extends AppCompatActivity {
    EditText et;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);

        et = (EditText) findViewById(R.id.eTextURL);
        et.setText("http://www.infoseriestv.com/wp-content/uploads/2013/04/6968429550_8e0802575c_opt.jpg");
        imgView = (ImageView) findViewById(R.id.imageView);
    }

    public void descargarImg(View view) {
        String imagenURL = et.getText().toString();
        if (imagenURL == null){
            Toast.makeText(this, "No hay URL", Toast.LENGTH_SHORT).show();
        }else{
            HiloDescarga descarga = new HiloDescarga();
            descarga.execute(imagenURL);
        }
    }

    public class HiloDescarga extends AsyncTask<String,Void,Bitmap> {
        ProgressDialog progress;

        @Override
        protected void onPreExecute() {
            progress = new ProgressDialog(AsyncActivity.this);
            progress.setIndeterminate(false);
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progress.show();
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            String strURL = params[0];
            URL theURL = null;
            Bitmap bm = null;

            try {
                theURL = new URL(strURL);
                bm = BitmapFactory.decodeStream(theURL.openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bm;
        }

        @TargetApi(Build.VERSION_CODES.KITKAT)
        @RequiresApi(api = Build.VERSION_CODES.KITKAT) //He necesitado añadir estas anotaciones por el getAllocationByteCount()
        @Override
        protected void onPostExecute(Bitmap bm) {
            if (bm != null){
                imgView.setImageBitmap(bm);
                Toast.makeText(AsyncActivity.this, "La imagen ocupa "+bm.getAllocationByteCount()+" bytes", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(AsyncActivity.this, "Descarga incorrecta", Toast.LENGTH_SHORT).show();
            }
            progress.dismiss();
        }
    }
}
