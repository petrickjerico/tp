package seedu.studybananas.model.task;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.studybananas.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class DurationTest {

    @Test
    public void constructor_nullCastToInteger_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Duration((Integer)null));
    }

    @Test
    public void constructor_nullCastToString_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Duration((String)null));
    }

    @Test
    public void isValidDuration() {
        // null duration
        assertThrows(NullPointerException.class, () -> Description.isValidDescription(null));

        // Duration greater or equal to 1440 -> returns false
        assertFalse(Duration.isValidDuration("1441"));
        assertFalse(Duration.isValidDuration("1440"));

        // Duration smaller than 0 -> returns false
        assertFalse(Duration.isValidDuration("-1"));

        // Valid duration
        assertTrue(Duration.isValidDuration("0"));
        assertTrue(Duration.isValidDuration("1"));
        assertTrue(Duration.isValidDuration("500"));
        assertTrue(Duration.isValidDuration("1439"));
    }
}
