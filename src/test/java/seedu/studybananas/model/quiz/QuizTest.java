package seedu.studybananas.model.quiz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static seedu.studybananas.testutil.TypicalFlashcardSets.ECONOMICS;
import static seedu.studybananas.testutil.TypicalFlashcardSets.PHYSICS;
import static seedu.studybananas.testutil.TypicalQuizzes.QUIZ_ECONOMICS;
import static seedu.studybananas.testutil.TypicalQuizzes.QUIZ_PHYSICS;

import org.junit.jupiter.api.Test;

import seedu.studybananas.testutil.QuizBuilder;

public class QuizTest {

    @Test
    public void equals() {
        // same object -> returns true
        assertEquals(QUIZ_PHYSICS, QUIZ_PHYSICS);

        // null -> returns false
        assertNotEquals(QUIZ_PHYSICS, null);

        // different flashcard set -> returns false
        Quiz editedQuizPhysics = new QuizBuilder()
                .withFlashcardSet(ECONOMICS)
                .build();
        assertNotEquals(editedQuizPhysics, QUIZ_PHYSICS);

        // same values -> returns true
        Quiz quizPhysicsCopy = new QuizBuilder()
                .withFlashcardSet(PHYSICS)
                .build();
        assertEquals(quizPhysicsCopy, QUIZ_PHYSICS);

        // different quiz -> returns false
        assertNotEquals(QUIZ_PHYSICS, QUIZ_ECONOMICS);
    }
}
