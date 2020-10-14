package seedu.address.model.task.timeformat;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.task.exceptions.TimeFormatException;

public class TimeFormatChecker {
    private static final List<TimeFormat> VALID_FORMATS = Arrays.asList(new IsoDateTime(), new IsoDate());

    /**
     * Check if the time format is supported by Study bananas)
     * @param time
     */
    public static boolean check(String time) {
        for (TimeFormat format : VALID_FORMATS) {
            try {
                LocalDateTime ldt = format.check(time);
                return true;
            } catch (TimeFormatException e) {
                // not a good practice, still need refactor.
            }
        }
        return false;
    }

    /**
     * Map time String to {@Code LocalDateTime}
     * @param time
     */
    public static LocalDateTime mapToLocalDateTime(String time) {
        for (TimeFormat format : VALID_FORMATS) {
            try {
                LocalDateTime ldt = format.check(time);
                return ldt;
            } catch (TimeFormatException e) {
                //Not a good practice, still need to refactor.
            }
        }
        throw new TimeFormatException();
    }
}
