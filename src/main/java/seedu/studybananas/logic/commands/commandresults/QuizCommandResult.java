package seedu.studybananas.logic.commands.commandresults;

import seedu.studybananas.model.quiz.Quiz;

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
    public CommmandResultType getCommandResultType() {
        return CommmandResultType.Quiz;
    }

}
