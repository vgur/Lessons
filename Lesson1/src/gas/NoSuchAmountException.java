package gas;

public class NoSuchAmountException extends Exception {

    public NoSuchAmountException() {
    }

    public NoSuchAmountException(String message) {
        super(message);
    }
}
