package di.ftpservice;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LoginActivity extends AppCompatActivity {
    EditText ip;
    EditText username;
    EditText password;
    CheckBox remember;
    Button loginButton;

    FTPClient mFTPClient;

    String ipUsuario;
    String nombreUsuario;
    String contrasenyaUsuario;
    boolean recuerdame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ip = (EditText) findViewById(R.id.edTxIpLog);
        username = (EditText) findViewById(R.id.edTxUserLog);
        password = (EditText) findViewById(R.id.edTxPassLog);
        remember = (CheckBox) findViewById(R.id.checkRecuerdame);
        loginButton = (Button) findViewById(R.id.btnLog);

        //Comprueba si hay internet
        checkInternet(this);

        if(comprobarUltimoUsuario()){
            loginFTP();
        }

    }
    
    //TODO
    public void loginFTP() {
        recuerdame = remember.isChecked();

        if(comprobarUltimoUsuario()) {
            ipUsuario = ip.getText().toString();
            nombreUsuario = username.getText().toString();
        } else {
            SharedPreferences sh = getApplication().getSharedPreferences(Constantes.SHARED_PREFERENCES_FILE, MODE_PRIVATE);

            ipUsuario = sh.getString(Constantes.SHARPREF_USUARIO_GUARDADO_IP, null);
            nombreUsuario = sh.getString(Constantes.SHARPREF_USUARIO_GUARDADO, null);
        }

        FTPConnection hiloLogin = new FTPConnection();
        hiloLogin.execute();
    }

    public boolean comprobarUltimoUsuario() {
        SharedPreferences shared = getApplication().getSharedPreferences( Constantes.SHARED_PREFERENCES_FILE, MODE_PRIVATE);
        String ultimoUsuario = shared.getString(Constantes.SHARPREF_USUARIO_GUARDADO, null);

        if (ultimoUsuario != null){
            return false;
        } else {
            return true;
        }

    }

    public boolean checkInternet(Context ctx) {
        AlertDialog.Builder builder;

        boolean bandera = true;
        ConnectivityManager conMgr = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo i = conMgr.getActiveNetworkInfo();
        if (i == null || !i.isConnected() || !i.isAvailable()) {
            builder = new AlertDialog.Builder(ctx);

            builder.setTitle(ctx.getString(R.string.if_conection));
            builder.setMessage(ctx.getString(R.string.activation_internet));
            builder.setCancelable(false);

            builder.setPositiveButton(ctx.getString(R.string.yes),
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Lanzo un intent implícito que hace que se abra
                            // la pantalla de Configuración del móvil
                            // para que el usuario se conecte a Internet
                            Intent intent = new Intent(
                                    Settings.ACTION_SETTINGS);

                            startActivity(intent);
                        }
                    });


            builder.setNegativeButton(ctx.getString(R.string.cancel),
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    });

            builder.create();
            builder.show();
            bandera = false;
        }

        return bandera;

    }

    public class FTPConnection extends AsyncTask<Void,Void,Boolean> {

        @Override
        protected Boolean doInBackground(Void... voids) {
            mFTPClient = new FTPClient();
            boolean status = false;
            // connecting to the host
            if (ipUsuario != null ){
                if (nombreUsuario != null) {
                    try {

                        mFTPClient.connect(ipUsuario, 21);
                        status = mFTPClient.login(nombreUsuario, contrasenyaUsuario);

                        // now check the reply code, if positive mean connection success
                        if (FTPReply.isPositiveCompletion(mFTPClient.getReplyCode())) {
                            mFTPClient.setFileType(FTP.ASCII_FILE_TYPE);
                            mFTPClient.enterLocalPassiveMode();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "No se ha especificado Usuario", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(LoginActivity.this, "Introduzca la IP de Usuario", Toast.LENGTH_SHORT).show();
            }

            return status;

        }

        @Override
        protected void onPostExecute(Boolean status) {
            if (status) {
                recordarUsuario(recuerdame);

                determinarUsuarioActual();
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            } else {
                Toast.makeText(LoginActivity.this, "No hay conexión con el FTP", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void determinarUsuarioActual() {

        SharedPreferences sharPref = getApplication().getSharedPreferences(Constantes.SHARED_PREFERENCES_FILE, MODE_PRIVATE);

        SharedPreferences.Editor editor = sharPref.edit();

        editor.putString(Constantes.USUARIO_ACTUAL_IP, ipUsuario);
        editor.putString(Constantes.USUARIO_ACTUAL_NOMBRE, nombreUsuario);
        editor.putString(Constantes.USUARIO_ACTUAL_CONTRASENYA, contrasenyaUsuario);

        editor.commit();
    }

    private void recordarUsuario(boolean guardar) {
        SharedPreferences sharPref = getApplication().getSharedPreferences(Constantes.SHARED_PREFERENCES_FILE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharPref.edit();

        if (guardar) {
            editor.putString(Constantes.SHARPREF_USUARIO_GUARDADO, nombreUsuario);
            editor.putString(Constantes.SHARPREF_USUARIO_GUARDADO_IP, ipUsuario);
            editor.putString(Constantes.SHARPREF_USUARIO_GUARDADO_CONTRASENYA, contrasenyaUsuario);

            editor.commit();
        } else {
            editor.putString(Constantes.SHARPREF_USUARIO_GUARDADO, null);
            editor.putString(Constantes.SHARPREF_USUARIO_GUARDADO_IP, null);
            editor.putString(Constantes.SHARPREF_USUARIO_GUARDADO_CONTRASENYA, null);

            editor.commit();
        }

    }
}
