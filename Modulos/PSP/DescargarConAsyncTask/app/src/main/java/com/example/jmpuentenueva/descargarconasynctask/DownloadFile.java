package com.example.jmpuentenueva.descargarconasynctask;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Luismi on 17/10/2016.
 */

public class DownloadFile {

    public static byte[] downloadFile(String url) throws IOException {

        //Inicializamos clases
        byte[] result = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        URL theURL = new URL(url);
        BufferedInputStream bin = new BufferedInputStream(theURL.openStream());
        byte[] buffer = new byte[512*1024];
        int bytesLeidos;

        //Descargamos el fichero
        while((bytesLeidos = bin.read(buffer, 0, 512*1024)) != -1) {
            baos.write(buffer, 0, bytesLeidos);
        }

        //Cerramos flujo
        if (bin != null) {
            bin.close();
        }

        if (baos != null) {
            result = baos.toByteArray();
            baos.close();
        }

        //Devolvemos el contenido como un bytes[]
        return result;
    }


    public static String downloadFileAndSave(String url, Context ctx) throws IOException {

        //Escogemos un nombre de fichero aleatorio, basado en
        //la fecha y hora actual.
        String fileName = null;
        String ext = (url.split("\\.").length > 0) ? url.split("\\.")[url.split("\\.").length-1] : "";
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy.hh-mm-ss");
        fileName = "file" + df.format(new Date()) + "." + ext;

        //Inicializamos el flujo de lectura a partir del método anterior
        ByteArrayInputStream bais = new ByteArrayInputStream(downloadFile(url));

        //Inicializamos el flujo de escritura
        BufferedOutputStream bout = new BufferedOutputStream(ctx.openFileOutput(fileName, ctx.MODE_PRIVATE));
        byte[] buffer = new byte[512*1024];

        int bytesLeidos;

        //Descargamos el fichero
        while((bytesLeidos = bais.read(buffer, 0, 512*1024)) != -1) {
            bout.write(buffer, 0, bytesLeidos);
        }


        return fileName;
    }

}
