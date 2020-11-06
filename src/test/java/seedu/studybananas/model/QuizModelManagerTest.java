package seedu.studybananas.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import seedu.studybananas.model.flashcard.FlashcardSetName;
import seedu.studybananas.model.systemlevelmodel.QuizRecords;

public class QuizModelManagerTest {

    private static final QuizModel quizModel = new QuizModelManager(new QuizRecords());

    @Test
    public void equals() {
        // same object -> returns true
        assertEquals(quizModel, quizModel);

        // different instances -> return false
        assertNotEquals(quizModel, new FlashcardSetName("Different class"));
    }
}
