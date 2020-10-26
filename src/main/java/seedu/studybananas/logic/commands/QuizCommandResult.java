package seedu.studybananas.logic.commands;

import seedu.studybananas.model.quiz.Quiz;

public class QuizCommandResult extends CommandResult {
    private final Quiz quiz;

    public QuizCommandResult(String feedbackToUser) {
        super(feedbackToUser);
        this.quiz = null;
    }

    public QuizCommandResult(String feedbackToUser, Quiz quiz) {
        super(feedbackToUser);
        this.quiz = quiz;
    }

    public Quiz getQuiz() {
        return  this.quiz;
    }

    @Override
    public String getFeedbackToUser() {
        return feedbackToUser;
    }

}
