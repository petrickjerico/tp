package seedu.address.model;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.index.Index;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.flashcard.FlashcardSet;
import seedu.address.model.systemlevelmodel.ReadOnlyFlashcardBank;

public interface FlashcardModel {
    // FLASHCARD

    /** {@code Predicate} that always evaluate to true */
    Predicate<FlashcardSet> PREDICATE_SHOW_ALL_FLASHCARDSETS = unused -> true;

    /** {@code Predicate} that always evaluate to true */
    Predicate<FlashcardSet> PREDICATE_SHOW_ALL_FLASHCARDS = unused -> true;

    void setFlashcardBank(ReadOnlyFlashcardBank flashcardBank);

    ReadOnlyFlashcardBank getFlashcardBank();



    FlashcardSet getFlashcardSet(Index index); // added because quiz needs, feel free to change implementation

    void setFlashcardSet(FlashcardSet target, FlashcardSet editedFlashcardSet);

    boolean hasFlashcardSet(FlashcardSet flashcardSet);

    void addFlashcardSet(FlashcardSet flashcardSet);

    void deleteFlashcardSet(FlashcardSet target);



    Flashcard getFlashcard(FlashcardSet flashcardSet, Index flashcardIndex);

    void setFlashcard(FlashcardSet flashcardSet, Flashcard target, Flashcard editedFlashcard);

    boolean hasFlashcard(FlashcardSet flashcardSet, Flashcard flashcard);

    void addFlashcard(FlashcardSet flashcardSet, Flashcard flashcard);

    void deleteFlashcard(FlashcardSet flashcardSet, Index flashcardIndex);



    ObservableList<FlashcardSet> getFlashcardSetList();

    void updateFilteredFlashcardSetList(Predicate<FlashcardSet> predicate);
}
