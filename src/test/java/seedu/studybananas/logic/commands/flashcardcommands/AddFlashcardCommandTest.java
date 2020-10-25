package seedu.studybananas.logic.commands.flashcardcommands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.studybananas.testutil.Assert.assertThrows;
import static seedu.studybananas.testutil.TypicalIndexes.INDEX_FIRST;
import static seedu.studybananas.testutil.TypicalIndexes.INDEX_SECOND;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.studybananas.commons.core.Messages;
import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.logic.commands.CommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.FlashcardModel;
import seedu.studybananas.model.flashcard.Flashcard;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.systemlevelmodel.FlashcardBank;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyFlashcardBank;
import seedu.studybananas.testutil.FlashcardBuilder;
import seedu.studybananas.testutil.FlashcardSetBuilder;

public class AddFlashcardCommandTest {

    @Test
    public void constructor_nullFlashcard_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddFlashcardCommand(null, INDEX_FIRST));
    }

    @Test
    public void execute_flashcardAcceptedByModel_addSuccess() throws Exception {
        AddFlashcardCommandTest.ModelStubAcceptingFlashcardAdded modelStub =
                new AddFlashcardCommandTest.ModelStubAcceptingFlashcardAdded();
        Flashcard validFlashcard = new FlashcardBuilder().build();

        CommandResult result = new AddFlashcardCommand(validFlashcard, INDEX_FIRST).execute(modelStub);

        assertEquals(String.format(AddFlashcardCommand.MESSAGE_SUCCESS, validFlashcard), result.getFeedbackToUser());
        assertEquals(validFlashcard, modelStub.flashcardBank.getFlashcardSetList()
                .get(INDEX_FIRST.getZeroBased())
                .getFlashcard(INDEX_FIRST.getZeroBased()));
    }

    @Test
    public void execute_duplicateFlashcard_throwsCommandException() {
        Flashcard validFlashcard = new FlashcardBuilder().build();
        AddFlashcardCommand addCommand = new AddFlashcardCommand(validFlashcard, INDEX_FIRST);
        AddFlashcardCommandTest.ModelStubWithFlashcard modelStub =
                new AddFlashcardCommandTest.ModelStubWithFlashcard();

        assertThrows(CommandException.class, AddFlashcardCommand.MESSAGE_DUPLICATE_FLASHCARD, (
        ) -> addCommand.execute(modelStub));
    }

    @Test
    public void execute_invalidIndexFlset_throwsCommandException() {
        Flashcard validFlashcard = new FlashcardBuilder().build();
        AddFlashcardCommand addCommand = new AddFlashcardCommand(validFlashcard, INDEX_SECOND);
        AddFlashcardCommandTest.ModelStubWithFlashcard modelStub =
                new AddFlashcardCommandTest.ModelStubWithFlashcard();

        assertThrows(CommandException.class, Messages.MESSAGE_INVALID_FLASHCARDSET_DISPLAYED_INDEX, (
        ) -> addCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Flashcard google = new FlashcardBuilder().build();
        Flashcard blueOcean = new FlashcardBuilder().withQuestion("Why is the ocean blue")
                .withAnswer("The ocean is blue because water absorbs colors "
                        + "in the red part of the light spectrum.")
                .build();
        AddFlashcardCommand addGoogle = new AddFlashcardCommand(google, INDEX_FIRST);
        AddFlashcardCommand addBlueOcean = new AddFlashcardCommand(blueOcean, INDEX_FIRST);

        // same object -> returns true
        assertTrue(addGoogle.equals(addGoogle));

        // same values -> returns true
        AddFlashcardCommand addGoogleCommandCopy = new AddFlashcardCommand(google, INDEX_FIRST);
        assertTrue(addGoogle.equals(addGoogleCommandCopy));

        // different types -> returns false
        assertFalse(addGoogle.equals(1));

        // null -> returns false
        assertFalse(addGoogle.equals(null));

        // different flashcards -> returns false
        assertFalse(addGoogle.equals(addBlueOcean));
    }

    /**
     * A Model stub that contains a single FlashcardSet.
     */
    private class ModelStubWithFlashcard extends AddFlashcardCommandTest.FlashcardModelStub {
        private final FlashcardBank flashcardBank = new FlashcardBank();

        ModelStubWithFlashcard() {
            FlashcardSet flset = new FlashcardSetBuilder().build();
            Flashcard flashcardAlrAdded = new FlashcardBuilder().build();
            flset.addFlashcard(flashcardAlrAdded);
            flashcardBank.addFlashcardSet(flset);
        }

        @Override
        public boolean hasFlashcard(FlashcardSet flset, Flashcard flashcard) {
            requireNonNull(flashcard);
            return flset.getFlashcards().stream().anyMatch(f -> f.equals(flashcard));
        }

        @Override
        public void addFlashcard(FlashcardSet flset, Flashcard flashcard) {
            requireNonNull(flashcard);
            flset.addFlashcard(flashcard);
        }

        @Override
        public FlashcardSet getFlashcardSet(Index index) {
            return flashcardBank.getFlashcardSetList().get(index.getZeroBased());
        }
    }

    /**
     * A Model stub that always accepts the Flashcard being added.
     */
    private class ModelStubAcceptingFlashcardAdded extends AddFlashcardCommandTest.FlashcardModelStub {
        private final FlashcardBank flashcardBank = new FlashcardBank();

        ModelStubAcceptingFlashcardAdded() {
            flashcardBank.addFlashcardSet(new FlashcardSetBuilder().build());
        }

        @Override
        public boolean hasFlashcard(FlashcardSet flset, Flashcard flashcard) {
            requireNonNull(flashcard);
            return flset.getFlashcards().stream().anyMatch(f -> f.equals(flashcard));
        }

        @Override
        public void addFlashcard(FlashcardSet flset, Flashcard flashcard) {
            requireNonNull(flashcard);
            flset.addFlashcard(flashcard);
        }

        @Override
        public FlashcardSet getFlashcardSet(Index index) {
            return flashcardBank.getFlashcardSetList().get(index.getZeroBased());
        }
    }

    private static class FlashcardModelStub implements FlashcardModel {

        @Override
        public void setFlashcardBank(ReadOnlyFlashcardBank flashcardBank) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyFlashcardBank getFlashcardBank() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Flashcard getFlashcard(FlashcardSet flashcardSet, Index flashcardIndex) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setFlashcard(FlashcardSet flashcardSet, Flashcard target, Flashcard editedFlashcard) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasFlashcard(FlashcardSet flashcardSet, Flashcard flashcard) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteFlashcard(FlashcardSet flashcardSet, Index flashcardIndex) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addFlashcard(FlashcardSet flashcardSet, Flashcard flashcard) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public FlashcardSet getFlashcardSet(Index index) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setFlashcardSet(FlashcardSet target, FlashcardSet editedFlashcardSet) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasFlashcardSet(FlashcardSet flashcardSet) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addFlashcardSet(FlashcardSet flashcardSet) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteFlashcardSet(FlashcardSet target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<FlashcardSet> getFilteredFlashcardSetList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredFlashcardSetList(Predicate<FlashcardSet> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public FlashcardSet getFlashcardSetToView() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setFlashcardSetToView(FlashcardSet flashcardSet) {
            throw new AssertionError("This method should not be called.");
        }
    }
}
