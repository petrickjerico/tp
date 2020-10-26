package seedu.studybananas.model.flashcard;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.studybananas.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class FlashcardSetNameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new FlashcardSetName(null));
    }

    @Test
    public void constructor_invalidFlashcardSetName_throwsIllegalArgumentException() {
        String invalidAnswer = "";
        assertThrows(IllegalArgumentException.class, () -> new FlashcardSetName(invalidAnswer));
    }

    @Test
    public void isValidAnswer() {
        // null name
        assertThrows(NullPointerException.class, () -> FlashcardSetName.isValidName(null));

        // invalid question
        assertFalse(FlashcardSetName.isValidName("")); // empty string
        assertFalse(FlashcardSetName.isValidName(" ")); // spaces only
        assertFalse(FlashcardSetName.isValidName("Computer Science!")); // with non-alphanumeric character '!'

        // valid questions
        assertTrue(FlashcardSetName.isValidName("Physics"));
        assertTrue(FlashcardSetName.isValidName("Y")); // one character
    }
}
