package seedu.studybananas.logic.commands.commandresults;

import seedu.studybananas.model.quiz.Quiz;
import seedu.studybananas.ui.util.UiStateType;

public class QuizCommandResult extends CommandResult {
    private final Quiz quiz;

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
     * @param quiz Quiz object to be stored in the CommandResult.
     */
    public QuizCommandResult(String feedbackToUser, Quiz quiz) {
        super(feedbackToUser);
        this.quiz = quiz;
    }

    public Quiz getQuiz() {
        return this.quiz;
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
        return quiz.getQuizName();
    }

}
