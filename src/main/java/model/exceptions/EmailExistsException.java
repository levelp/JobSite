package model.exceptions;

/**
 * Пользователь с таким е-mail уже есть
 */
public class EmailExistsException extends Exception {
    public EmailExistsException(String message) {
        super(message);
    }
}
