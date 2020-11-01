package seedu.studybananas.storage.quizstorage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.studybananas.storage.quizstorage.JsonAdaptedQuiz.MESSAGE_MISSING_FIELD;
import static seedu.studybananas.testutil.Assert.assertThrows;
import static seedu.studybananas.testutil.TypicalFlashcardSets.PHYSICS;
import static seedu.studybananas.testutil.TypicalQuizzes.QUIZ_PHYSICS;

import org.junit.jupiter.api.Test;

import seedu.studybananas.commons.exceptions.IllegalValueException;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.storage.flashcardstorage.JsonAdaptedFlashcardSet;
import seedu.studybananas.testutil.QuizBuilder;

public class JsonAdaptedQuizTest {

    private static final JsonAdaptedFlashcardSet VALID_FLSET = new JsonAdaptedFlashcardSet(PHYSICS);
    private static final int VALID_TOTAL_SCORE = QuizBuilder.DEFAULT_TOTAL_SCORE;
    private static final int VALID_POINTS_SCORED = QuizBuilder.DEFAULT_POINTS_SCORED;
    private static final boolean[] VALID_SCOREBOARD = QuizBuilder.DEFAULT_SCORE_BOARD;
    private static final String[] VALID_USER_ANSWERS = QuizBuilder.DEFAULT_USER_ANSWERS;

    @Test
    public void toModelType_validQuizDetails_returnsQuiz() throws Exception {
        JsonAdaptedQuiz quiz = new JsonAdaptedQuiz(VALID_FLSET, VALID_TOTAL_SCORE,
                VALID_POINTS_SCORED, VALID_SCOREBOARD, VALID_USER_ANSWERS);
        assertEquals(QUIZ_PHYSICS, quiz.toModelType());
    }

    @Test
    public void toModelType_nullFlashcardSet_throwsIllegalValueException() {
        JsonAdaptedQuiz quiz = new JsonAdaptedQuiz(null, VALID_TOTAL_SCORE,
                VALID_POINTS_SCORED, VALID_SCOREBOARD, VALID_USER_ANSWERS);
        String expectedMessage = String.format(MESSAGE_MISSING_FIELD, FlashcardSet.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, quiz::toModelType);
    }

    @Test
    public void toModelType_zeroTotalScore_throwsIllegalValueException() {
        JsonAdaptedQuiz quiz = new JsonAdaptedQuiz(VALID_FLSET, 0,
                VALID_POINTS_SCORED, VALID_SCOREBOARD, VALID_USER_ANSWERS);
        String expectedMessage = String.format(MESSAGE_MISSING_FIELD, "total score");
        assertThrows(IllegalValueException.class, expectedMessage, quiz::toModelType);
    }

    @Test
    public void toModelType_nullScoreboard_throwsIllegalValueException() {
        JsonAdaptedQuiz quiz = new JsonAdaptedQuiz(VALID_FLSET, VALID_TOTAL_SCORE,
                VALID_POINTS_SCORED, null, VALID_USER_ANSWERS);
        String expectedMessage = String.format(MESSAGE_MISSING_FIELD, "scoreboard");
        assertThrows(IllegalValueException.class, expectedMessage, quiz::toModelType);
    }

    @Test
    public void toModelType_zeroLengthScoreboard_throwsIllegalValueException() {
        JsonAdaptedQuiz quiz = new JsonAdaptedQuiz(VALID_FLSET, VALID_TOTAL_SCORE,
                VALID_POINTS_SCORED, new boolean[0], VALID_USER_ANSWERS);
        String expectedMessage = String.format(MESSAGE_MISSING_FIELD, "scoreboard");
        assertThrows(IllegalValueException.class, expectedMessage, quiz::toModelType);
    }


    @Test
    public void toModelType_nullUserAnswers_throwsIllegalValueException() {
        JsonAdaptedQuiz quiz = new JsonAdaptedQuiz(VALID_FLSET, VALID_TOTAL_SCORE,
                VALID_POINTS_SCORED, VALID_SCOREBOARD, null);
        String expectedMessage = String.format(MESSAGE_MISSING_FIELD, "user answers");
        assertThrows(IllegalValueException.class, expectedMessage, quiz::toModelType);
    }

    @Test
    public void toModelType_zeroLengthUserAnswers_throwsIllegalValueException() {
        JsonAdaptedQuiz quiz = new JsonAdaptedQuiz(VALID_FLSET, VALID_TOTAL_SCORE,
                VALID_POINTS_SCORED, VALID_SCOREBOARD, new String[0]);
        String expectedMessage = String.format(MESSAGE_MISSING_FIELD, "user answers");
        assertThrows(IllegalValueException.class, expectedMessage, quiz::toModelType);
    }
}
