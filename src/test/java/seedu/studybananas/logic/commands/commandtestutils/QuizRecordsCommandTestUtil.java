package seedu.studybananas.logic.commands.commandtestutils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.studybananas.testutil.Assert.assertThrows;

import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.QuizCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.FlashcardQuizModel;
import seedu.studybananas.model.QuizModel;
import seedu.studybananas.model.systemlevelmodel.QuizRecords;

public class QuizRecordsCommandTestUtil {

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command<QuizModel> command, QuizModel actualModel,
                                            CommandResult expectedCommandResult, QuizModel expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, QuizModel, CommandResult, QuizModel)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command<QuizModel> command, QuizModel actualModel,
                                            String expectedMessage,
                                            QuizModel expectedModel) {
        CommandResult expectedCommandResult = new QuizCommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command<FlashcardQuizModel> command, FlashcardQuizModel actualModel,
                                            CommandResult expectedCommandResult, FlashcardQuizModel expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to
     * {@link #assertCommandSuccess(Command, FlashcardQuizModel, CommandResult, FlashcardQuizModel)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command<FlashcardQuizModel> command, FlashcardQuizModel actualModel,
                                            String expectedMessage,
                                            FlashcardQuizModel expectedModel) {
        CommandResult expectedCommandResult = new QuizCommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the quiz records and selected quiz <br>
     * - in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command<QuizModel> command, QuizModel actualModel,
                                            String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        QuizRecords expectedQuizRecords = new QuizRecords(actualModel.getAllQuizRecords());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedQuizRecords, actualModel.getAllQuizRecords());
    }
}
