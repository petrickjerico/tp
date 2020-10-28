package seedu.studybananas.model.task.timeformat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import seedu.studybananas.model.task.exceptions.TimeFormatException;

public class IsoDate implements TimeFormat {
    private static final String PATTERN = "uuuu-MM-dd";

    // Default time to be set up for date is 12PM
    private static final String DEFAULT_TIME = " 12:00";

    private static final DateTimeFormatter TIME_FORMATTER =
            new DateTimeFormatterBuilder().appendPattern(PATTERN)
                    .optionalStart().appendPattern(" HH:mm")
                    .optionalEnd().toFormatter();

    @Override
    public LocalDateTime check(String date) {
        try {
            String dateAppendedTime = date + DEFAULT_TIME;
            DateTimeFormatter strictDateTimeFormatter = TIME_FORMATTER.withResolverStyle(ResolverStyle.STRICT);
            LocalDateTime ld = LocalDateTime.parse(dateAppendedTime, strictDateTimeFormatter);
            return ld;
        } catch (DateTimeParseException e) {
            throw new TimeFormatException();
        }
    }
}
