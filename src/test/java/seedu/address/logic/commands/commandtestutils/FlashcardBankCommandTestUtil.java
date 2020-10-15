package seedu.address.logic.commands.commandtestutils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ANSWER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_FLASHCARDSET;
import static seedu.address.logic.parser.CliSyntax.PREFIX_QUESTION;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.FlashcardModel;

public class FlashcardBankCommandTestUtil {
    public static final String VALID_FLSET_NAME_PHYSICS = "Physics";
    public static final String VALID_FLSET_NAME_ECONOMICS = "Economics";

    public static final String VALID_QUESTION_SECOND_LAW = "Newton's Second Law";
    public static final String VALID_QUESTION_OPPORTUNITY_COST = "Explain the idea of an opportunity cost.";

    public static final String VALID_ANSWER_SECOND_LAW = "The rate of change of momentum of a body "
            + "is directly proportional to the resultant force acting on it"
            + " and occurs in the direction of the force";
    public static final String VALID_ANSWER_OPPORTUNITY_COST = "Benefits or value of the next best alternative forgone";

    public static final String NAME_DESC_PHYSICS = " " + PREFIX_FLASHCARDSET + VALID_FLSET_NAME_PHYSICS;
    public static final String NAME_DESC_ECONOMICS = " " + PREFIX_FLASHCARDSET + VALID_FLSET_NAME_ECONOMICS;

    public static final String QUESTION_DESC_SECOND_LAW = " " + PREFIX_QUESTION + VALID_QUESTION_SECOND_LAW;
    public static final String QUESTION_DESC_OPPORTUNITY_COST = " " + PREFIX_QUESTION + VALID_QUESTION_OPPORTUNITY_COST;

    public static final String ANSWER_DESC_SECOND_LAW = " " + PREFIX_ANSWER + VALID_ANSWER_SECOND_LAW;
    public static final String ANSWER_DESC_OPPORTUNITY_COST = " " + PREFIX_ANSWER + VALID_ANSWER_OPPORTUNITY_COST;

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
