package seedu.studybananas.model.flashcard;

import static java.util.Objects.requireNonNull;
import static seedu.studybananas.commons.util.AppUtil.checkArgument;

/**
 * Represents a Flashcard's question.
 */
public class Question {

    public static final String MESSAGE_CONSTRAINTS =
            "Question should only contain alphanumeric characters and spaces, and it should not be blank";
    /*
     * The first character of the question must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Graph}][\\p{Graph} ]*";

    public final String question;

    /**
     * Constructs a {@code Question}.
     *
     * @param question A valid question.
     */
    public Question(String question) {
        requireNonNull(question);
        checkArgument(isValidQuestion(question), MESSAGE_CONSTRAINTS);
        this.question = question;
    }

    public static boolean isValidQuestion(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return question;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || other instanceof seedu.studybananas.model.flashcard.Question // instanceof handles nulls
                && question.equals(((seedu.studybananas.model.flashcard.Question) other).question); // state check
    }

    @Override
    public int hashCode() {
        return question.hashCode();
    }
}

