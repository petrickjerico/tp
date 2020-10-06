package seedu.address.model.task.timeformat;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.person.exceptions.TimeFormatException;

public class TimeFormatChecker {
    private static final List<TimeFormat> VALID_FORMATS = Arrays.asList(new IsoDate(), new IsoDateTime());

    public static boolean check(String time) {
        for (TimeFormat format : VALID_FORMATS) {
            try {
                LocalDateTime ldt = format.check(time);
                return true;
            } catch (TimeFormatException e) {}
        }
        return false;
    }

    public static LocalDateTime mapToLocalDateTime(String time) {
        for (TimeFormat format : VALID_FORMATS) {
            try {
                LocalDateTime ldt = format.check(time);
                return ldt;
            } catch (TimeFormatException e) {}
        }
        throw new TimeFormatException();
    }
}
