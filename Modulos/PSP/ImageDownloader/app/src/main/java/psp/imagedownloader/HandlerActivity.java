package psp.imagedownloader;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HandlerActivity extends AppCompatActivity {
    EditText et;
    ImageView imgView;
    Handler hnd = new Handler(){
        @TargetApi(Build.VERSION_CODES.KITKAT)
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void dispatchMessage(Message msg) {
            int numBytes = 0;
            String url = (String) msg.obj;
            Bitmap bm = null;
            URL theURL = null;

            try {
                theURL = new URL(url);
                bm = BitmapFactory.decodeStream(theURL.openStream());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (bm != null) {
                imgView.setImageBitmap(bm);
                Toast.makeText(HandlerActivity.this, "La imagen ocupa "+bm.getAllocationByteCount()+" bytes", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(HandlerActivity.this, "Descarga incorrecta", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        et = (EditText) findViewById(R.id.eTextURL);
        et.setText("http://www.infoseriestv.com/wp-content/uploads/2013/04/6968429550_8e0802575c_opt.jpg");
        imgView = (ImageView) findViewById(R.id.imageView);
    }

    public void descargarImgPorHandler(View view) {

    }
}
