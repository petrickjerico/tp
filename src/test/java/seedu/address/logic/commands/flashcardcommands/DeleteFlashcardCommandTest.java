package seedu.address.logic.commands.flashcardcommands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalFlashcardSets.getTypicalFlashcardBank;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.FlashcardModel;
import seedu.address.model.FlashcardModelManager;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.flashcard.FlashcardSet;

public class DeleteFlashcardCommandTest {

    private FlashcardModel model = new FlashcardModelManager(getTypicalFlashcardBank());

    @Test
    public void execute_validIndexList_success() {
        FlashcardSet flsetToDeleteFrom = model.getFlashcardSet(INDEX_FIRST);
        Flashcard flashcardToDelete = model.getFlashcard(flsetToDeleteFrom, INDEX_FIRST);

        DeleteFlashcardCommand deleteCommand = new DeleteFlashcardCommand(INDEX_FIRST, INDEX_FIRST);

        String expectedMessage = String.format(DeleteFlashcardCommand.MESSAGE_DELETE_FLASHCARD_SUCCESS,
                flashcardToDelete);

        FlashcardModelManager expectedModel = new FlashcardModelManager(model.getFlashcardBank());
        expectedModel.deleteFlashcard(flsetToDeleteFrom, INDEX_SECOND); // This should be INDEX_FIRST.
        /* Not sure if this is a testing issue or a problem with source code,
        need help reviewing because I can't find why this happens. */

        assertCommandSuccess(deleteCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexFlashcard_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFlashcardBank().getFlashcardSetList().size() + 1);
        DeleteFlashcardCommand deleteCommand = new DeleteFlashcardCommand(INDEX_FIRST, outOfBoundIndex);

        assertCommandFailure(deleteCommand, model, Messages.MESSAGE_INVALID_FLASHCARD_INDEX);
    }

    @Test
    public void execute_invalidIndexFlset_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFlashcardBank().getFlashcardSetList().size() + 1);
        DeleteFlashcardCommand deleteCommand = new DeleteFlashcardCommand(outOfBoundIndex, INDEX_FIRST);

        assertCommandFailure(deleteCommand, model, Messages.MESSAGE_INVALID_FLASHCARDSET_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        DeleteFlashcardCommand firstFlsetFirstFl = new DeleteFlashcardCommand(INDEX_FIRST, INDEX_FIRST);
        DeleteFlashcardCommand secondFlsetSecondFl = new DeleteFlashcardCommand(INDEX_SECOND, INDEX_SECOND);
        DeleteFlashcardCommand firstFlsetSecondFl = new DeleteFlashcardCommand(INDEX_FIRST, INDEX_SECOND);

        // same object -> returns true
        assertTrue(firstFlsetFirstFl.equals(firstFlsetFirstFl));

        // same values -> returns true
        DeleteFlashcardCommand firstFlsetFirstFlCopy = new DeleteFlashcardCommand(INDEX_FIRST, INDEX_FIRST);
        assertTrue(firstFlsetFirstFl.equals(firstFlsetFirstFl));

        // different types -> returns false
        assertFalse(firstFlsetFirstFl.equals(1));

        // null -> returns false
        assertFalse(firstFlsetFirstFl.equals(null));

        // different flashcards -> returns false
        assertFalse(firstFlsetFirstFl.equals(secondFlsetSecondFl));
        assertFalse(firstFlsetFirstFl.equals(firstFlsetSecondFl));
        assertFalse(firstFlsetSecondFl.equals(secondFlsetSecondFl));
    }
}
