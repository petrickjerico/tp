package seedu.address.testutil;

import java.util.ArrayList;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.flashcard.FlashcardSet;
import seedu.address.model.flashcard.FlashcardSetName;

public class FlashcardSetBuilder {

    public static final String DEFAULT_FLASHCARD_SET_NAME = "Physics";

    private FlashcardSetName flashcardSetName;
    private List<Flashcard> flashcards = new ArrayList<>();

    /**
     * Creates a {@code FlashcardSetBuilder} with the default details.
     */
    public FlashcardSetBuilder() {
        flashcardSetName = new FlashcardSetName(DEFAULT_FLASHCARD_SET_NAME);
    }

    /**
     * Initializes the FlashcardBuilder with the data of {@code flashcardSetToCopy}.
     */
    public FlashcardSetBuilder(FlashcardSet flashcardSetToCopy) {
        flashcardSetName = flashcardSetToCopy.getName();
        flashcards = flashcardSetToCopy.getFlashcards();
    }

    /**
     * Sets the {@code FlashcardSetName} of the {@code FlashcardSet} that we are building.
     */
    public FlashcardSetBuilder withFlashcardSetName(String flashcardSetName) {
        this.flashcardSetName = new FlashcardSetName(flashcardSetName);
        return this;
    }

    /**
     * Sets the {@code flashcards} of the {@code FlashcardSet} that we are building.
     */
    public FlashcardSetBuilder withFlashcards(List<Flashcard> flashcards) {
        this.flashcards = flashcards;
        return this;
    }

    /**
     * Adds a {@code Flashcard} to the {@code FlashcardSet} that we are building.
     * @param flashcard to be added
     */
    public FlashcardSetBuilder addFlashcard(Flashcard flashcard) {
        this.flashcards.add(flashcard);
        return this;
    }

    /**
     * Deletes a {@code Flashcard} from the {@code FlashcardSet} that we are building,
     * at the given index.
     */
    public FlashcardSetBuilder deleteFlashcard(Index flashcardIndex) {
        this.flashcards.remove(flashcardIndex.getZeroBased());
        return this;
    }

    public FlashcardSet build() {
        return new FlashcardSet(flashcardSetName, flashcards);
    }
}
