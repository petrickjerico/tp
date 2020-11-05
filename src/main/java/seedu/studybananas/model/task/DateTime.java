package seedu.studybananas.model.task;

import static java.util.Objects.requireNonNull;
import static seedu.studybananas.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import seedu.studybananas.model.task.timeformat.TimeFormatChecker;

/**
 * Represents a Task's dateTime in StudyBananas.
 * Guarantees: immutable; is valid as declared in {@link #isValidDateTime(String)}
 */
public class DateTime {
    public static final String MESSAGE_CONSTRAINTS =
            "DateTime should be in the yyyy-MM-dd HH:mm or yyyy-MM-dd format";
    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm";
    private static final String UI_FORMAT_DATE = "EEEE, MMM dd yyyy";

    public final LocalDateTime dateTime;

    /**
     * Constructs a {@code DateTime}.
     * @param dateTime A valid date time.
     */
    public DateTime(String dateTime) {
        requireNonNull(dateTime);
        checkArgument(isValidDateTime(dateTime), MESSAGE_CONSTRAINTS);
        this.dateTime = TimeFormatChecker.mapToLocalDateTime(dateTime);
    }

    /**
     * Util function for sample data.
     * @return
     */
    public static DateTime getToday(int hour, int minute) {
        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.of(hour, minute);
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String todayStr = dayFormatter.format(today) + " " + timeFormatter.format(time);
        return new DateTime(todayStr);
    }

    /**
     * Util function for sample data.
     * @return
     */
    public static DateTime getYesterday(int hour, int minute) {
        LocalDate today = LocalDate.now().minusDays(1);
        LocalTime time = LocalTime.of(hour, minute);
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String todayStr = dayFormatter.format(today) + " " + timeFormatter.format(time);
        return new DateTime(todayStr);
    }



    /**
     * Returns true if a given string is a valid date or an empty string.
     */
    public static boolean isValidDateTime(String test) {
        requireNonNull(test);
        return test.equals("") || TimeFormatChecker.check(test);
    }

    /**
     * Check if the dateTime is today
     */
    public boolean isToday() {
        return LocalDate.now().equals(dateTime.toLocalDate());
    }


    @Override
    public String toString() {
        DateTimeFormatter wantedFormat = DateTimeFormatter.ofPattern(STANDARD_FORMAT);
        String dateInString = dateTime.format(wantedFormat);
        return dateInString;
    }

    public String getUiFormatDateNoPunctuation() {
        String dateInString = this.getUiFormatDate();
        String punctuationRegex = "\\p{Punct}";
        String dateInStringNoPunctuation = dateInString.replaceAll(punctuationRegex, " ");
        return dateInStringNoPunctuation;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DateTime // instanceof handles nulls
                && dateTime.toString().equals(((DateTime) other).dateTime.toString())); // state check
    }

    @Override
    public int hashCode() {
        return dateTime.hashCode();
    }

    /**
     * Provides Ui Format Date.
     */
    public String getUiFormatDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(UI_FORMAT_DATE);
        return formatter.format(this.dateTime);
    }

    /**
     * Provides Standard Format Time.
     */
    public String getStandardFormatTime() {
        return toString().split(" ")[1];
    }

}
