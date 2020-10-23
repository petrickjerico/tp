package seedu.address.logic.commands.schedulecommands;

import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.showTaskAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;
import static seedu.address.testutil.SampleTasks.getSampleSchedule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.ScheduleModel;
import seedu.address.model.ScheduleModelManager;

public class ScheduleListCommandTest {
    private ScheduleModel model;
    private ScheduleModel expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ScheduleModelManager(getSampleSchedule());
        expectedModel = new ScheduleModelManager(model.getSchedule());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new ScheduleListCommand(), model, ScheduleListCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        showTaskAtIndex(model, INDEX_FIRST);
        assertCommandSuccess(new ScheduleListCommand(), model, ScheduleListCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
