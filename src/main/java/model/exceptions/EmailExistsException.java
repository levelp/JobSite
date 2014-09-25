package model.exceptions;

/**
 * Пользователь с таким e-mail'ом уже есть
 */
public class EmailExistsException extends Exception {
    public EmailExistsException(String msg) {
        super(msg);
    }
}
