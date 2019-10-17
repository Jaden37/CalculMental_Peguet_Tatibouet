package bo;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String login;
    private String password;
    private int bestScore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public User() {
    }

    public User(int id, String login, String password, int bestScore) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.bestScore = bestScore;
    }
}
