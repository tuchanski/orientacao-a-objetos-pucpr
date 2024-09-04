package models.exceptions;

public class AlreadyRegisteredMusicException extends Exception {
  
    public AlreadyRegisteredMusicException() {
        super();
    }

    public AlreadyRegisteredMusicException(String message) {
        super(message);
    }

    public AlreadyRegisteredMusicException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadyRegisteredMusicException(Throwable cause) {
        super(cause);
    }
}