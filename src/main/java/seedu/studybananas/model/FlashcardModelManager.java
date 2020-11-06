package seedu.studybananas.model;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.model.flashcard.Flashcard;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.flashcard.FlashcardSetName;
import seedu.studybananas.model.systemlevelmodel.FlashcardBank;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyFlashcardBank;

public class FlashcardModelManager implements FlashcardModel {
    private final FlashcardBank flashcardBank;
    private final FilteredList<FlashcardSet> filteredFlashcardSets;
    private final ObservableList<Flashcard> flashcardSetToDisplay = FXCollections.observableArrayList();

    /**
     * Creates FlashcardModelManager from {@code flashcardBank}
     *
     * @param flashcardBank
     */
    public FlashcardModelManager(ReadOnlyFlashcardBank flashcardBank) {
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
    public FlashcardSet getFlashcardSet(FlashcardSetName flsetName) {
        for (FlashcardSet flset : filteredFlashcardSets) {
            if (flset.getName().equals(flsetName)) {
                return flset;
            }
        }
        return null;
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
        flashcardSetToDisplay.setAll(flashcardSet.getFlashcards());
    }

    @Override
    public void deleteFlashcardSet(FlashcardSet target) {
        flashcardBank.removeFlashcardSet(target);
        if (flashcardSetToDisplay.equals(FXCollections.observableArrayList(target.getFlashcards()))) {
            flashcardSetToDisplay.clear();
        }
    }

    //=========== Filtered Flashcard Set Accessors =============================================================

    @Override
    public ObservableList<FlashcardSet> getFilteredFlashcardSetList() {
        return filteredFlashcardSets;
    }

    @Override
    public void updateFilteredFlashcardSetList(Predicate<FlashcardSet> predicate) {
        requireNonNull(predicate);
        filteredFlashcardSets.setPredicate(predicate);
    }

    @Override
    public ObservableList<Flashcard> getFlashcardSetToView() {
        return flashcardSetToDisplay;
    }

    @Override
    public void setFlashcardSetToView(Index index) {
        flashcardSetToDisplay.setAll(getFlashcardSet(index).getFlashcards());
    }

    @Override
    public void setFlashcardSetToView(FlashcardSet flashcardSet) {
        flashcardSetToDisplay.setAll(flashcardSet.getFlashcards());
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
