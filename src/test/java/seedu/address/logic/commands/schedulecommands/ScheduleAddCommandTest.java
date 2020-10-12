package seedu.address.logic.commands.schedulecommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.commandtestutils.ModelStub;
import seedu.address.model.person.Person;
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
    private class ModelStubWithTask extends ModelStub {
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
    private class ModelStubAcceptingTaskAdded extends  ModelStub{
        List<Task> tasks;
        @Override
        public boolean hasTask(Task task) {
            requireNonNull(task);
            return tasks.stream().anyMatch(task::isSameTask);
        }
    }
}
