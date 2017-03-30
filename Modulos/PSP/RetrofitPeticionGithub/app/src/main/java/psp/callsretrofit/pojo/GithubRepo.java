package psp.callsretrofit.pojo;

/**
 * Created by jmpuentenueva on 23/11/2016.
 */

public class GithubRepo {

    String name;
    String url;

    public GithubRepo(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public GithubRepo() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return(name + " " +  url);
    }
}
