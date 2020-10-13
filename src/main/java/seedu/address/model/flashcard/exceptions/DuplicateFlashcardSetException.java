package seedu.address.model.flashcard.exceptions;

/**
 * Signals that the operation will result in duplicate FlashcardSet
 * (FlashcardSet are considered duplicates if they have the same name).
 */
public class DuplicateFlashcardSetException extends RuntimeException {
    public DuplicateFlashcardSetException() {
        super("Operation would result in duplicate flashcard set");
    }
}
