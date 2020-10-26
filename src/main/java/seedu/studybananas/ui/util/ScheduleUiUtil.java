package seedu.studybananas.ui.util;

import seedu.studybananas.model.task.DateTime;

public class ScheduleUiUtil {

    // This part needs to synchronize with TimeScaleCell
    public static final double INITIAL_PADDING = 9.0; //The paddingTop is set to 10, but 9 is more accurate.
    public static final double MARGIN_PER_HOUR = 40.0;
    public static final double MARGIN_PER_MINUTE = MARGIN_PER_HOUR / 60.0;
    public static final double CURRENT_TIME_POINTER_PADDING = 5.0;


    /**
     * Method used to check if the time format is hh:mm AM/PM
     * @return
     */
    public static boolean checkTimePattern(String time) {
        String[] splitTime = time.split(" ");
        String[] splitHourMinute = splitTime[0].split(":");
        String hour = splitHourMinute[0];
        String minute = splitHourMinute[1];
        return splitTime[1].matches("(AM)|(PM)") && hour.matches("(1[0-2])|[1-9]")
                && minute.matches("(0[0-9])|([0-5][0-9])");
    }

    /**
     * This method transforms "HH:mm" to "hh:mm AM/PM"
     */
    public static String toAmPmTime(String formattedTime) {
        String[] splitTime = formattedTime.split(":");
        int hour = Integer.parseInt(splitTime[0]);
        //make sure that minutes have a trailing 0.
        String minute = splitTime[1];

        if (hour > 12) {
            hour -= 12;
            return String.format("%d:%s PM", hour, minute);
        } else if (hour == 12) {
            return String.format("%d:%s PM", hour, minute);
        } else {
            return String.format("%d:%s AM", hour, minute);
        }
    }

    /**
     * This method calculates the margin from "HH:mm";
     * Still need to check if it is accurate.
     */
    public static double getMarginFromTime(String primitiveTime) {
        String[] splitTime = primitiveTime.split(":");
        int hour = Integer.parseInt(splitTime[0]);
        int minute = Integer.parseInt(splitTime[1]);

        return INITIAL_PADDING + hour * MARGIN_PER_HOUR + minute * MARGIN_PER_MINUTE;

    }

    /**
     * This method calculates the margin from "HH:mm";
     * Still need to check if it is accurate.
     */
    public static double getMarginFromDateTime(DateTime time) {
        int hour = time.dateTime.getHour();
        int minute = time.dateTime.getMinute();
        return INITIAL_PADDING + hour * MARGIN_PER_HOUR + minute * MARGIN_PER_MINUTE;

    }
}
