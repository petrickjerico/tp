package seedu.address.ui.util;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class ScheduleUiUtil {
    /**
     * Method used to check if the time format is hh:mm AM/PM
     * @return
     */
    public static boolean checkTimePattern(String time) {
        String[] splitTime = time.split(" ");
        try {
            LocalTime.parse(splitTime[0]);
            return splitTime[1].matches("AM|PM");
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
