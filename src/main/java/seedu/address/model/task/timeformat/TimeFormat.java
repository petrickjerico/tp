package seedu.address.model.task.timeformat;

import java.time.LocalDateTime;

import seedu.address.model.person.exceptions.TimeFormatException;

public interface TimeFormat {
    LocalDateTime check(String time) throws TimeFormatException;
}
