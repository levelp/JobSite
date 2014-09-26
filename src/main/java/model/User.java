package model;

import dao.Entity;

import java.util.regex.Pattern;

/**
 * Пользователь
 */
public class User implements Entity {
    public static final Pattern emailPattern = Pattern.compile("(\\w+.)*\\w+@(\\w+.)+\\w+");
    public static final int MIN_PASSWORD_LENGTH = 8;
    public static final String PASSWORD_REQUIREMENTS =
            "Пароль должен быть не меньше 8 символов, содержать цифры, заглавные и строчные буквы и не совпадал" +
                    " с именем пользователя";

    public static final Pattern emailPattern = Pattern.compile("(\\w+.)*\\w+@(\\w+.)+\\w+");
    public static final String PASSWORD_NOT_CONTAIN_UPPERCASE_AND_DIGITS =
            "Пароль не содержит заглавных букв и цифр";
    public int id;

    private String email;
    private String username;

    // Новый пароль при регистрации (не хранится в БД)
    private String newPassword;

    // Зашифрованный пароль (как он хранится в БД)
    private String passwordHash;

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
}
