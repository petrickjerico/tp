package seedu.address.logic.commands.quizcommands;

public abstract class QuizCommand {

    public static final String MESSAGE_QUIZ_NEVER_STARTED = "There are currently no ongoing quizzes";
    public static final String MESSAGE_UNAVAIL_ON_ANSWER =
            "This command is not available now. Type 'c', 'w' or 'cancel' to continue";
    public static final String MESSAGE_UNAVAIL_ON_QUESTION =
            "This command is not available now. Type 'flip' or 'cancel' to continue";
    private static Status status;
    private static String currentCommandResult;

    public static Status getStatus() {
        return status;
    }

    public static void setStatus(Status state) {
        status = state;
    }

    /**
     * Updates the current command result string
     * @param commandResult provided after execution of quiz command
     */
    public static void updateCommandResult(String commandResult) {
        if (commandResult == null) {
            currentCommandResult = MESSAGE_QUIZ_NEVER_STARTED;
        }
        currentCommandResult = commandResult;
    }

    public static String getCurrentCommandResult() {
        if (currentCommandResult == null) {
            currentCommandResult = MESSAGE_QUIZ_NEVER_STARTED;
        }
        return currentCommandResult;
    }
}
