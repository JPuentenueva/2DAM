package psp.puentenuevasanchezjosemariaext1;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;


public class ImageUtils {

    /*
        Este método estático devuelve la URL de una imagen aleatoria del contenido
        popular de la NASA.

        Es el método a utilizar para obtener la URL de la imagen a descargar
    */

    public static String getRandomPhoto() {
        return getPhotoURL();
    }

    /*
        Este método estático recibe un Bitmap y lo duvuelve rotado 90 grados
        en el sentido de las agujas del reloj.
     */
    public static Bitmap rotate90rigth(Bitmap src) {
        return RotateBitmap(src, 90);
    }

    /*
     * Método estático que recibe un Bitmap y nos devuelve otro con los colores
	 * invertidos
	 */
    public static Bitmap doInvert(Bitmap src) {
        // create new bitmap with the same settings as source bitmap
        Bitmap bmOut = Bitmap.createBitmap(src.getWidth(), src.getHeight(), src.getConfig());
        // color info
        int A, R, G, B;
        int pixelColor;
        // image size
        int height = src.getHeight();
        int width = src.getWidth();

        // scan through every pixel
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // get one pixel
                pixelColor = src.getPixel(x, y);
                // saving alpha channel
                A = Color.alpha(pixelColor);
                // inverting byte for each R/G/B channel
                R = 255 - Color.red(pixelColor);
                G = 255 - Color.green(pixelColor);
                B = 255 - Color.blue(pixelColor);
                // set newly-inverted pixel to output image
                bmOut.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }

        // return final bitmap
        return bmOut;
    }

    /*
        Método privado auxiliar para la rotación de imágenes
     */
    private static Bitmap RotateBitmap(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(), matrix, true);
    }


    /*
        Método privado auxiliar que es capaz de leer de la API Picture of the Day de la NASA
     */
    private static String readNASAApi() {
        StringBuilder builder = new StringBuilder();
        try {
            String date = getDateInUSAformat(getRandomDate());
            URL url = new URL("https://api.nasa.gov/planetary/apod?api_key=6hBmumTbSezozlDSqPIz642NzHX1rCwoEAzJr6DH&date=" + date);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }
    

    private static String getPhotoURL() {
        String jsonNASA = readNASAApi();
        String result = null;

        try {
            JSONObject jsonObject = (JSONObject) new JSONTokener(jsonNASA).nextValue();
            result = jsonObject.getString("url");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    /*
            Método privado auxiliar que devuelve la representación americana de una fecha
    */
    private static String getDateInUSAformat(Date d) {
        String result = "";

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        result = df.format(d);

        return result;
    }

    /*
            Método privado auxiliar que devuelve una fecha aleatoria en el rango
            de fechas de los cuales la NASA tiene una imagen del día.
    */
    private static Date getRandomDate() {

        Date dMin, dMax;

        //Instanciación del calendario para establecer las fechas mínima y máxima

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.YEAR, 1996);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        dMin = cal.getTime();

        cal.set(Calendar.YEAR, 2016);
        cal.set(Calendar.MONTH, 11);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        dMax = cal.getTime();

        long MILLIS_PER_DAY = 1000 * 60 * 60 * 24;
        GregorianCalendar s = new GregorianCalendar();
        s.setTimeInMillis(dMin.getTime());
        GregorianCalendar e = new GregorianCalendar();
        e.setTimeInMillis(dMax.getTime());

        // Get difference in milliseconds
        long endL = e.getTimeInMillis() + e.getTimeZone().getOffset(e.getTimeInMillis());
        long startL = s.getTimeInMillis() + s.getTimeZone().getOffset(s.getTimeInMillis());
        long dayDiff = (endL - startL) / MILLIS_PER_DAY;

        cal = Calendar.getInstance();
        cal.setTime(dMin);
        cal.add(Calendar.DATE, new Random().nextInt((int) dayDiff));
        return cal.getTime();
    }


}
