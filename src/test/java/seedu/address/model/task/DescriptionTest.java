package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class DescriptionTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Description(null));
    }

    @Test
    public void isValidDescription() {
        // null description
        assertThrows(NullPointerException.class, () -> Description.isValidDescription(null));

        // blank description
        assertFalse(Description.isValidDescription(" ")); // spaces only

        // valid description
        assertTrue(Description.isValidDescription("Final Examination for CS2103T"));
        assertTrue(Description.isValidDescription("PE")); // minimal
        assertTrue(Description.isValidDescription("Practical Examination")); // alphabets only
        assertTrue(Description.isValidDescription("!#$%&'*+/=?`{|}~^.-")); // special characters
        assertTrue(Description.isValidDescription("123145")); // numbers only
        assertTrue(Description.isValidDescription(
                "Final Examination which covers all the materials so far")); // long description
    }
}
