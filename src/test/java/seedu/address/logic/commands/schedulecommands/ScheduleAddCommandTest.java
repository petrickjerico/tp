package seedu.address.logic.commands.schedulecommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.model.ReadOnlySchedule;
import seedu.address.model.ScheduleModel;
import seedu.address.model.task.Task;

public class ScheduleAddCommandTest {
    @Test
    public void constructor_nullTask_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ScheduleAddCommand(null));
    }

    @Test
    public void execute_taskAcceptedByModel_addSuccess() {
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
        List<Task> tasks;
        @Override
        public boolean hasTask(Task task) {
            requireNonNull(task);
            return tasks.stream().anyMatch(task::isSameTask);
        }
    }

    private class ScheduleModelStub implements ScheduleModel {

        @Override
        public Path getScheduleFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setScheduleFilePath(Path scheduleFilePath) {
            throw new AssertionError("This method should not be called.");
        }

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
