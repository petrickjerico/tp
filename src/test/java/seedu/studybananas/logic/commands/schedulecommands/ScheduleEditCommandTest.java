package seedu.studybananas.logic.commands.schedulecommands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.studybananas.commons.core.Messages.MESSAGE_DUPLICATED_TASK;
import static seedu.studybananas.commons.core.Messages.MESSAGE_OVERLAP_TASK;
import static seedu.studybananas.logic.commands.commandtestutils.ScheduleCommandTestUtil.assertCommandFailure;
import static seedu.studybananas.testutil.Assert.assertThrows;
import static seedu.studybananas.testutil.SampleTasks.CS2100_TUTORIAL_HOMEWORK;
import static seedu.studybananas.testutil.SampleTasks.CS2103T_WEEK8_QUIZ;
import static seedu.studybananas.testutil.SampleTasks.getSampleSchedule;
import static seedu.studybananas.testutil.TypicalIndexes.INDEX_FIRST;
import static seedu.studybananas.testutil.TypicalIndexes.INDEX_SECOND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.studybananas.commons.core.Messages;
import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.ScheduleModel;
import seedu.studybananas.model.ScheduleModelManager;
import seedu.studybananas.model.systemlevelmodel.ReadOnlySchedule;
import seedu.studybananas.model.task.DateTime;
import seedu.studybananas.model.task.Description;
import seedu.studybananas.model.task.Duration;
import seedu.studybananas.model.task.Task;
import seedu.studybananas.model.task.Title;
import seedu.studybananas.testutil.TaskBuilder;

public class ScheduleEditCommandTest {
    private ScheduleModel model = new ScheduleModelManager(getSampleSchedule());

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredTaskList().size() + 1);
        ScheduleEditCommand editCommand = new ScheduleEditCommand(outOfBoundIndex, null, null, null, null);

        assertCommandFailure(editCommand, model, Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
    }

    @Test
    public void execute_taskAcceptedByModel_editSuccess() throws Exception {
        Description editedDescription = new Description("Week 9 Quiz");
        DateTime editedDateTime = new DateTime("2020-09-27 14:00");
        Duration editedDuration = new Duration("30");
        Task editedTask = new TaskBuilder().withDescription("Week 9 Quiz")
                .withDateTime(("2020-09-27 14:00"))
                .withDuration("30")
                .build();
        ModelStubAcceptingTaskAdded modelStub = new ModelStubAcceptingTaskAdded(
                CS2103T_WEEK8_QUIZ, CS2100_TUTORIAL_HOMEWORK);
        CommandResult result = new ScheduleEditCommand(
                INDEX_FIRST, null, editedDescription, editedDateTime, editedDuration).execute(modelStub);
        assertEquals(String.format(ScheduleEditCommand.MESSAGE_EDIT_TASK_SUCCESS, editedTask),
                result.getFeedbackToUser());
        assertEquals(Arrays.asList(editedTask, CS2100_TUTORIAL_HOMEWORK), modelStub.tasks);
    }

    @Test
    public void execute_duplicatedTask_throwsCommandException() {
        Title editedTitle = CS2100_TUTORIAL_HOMEWORK.getTitle();
        Description editedDescription = CS2100_TUTORIAL_HOMEWORK.getDescription().get();
        DateTime editedDateTime = CS2100_TUTORIAL_HOMEWORK.getDateTime().get();
        Duration editedDuration = CS2100_TUTORIAL_HOMEWORK.getDuration().get();
        ModelStubAcceptingTaskAdded modelStub = new ModelStubAcceptingTaskAdded(
                CS2103T_WEEK8_QUIZ, CS2100_TUTORIAL_HOMEWORK);
        ScheduleEditCommand editCommand = new ScheduleEditCommand(
                INDEX_FIRST, editedTitle, editedDescription, editedDateTime, editedDuration);
        assertThrows(CommandException.class, MESSAGE_DUPLICATED_TASK, (
        ) -> editCommand.execute(modelStub));
    }

    @Test
    public void execute_overlappedTask_throwsCommandException() {
        DateTime editedDateTime = CS2100_TUTORIAL_HOMEWORK.getDateTime().get();
        Duration editedDuration = CS2100_TUTORIAL_HOMEWORK.getDuration().get();
        ModelStubAcceptingTaskAdded modelStub = new ModelStubAcceptingTaskAdded(
                CS2103T_WEEK8_QUIZ, CS2100_TUTORIAL_HOMEWORK);
        ScheduleEditCommand editCommand = new ScheduleEditCommand(
                INDEX_FIRST, null, null, editedDateTime, editedDuration);
        assertThrows(CommandException.class, MESSAGE_OVERLAP_TASK, (
        ) -> editCommand.execute(modelStub));
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

    /**
     * A Model stub that always accepts the Task being edited.
     */
    private class ModelStubAcceptingTaskAdded extends ScheduleModelStub {
        private List<Task> tasks = new ArrayList<>();

        ModelStubAcceptingTaskAdded(Task t1, Task t2) {
            tasks.add(t1);
            tasks.add(t2);
        }

        @Override
        public boolean hasTask(Task task) {
            requireNonNull(task);
            return tasks.stream().anyMatch(task::isSameTask);
        }

        @Override
        public boolean isTaskOverlapped(Task exceptionTask, Task addedTask) {
            requireNonNull(addedTask);
            return tasks.stream().anyMatch(task ->
                    !exceptionTask.equals(addedTask) && task.isDateTimeOverlapped(addedTask));
        }

        @Override
        public void addTask(Task task) {
            requireNonNull(task);
            tasks.add(task);
        }

        @Override
        public void setTask(Task target, Task task) {
            requireNonNull(task);
            int index = tasks.indexOf(target);
            tasks.set(index, task);
        }

        @Override
        public ObservableList<Task> getFilteredTaskList() {
            return FXCollections.observableArrayList(tasks);
        }
    }

    private class ScheduleModelStub implements ScheduleModel {

        @Override
        public void setSchedule(ReadOnlySchedule schedule) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlySchedule getSchedule() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasTask(Task task) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean isTaskOverlapped(Task exceptionTask, Task task) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteTask(Task target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addTask(Task task) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setTask(Task target, Task editedTask) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Task> getFilteredTaskList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Task> getUpcomingTaskList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredTaskList(Predicate<Task> predicate) {
            throw new AssertionError("This method should not be called.");
        }
    }
}
