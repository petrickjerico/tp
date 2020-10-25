package seedu.studybananas.model.task;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.studybananas.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class DateTimeTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new DateTime(null));
    }

    @Test
    public void isValidDateTime() {
        // null phone number
        assertThrows(NullPointerException.class, () -> DateTime.isValidDateTime(null));

        // invalid date time
        assertFalse(DateTime.isValidDateTime(" ")); // spaces only
        assertFalse(DateTime.isValidDateTime("10/12/2020 12:00")); // wrong format in dd/MM/yyyy hh:mm
        assertFalse(DateTime.isValidDateTime("date")); // non-numeric
        assertFalse(DateTime.isValidDateTime("2020/03/20")); // no time

        // valid date time
        assertTrue(DateTime.isValidDateTime("2020-10-10 12:00")); // correct format
    }
}
