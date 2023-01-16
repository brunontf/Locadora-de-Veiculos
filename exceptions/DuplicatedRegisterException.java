package exceptions;

public class DuplicatedRegisterException extends Exception {
    public DuplicatedRegisterException(String errorMessage) {
        super(errorMessage);
    }
}
