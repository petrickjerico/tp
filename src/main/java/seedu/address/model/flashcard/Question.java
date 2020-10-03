package seedu.address.model.flashcard;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Flashcard's question.
 */
public class Question {

    public static final String MESSAGE_CONSTRAINTS =
            "Question should only contain alphanumeric characters and spaces, and it should not be blank";

    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

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
}

