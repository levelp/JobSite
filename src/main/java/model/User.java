package model;

import dao.Entity;

/**
 * Пользователь
 */
public class User implements Entity {
    public int id;

    private String email;
    private String username;

    public User() {
        // TODO: получить новый идентификатор пользователя
        id = 1;
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
        // TODO: проверять email
        return true;
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
