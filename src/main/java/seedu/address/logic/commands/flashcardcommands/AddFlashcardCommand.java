package seedu.address.logic.commands.flashcardcommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ANSWER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_FLASHCARDSET;
import static seedu.address.logic.parser.CliSyntax.PREFIX_QUESTION;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.flashcard.Flashcard;

/**
 * Adds a flashcard to a flashcard set.
 */
public class AddFlashcardCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a flashcard to a flashcard set. "
            + "Parameters: "
            + PREFIX_FLASHCARDSET + "<flashcardsetindex> "
            + PREFIX_QUESTION + "<question> "
            + PREFIX_ANSWER + "<answer> "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_FLASHCARDSET + "1 "
            + PREFIX_QUESTION + "When demand goes up, what happens to price? "
            + PREFIX_ANSWER + "Price increases ";

    public static final String MESSAGE_SUCCESS = "New flashcard added: %1$s";

    private final Flashcard toAdd;
    private final Index flashcardSetIndex;

    /**
     * Creates an AddFlashcardCommand to add the specified {@code Flashcard}
     */
    public AddFlashcardCommand(Flashcard flashcard, Index targetIndex) {
        requireNonNull(flashcard);
        toAdd = flashcard;
        flashcardSetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        model.addFlashcard(toAdd, flashcardSetIndex);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddFlashcardCommand // instanceof handles nulls
                && toAdd.equals(((AddFlashcardCommand) other).toAdd));
    }
}
