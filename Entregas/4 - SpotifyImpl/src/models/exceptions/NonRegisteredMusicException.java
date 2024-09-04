package models.exceptions;

public class NonRegisteredMusicException extends Exception {
  
    public NonRegisteredMusicException() {
        super();
    }

    public NonRegisteredMusicException(String message) {
        super(message);
    }

    public NonRegisteredMusicException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonRegisteredMusicException(Throwable cause) {
        super(cause);
    }
}