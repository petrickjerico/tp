package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.task.DateTime;
import seedu.address.model.task.exceptions.TimeFormatException;

public class JsonAdaptedDateTimeTest {
    private static final String INVALID_DATE_TIME = "12/10/2020 12:00";

    private static final String VALID_DATE_TIME = "2020-10-10 12:00";

    @Test
    public void toModelType_validDateTime_returnsDateTime() throws Exception {
        JsonAdaptedDateTime dateTime = new JsonAdaptedDateTime(VALID_DATE_TIME);
        DateTime dateTimeObject = new DateTime(VALID_DATE_TIME);
        assertEquals(dateTimeObject, dateTime.toModelType());
    }

    @Test
    public void toModelType_invalidDateTime_throwsIllegalValueException() {
        JsonAdaptedDateTime dateTime =
                new JsonAdaptedDateTime(INVALID_DATE_TIME);
        String expectedMessage = DateTime.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, dateTime::toModelType);
    }
}
