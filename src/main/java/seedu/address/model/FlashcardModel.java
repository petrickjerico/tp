package seedu.address.model;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.index.Index;
import seedu.address.model.systemlevelmodel.ReadOnlyFlashcardBank;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.flashcard.FlashcardSet;

public interface FlashcardModel {
    // FLASHCARD

    void setFlashcardBank(ReadOnlyFlashcardBank flashcardBank);

    ReadOnlyFlashcardBank getFlashcardBank();

    boolean hasFlashcardSet(FlashcardSet flashcardSet);

    void deleteFlashcardSet(FlashcardSet target);

    void addFlashcardSet(FlashcardSet flashcardSet);

    void setFlashcardSet(FlashcardSet target, FlashcardSet editedFlashcardSet);

    ObservableList<FlashcardSet> getFlashcardSetList();

    void updateFilteredFlashcardSetList(Predicate<FlashcardSet> predicate);



    void addFlashcard(Flashcard flashcard, Index flashcardSetIndex);

    FlashcardSet getFlashcardSet(int index); // added because quiz needs, feel free to change implementation
}
