package model;

import dao.Entity;

/**
 * Пользователь
 */
public class User implements Entity {
    public int id;

    private String email;

    public User() {
        // TODO: получить новый идентификатор пользователя
        id = 1;
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
