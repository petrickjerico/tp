package seedu.studybananas.model.flashcard;

import static java.util.Objects.requireNonNull;
import static seedu.studybananas.commons.util.AppUtil.checkArgument;

/**
 * Represents a Flashcard's answer
 */
public class Answer {

    public static final String MESSAGE_CONSTRAINTS =
            "Answer should only contain alphanumeric characters and spaces, and it, should not be blank";
    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Graph}][\\p{Graph} ]*";

    public final String answer;

    /**
     * Constructs a {@code Answer}.
     *
     * @param answer A valid answer.
     */
    public Answer(String answer) {
        requireNonNull(answer);
        checkArgument(isValidAnswer(answer), MESSAGE_CONSTRAINTS);
        this.answer = answer;
    }

    public static boolean isValidAnswer(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return answer;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || other instanceof seedu.studybananas.model.flashcard.Answer // instanceof handles nulls
                && answer.equals(((seedu.studybananas.model.flashcard.Answer) other).answer); // state check
    }

    @Override
    public int hashCode() {
        return answer.hashCode();
    }
}
