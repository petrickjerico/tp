package seedu.address.logic.commands.schedulecommands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.ScheduleModel;
import seedu.address.model.systemlevelmodel.ReadOnlySchedule;
import seedu.address.model.task.Task;
import seedu.address.testutil.TaskBuilder;

public class ScheduleAddCommandTest {
    @Test
    public void constructor_nullTask_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ScheduleAddCommand(null));
    }

    @Test
    public void execute_taskAcceptedByModel_addSuccess() throws Exception {
        ModelStubAcceptingTaskAdded modelStub = new ModelStubAcceptingTaskAdded();
        Task validTask = new TaskBuilder().build();

        CommandResult result = new ScheduleAddCommand(validTask).execute(modelStub);

        assertEquals(String.format(ScheduleAddCommand.MESSAGE_SUCCESS, validTask), result.getFeedbackToUser());
        assertEquals(Arrays.asList(validTask), modelStub.tasksAdded);
    }

    @Test
    public void execute_duplicateTask_throwsCommandException() {
        Task validTask = new TaskBuilder().build();
        ScheduleAddCommand addCommand = new ScheduleAddCommand(validTask);
        ModelStubWithTask modelStub = new ModelStubWithTask(validTask);

        assertThrows(CommandException.class, ScheduleAddCommand.MESSAGE_DUPLICATE_TASK, (
        ) -> addCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Task cs2103 = new TaskBuilder().withTitle("cs2103").build();
        Task cs2101 = new TaskBuilder().withTitle("cs2101").build();
        ScheduleAddCommand addCs2103 = new ScheduleAddCommand(cs2103);
        ScheduleAddCommand addCs2101 = new ScheduleAddCommand(cs2101);

        // same object -> returns true
        assertTrue(addCs2103.equals(addCs2103));

        // same values -> returns true
        ScheduleAddCommand addCs2103CommandCopy = new ScheduleAddCommand(cs2103);
        assertTrue(addCs2103.equals(addCs2103CommandCopy));

        // different types -> returns false
        assertFalse(addCs2103.equals(1));

        // null -> returns false
        assertFalse(addCs2103.equals(null));

        // different task -> returns false
        assertFalse(addCs2101.equals(addCs2103));
    }




    /**
     * A Model stub that contains a single Task.
     */
    private class ModelStubWithTask extends ScheduleModelStub {
        private final Task task;

        ModelStubWithTask(Task task) {
            requireNonNull(task);
            this.task = task;
        }

        @Override
        public boolean hasTask(Task task) {
            requireNonNull(task);
            return this.task.isSameTask(task);
        }
    }

    /**
     * A Model stub that always accepts the Task being added.
     */
    private class ModelStubAcceptingTaskAdded extends ScheduleModelStub {
        private List<Task> tasksAdded = new ArrayList<>();
        @Override
        public boolean hasTask(Task task) {
            requireNonNull(task);
            return tasksAdded.stream().anyMatch(task::isSameTask);
        }
        @Override
        public void addTask(Task task) {
            requireNonNull(task);
            tasksAdded.add(task);
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
        public void updateFilteredTaskList(Predicate<Task> predicate) {
            throw new AssertionError("This method should not be called.");
        }
    }
}
