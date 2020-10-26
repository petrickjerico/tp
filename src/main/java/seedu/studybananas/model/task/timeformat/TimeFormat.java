package seedu.studybananas.model.task.timeformat;

import java.time.LocalDateTime;

import seedu.studybananas.model.task.exceptions.TimeFormatException;

public interface TimeFormat {
    LocalDateTime check(String time) throws TimeFormatException;
}
