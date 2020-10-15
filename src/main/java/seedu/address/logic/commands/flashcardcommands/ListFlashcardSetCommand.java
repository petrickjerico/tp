package seedu.address.logic.commands.flashcardcommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_FLASHCARDSETS;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.FlashcardModel;

public class ListFlashcardSetCommand extends Command<FlashcardModel> {
    public static final String COMMAND_WORD = "list flset";

    public static final String MESSAGE_SUCCESS = "Listed all flashcard sets";


    @Override
    public CommandResult execute(FlashcardModel model) {
        requireNonNull(model);
        model.updateFilteredFlashcardSetList(PREDICATE_SHOW_ALL_FLASHCARDSETS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
