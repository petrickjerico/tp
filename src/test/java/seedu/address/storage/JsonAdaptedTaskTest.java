package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.schedulestorage.JsonAdaptedTask.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.SampleTasks.CS2103T_WEEK8_QUIZ;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.task.Title;
import seedu.address.storage.schedulestorage.JsonAdaptedTask;

public class JsonAdaptedTaskTest {
    private static final Optional<String> VALID_DESCRIPTION =
            Optional.ofNullable((CS2103T_WEEK8_QUIZ.getDescription().get().toString()));
    private static final Optional<String> VALID_DATE_TIME =
            CS2103T_WEEK8_QUIZ.getDateTime().map(dateTime -> dateTime.toString());

    @Test
    public void toModelType_validTaskDetails_returnsTask() throws Exception {
        JsonAdaptedTask task = new JsonAdaptedTask(CS2103T_WEEK8_QUIZ);
        assertEquals(CS2103T_WEEK8_QUIZ, task.toModelType());
    }

    @Test
    public void toModelType_nullTitle_throwsIllegalValueException() {
        JsonAdaptedTask task = new JsonAdaptedTask(null, VALID_DESCRIPTION, VALID_DATE_TIME);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Title.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, task::toModelType);
    }

}
