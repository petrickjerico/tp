package seedu.studybananas.model.task;

import seedu.studybananas.commons.util.StringUtil;

import static java.util.Objects.requireNonNull;
import static seedu.studybananas.commons.util.AppUtil.checkArgument;

/**
 * Represents a Task's description in StudyBananas.
 * Guarantees: immutable; is valid as declared in {@link #isValidDescription(String)}
 */
public class Description {
    public static final String MESSAGE_CONSTRAINTS =
            "Description should only contain printable characters, and it should not be blank";

    /*
     * The first character of the description must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "^([^\\s].*)?$";

    public final String description;

    /**
     * Constructs a {@code Description}.
     *
     * @param description A valid task's description.
     */
    public Description(String description) {
        requireNonNull(description);
        checkArgument(isValidDescription(description), MESSAGE_CONSTRAINTS);
        this.description = description;
    }

    /**
     * Returns true if a given string is a valid description.
     */
    public static boolean isValidDescription(String test) {
        return test.equals("") || test.matches(VALIDATION_REGEX);
    }

    public boolean rigorousEquals(Description other) {
        return this.description.toLowerCase().equals(other.description.toLowerCase());
    }

    @Override
    public String toString() {
        return description;
    }

    /**
     * Gets the description string without any punctuation.
     *
     * @return Description string without punctuation.
     */
    public String toStringNoPunctuation() {
        return StringUtil.getStringNoPunctuation(description);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Description // instanceof handles nulls
                && description.equals(((Description) other).description)); // state check
    }

    @Override
    public int hashCode() {
        return description.hashCode();
    }
}
