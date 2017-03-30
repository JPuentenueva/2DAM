package psp.callsretrofit.pojo;

/**
 * Created by jmpuentenueva on 23/11/2016.
 */

public class GithubUser {

    String login;
    String name;
    String email;

    public GithubUser(String login, String name, String email) {
        this.login = login;
        this.name = name;
        this.email = email;
    }

    public GithubUser() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return(login);
    }
}
