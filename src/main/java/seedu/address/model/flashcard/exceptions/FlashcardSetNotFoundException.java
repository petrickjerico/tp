package seedu.address.model.flashcard.exceptions;

/**
 * Signals that the operation is unable to find the specified flashcard set.
 */
public class FlashcardSetNotFoundException extends RuntimeException {
    public FlashcardSetNotFoundException() {
        super("Flashcard set not found.");
    }
}
