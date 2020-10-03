package seedu.address.model.flashcard;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a FlashcardSet that contains flashcards for quiz.
 */
public class FlashcardSet {

    private final List<Flashcard> flashcards = new ArrayList<>();
    private final Name name;

    /**
     * Creates a FlashcardSet with valid Name.
     */
    public FlashcardSet(Name name, List<Flashcard> flashcards) {
        this.name = name;
        this.flashcards.addAll(flashcards);
    }

    public Name getName() {
        return name;
    }

    public List<Flashcard> getFlashcards() {
        return flashcards;
    }

}
