package seedu.address.model.task.timeformat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;

import seedu.address.model.person.exceptions.TimeFormatException;

public class IsoDateTime implements TimeFormat {
    private static final String PATTERN = "yyyy-MM-dd";
    private static final DateTimeFormatter TIME_FORMATTER =
            new DateTimeFormatterBuilder().appendPattern(PATTERN)
                    .optionalStart().appendPattern(" HH:mm")
                    .optionalEnd().toFormatter();

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
