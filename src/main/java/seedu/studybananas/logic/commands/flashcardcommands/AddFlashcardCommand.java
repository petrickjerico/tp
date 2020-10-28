package seedu.studybananas.logic.commands.flashcardcommands;

import static java.util.Objects.requireNonNull;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_ANSWER;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_FLASHCARDSET;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_QUESTION;

import seedu.studybananas.commons.core.Messages;
import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.FlashcardCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.FlashcardModel;
import seedu.studybananas.model.flashcard.Flashcard;
import seedu.studybananas.model.flashcard.FlashcardSet;

/**
 * Regulates the behaviour of a {@code Command} that adds a {@code Flashcard}
 * to a {@code FlashcardSet}
 */
public class AddFlashcardCommand extends Command<FlashcardModel> {

    public static final String COMMAND_WORD = "add fl";
    public static final String MESSAGE_SUCCESS = "New flashcard added: %1$s";
    public static final String MESSAGE_DUPLICATE_FLASHCARD =
            "This flashcard already exists in the given flashcard set.";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a flashcard to a flashcard set. "
            + "Parameters: "
            + PREFIX_FLASHCARDSET + "<flashcardsetindex> "
            + PREFIX_QUESTION + "<question> "
            + PREFIX_ANSWER + "<answer> "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_FLASHCARDSET + "1 "
            + PREFIX_QUESTION + "When demand goes up, what happens to price? "
            + PREFIX_ANSWER + "Price increases ";

    private final Flashcard toAdd;
    private final Index flashcardSetIndex;

    /**
     * Creates a {@code Command} to add a {@code Flashcard}
     * in the specified {@code FlashcardSet}
     */
    public AddFlashcardCommand(Flashcard flashcard, Index targetIndex) {
        requireNonNull(flashcard);
        toAdd = flashcard;
        flashcardSetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(FlashcardModel model) throws CommandException {
        requireNonNull(model);
        try {
            FlashcardSet flashcardSet = model.getFlashcardSet(flashcardSetIndex);

            if (model.hasFlashcard(flashcardSet, toAdd)) {
                model.setFlashcardSetToView(flashcardSetIndex);
                throw new CommandException(MESSAGE_DUPLICATE_FLASHCARD);
            }

            model.addFlashcard(flashcardSet, toAdd);
            model.setFlashcardSetToView(flashcardSetIndex);
            return new FlashcardCommandResult(String.format(MESSAGE_SUCCESS, toAdd));
        } catch (IndexOutOfBoundsException e) {
            throw new CommandException(Messages.MESSAGE_INVALID_FLASHCARDSET_DISPLAYED_INDEX);
        }

    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddFlashcardCommand // instanceof handles nulls
                && toAdd.equals(((AddFlashcardCommand) other).toAdd));
    }
}
