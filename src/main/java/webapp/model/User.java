package webapp.model;

import webapp.dao.Entity;
import webapp.model.exceptions.NotCorrectEmailException;
import webapp.model.exceptions.NotCorrectPasswordException;

import javax.persistence.Column;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Пользователь
 */
@javax.persistence.Entity
public class User implements Entity {
    public static final int MIN_PASSWORD_LENGTH = 8;
    public static final String PASSWORD_REQUIREMENTS =
            "Пароль должен быть не меньше 8 символов, содержать цифры, заглавные и строчные буквы и не совпадал" +
                    " с именем пользователя";

    public static final String PASSWORD_NOT_CONTAIN_UPPERCASE_AND_DIGITS =
            "Пароль не содержит заглавных букв и цифр";
    public static final Pattern emailPattern = Pattern.compile("(\\w+.)*\\w+@(\\w+.)+\\w+");
    public static final Pattern passwordPattern = Pattern.compile("[-_A-Za-z0-9]{8,20}");
    public static final String PASSWORD_NOT_MATCH_PATTERN =
            "Пароль должен быть от 8 до 20 символов. Допускаются символы:" +
                    " латинские буквы в верхнем и нижнем регистрах, цифры, дефис и подчёркивание.";
    public static final String PASSWORD_TOO_SHORT = "Пароль слишком короткий, должен быть не менее 8 символов";

    public List<Resume> resumes;
    public int id;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "SEX")
    private Sex sex;

    // Новый пароль при регистрации (не хранится в БД)
    private String newPassword;

    // Хеш пароля (зашифрованный пароль - как он хранится в БД)
    private String passwordHash;
    private String password;

    public User(String username, String email, String password, Sex sex) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.sex = sex;
        this.resumes = null;
    }

    public User() {
        // TODO: получить новый идентификатор пользователя
        id = 1;
        username = "Гость";
        password = "";
        newPassword = "";
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean validate() throws NotCorrectEmailException, NotCorrectPasswordException {
        return ((validateEmail() && validateUsername()) && validatePassword());
    }

    private boolean validateUsername() {
        return !username.isEmpty();
    }

    boolean validateEmail() {
        return emailPattern.matcher(email).matches();
    }

    private boolean validatePassword() throws NotCorrectPasswordException {
        String error = checkPasswordComplexity();
        if (error != null)
            throw new NotCorrectPasswordException(error);
        if (passwordPattern.matcher(newPassword).matches() && newPassword.length() >= MIN_PASSWORD_LENGTH) return true;
        else throw new NotCorrectPasswordException(PASSWORD_NOT_MATCH_PATTERN);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String password) {
        this.newPassword = password;
    }

    /**
     * Проверка пароля на сложность
     *
     * @return
     */
    public String checkPasswordComplexity() {
        if (newPassword.length() < MIN_PASSWORD_LENGTH)
            return PASSWORD_TOO_SHORT;
        int lowerLetter = 0;
        int upperLetter = 0;
        int digits = 0;
        for (int i = 0; i < newPassword.length(); ++i) {
            char c = newPassword.charAt(i);
            if (Character.isDigit(c))
                digits++;
            if (Character.isLowerCase(c))
                lowerLetter++;
            if (Character.isUpperCase(c))
                upperLetter++;
        }
        if (upperLetter == 0 && digits == 0)
            return PASSWORD_NOT_CONTAIN_UPPERCASE_AND_DIGITS;
        if (lowerLetter == 0 && digits == 0)
            return "Пароль не содержит строчных букв и цифр";
        if (digits == 0)
            return "Пароль не содержит цифр";
        if (upperLetter == 0 && lowerLetter == 0)
            return "Пароль состоит только из цифр";

        return null;
    }
}
