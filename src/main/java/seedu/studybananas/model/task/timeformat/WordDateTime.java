package seedu.studybananas.model.task.timeformat;

import seedu.studybananas.model.task.exceptions.TimeFormatException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordDateTime implements TimeFormat {
    private static final List<String> DAYS = Arrays.asList("^MON(DAY)?$", "^TUE(SDAY)?$", "^WED(NESDAY)?$",
            "^THU(RSDAY)?$", "^FRI(DAY)?$", "^SAT(URDAY)?$", "^SUN(DAY)?$");

    private static final String TODAY = "TODAY";

    private static final String TOMORROW = "TOMORROW";

    // Default time to be set up for date is 12PM
    private static final String DEFAULT_TIME = "12:00";

    @Override
    public LocalDateTime check(String date) {
        String day = getDay(date);
        String dayUpperCase = day.toUpperCase();
        String time = getTime(date);
        switch (dayUpperCase) {
            case TODAY:
                return getLocalDateTimeFromWord(0, time);
            case TOMORROW:
                return getLocalDateTimeFromWord(1, time);
            default:
                return getLocalDateTimeFromWeekDay(dayUpperCase, time);
        }
    }

    private boolean hasTime(String dateInput) {
        String[] dayAndTime = dateInput.split(" ");
        // Day and Time are separated by an empty space
        return dayAndTime.length == 2;
    }

    private String getDay(String dateInput) {
        try {
            String[] dayAndTime = dateInput.split(" ");
            // Day should be the first word in the date input
            return dayAndTime[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            // Empty space case
            throw new TimeFormatException();
        }
    }

    private String getTime(String dateInput) {
        if (hasTime(dateInput)) {
            // Time should be the second word in the date input
            return dateInput.split(" ")[1];
        } else {
            return DEFAULT_TIME;
        }
    }

    private LocalDateTime getLocalDateTimeFromWord(int dayFromNow, String time) {
        try {
            LocalTime localTime = LocalTime.parse(time);
            LocalDate localDate = LocalDate.now().plusDays(dayFromNow);
            return LocalDateTime.of(localDate, localTime);
        } catch (DateTimeParseException | NullPointerException e) {
            throw new TimeFormatException();
        }
    }

    private LocalDateTime getLocalDateTimeFromWeekDay(String day, String time) {
        try {
            LocalTime localTime = LocalTime.parse(time);
            LocalDate currentDate = LocalDate.now();
            return DAYS.stream().filter(dayOfWeek -> day.matches(dayOfWeek)).map(dayOfWeek ->
                    LocalDateTime.of(currentDate, localTime)
                    .with(adjustDayDifference(dayOfWeek)))
                    .collect(Collectors.toList()).get(0);
        } catch (DateTimeParseException | NullPointerException | IndexOutOfBoundsException e) {
            throw new TimeFormatException();
        }
    }

    private TemporalAdjuster adjustDayDifference(String dayOfWeekString) {
        int indexOfDay = DAYS.indexOf(dayOfWeekString) + 1;
        DayOfWeek dayOfWeek = DayOfWeek.of(indexOfDay);
        return TemporalAdjusters.next(dayOfWeek);
    }
}
