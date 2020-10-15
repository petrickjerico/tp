package seedu.address.logic.commands.schedulecommands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_TASKS_LISTED_OVERVIEW;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalTasks.CS2100_FINAL;
import static seedu.address.testutil.TypicalTasks.CS2100_TUTORIAL_HOMEWORK;
import static seedu.address.testutil.TypicalTasks.getTypicalSchedule;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.model.ScheduleModel;
import seedu.address.model.ScheduleModelManager;
import seedu.address.model.task.TitleContainsKeywordsPredicate;

public class ScheduleSearchCommandTest {
    private ScheduleModel model = new ScheduleModelManager(getTypicalSchedule());
    private ScheduleModel expectedModel = new ScheduleModelManager(getTypicalSchedule());


    @Test
    public void equals() {
        TitleContainsKeywordsPredicate firstPredicate =
                new TitleContainsKeywordsPredicate(Collections.singletonList("first"));
        TitleContainsKeywordsPredicate secondPredicate =
                new TitleContainsKeywordsPredicate(Collections.singletonList("second"));

        ScheduleSearchCommand findFirstCommand = new ScheduleSearchCommand(firstPredicate);
        ScheduleSearchCommand findSecondCommand = new ScheduleSearchCommand(secondPredicate);

        // same object -> returns true
        assertTrue(findFirstCommand.equals(findFirstCommand));

        // same values -> returns true
        ScheduleSearchCommand findFirstCommandCopy = new ScheduleSearchCommand(firstPredicate);
        assertTrue(findFirstCommand.equals(findFirstCommandCopy));

        // different types -> returns false
        assertFalse(findFirstCommand.equals(1));

        // null -> returns false
        assertFalse(findFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(findFirstCommand.equals(findSecondCommand));
    }

    @Test
    public void execute_zeroKeywords_noTaskFound() {
        String expectedMessage = String.format(MESSAGE_TASKS_LISTED_OVERVIEW, 0);
        TitleContainsKeywordsPredicate predicate = preparePredicate(" ");
        ScheduleSearchCommand command = new ScheduleSearchCommand(predicate);
        expectedModel.updateFilteredTaskList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.getFilteredTaskList());
    }

    @Test
    public void execute_multipleKeywords_multipleTasksFound() {
        String expectedMessage = String.format(MESSAGE_TASKS_LISTED_OVERVIEW, 2);
        TitleContainsKeywordsPredicate predicate = preparePredicate("CS2100");
        ScheduleSearchCommand command = new ScheduleSearchCommand(predicate);
        expectedModel.updateFilteredTaskList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(CS2100_TUTORIAL_HOMEWORK, CS2100_FINAL), model.getFilteredTaskList());
    }

    /**
     * Parses {@code userInput} into a {@code TitleContainsKeywordsPredicate}.
     */
    private TitleContainsKeywordsPredicate preparePredicate(String userInput) {
        return new TitleContainsKeywordsPredicate(Arrays.asList(userInput.split("\\s+")));
    }
}
