package psp.callsretrofit.interfaces;

import java.util.List;

import psp.callsretrofit.pojo.GithubRepo;
import psp.callsretrofit.pojo.GithubUser;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;

/**
 * Created by jmpuentenueva on 23/11/2016.
 */

public interface GithubAPI {
    String ENDPOINT = "https://api.github.com";

    @GET("/users/{user}")
    Call<GithubUser> getUser(@Path("user") String user);

    @Headers({"Accept: ",""}) //TODO
    @GET("users/{user}/repos")
    Call<List<GithubRepo>> getRepos(@Path("user") String user);

}
