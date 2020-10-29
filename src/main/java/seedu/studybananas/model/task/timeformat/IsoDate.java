package seedu.studybananas.model.task.timeformat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Arrays;
import java.util.List;

import seedu.studybananas.model.task.exceptions.TimeFormatException;

public class IsoDate implements TimeFormat {
    private static final List<String> PATTERNS = Arrays.asList("uuuu-MM-dd", "EEEE, MMM dd uuuu");

    // Default time to be set up for date is 12PM
    private static final String DEFAULT_TIME = " 12:00";

    private DateTimeFormatter buildDateTimeFormatter(String format) {
        return new DateTimeFormatterBuilder().appendPattern(format)
                .optionalStart().appendPattern(" HH:mm")
                .optionalEnd()
                .toFormatter();
    }

    @Override
    public LocalDateTime check(String date) {
        for (String pattern : PATTERNS) {
            try {
                String dateAppendedTime = date + DEFAULT_TIME;
                DateTimeFormatter dateTimeFormatter = buildDateTimeFormatter(pattern);
                DateTimeFormatter strictDateTimeFormatter = dateTimeFormatter.withResolverStyle(ResolverStyle.STRICT);
                LocalDateTime ld = LocalDateTime.parse(dateAppendedTime, strictDateTimeFormatter);
                return ld;
            } catch (DateTimeParseException e) {
                continue;
            }
        }
        // Fail all the date time formats
        throw new TimeFormatException();
    }


}
