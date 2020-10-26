package seedu.studybananas.model.task.timeformat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;

import seedu.studybananas.model.task.exceptions.TimeFormatException;

public class IsoDate implements TimeFormat {
    private static final String PATTERN = "yyyy-MM-dd";
    private static final DateTimeFormatter TIME_FORMATTER =
            new DateTimeFormatterBuilder().appendPattern(PATTERN)
                    .optionalStart().appendPattern(" HH:mm")
                    .optionalEnd().parseDefaulting(ChronoField.HOUR_OF_DAY, 12)
                    .parseDefaulting(ChronoField.MINUTE_OF_DAY, 0).toFormatter();

    @Override
    public LocalDateTime check(String date) {
        try {
            LocalDateTime ld = LocalDateTime.parse(date, TIME_FORMATTER);
            return ld;
        } catch (DateTimeParseException e) {
            throw new TimeFormatException();
        }
    }

}
