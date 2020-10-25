package seedu.studybananas.model.flashcard;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.studybananas.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class QuestionTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Question(null));
    }

    @Test
    public void constructor_invalidQuestion_throwsIllegalArgumentException() {
        String invalidQuestion = "";
        assertThrows(IllegalArgumentException.class, () -> new Question(invalidQuestion));
    }

    @Test
    public void isValidQuestion() {
        // null question
        assertThrows(NullPointerException.class, () -> Question.isValidQuestion(null));

        // invalid question
        assertFalse(Question.isValidQuestion("")); // empty string
        assertFalse(Question.isValidQuestion(" ")); // spaces only

        // valid questions
        assertTrue(Question.isValidQuestion("Define enthalpy change"));
        assertTrue(Question.isValidQuestion("What is Google?")); // with non-alphanumeric character '?'
        assertTrue(Question.isValidQuestion("H")); // one character
    }
}
