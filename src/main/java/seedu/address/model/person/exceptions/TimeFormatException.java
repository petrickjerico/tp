package seedu.address.model.person.exceptions;

public class TimeFormatException extends RuntimeException {
    public TimeFormatException() {
        super("Time format is not valid");
    }
}
