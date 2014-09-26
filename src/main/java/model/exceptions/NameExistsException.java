package model.exceptions;

/**
 * Пользователь с таким именем уже есть
 */
public class NameExistsException extends Exception {
    public NameExistsException(String msg) {
        super(msg);
    }
}
