package seedu.studybananas.logic.commands.commandresults;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FlashcardCommandResultTest {
    @Test
    public void equals() {
        CommandResult commandResult = new FlashcardCommandResult("feedback");

        // same values -> returns true
        assertTrue(commandResult.equals(new FlashcardCommandResult("feedback")));
        assertTrue(commandResult.equals(new FlashcardCommandResult("feedback", false, false)));

        // same object -> returns true
        assertTrue(commandResult.equals(commandResult));

        // null -> returns false
        assertFalse(commandResult.equals(null));

        // different types -> returns false
        assertFalse(commandResult.equals(0.5f));

        // different feedbackToUser value -> returns false
        assertFalse(commandResult.equals(new FlashcardCommandResult("different")));

        // different showHelp value -> returns false
        assertFalse(commandResult.equals(new FlashcardCommandResult("feedback", true, false)));

        // different exit value -> returns false
        assertFalse(commandResult.equals(new FlashcardCommandResult("feedback", false, true)));
    }

    @Test
    public void hashcode() {
        CommandResult commandResult = new FlashcardCommandResult("feedback");

        // same values -> returns same hashcode
        assertEquals(commandResult.hashCode(), new FlashcardCommandResult("feedback").hashCode());

        // different feedbackToUser value -> returns different hashcode
        assertNotEquals(commandResult.hashCode(), new FlashcardCommandResult("different").hashCode());

        // different showHelp value -> returns different hashcode
        assertNotEquals(commandResult.hashCode(), new FlashcardCommandResult("feedback", true, false).hashCode());

        // different exit value -> returns different hashcode
        assertNotEquals(commandResult.hashCode(), new FlashcardCommandResult("feedback", false, true).hashCode());
    }
}
