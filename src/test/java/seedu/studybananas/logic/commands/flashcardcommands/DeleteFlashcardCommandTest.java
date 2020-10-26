package seedu.studybananas.logic.commands.flashcardcommands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.assertCommandFailure;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.assertCommandSuccess;
import static seedu.studybananas.testutil.TypicalFlashcardSets.getTypicalFlashcardBank;
import static seedu.studybananas.testutil.TypicalIndexes.INDEX_FIRST;
import static seedu.studybananas.testutil.TypicalIndexes.INDEX_SECOND;

import org.junit.jupiter.api.Test;

import seedu.studybananas.commons.core.Messages;
import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.model.FlashcardModel;
import seedu.studybananas.model.FlashcardModelManager;
import seedu.studybananas.model.flashcard.Answer;
import seedu.studybananas.model.flashcard.Flashcard;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.flashcard.FlashcardSetName;
import seedu.studybananas.model.flashcard.Question;
import seedu.studybananas.model.systemlevelmodel.FlashcardBank;

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
        /* Not sure if this is a problem with source code. Need help reviewing
        because I can't find why this happens. */
        assertCommandSuccess(deleteCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void testTheAboveTest() { // to check if this is a test code regression problem
        // method to be deleted after problem is resolved
        // create a model with no typical flashcards such that the error is not typical-flashcard related
        Question question1 = new Question("1 + 1");
        Answer answer1 = new Answer("2");
        Flashcard flashcard1 = new Flashcard(question1, answer1);
        Question question2 = new Question("2 + 2");
        Answer answer2 = new Answer("4");
        Flashcard flashcard2 = new Flashcard(question2, answer2);
        FlashcardBank flashcardBank = new FlashcardBank();
        FlashcardSet flset = new FlashcardSet(new FlashcardSetName("Basic Arithmetic"));
        flset.addFlashcard(flashcard1);
        flset.addFlashcard(flashcard2);
        flashcardBank.addFlashcardSet(flset);
        FlashcardModel flmodel = new FlashcardModelManager(flashcardBank);

        // test delete flashcard
        FlashcardSet flsetToDeleteFrom = flmodel.getFlashcardSet(INDEX_FIRST);
        Flashcard flashcardToDelete = flmodel.getFlashcard(flsetToDeleteFrom, INDEX_FIRST);

        DeleteFlashcardCommand deleteCommand = new DeleteFlashcardCommand(INDEX_FIRST, INDEX_FIRST);

        String expectedMessage = String.format(DeleteFlashcardCommand.MESSAGE_DELETE_FLASHCARD_SUCCESS,
                flashcardToDelete);

        FlashcardModelManager expectedModel = new FlashcardModelManager(flmodel.getFlashcardBank());
        expectedModel.deleteFlashcard(flsetToDeleteFrom, INDEX_SECOND); // test only passes with INDEX_SECOND
        // CONCLUSION: Doesn't seem to be a testing problem unless this method I wrote is wrong
        assertCommandSuccess(deleteCommand, flmodel, expectedMessage, expectedModel);
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
