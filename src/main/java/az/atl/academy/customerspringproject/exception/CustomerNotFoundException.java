package az.atl.academy.customerspringproject.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException (String message) {
        super(message);
    }
}
