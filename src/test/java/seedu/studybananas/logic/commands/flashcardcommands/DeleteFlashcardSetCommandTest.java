package seedu.studybananas.logic.commands.flashcardcommands;

import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.assertCommandFailure;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.assertCommandSuccess;
import static seedu.studybananas.testutil.TypicalFlashcardSets.getTypicalFlashcardBank;
import static seedu.studybananas.testutil.TypicalIndexes.INDEX_FIRST;

import org.junit.jupiter.api.Test;

import seedu.studybananas.commons.core.Messages;
import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.model.FlashcardModel;
import seedu.studybananas.model.FlashcardModelManager;
import seedu.studybananas.model.flashcard.FlashcardSet;

public class DeleteFlashcardSetCommandTest {

    private FlashcardModel model = new FlashcardModelManager(getTypicalFlashcardBank());

    @Test
    public void execute_validIndexList_success() {
        FlashcardSet flsetToDelete = model.getFilteredFlashcardSetList().get(INDEX_FIRST.getZeroBased());
        DeleteFlashcardSetCommand deleteCommand = new DeleteFlashcardSetCommand(INDEX_FIRST);

        String expectedMessage = String.format(DeleteFlashcardSetCommand.MESSAGE_SUCCESS, flsetToDelete);

        FlashcardModelManager expectedModel = new FlashcardModelManager(model.getFlashcardBank());
        expectedModel.deleteFlashcardSet(flsetToDelete);

        assertCommandSuccess(deleteCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFlashcardBank().getFlashcardSetList().size() + 1);
        DeleteFlashcardSetCommand deleteCommand = new DeleteFlashcardSetCommand(outOfBoundIndex);

        assertCommandFailure(deleteCommand, model, Messages.MESSAGE_INVALID_FLASHCARDSET_DISPLAYED_INDEX);
    }
}
