package seedu.studybananas.commons.core;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_TASKS_LISTED_OVERVIEW = "%1$d tasks listed!";
    public static final String MESSAGE_INVALID_TASK_DISPLAYED_INDEX = "The task index provided is invalid";
    public static final String MESSAGE_DUPLICATED_TASK = "This task already exists in the schedule";
    public static final String MESSAGE_OVERLAP_TASK = "The duration of this task overlaps with other "
            + "task in the schedule";
    public static final String MESSAGE_INVALID_FLASHCARDSET_DISPLAYED_INDEX =
            "The flashcard set index provided is invalid";
    public static final String MESSAGE_INVALID_FLASHCARD_INDEX =
            "The flashcard index provided is invalid";
    public static final String MESSAGE_QUIZ_HAS_STARTED = "A quiz is ongoing, "
            + "no non-quiz commands are allowed.\nKey `refresh' "
            + "to continue with quiz or 'cancel' to stop quiz.";
}
