package ru.itis.inform.users.models;


/**
 * Created by Moskieva on 24.04.16.
 */
public class PasswordDto {
    private int userId;
    private String login;
    private String password;

    public PasswordDto() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
}
