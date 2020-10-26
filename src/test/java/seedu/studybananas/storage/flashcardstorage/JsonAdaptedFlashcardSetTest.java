package seedu.studybananas.storage.flashcardstorage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.studybananas.storage.flashcardstorage.JsonAdaptedFlashcardSet.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.studybananas.testutil.Assert.assertThrows;
import static seedu.studybananas.testutil.TypicalFlashcardSets.PHYSICS;
import static seedu.studybananas.testutil.TypicalFlashcards.DECAY_CONSTANT;
import static seedu.studybananas.testutil.TypicalFlashcards.HOOKES_LAW;
import static seedu.studybananas.testutil.TypicalFlashcards.NEWTONS_SECOND_LAW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.studybananas.commons.exceptions.IllegalValueException;
import seedu.studybananas.model.flashcard.FlashcardSetName;

public class JsonAdaptedFlashcardSetTest {
    private static final String VALID_NAME = PHYSICS.getFlashcardSetName().toString();
    private static final List<JsonAdaptedFlashcard> VALID_FLASHCARD_LIST =
            new ArrayList<>(Arrays.asList(new JsonAdaptedFlashcard(NEWTONS_SECOND_LAW),
                    new JsonAdaptedFlashcard(HOOKES_LAW),
                    new JsonAdaptedFlashcard(DECAY_CONSTANT)));

    @Test
    public void toModelType_validFlashcardSetDetails_returnsFlashcardSet() throws Exception {
        JsonAdaptedFlashcardSet flashcardSet = new JsonAdaptedFlashcardSet(PHYSICS);
        assertEquals(PHYSICS, flashcardSet.toModelType());
    }

    @Test
    public void toModelType_nullFlsetName_throwsIllegalValueException() {
        JsonAdaptedFlashcardSet flashcardSet = new JsonAdaptedFlashcardSet(null, VALID_FLASHCARD_LIST);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, FlashcardSetName.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, flashcardSet::toModelType);
    }
}
