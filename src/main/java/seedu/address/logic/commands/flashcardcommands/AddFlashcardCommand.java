package seedu.address.logic.commands.flashcardcommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ANSWER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_FLASHCARDSET;
import static seedu.address.logic.parser.CliSyntax.PREFIX_QUESTION;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.FlashcardModel;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.flashcard.FlashcardSet;

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
        FlashcardSet flashcardSet = model.getFlashcardSet(flashcardSetIndex);

        if (model.hasFlashcard(flashcardSet, toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_FLASHCARD);
        }

        model.addFlashcard(flashcardSet, toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddFlashcardCommand // instanceof handles nulls
                && toAdd.equals(((AddFlashcardCommand) other).toAdd));
    }
}
