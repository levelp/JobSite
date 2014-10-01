package model.exceptions;

/**
 * Created by vladimir on 26.09.14.
 */
public class NotCorrectPasswordException extends Exception {

    public NotCorrectPasswordException(String message) {
        super(message);
    }
}
