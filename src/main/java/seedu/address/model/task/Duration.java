package seedu.address.model.task;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Task's duration in StudyBananas.
 */
public class Duration {
    public static final String MESSAGE_CONSTRAINTS =
            "Duration should only contain an integer which is less than 1440.";

    private static final int MINUTE_PER_DAY = 60 * 24;

    public final Integer duration;

    /**
     * Constructs a {@code Duration}.
     * @param duration A valid task's duration.
     */
    public Duration(String duration) {
        requireNonNull(duration);
        checkArgument(isValidDuration(duration), MESSAGE_CONSTRAINTS);
        this.duration = Integer.valueOf(duration);
    }

    public Duration(Integer duration) {
        requireNonNull(duration);
        checkArgument(duration < MINUTE_PER_DAY, MESSAGE_CONSTRAINTS);
        this.duration = duration;
    }

    /**
     * Returns true if a given string is a valid description.
     */
    public static boolean isValidDuration(String test) {
        try {
            int duration = Integer.valueOf(test);
            return duration < MINUTE_PER_DAY;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return duration + " minutes";
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Duration)// instanceof handles nulls
                && duration == ((Duration) other).duration; // state check
    }

    @Override
    public int hashCode() {
        return duration.hashCode();
    }
}
