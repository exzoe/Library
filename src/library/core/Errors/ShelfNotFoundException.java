package library.core.Errors;

public class ShelfNotFoundException extends RuntimeException {
    public ShelfNotFoundException(String message) {
        super(message);
    }
}