package seedu.address.logic.commands.flashcardcommands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.FlashcardModel;
import seedu.address.model.flashcard.FlashcardSet;

/**
 * Regulates the behaviour of a {@code Command} that deletes a {@code FlashcardSet}
 */
public class DeleteFlashcardSetCommand extends Command<FlashcardModel> {

    public static final String COMMAND_WORD = "delete flset";
    public static final String MESSAGE_SUCCESS = "Flashcard set deleted: %1$s";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes a flashcard set."
            + "Parameters: "
            + "<flashcardsetindex> "
            + "Example: " + COMMAND_WORD + " 1";

    private final Index flashcardSetIndex;

    /**
     * Creates a {@code Command} to delete a {@code FlashcardSet}
     * with the specified {@code Index}
     */
    public DeleteFlashcardSetCommand(Index targetIndex) {
        flashcardSetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(FlashcardModel model) throws CommandException {
        requireNonNull(model);
        List<FlashcardSet> flashcardSets = model.getFlashcardSetList();

        if (flashcardSetIndex.getZeroBased() >= flashcardSets.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_FLASHCARDSET_DISPLAYED_INDEX);
        }

        FlashcardSet flashcardSetToDelete = flashcardSets.get(flashcardSetIndex.getZeroBased());
        model.deleteFlashcardSet(flashcardSetToDelete);
        return new CommandResult(String.format(MESSAGE_SUCCESS, flashcardSetToDelete));
    }
}
