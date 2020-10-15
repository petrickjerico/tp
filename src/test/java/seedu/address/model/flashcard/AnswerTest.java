package seedu.address.model.flashcard;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class AnswerTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Answer(null));
    }

    @Test
    public void constructor_invalidAnswer_throwsIllegalArgumentException() {
        String invalidAnswer = "";
        assertThrows(IllegalArgumentException.class, () -> new Answer(invalidAnswer));
    }

    @Test
    public void isValidAnswer() {
        // null address
        assertThrows(NullPointerException.class, () -> Answer.isValidAnswer(null));

        // invalid question
        assertFalse(Answer.isValidAnswer("")); // empty string
        assertFalse(Answer.isValidAnswer(" ")); // spaces only

        // valid questions
        assertTrue(Answer.isValidAnswer("Amount of heat evolved or "
                + "absorbed in a reaction carried out at constant pressure"));
        assertTrue(Answer.isValidAnswer("Google is a search engine.")); // with non-alphanumeric character '.'
        assertTrue(Answer.isValidAnswer("Y")); // one character
    }
}
