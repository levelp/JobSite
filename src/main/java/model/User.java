package model;

import dao.Entity;

import java.util.regex.Pattern;

/**
 * Пользователь
 */
public class User implements Entity {
    public static final Pattern emailPattern = Pattern.compile("(\\w+.)*\\w+@(\\w+.)+\\w+");
    public static final Pattern passwordPattern = Pattern.compile("[-_A-Za-z0-9]{8,20}");
    public int id;

    private String email;
    private String username;
    private String password;

    public User() {
        // TODO: получить новый идентификатор пользователя
        id = 1;
        username = "Гость";
        password = "12345678";
    }

    public User(String username) {
        setUsername(username);
    }

    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public User(String email, String username, String password) {
        setPassword(password);
        setUsername(username);
        setEmail(email);
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean validate() {
        return ((validateEmail() && validateUsername()) && validatePassword());
    }

    private boolean validateUsername() {
        return !username.isEmpty();
    }

    private boolean validateEmail() {
        return emailPattern.matcher(email).matches();
    }

    private boolean validatePassword() {
        return passwordPattern.matcher(password).matches() && password.length() >= 8;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }


}
