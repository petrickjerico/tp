package seedu.address.model.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Task's dateTime in StudyBananas.
 * Guarantees: immutable; is valid as declared in {@link #isValidDateTime(String)}
 */
public class DateTime {
    public static final String MESSAGE_CONSTRAINTS =
            "DateTime should be in the dd/mm/yyyy hh:mm format";
    public static final String VALIDATION_REGEX = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]" +
            "|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]" +
            "|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]" +
            "|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9" +
            "]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2}) " +
            "[012]{0,1}[0-9]:[0-6][0-9]$";
    public final LocalDateTime dateTime;

    /**
     * Constructs a {@code DateTime}.
     *
     * @param dateTime A valid date time.
     */
    public DateTime(String dateTime) {
        requireNonNull(dateTime);
        checkArgument(isValidDateTime(dateTime), MESSAGE_CONSTRAINTS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm");
        LocalDateTime dateTimeObject = LocalDateTime.parse(dateTime, formatter);
        this.dateTime = dateTimeObject;
    }

    /**
     * Returns true if a given string is a valid date.
     */
    public static boolean isValidDateTime(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        DateTimeFormatter wantedFormat = DateTimeFormatter.ofPattern("dd/mm/yyyy hh:mm");
        String dateInString = dateTime.format(wantedFormat);
        return dateInString;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Date // instanceof handles nulls
                && dateTime.toString().equals(((DateTime) other).dateTime.toString())); // state check
    }

    @Override
    public int hashCode() {
        return dateTime.hashCode();
    }
}
