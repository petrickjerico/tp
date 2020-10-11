package seedu.address.model.task.exceptions;

public class TimeFormatException extends RuntimeException {
    public TimeFormatException() {
        super("Time format is not valid");
    }
}
