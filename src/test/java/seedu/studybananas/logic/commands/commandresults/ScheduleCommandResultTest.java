package seedu.studybananas.logic.commands.commandresults;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ScheduleCommandResultTest {
    @Test
    public void equals() {
        CommandResult commandResult = new ScheduleCommandResult("feedback");

        // same values -> returns true
        assertTrue(commandResult.equals(new ScheduleCommandResult("feedback")));
        assertTrue(commandResult.equals(new ScheduleCommandResult("feedback", false, false)));

        // same object -> returns true
        assertTrue(commandResult.equals(commandResult));

        // null -> returns false
        assertFalse(commandResult.equals(null));

        // different types -> returns false
        assertFalse(commandResult.equals(0.5f));

        // different feedbackToUser value -> returns false
        assertFalse(commandResult.equals(new ScheduleCommandResult("different")));

        // different showHelp value -> returns false
        assertFalse(commandResult.equals(new ScheduleCommandResult("feedback", true, false)));

        // different exit value -> returns false
        assertFalse(commandResult.equals(new ScheduleCommandResult("feedback", false, true)));
    }

    @Test
    public void hashcode() {
        CommandResult commandResult = new ScheduleCommandResult("feedback");

        // same values -> returns same hashcode
        assertEquals(commandResult.hashCode(), new ScheduleCommandResult("feedback").hashCode());

        // different feedbackToUser value -> returns different hashcode
        assertNotEquals(commandResult.hashCode(), new ScheduleCommandResult("different").hashCode());

        // different showHelp value -> returns different hashcode
        assertNotEquals(commandResult.hashCode(), new ScheduleCommandResult("feedback", true, false).hashCode());

        // different exit value -> returns different hashcode
        assertNotEquals(commandResult.hashCode(), new ScheduleCommandResult("feedback", false, true).hashCode());
    }
}
