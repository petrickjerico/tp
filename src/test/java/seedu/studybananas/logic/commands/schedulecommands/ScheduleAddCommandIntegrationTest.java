package seedu.studybananas.logic.commands.schedulecommands;

import static seedu.studybananas.logic.commands.commandtestutils.ScheduleCommandTestUtil.assertCommandFailure;
import static seedu.studybananas.logic.commands.commandtestutils.ScheduleCommandTestUtil.assertCommandSuccess;
import static seedu.studybananas.testutil.SampleTasks.getSampleSchedule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.studybananas.model.ScheduleModel;
import seedu.studybananas.model.ScheduleModelManager;
import seedu.studybananas.model.task.Task;
import seedu.studybananas.testutil.TaskBuilder;

public class ScheduleAddCommandIntegrationTest {
    private ScheduleModel model;

    @BeforeEach
    public void setUp() {
        model = new ScheduleModelManager(getSampleSchedule());
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
