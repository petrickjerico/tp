package seedu.address.model;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.index.Index;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.flashcard.FlashcardSet;
import seedu.address.model.systemlevelmodel.ReadOnlyFlashcardBank;

public interface FlashcardModel {

    /** {@code Predicate} that always evaluate to true */
    Predicate<FlashcardSet> PREDICATE_SHOW_ALL_FLASHCARDSETS = unused -> true;

    /** {@code Predicate} that always evaluate to true */
    Predicate<FlashcardSet> PREDICATE_SHOW_ALL_FLASHCARDS = unused -> true;

    //=========== Flashcard ==================================================================================

    /**
     * Retrieves the flashcard from a given {@code FlashcardSet}
     * at a given {@code Index}.
     *
     * @param flashcardSet the {@code FlashcardSet} to obtain from
     * @param flashcardIndex the reference {@code Index}
     * @return the {@code Flashcard} in the given {@code FlashcardSet} at that {@code Index}
     */
    Flashcard getFlashcard(FlashcardSet flashcardSet, Index flashcardIndex);

    /**
     * Replaces the target {@code Flashcard} in a given {@code FlashcardSet}
     * with an edited {@code Flashcard}.
     *
     * @param flashcardSet the {@code FlashcardSet} to replace from
     * @param target the replaced {@code Flashcard}
     * @param editedFlashcard the replacing {@code Flashcard}
     */
    void setFlashcard(FlashcardSet flashcardSet, Flashcard target, Flashcard editedFlashcard);

    /**
     * Checks whether a given {@code FlashcardSet} contains
     * a given {@code Flashcard}.
     *
     * @param flashcardSet the {@code FlashcardSet} to check from
     * @param flashcard the {@code Flashcard} to find
     * @return {@code true} if the set contains the card
     */
    boolean hasFlashcard(FlashcardSet flashcardSet, Flashcard flashcard);

    /**
     * Adds a given {@code Flashcard} to a given {@code FlashcardSet}.
     *
     * @param flashcardSet
     * @param flashcard the new {@code Flashcard}
     */
    void addFlashcard(FlashcardSet flashcardSet, Flashcard flashcard);

    /**
     * Removes a {@code Flashcard} at a given {@code Index}
     * from a given {@code FlashcardBank}.
     *
     * @param flashcardSet {@code FlashcardSet}
     * @param flashcardIndex the reference {@code Index} to delete
     */
    void deleteFlashcard(FlashcardSet flashcardSet, Index flashcardIndex);

    //=========== Flashcard Set ==================================================================================

    /**
     * Retrieves the {@code FlashcardSet} with the given {@code Index}.
     * Used for {@code Quiz}.
     *
     * @param index the reference {@code Index}
     * @return the {@code FlashcardSet} in the high-level {@code FlashcardBank} with that {@code Index}
     */
    FlashcardSet getFlashcardSet(Index index);

    /**
     * Replaces the target {@code FlashcardSet} in the {@code FlashcardBank}
     * with an edited {@code FlashcardSet}.
     * {@code target} must exist in the {@code FlashcardBank}.
     * The task identity of the edited {@code FlashcardSet} must not
     * be the same as any other existing {@code FlashcardSet} in
     * the {@code FlashcardBank}.
     *
     * @param target the replaced {@code FlashcardSet}
     * @param editedFlashcardSet the replacing {@code FlashcardSet}
     */
    void setFlashcardSet(FlashcardSet target, FlashcardSet editedFlashcardSet);

    /**
     * Checks whether the {@code FlashcardBank}
     * contains a given {@code FlashcardSet}
     *
     * @param flashcardSet the {@code FlashcardSet} to find
     * @return {@code true} if the bank contains the set
     */
    boolean hasFlashcardSet(FlashcardSet flashcardSet);

    /**
     * Adds a given empty or filled {@code FlashcardSet}
     * to the {@code FlashcardBank}.
     *
     * @param flashcardSet the new {@code FlashcardSet}
     */
    void addFlashcardSet(FlashcardSet flashcardSet);

    /**
     * Removes a {@code FlashcardSet} and its contents
     * from the {@code FlashcardBank}.
     *
     * @param target the {@code FlashcardSet} to delete
     */
    void deleteFlashcardSet(FlashcardSet target);

    //=========== Flashcard Bank ==================================================================================

    /**
     * Replaces the target {@code FlashcardBank} data
     * with a newly given one.
     *
     * @param flashcardBank the replacement {@code FlashcardBank}
     */
    void setFlashcardBank(ReadOnlyFlashcardBank flashcardBank);

    /** Returns the {@code FlashcardBank} */
    ReadOnlyFlashcardBank getFlashcardBank();

    //=========== Filtered Flashcard Set Accessors =========================================================

    /** Returns an unmodifiable view of the filtered flashcard set list */
    ObservableList<FlashcardSet> getFilteredFlashcardSetList();

    /**
     * Updates the filter of the filtered flashcard set list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredFlashcardSetList(Predicate<FlashcardSet> predicate);
}
