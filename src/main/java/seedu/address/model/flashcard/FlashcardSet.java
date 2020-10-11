package seedu.address.model.flashcard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import seedu.address.model.person.Person;

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

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof FlashcardSet)) {
            return false;
        }

        FlashcardSet otherFlashcardSet = (FlashcardSet) other;
        return otherFlashcardSet.getName().equals(getName())
                && otherFlashcardSet.getFlashcards().equals(getFlashcards());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, flashcards);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName());
        getFlashcards().forEach(builder::append);
        return builder.toString();
    }
}
