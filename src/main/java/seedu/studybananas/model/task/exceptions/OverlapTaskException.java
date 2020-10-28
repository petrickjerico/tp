package seedu.studybananas.model.task.exceptions;

/**
 * Signals that the operation would create a task conflicting in duration
 * with another existing task in the schedule.
 */
public class OverlapTaskException extends RuntimeException {
    public OverlapTaskException() {
        super("Operation would result in other existing tasks to be overlapped in the duration");
    }

}
