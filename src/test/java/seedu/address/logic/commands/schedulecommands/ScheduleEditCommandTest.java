package seedu.address.logic.commands.schedulecommands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.assertCommandFailure;
import static seedu.address.testutil.SampleTasks.getSampleSchedule;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.ScheduleModel;
import seedu.address.model.ScheduleModelManager;
import seedu.address.model.task.DateTime;
import seedu.address.model.task.Description;
import seedu.address.model.task.Duration;
import seedu.address.model.task.Task;
import seedu.address.testutil.TaskBuilder;

public class ScheduleEditCommandTest {
    private ScheduleModel model = new ScheduleModelManager(getSampleSchedule());
    private ScheduleModel expectedModel = new ScheduleModelManager(getSampleSchedule());

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredTaskList().size() + 1);
        ScheduleEditCommand editCommand = new ScheduleEditCommand(outOfBoundIndex, null, null, null, null);

        assertCommandFailure(editCommand, model, Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
    }

    @Test
    public void execute_taskAcceptedByModel_editSuccess() throws Exception {
        Description editedDescription = new Description("Week 9 Quiz");
        DateTime editedDateTime = new DateTime("2020-09-27 12:00");
        Duration editedDuration = new Duration("30");
        Task editedTask = new TaskBuilder().withDescription("Week 9 Quiz")
                .withDateTime(("2020-09-27 12:00"))
                .withDuration("30")
                .build();
        CommandResult result = new ScheduleEditCommand(
                INDEX_FIRST, null, editedDescription, editedDateTime, editedDuration).execute(expectedModel);
        assertEquals(String.format(ScheduleEditCommand.MESSAGE_EDIT_TASK_SUCCESS, editedTask),
                result.getFeedbackToUser());
    }

    @Test
    public void equals() {
        ScheduleEditCommand editFirstCommand = new ScheduleEditCommand(INDEX_FIRST, null, null, null, null);
        ScheduleEditCommand editSecondCommand = new ScheduleEditCommand(INDEX_SECOND, null, null, null, null);

        // same object -> returns true
        assertTrue(editFirstCommand.equals(editFirstCommand));

        // same values -> returns true
        ScheduleEditCommand editFirstCommandCopy = new ScheduleEditCommand(INDEX_FIRST, null, null, null, null);
        assertTrue(editFirstCommand.equals(editFirstCommandCopy));

        // different types -> returns false
        assertFalse(editFirstCommand.equals(1));

        // null -> returns false
        assertFalse(editFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(editFirstCommand.equals(editSecondCommand));
    }

}
