package seedu.studybananas.logic.commands.commandtestutils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_ANSWER;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_FLASHCARD;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_FLASHCARDSET;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_FLASHCARDSET_NAME;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_QUESTION;
import static seedu.studybananas.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.FlashcardCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.FlashcardModel;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.systemlevelmodel.FlashcardBank;

public class FlashcardBankCommandTestUtil {
    public static final String VALID_FLSET_NAME_PHYSICS = "Physics";
    public static final String VALID_FLSET_NAME_ECONOMICS = "Economics";

    public static final String VALID_QUESTION_SECOND_LAW = "Newton's Second Law";
    public static final String VALID_QUESTION_OPPORTUNITY_COST = "Explain the idea of an opportunity cost.";
    public static final String INVALID_QUESTION = "Graph regex should not contain non-roman characters: 漢字";

    public static final String VALID_ANSWER_SECOND_LAW = "The rate of change of momentum of a body "
            + "is directly proportional to the resultant force acting on it"
            + " and occurs in the direction of the force";
    public static final String VALID_ANSWER_OPPORTUNITY_COST = "Benefits or value of the next best alternative forgone";
    public static final String INVALID_ANSWER = "Graph regex should not contain non-roman characters: 漢字";

    public static final String NAME_DESC_PHYSICS = " " + PREFIX_FLASHCARDSET_NAME + VALID_FLSET_NAME_PHYSICS;
    public static final String NAME_DESC_ECONOMICS = " " + PREFIX_FLASHCARDSET_NAME + VALID_FLSET_NAME_ECONOMICS;
    public static final String NAME_DESC_PHYSICS_EXTRA_WHITESPACE = String.format(" %s  %s",
            PREFIX_FLASHCARDSET_NAME, VALID_FLSET_NAME_PHYSICS);

    public static final String QUESTION_DESC_SECOND_LAW = " " + PREFIX_QUESTION + VALID_QUESTION_SECOND_LAW;
    public static final String QUESTION_DESC_OPPORTUNITY_COST = " " + PREFIX_QUESTION + VALID_QUESTION_OPPORTUNITY_COST;
    public static final String INVALID_QUESTION_DESC = " " + PREFIX_QUESTION + INVALID_QUESTION;

    public static final String ANSWER_DESC_SECOND_LAW = " " + PREFIX_ANSWER + VALID_ANSWER_SECOND_LAW;
    public static final String ANSWER_DESC_OPPORTUNITY_COST = " " + PREFIX_ANSWER + VALID_ANSWER_OPPORTUNITY_COST;
    public static final String INVALID_ANSWER_DESC = " " + PREFIX_ANSWER + INVALID_ANSWER;

    public static final String FLSET_INDEX_DESC_ONE = " " + PREFIX_FLASHCARDSET + "1";
    public static final String FLSET_INDEX_DESC_TWO = " " + PREFIX_FLASHCARDSET + "2";
    public static final String FL_INDEX_DESC_ONE = " " + PREFIX_FLASHCARD + "1";
    public static final String INVALID_FLSET_INDEX_NEGATIVE = " " + PREFIX_FLASHCARDSET + "-1";
    public static final String INVALID_FLSET_INDEX_NON_INTEGER = " " + PREFIX_FLASHCARDSET + "A";
    public static final String INVALID_FL_INDEX_NEGATIVE = " " + PREFIX_FLASHCARD + "-1";
    public static final String INVALID_FL_INDEX_NON_INTEGER = " " + PREFIX_FLASHCARD + "A";
    public static final String INVALID_INDEX_ERROR_MESSAGE = "Index is not a non-zero unsigned integer.";

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command<FlashcardModel> command, FlashcardModel actualModel,
                                            CommandResult expectedCommandResult, FlashcardModel expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, FlashcardModel, CommandResult, FlashcardModel)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command<FlashcardModel> command, FlashcardModel actualModel,
                                            String expectedMessage,
                                            FlashcardModel expectedModel) {
        CommandResult expectedCommandResult = new FlashcardCommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the flashcard bank, filtered flashcard set list and selected flashcard set <br>
     * - in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command<FlashcardModel> command, FlashcardModel actualModel,
                                            String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        FlashcardBank expectedFlashcardBank = new FlashcardBank(actualModel.getFlashcardBank());
        List<FlashcardSet> expectedFilteredList = new ArrayList<>(actualModel.getFilteredFlashcardSetList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedFlashcardBank, actualModel.getFlashcardBank());
        assertEquals(expectedFilteredList, actualModel.getFilteredFlashcardSetList());
    }
}
