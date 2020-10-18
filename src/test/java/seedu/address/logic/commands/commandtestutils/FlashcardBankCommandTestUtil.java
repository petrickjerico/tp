package seedu.address.logic.commands.commandtestutils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.parser.CliSyntax.*;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.FlashcardModel;

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
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }
}
