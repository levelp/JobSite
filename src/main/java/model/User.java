package model;

import dao.Entity;
import model.exceptions.EmailExistsException;
import model.exceptions.EqualityException;
import model.exceptions.NameExistsException;

import java.util.regex.Pattern;

/**
 * Пользователь
 */
public class User implements Entity {
    public static final Pattern emailPattern = Pattern.compile("(\\w+.)*\\w+@(\\w+.)+\\w+");
    public int id;

    private String email;
    private String username;

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

        if (username == null || username.isEmpty()) {
            return false;
        }
        if (!username.matches("(\\w+-)*(\\w+\\s)*\\w+")) {
            return false;
        }
        return true;
    }

    private boolean validateEmail() {
        return email == null || emailPattern.matcher(email).matches();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void equalityCheck(Entity e) throws EqualityException {
        User other = (User) e;

        EqualityException eqEx = new EqualityException();
        EmailExistsException exEmail;
        NameExistsException exName;

        if (this.email != null && this.email.equals(other.email)) {
            exEmail = new EmailExistsException("Пользователь с " + this.email + " уже есть в БД");
            eqEx.addSuppressed(exEmail);
        }

        if (this.username.equals(other.username)) {
            exName = new NameExistsException("Пользователь с именеме " + this.username + " уже есть в БД");
            eqEx.addSuppressed(exName);
        }

        if (eqEx.getSuppressed().length != 0) throw eqEx;

    }
}
