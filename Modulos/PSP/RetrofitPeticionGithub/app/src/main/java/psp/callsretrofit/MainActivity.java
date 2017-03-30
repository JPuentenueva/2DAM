package psp.callsretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import psp.callsretrofit.interfaces.GithubAPI;
import psp.callsretrofit.pojo.GithubRepo;
import psp.callsretrofit.pojo.GithubUser;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx = (TextView) findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GithubAPI.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final GithubAPI service = retrofit.create(GithubAPI.class);

        Call<GithubUser> call = service.getUser("camposmiguel");

        call.enqueue(new Callback<GithubUser>() {
            @Override
            public void onResponse(Response<GithubUser> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    GithubUser user = response.body();
                    tx.setText(user.getName());

                } else {
                    Toast.makeText(MainActivity.this, "Error code " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        Call<List<GithubRepo>> call2 = service.getRepos("camposmiguel");

        call2.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Response<List<GithubRepo>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    List<GithubRepo> repos = response.body();



                } else {
                    Toast.makeText(MainActivity.this, "Error code " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    public void onClick(View view) {



        /*switch (view.getId()) {
            case R.id.loadUserData:
                // prepare call in Retrofit 2.0

                Call<GithubUser> callUser = service.getUser("vogella");
                //asynchronous call
                callUser.enqueue(this);
                break;
            case R.id.loadRepositories:
                Call<List<GithubRepo>> callRepos = service.getRepos("vogella");
                //asynchronous call
                callRepos.enqueue(repos);
                break;
        }*/
    }

    /*
    Callback repos = new Callback<List<GithubRepo>>(){

        @Override
        public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
            if (response.isSuccessful()) {
                List<GithubRepo> repos = response.body();
                StringBuilder builder = new StringBuilder();
                for (GithubRepo repo: repos) {
                    builder.append(repo.name + " " + repo.toString());
                }
                Toast.makeText(MainActivity.this, builder.toString(), Toast.LENGTH_SHORT).show();

            } else
            {
                Toast.makeText(MainActivity.this, "Error code " + response.code(), Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
            Toast.makeText(MainActivity.this, "Did not work " +  t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onResponse(Call<GithubUser> call, Response<GithubUser> response) {
        int code = response.code();
        if (code == 200) {
            GithubUser user = response.body();
            Toast.makeText(this, "Got the user: " + user.email, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Did not work: " + String.valueOf(code), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailure(Call<GithubUser> call, Throwable t) {
        Toast.makeText(this, "Nope", Toast.LENGTH_LONG).show();

    }
    */
}
