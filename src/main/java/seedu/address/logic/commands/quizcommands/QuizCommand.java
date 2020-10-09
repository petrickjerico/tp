package seedu.address.logic.commands.quizcommands;

public abstract class QuizCommand {

    public static final String MESSAGE_QUIZ_NEVER_STARTED = "There are currently no ongoing quizzes";
    public static final String MESSAGE_UNAVAIL_ON_ANSWER =
            "This command is not available now. Type 'c', 'w' or 'cancel' to continue";
    public static final String MESSAGE_UNAVAIL_ON_QUESTION =
            "This command is not available now. Type 'flip' or 'cancel' to continue";
    private static Status status;

    public static Status getStatus() {
        return status;
    }
    public static void setStatus(Status state) {
        status = state;
    }
}
