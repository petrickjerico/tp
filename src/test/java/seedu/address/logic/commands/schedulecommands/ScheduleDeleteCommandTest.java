package seedu.address.logic.commands.schedulecommands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.showTaskAtIndex;
import static seedu.address.testutil.SampleTasks.getSampleSchedule;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.ScheduleModel;
import seedu.address.model.ScheduleModelManager;
import seedu.address.model.task.Task;

public class ScheduleDeleteCommandTest {
    private ScheduleModel model = new ScheduleModelManager(getSampleSchedule());

    @Test
    public void execute_validIndexUnfilteredList_success() {
        Task taskToDelete = model.getFilteredTaskList().get(INDEX_FIRST.getZeroBased());
        ScheduleDeleteCommand deleteCommand = new ScheduleDeleteCommand(INDEX_FIRST);

        String expectedMessage = String.format(ScheduleDeleteCommand.MESSAGE_DELETE_TASK_SUCCESS, taskToDelete);

        ScheduleModelManager expectedModel = new ScheduleModelManager(model.getSchedule());
        expectedModel.deleteTask(taskToDelete);

        assertCommandSuccess(deleteCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredTaskList().size() + 1);
        ScheduleDeleteCommand deleteCommand = new ScheduleDeleteCommand(outOfBoundIndex);

        assertCommandFailure(deleteCommand, model, Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validIndexFilteredList_success() {
        showTaskAtIndex(model, INDEX_FIRST);

        Task taskToDelete = model.getFilteredTaskList().get(INDEX_FIRST.getZeroBased());
        ScheduleDeleteCommand deleteCommand = new ScheduleDeleteCommand(INDEX_FIRST);

        String expectedMessage = String.format(ScheduleDeleteCommand.MESSAGE_DELETE_TASK_SUCCESS, taskToDelete);

        ScheduleModel expectedModel = new ScheduleModelManager(model.getSchedule());
        expectedModel.deleteTask(taskToDelete);
        showNoTask(expectedModel);

        assertCommandSuccess(deleteCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        showTaskAtIndex(model, INDEX_FIRST);

        Index outOfBoundIndex = INDEX_SECOND;
        // ensures that outOfBoundIndex is still in bounds of schedule list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getSchedule().getTaskList().size());

        ScheduleDeleteCommand deleteCommand = new ScheduleDeleteCommand(outOfBoundIndex);

        assertCommandFailure(deleteCommand, model, Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        ScheduleDeleteCommand deleteFirstCommand = new ScheduleDeleteCommand(INDEX_FIRST);
        ScheduleDeleteCommand deleteSecondCommand = new ScheduleDeleteCommand(INDEX_SECOND);

        // same object -> returns true
        assertTrue(deleteFirstCommand.equals(deleteFirstCommand));

        // same values -> returns true
        ScheduleDeleteCommand deleteFirstCommandCopy = new ScheduleDeleteCommand(INDEX_FIRST);
        assertTrue(deleteFirstCommand.equals(deleteFirstCommandCopy));

        // different types -> returns false
        assertFalse(deleteFirstCommand.equals(1));

        // null -> returns false
        assertFalse(deleteFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(deleteFirstCommand.equals(deleteSecondCommand));
    }

    /**
     * Updates {@code model}'s filtered list to show no one.
     */
    private void showNoTask(ScheduleModel model) {
        model.updateFilteredTaskList(p -> false);

        assertTrue(model.getFilteredTaskList().isEmpty());
    }


}
