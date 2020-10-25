package seedu.studybananas.model.flashcard.exceptions;

public class DuplicateFlashcardException extends RuntimeException {
    public DuplicateFlashcardException() {
        super("Operation would result in duplicate flashcard");
    }
}
