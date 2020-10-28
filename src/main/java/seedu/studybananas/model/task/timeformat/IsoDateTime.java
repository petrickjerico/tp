package seedu.studybananas.model.task.timeformat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import seedu.studybananas.model.task.exceptions.TimeFormatException;

public class IsoDateTime implements TimeFormat {
    private static final String PATTERN = "uuuu-MM-dd";
    private static final DateTimeFormatter TIME_FORMATTER =
            new DateTimeFormatterBuilder().appendPattern(PATTERN)
                    .optionalStart().appendPattern(" HH:mm")
                    .optionalEnd()
                    .toFormatter();

    @Override
    public LocalDateTime check(String date) {
        try {
            DateTimeFormatter strictDateTimeFormatter = TIME_FORMATTER.withResolverStyle(ResolverStyle.STRICT);
            LocalDateTime ld = LocalDateTime.parse(date, strictDateTimeFormatter);
            return ld;
        } catch (DateTimeParseException e) {
            throw new TimeFormatException();
        }
    }
}
