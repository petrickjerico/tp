package seedu.address.logic.commands.schedulecommands;

import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalTasks.getTypicalSchedule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.ScheduleModel;
import seedu.address.model.ScheduleModelManager;
import seedu.address.model.task.Task;
import seedu.address.testutil.TaskBuilder;

public class ScheduleAddCommandIntegrationTest {
    private ScheduleModel model;

    @BeforeEach
    public void setUp() {
        model = new ScheduleModelManager(getTypicalSchedule());
    }

    @Test
    public void execute_newTask_success() {
        Task validTask = new TaskBuilder().build();

        ScheduleModel expectedModel = new ScheduleModelManager(model.getSchedule());
        expectedModel.addTask(validTask);

        assertCommandSuccess(new ScheduleAddCommand(validTask), model,
                String.format(ScheduleAddCommand.MESSAGE_SUCCESS, validTask), expectedModel);
    }

    @Test
    public void execute_duplicateTask_throwsCommandException() {
        Task taskInList = model.getSchedule().getTaskList().get(0);
        assertCommandFailure(new ScheduleAddCommand(taskInList), model, ScheduleAddCommand.MESSAGE_DUPLICATE_TASK);
    }

}
