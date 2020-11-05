package seedu.studybananas.logic.commands.flashcardcommands;

import static java.util.Objects.requireNonNull;
import static seedu.studybananas.model.Model.PREDICATE_SHOW_ALL_FLASHCARDS;

import java.util.List;

import seedu.studybananas.commons.core.Messages;
import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.FlashcardCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.FlashcardModel;
import seedu.studybananas.model.flashcard.FlashcardSet;



/**
 * Regulates the behaviour of a {@code Command} that lists down
 * {@code Flashcard}s of a {@code FlashcardSet}
 */
public class ListFlashcardCommand extends Command<FlashcardModel> {

    public static final String COMMAND_WORD = "list fl";
    public static final String MESSAGE_SUCCESS = "Listed all flashcard in the selected flashcard set";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Lists flashcards in a flashcard set.\n"
            + "Parameters: "
            + "<flashcardsetindex>\n"
            + "Example: " + COMMAND_WORD + " 1";

    private final Index flashcardSetIndex;

    /**
     * Creates a {@code Command} to list all {@code Flashcard}s
     * of a {@code FlashcardSet} with a specified {@code Index}
     */
    public ListFlashcardCommand(Index flashcardSetIndex) {
        this.flashcardSetIndex = flashcardSetIndex;
    }

    @Override
    public CommandResult execute(FlashcardModel model) throws CommandException {
        requireNonNull(model);
        model.updateFilteredFlashcardSetList(PREDICATE_SHOW_ALL_FLASHCARDS);

        List<FlashcardSet> flashcardSets = model.getFilteredFlashcardSetList();

        if (flashcardSetIndex.getZeroBased() >= flashcardSets.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_FLASHCARDSET_DISPLAYED_INDEX);
        }

        model.setFlashcardSetToView(flashcardSetIndex);
        FlashcardSet flashcardSet = model.getFlashcardSet(flashcardSetIndex);

        return new FlashcardCommandResult(String.format(
                MESSAGE_SUCCESS + "\n" + "There are %d flashcards in the set %s.",
                flashcardSet.getSize(), flashcardSet.getName().name));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ListFlashcardCommand // instanceof handles nulls
                && flashcardSetIndex.equals(((ListFlashcardCommand) other).flashcardSetIndex)); // state check
    }
}
