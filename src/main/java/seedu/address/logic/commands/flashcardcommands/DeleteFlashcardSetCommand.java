package seedu.address.logic.commands.flashcardcommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_FLASHCARDSET;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.flashcard.FlashcardSet;



public class DeleteFlashcardSetCommand extends Command {
    public static final String COMMAND_WORD = "delete flset";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes a flashcard set."
            + "Parameters: "
            + PREFIX_FLASHCARDSET + "<flashcardsetindex> "
            + "Example: " + COMMAND_WORD + ":1";

    public static final String MESSAGE_SUCCESS = "Flashcard set deleted: %1$s";

    private final Index flashcardSetIndex;

    /**
     * Creates an AddFlashcardCommand to add the specified {@code Flashcard}
     */
    public DeleteFlashcardSetCommand(Index targetIndex) {
        flashcardSetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<FlashcardSet> flashcardSets = model.getFlashcardSetList();

        if (flashcardSetIndex.getOneBased() > flashcardSets.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_FLASHCARDSET_DISPLAYED_INDEX);
        }

        FlashcardSet flashcardSetToDelete = flashcardSets.get(flashcardSetIndex.getZeroBased());
        model.deleteFlashcardSet(flashcardSetToDelete);
        return new CommandResult(String.format(MESSAGE_SUCCESS, flashcardSetToDelete));
    }
}
