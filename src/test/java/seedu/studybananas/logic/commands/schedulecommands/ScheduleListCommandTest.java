package seedu.studybananas.logic.commands.schedulecommands;

import static seedu.studybananas.logic.commands.commandtestutils.ScheduleCommandTestUtil.assertCommandSuccess;
import static seedu.studybananas.logic.commands.commandtestutils.ScheduleCommandTestUtil.showTaskAtIndex;
import static seedu.studybananas.testutil.SampleTasks.getSampleSchedule;
import static seedu.studybananas.testutil.TypicalIndexes.INDEX_FIRST;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.studybananas.model.ScheduleModel;
import seedu.studybananas.model.ScheduleModelManager;

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
