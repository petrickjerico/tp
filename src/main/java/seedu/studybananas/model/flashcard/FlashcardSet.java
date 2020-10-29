package seedu.studybananas.model.flashcard;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.model.flashcard.exceptions.DuplicateFlashcardException;
import seedu.studybananas.model.flashcard.exceptions.FlashcardNotFoundException;

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

    public FlashcardSetName getName() {
        return flashcardSetName;
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

        if (setIndex == -1) {
            throw new FlashcardNotFoundException();
        }

        if (!target.equals(editedFlashcard) && hasFlashcard(editedFlashcard)) {
            throw new DuplicateFlashcardException();
        }

        flashcards.set(setIndex, editedFlashcard);
    }

    /**
     * Checks if the flashcard set contains the specified flashcard.
     * @param flashcard as specified
     * @return boolean true or false
     */
    public boolean hasFlashcard(Flashcard flashcard) {
        requireNonNull(flashcard);
        return flashcards.contains(flashcard);
    }

    /**
     * Adds a flashcard to the flashcard set.
     * @param flashcard provided
     */
    public void addFlashcard(Flashcard flashcard) {
        requireNonNull(flashcard);
        if (hasFlashcard(flashcard)) {
            throw new DuplicateFlashcardException();
        }
        flashcards.add(flashcard);
    }

    /**
     * Deletes a flashcard at the specified flashcard index.
     * @param flashcardIndex provided
     */
    public void deleteFlashcard(Index flashcardIndex) {
        try {
            flashcards.remove(flashcardIndex.getZeroBased());
        } catch (IndexOutOfBoundsException e) {
            throw new FlashcardNotFoundException();
        }
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
