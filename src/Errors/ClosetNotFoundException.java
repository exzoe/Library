package Errors;

public class ClosetNotFoundException extends RuntimeException {
    public ClosetNotFoundException(String message) {
        super(message);
    }
}
