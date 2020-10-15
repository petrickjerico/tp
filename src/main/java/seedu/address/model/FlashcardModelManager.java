package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.index.Index;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.flashcard.FlashcardSet;
import seedu.address.model.systemlevelmodel.FlashcardBank;
import seedu.address.model.systemlevelmodel.ReadOnlyFlashcardBank;

public class FlashcardModelManager implements FlashcardModel {
    private final FlashcardBank flashcardBank;
    private final FilteredList<FlashcardSet> filteredFlashcardSets;

    /**
     * Creates FlashcardModelManager from {@code flashcardBank}
     *
     * @param flashcardBank
     */
    FlashcardModelManager(ReadOnlyFlashcardBank flashcardBank) {
        this.flashcardBank = new FlashcardBank(flashcardBank);
        filteredFlashcardSets = new FilteredList<>(this.flashcardBank.getFlashcardSetList());
    }

    //=========== Flashcard =============================================================

    @Override
    public Flashcard getFlashcard(FlashcardSet flashcardSet, Index flashcardIndex) {
        return flashcardSet.getFlashcard(flashcardIndex.getZeroBased());
    }

    @Override
    public void setFlashcard(FlashcardSet flashcardSet, Flashcard target, Flashcard editedFlashcard) {
        flashcardSet.setFlashcard(target, editedFlashcard);
    }

    @Override
    public boolean hasFlashcard(FlashcardSet flashcardSet, Flashcard flashcard) {
        return flashcardSet.hasFlashcard(flashcard);
    }

    @Override
    public void addFlashcard(FlashcardSet flashcardSet, Flashcard flashcard) {
        flashcardSet.addFlashcard(flashcard);
    }

    @Override
    public void deleteFlashcard(FlashcardSet flashcardSet, Index flashcardIndex) {
        flashcardSet.deleteFlashcard(flashcardIndex);
    }

    //=========== Flashcard Set =============================================================

    @Override
    public FlashcardSet getFlashcardSet(Index index) {
        return filteredFlashcardSets.get(index.getZeroBased());
    }

    @Override
    public void setFlashcardSet(FlashcardSet target, FlashcardSet editedFlashcardSet) {
        flashcardBank.setFlashcardSet(target, editedFlashcardSet);
    }

    @Override
    public boolean hasFlashcardSet(FlashcardSet flashcardSet) {
        requireNonNull(flashcardSet);
        return flashcardBank.hasFlashcardSet(flashcardSet);
    }

    @Override
    public void addFlashcardSet(FlashcardSet flashcardSet) {
        flashcardBank.addFlashcardSet(flashcardSet);
    }

    @Override
    public void deleteFlashcardSet(FlashcardSet target) {
        flashcardBank.removeFlashcardSet(target);
    }

    //=========== Filtered Flashcard Set Accessors =============================================================

    @Override
    public ObservableList<FlashcardSet> getFlashcardSetList() {
        return filteredFlashcardSets;
    }

    @Override
    public void updateFilteredFlashcardSetList(Predicate<FlashcardSet> predicate) {
        requireNonNull(predicate);
        filteredFlashcardSets.setPredicate(predicate);
    }

    //=========== Flashcard Bank =============================================================

    @Override
    public void setFlashcardBank(ReadOnlyFlashcardBank flashcardBank) {
        this.flashcardBank.resetData(flashcardBank);
    }

    @Override
    public ReadOnlyFlashcardBank getFlashcardBank() {
        return flashcardBank;
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof FlashcardModelManager)) {
            return false;
        }

        // state check
        FlashcardModelManager other = (FlashcardModelManager) obj;
        return filteredFlashcardSets.equals(other.filteredFlashcardSets);
    }

}
