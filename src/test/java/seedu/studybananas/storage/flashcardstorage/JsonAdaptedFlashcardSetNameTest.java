package seedu.studybananas.storage.flashcardstorage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.studybananas.testutil.Assert.assertThrows;
import static seedu.studybananas.testutil.TypicalFlashcardSets.PHYSICS;

import org.junit.jupiter.api.Test;

import seedu.studybananas.commons.exceptions.IllegalValueException;
import seedu.studybananas.model.flashcard.FlashcardSetName;

public class JsonAdaptedFlashcardSetNameTest {
    private static final String VALID_NAME = "Physics";
    private static final String INVALID_NAME = "!!..,,";

    @Test
    public void toModelType_validFlashcardSetName_returnsFlashcardSetName() throws Exception {
        JsonAdaptedFlashcardSetName flashcardSetName = new JsonAdaptedFlashcardSetName(VALID_NAME);
        assertEquals(PHYSICS.getFlashcardSetName(), flashcardSetName.toModelType());
    }

    @Test
    public void toModelType_nullName_throwsNullPointerException() {
        JsonAdaptedFlashcardSetName flashcardSetName = new JsonAdaptedFlashcardSetName((String) null);
        assertThrows(NullPointerException.class, flashcardSetName::toModelType);
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedFlashcardSetName flashcardSetName = new JsonAdaptedFlashcardSetName(INVALID_NAME);
        assertThrows(IllegalValueException.class, FlashcardSetName.MESSAGE_CONSTRAINTS, flashcardSetName::toModelType);
    }

}
