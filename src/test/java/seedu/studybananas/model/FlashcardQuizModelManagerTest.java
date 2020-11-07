package seedu.studybananas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.studybananas.testutil.TypicalFlashcardSets.ECONOMICS;
import static seedu.studybananas.testutil.TypicalFlashcardSets.PHYSICS;
import static seedu.studybananas.testutil.TypicalFlashcardSets.getTypicalFlashcardBank;
import static seedu.studybananas.testutil.TypicalQuizzes.QUIZ_ECONOMICS;
import static seedu.studybananas.testutil.TypicalQuizzes.QUIZ_PHYSICS;
import static seedu.studybananas.testutil.TypicalQuizzes.getTypicalQuizRecords;

import org.junit.jupiter.api.Test;

import seedu.studybananas.model.flashcard.FlashcardSetName;

public class FlashcardQuizModelManagerTest {

    private final FlashcardQuizModel flashcardQuizModel = new FlashcardQuizModelManager(getTypicalFlashcardBank(),
            getTypicalQuizRecords());

    @Test
    public void getQuizRecordsToView_success() {
        flashcardQuizModel.setQuizRecordsToView(PHYSICS.getFlashcardSetName());
        assertEquals(QUIZ_PHYSICS, flashcardQuizModel.getQuizRecordsToView());
    }

    @Test
    public void equals() {
        // same object -> returns true
        assertEquals(flashcardQuizModel, flashcardQuizModel);

        // different instances -> return false
        assertNotEquals(flashcardQuizModel, new FlashcardSetName("Different class"));
    }

    @Test
    public void deleteFlashcardSet_deletesQuizRecords() {

        assertEquals(QUIZ_ECONOMICS.toString(), flashcardQuizModel.getQuizRecords(ECONOMICS.getFlashcardSetName()));
        flashcardQuizModel.deleteFlashcardSet(ECONOMICS);
        assertThrows(NullPointerException.class, () -> // check that the quiz is removed
                flashcardQuizModel.getQuizRecords(ECONOMICS.getFlashcardSetName()));
    }
}
