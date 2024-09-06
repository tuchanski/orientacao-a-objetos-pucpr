package models.exceptions;

public class AlreadyRegisteredUserException extends Exception {

    public AlreadyRegisteredUserException() {
        super();
    }

    public AlreadyRegisteredUserException(String message) {
        super(message);
    }

    public AlreadyRegisteredUserException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadyRegisteredUserException(Throwable cause) {
        super(cause);
    }
}