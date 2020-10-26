package seedu.studybananas.model.flashcard.exceptions;

public class FlashcardNotFoundException extends RuntimeException {
    public FlashcardNotFoundException() {
        super("Flashcard not found.");
    }
}
