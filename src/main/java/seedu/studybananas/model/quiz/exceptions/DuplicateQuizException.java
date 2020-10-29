package seedu.studybananas.model.quiz.exceptions;

public class DuplicateQuizException extends RuntimeException {

    public static final String MESSAGE_DUPLICATE_QUIZ = "Duplicate quiz found! Action is not allowed";

    public DuplicateQuizException() {
        super(MESSAGE_DUPLICATE_QUIZ);
    }
}
