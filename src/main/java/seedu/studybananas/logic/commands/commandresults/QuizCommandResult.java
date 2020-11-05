package seedu.studybananas.logic.commands.commandresults;

import seedu.studybananas.model.quiz.Quiz;
import seedu.studybananas.ui.util.UiStateType;

public class QuizCommandResult extends CommandResult {
    private final Quiz quiz;

    private QuizCommandResultType commandType;

    /**
     * Initializes a {@code QuizCommandResult}.
     * @param feedbackToUser Feedback displayed to the user.
     */
    public QuizCommandResult(String feedbackToUser) {
        super(feedbackToUser);
        this.quiz = null;
    }

    /**
     * Initializes a {@code QuizCommandResult}.
     * @param feedbackToUser Feedback displayed to the user.
     * @param showHelp Whether to show help.
     * @param exit Whether to exit the app.
     */
    public QuizCommandResult(String feedbackToUser, boolean showHelp, boolean exit) {
        super(feedbackToUser, showHelp, exit);
        this.quiz = null;
    }

    /**
     * Initializes a {@code QuizCommandResult}.
     * @param feedbackToUser Feedback displayed to the user.
     * @param commandType Command Type of the command that this result is generated from.
     */
    public QuizCommandResult(String feedbackToUser, QuizCommandResultType commandType) {
        super(feedbackToUser);
        this.quiz = null;
        this.commandType = commandType;
    }

    /**
     * Initializes a {@code QuizCommandResult}.
     * @param feedbackToUser Feedback displayed to the user.
     * @param showHelp Whether to show help.
     * @param exit Whether to exit the app.
     * @param commandType Command Type of the command that this result is generated from.
     */
    public QuizCommandResult(String feedbackToUser, boolean showHelp, boolean exit, QuizCommandResultType commandType) {
        super(feedbackToUser, showHelp, exit);
        this.quiz = null;
        this.commandType = commandType;
    }

    /**
     * Initializes a {@code QuizCommandResult}.
     * @param feedbackToUser Feedback displayed to the user.
     * @param showHelp Whether to show help.
     * @param exit Whether to exit the app.
     * @param quiz Quiz object to be stored in the CommandResult.
     * @param commandType Command Type of the command that this result is generated from.
     */
    public QuizCommandResult(String feedbackToUser, boolean showHelp, boolean exit, Quiz quiz,
                             QuizCommandResultType commandType) {
        super(feedbackToUser, showHelp, exit);
        this.quiz = quiz;
        this.commandType = commandType;
    }


    /**
     * Initializes a {@code QuizCommandResult}.
     * @param feedbackToUser Feedback displayed to the user.
     * @param quiz Quiz object to be stored in the CommandResult.
     * @param commandType Command Type of the command that this result is generated from.
     */
    public QuizCommandResult(String feedbackToUser, Quiz quiz, QuizCommandResultType commandType) {
        super(feedbackToUser);
        this.quiz = quiz;
        this.commandType = commandType;
    }
    public Quiz getQuiz() {
        return this.quiz;
    }

    public QuizCommandResultType getCommandType() {
        return commandType;
    }

    @Override
    public String getFeedbackToUser() {
        return feedbackToUser;
    }

    @Override
    public UiStateType getCommandResultType() {
        return UiStateType.QUIZ;
    }

    @Override
    public String toString() {
        return quiz != null ? quiz.getQuizName() : "empty quiz";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof QuizCommandResult)) {
            return false;
        }

        if (o == this) {
            return true;
        }

        if (this.quiz == null) {
            return ((QuizCommandResult) o).quiz == null;
        }

        return ((QuizCommandResult) o).quiz.equals(this.quiz);
    }

}
