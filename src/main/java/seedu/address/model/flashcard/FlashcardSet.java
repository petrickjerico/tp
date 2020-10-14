package seedu.address.model.flashcard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import seedu.address.commons.core.index.Index;

/**
 * Represents a FlashcardSet that contains flashcards for quiz.
 */
public class FlashcardSet {

    private final List<Flashcard> flashcards = new ArrayList<>();
    private final FlashcardSetName flashcardSetName;

    /**
     * Creates an empty FlashcardSet with valid Name and empty.
     */
    public FlashcardSet(FlashcardSetName flashcardSetName) {
        this.flashcardSetName = flashcardSetName;
    }

    /**
     * Creates an empty FlashcardSet with valid Name and empty.
     */
    public FlashcardSet(FlashcardSetName flashcardSetName, List<Flashcard> flashcards) {
        this.flashcardSetName = flashcardSetName;
        this.flashcards.addAll(flashcards);
    }

    public FlashcardSetName getFlashcardSetName() {
        return flashcardSetName;
    }

    public List<Flashcard> getFlashcards() {
        return flashcards;
    }

    public int getSize() {
        return flashcards.size();
    }

    public Flashcard getFlashcard(int index) {
        return flashcards.get(index);
    }

    public void setFlashcard(Flashcard target, Flashcard editedFlashcard) {
        int setIndex = flashcards.indexOf(target);
        flashcards.set(setIndex, editedFlashcard);
    }

    public boolean hasFlashcard(Flashcard flashcard) {
        return flashcards.contains(flashcard);
    }

    public void addFlashcard(Flashcard flashcard) {
        flashcards.add(flashcard);
    }

    public void deleteFlashcard(Index flashcardIndex) {
        flashcards.remove(flashcardIndex.getZeroBased());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof FlashcardSet)) {
            return false;
        }

        FlashcardSet otherFlashcardSet = (FlashcardSet) other;
        return otherFlashcardSet.getFlashcardSetName().equals(getFlashcardSetName());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(flashcardSetName, flashcards);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getFlashcardSetName());
        getFlashcards().forEach(builder::append);
        return builder.toString();
    }

}
