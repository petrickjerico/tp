package seedu.address.model.quiz.exceptions;

public class QuizNotFoundException extends RuntimeException {

    public static final String MESSAGE_QUIZ_NOT_FOUND = "Quiz not found!";

    public QuizNotFoundException() {
        super(MESSAGE_QUIZ_NOT_FOUND);
    }
}
