package seedu.studybananas.logic.commands.commandtestutils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_DURATION;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_TIME;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_TITLE;
import static seedu.studybananas.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.ScheduleCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.ScheduleModel;
import seedu.studybananas.model.systemlevelmodel.Schedule;
import seedu.studybananas.model.task.InfoContainsKeywordsPredicate;
import seedu.studybananas.model.task.Task;

public class ScheduleCommandTestUtil {
    public static final String VALID_TITLE_CS2103T = "CS2103T";
    public static final String VALID_TITLE_CS2101 = "CS2101";
    public static final String VALID_DESCRIPTION_CS2103T = "Tutorial homework.";
    public static final String VALID_DESCRIPTION_CS2101 = "Oral presentation1.";
    public static final String VALID_DATETIME_CS2103T = "2020-09-25 11:00";
    public static final String VALID_DATETIME_CS2101 = "2020-10-25 10:00";
    public static final String VALID_DURATION = "60";

    public static final String TITLE_DESC_CS2103T = " " + PREFIX_TITLE + VALID_TITLE_CS2103T;
    public static final String TITLE_DESC_CS2101 = " " + PREFIX_TITLE + VALID_TITLE_CS2101;
    public static final String DESCRIPTION_DESC_CS2103T = " " + PREFIX_DESCRIPTION + VALID_DESCRIPTION_CS2103T;
    public static final String DESCRIPTION_DESC_CS2101 = " " + PREFIX_DESCRIPTION + VALID_DESCRIPTION_CS2101;
    public static final String DATETIME_DESC_CS2103T = " " + PREFIX_TIME + VALID_DATETIME_CS2103T;
    public static final String DATETIME_DESC_CS2101 = " " + PREFIX_TIME + VALID_DATETIME_CS2101;
    public static final String DURATION = " " + PREFIX_DURATION + VALID_DURATION;

    public static final String INVALID_DATETIME_DESC = " " + PREFIX_TIME + "JANUARY"; // wrong date time format
    public static final String INVALID_DURATION = " " + PREFIX_DURATION + "-60"; // duration should be a positive number

    public static final String PREAMBLE_WHITESPACE = "\t \r \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command<ScheduleModel> command, ScheduleModel actualModel,
                                            CommandResult expectedCommandResult, ScheduleModel expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, ScheduleModel, CommandResult, ScheduleModel)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command<ScheduleModel> command, ScheduleModel actualModel,
                                            String expectedMessage,
                                            ScheduleModel expectedModel) {
        CommandResult expectedCommandResult = new ScheduleCommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the schedule, filtered task list and selected task in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command<ScheduleModel> command, ScheduleModel actualModel,
                                            String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        Schedule expectedSchedule = new Schedule(actualModel.getSchedule());
        List<Task> expectedFilteredList = new ArrayList<>(actualModel.getFilteredTaskList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedSchedule, actualModel.getSchedule());
        assertEquals(expectedFilteredList, actualModel.getFilteredTaskList());
    }
    /**
     * Updates {@code model}'s filtered list to show only the task at the given {@code targetIndex} in the
     * {@code model}'s schedule.
     */
    public static void showTaskAtIndex(ScheduleModel model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredTaskList().size());

        Task task = model.getFilteredTaskList().get(targetIndex.getZeroBased());
        final String[] splitName = task.getTitle().title.split("\\s+");
        model.updateFilteredTaskList(new InfoContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredTaskList().size());
    }
}
