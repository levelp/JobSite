package model;

import dao.Entity;

import java.util.regex.Pattern;

/**
 * Пользователь
 */
public class User implements Entity {
    public static final Pattern emailPattern = Pattern.compile("(\\w+.)*\\w+@(\\w+.)+\\w+");

    public int id;
    private String email;
    private String username;
    private Sex sex;

    public User(String username, String email, String password, Sex sex) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.sex = sex;
    }
    public User createMale(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.sex = Sex.MAN;
        return new User(username, email, password, sex);
    }

    public User createFemale(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.sex = Sex.WOMAN;
        return new User(username, email, password, sex);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    private String password;


    public User() {
        // TODO: получить новый идентификатор пользователя
        id = 1;
        username = "Гость";
    }

    public User(String username) {
        setUsername(username);
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

    public boolean validate() {
        return validateEmail() && validateUsername();
    }

    private boolean validateUsername() {
        return !username.isEmpty();
    }

    private boolean validateEmail() {
        return emailPattern.matcher(email).matches();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public boolean isPasswordCorrect() {
        return !this.getPassword().isEmpty() && this.getPassword().length() > 6;
    }

    public Sex getSex() {
        return sex;
    }
}
