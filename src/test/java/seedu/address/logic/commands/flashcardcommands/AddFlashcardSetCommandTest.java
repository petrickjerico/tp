package seedu.address.logic.commands.flashcardcommands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.VALID_FLSET_NAME_ECONOMICS;
import static seedu.address.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.VALID_FLSET_NAME_PHYSICS;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.FlashcardModel;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.flashcard.FlashcardSet;
import seedu.address.model.systemlevelmodel.ReadOnlyFlashcardBank;
import seedu.address.testutil.FlashcardSetBuilder;

public class AddFlashcardSetCommandTest {

    @Test
    public void constructor_nullFlashcardSet_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddFlashcardSetCommand(null));
    }

    @Test
    public void execute_flashcardSetAcceptedByModel_addSuccess() throws Exception {
        AddFlashcardSetCommandTest.ModelStubAcceptingFlsetAdded modelStub =
                new AddFlashcardSetCommandTest.ModelStubAcceptingFlsetAdded();
        FlashcardSet validFlset = new FlashcardSetBuilder().build();

        CommandResult result = new AddFlashcardSetCommand(validFlset).execute(modelStub);

        assertEquals(String.format(AddFlashcardSetCommand.MESSAGE_SUCCESS, validFlset), result.getFeedbackToUser());
        assertEquals(Arrays.asList(validFlset), modelStub.flsetsAdded);
    }

    @Test
    public void execute_duplicateFlashcardSet_throwsCommandException() {
        FlashcardSet validFlset = new FlashcardSetBuilder().build();
        AddFlashcardSetCommand addCommand = new AddFlashcardSetCommand(validFlset);
        AddFlashcardSetCommandTest.ModelStubWithFlashcardSet modelStub =
                new AddFlashcardSetCommandTest.ModelStubWithFlashcardSet(validFlset);

        assertThrows(CommandException.class, AddFlashcardSetCommand.MESSAGE_DUPLICATE_FLASHCARD_SET, (
        ) -> addCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        FlashcardSet physics = new FlashcardSetBuilder().withFlashcardSetName(VALID_FLSET_NAME_PHYSICS).build();
        FlashcardSet economics = new FlashcardSetBuilder().withFlashcardSetName(VALID_FLSET_NAME_ECONOMICS).build();
        AddFlashcardSetCommand addPhysics = new AddFlashcardSetCommand(physics);
        AddFlashcardSetCommand addEconomics = new AddFlashcardSetCommand(economics);

        // same object -> returns true
        assertTrue(addPhysics.equals(addPhysics));

        // same values -> returns true
        AddFlashcardSetCommand addPhysicsCommandCopy = new AddFlashcardSetCommand(physics);
        assertTrue(addPhysics.equals(addPhysicsCommandCopy));

        // different types -> returns false
        assertFalse(addPhysics.equals(1));

        // null -> returns false
        assertFalse(addPhysics.equals(null));

        // different flashcard sets -> returns false
        assertFalse(addEconomics.equals(addPhysics));
    }

    /**
     * A Model stub that contains a single FlashcardSet.
     */
    private class ModelStubWithFlashcardSet extends AddFlashcardSetCommandTest.FlashcardModelStub {
        private final FlashcardSet flset;

        ModelStubWithFlashcardSet(FlashcardSet flset) {
            requireNonNull(flset);
            this.flset = flset;
        }

        @Override
        public boolean hasFlashcardSet(FlashcardSet flashcardSet) {
            requireNonNull(flashcardSet);
            return this.flset.equals(flashcardSet);
        }
    }

    /**
     * A Model stub that always accepts the FlashcardSet being added.
     */
    private class ModelStubAcceptingFlsetAdded extends AddFlashcardSetCommandTest.FlashcardModelStub {
        private final List<FlashcardSet> flsetsAdded = new ArrayList<>();

        @Override
        public boolean hasFlashcardSet(FlashcardSet flashcardSet) {
            requireNonNull(flashcardSet);
            return flsetsAdded.stream().anyMatch(f -> f.equals(flashcardSet));
        }

        @Override
        public void addFlashcardSet(FlashcardSet flashcardSet) {
            requireNonNull(flashcardSet);
            flsetsAdded.add(flashcardSet);
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
        public ObservableList<FlashcardSet> getFlashcardSetList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredFlashcardSetList(Predicate<FlashcardSet> predicate) {
            throw new AssertionError("This method should not be called.");
        }
    }
}
