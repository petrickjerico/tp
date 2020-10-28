package seedu.studybananas.logic.commands.flashcardcommands;

import static java.util.Objects.requireNonNull;
import static seedu.studybananas.model.Model.PREDICATE_SHOW_ALL_FLASHCARDSETS;

import javafx.collections.ObservableList;
import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.FlashcardCommandResult;
import seedu.studybananas.model.FlashcardModel;
import seedu.studybananas.model.flashcard.FlashcardSet;

/**
 * Regulates the behaviour of a {@code Command} that lists down {@code FlashcardSet}s
 */
public class ListFlashcardSetCommand extends Command<FlashcardModel> {

    public static final String COMMAND_WORD = "list flset";
    public static final String MESSAGE_SUCCESS = "Listed all flashcard sets";

    @Override
    public CommandResult execute(FlashcardModel model) {
        requireNonNull(model);
        model.updateFilteredFlashcardSetList(PREDICATE_SHOW_ALL_FLASHCARDSETS);

        ObservableList<FlashcardSet> flashcardSets = model.getFilteredFlashcardSetList();

        StringBuilder details = new StringBuilder();
        details.append("\nThere are ");
        details.append(flashcardSets.size());
        details.append(" sets");
        flashcardSets.forEach(flashcardSet -> details.append("\n" + flashcardSet.toString()));

        return new FlashcardCommandResult(MESSAGE_SUCCESS + details.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        return obj instanceof ListFlashcardSetCommand;
    }
}
