package seedu.studybananas.model.quiz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.studybananas.testutil.Assert.assertThrows;
import static seedu.studybananas.testutil.TypicalFlashcardSets.PHYSICS;
import static seedu.studybananas.testutil.TypicalQuizzes.QUIZ_ECONOMICS;
import static seedu.studybananas.testutil.TypicalQuizzes.QUIZ_ICEBREAKER_JOKES;
import static seedu.studybananas.testutil.TypicalQuizzes.QUIZ_PHYSICS;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import seedu.studybananas.model.flashcard.FlashcardSetName;
import seedu.studybananas.model.quiz.exceptions.DuplicateQuizException;
import seedu.studybananas.model.quiz.exceptions.QuizNotFoundException;
import seedu.studybananas.testutil.QuizBuilder;

public class UniqueQuizRecordsMapTest {

    private final UniqueQuizRecordsMap uniqueQuizRecordsMap = new UniqueQuizRecordsMap();

    @Test
    public void contains_nullQuiz_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueQuizRecordsMap.contains(null));
    }

    @Test
    public void contains_quizNotInMap_returnsFalse() {
        assertFalse(uniqueQuizRecordsMap.contains(QUIZ_PHYSICS));
    }

    @Test
    public void contains_quizInMap_returnsTrue() {
        uniqueQuizRecordsMap.add(QUIZ_PHYSICS.getFlsetName(), QUIZ_PHYSICS);
        assertTrue(uniqueQuizRecordsMap.contains(QUIZ_PHYSICS));
    }

    @Test
    public void contains_taskWithSameInformationInMap_returnsTrue() {
        uniqueQuizRecordsMap.add(QUIZ_PHYSICS.getFlsetName(), QUIZ_PHYSICS);
        Quiz copyQuizPhysics = new QuizBuilder(QUIZ_PHYSICS)
                .withFlashcardSet(PHYSICS)
                .buildDefaultQuiz();
        assertTrue(uniqueQuizRecordsMap.contains(copyQuizPhysics));
    }

    @Test
    public void add_nullQuiz_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                uniqueQuizRecordsMap.add(new FlashcardSetName("Test"), null));
    }

    @Test
    public void setQuiz_nullTargetQuiz_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueQuizRecordsMap.setQuiz(null, QUIZ_PHYSICS));
    }

    @Test
    public void setQuiz_nullEditedQuiz_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueQuizRecordsMap.setQuiz(QUIZ_PHYSICS, null));
    }

    @Test
    public void setQuiz_targetQuizNotInMap_throwsTaskNotFoundException() {
        assertThrows(QuizNotFoundException.class, () -> uniqueQuizRecordsMap.setQuiz(QUIZ_PHYSICS, QUIZ_PHYSICS));
    }

    @Test
    public void setQuiz_editedQuizHasDifferentIdentity_success() {
        uniqueQuizRecordsMap.add(QUIZ_PHYSICS.getFlsetName(), QUIZ_PHYSICS);
        uniqueQuizRecordsMap.setQuiz(QUIZ_PHYSICS, QUIZ_ICEBREAKER_JOKES);
        UniqueQuizRecordsMap expectedQuizRecordsMap = new UniqueQuizRecordsMap();
        expectedQuizRecordsMap.add(QUIZ_ICEBREAKER_JOKES.getFlsetName(), QUIZ_ICEBREAKER_JOKES);
        assertEquals(expectedQuizRecordsMap, uniqueQuizRecordsMap);
    }

    @Test
    public void setQuiz_editedQuizHasNonUniqueIdentity_throwsDuplicateQuizException() {
        uniqueQuizRecordsMap.add(QUIZ_PHYSICS.getFlsetName(), QUIZ_PHYSICS);
        uniqueQuizRecordsMap.add(QUIZ_ECONOMICS.getFlsetName(), QUIZ_ECONOMICS);
        assertThrows(DuplicateQuizException.class, () -> uniqueQuizRecordsMap.setQuiz(
                QUIZ_PHYSICS, QUIZ_ECONOMICS));
    }

    @Test
    public void remove_nullQuiz_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueQuizRecordsMap.remove(null));
    }

    @Test
    public void remove_existingQuiz_removesQuiz() {
        uniqueQuizRecordsMap.add(QUIZ_PHYSICS.getFlsetName(), QUIZ_PHYSICS);
        uniqueQuizRecordsMap.remove(QUIZ_PHYSICS.getFlsetName());
        UniqueQuizRecordsMap expectedUniqueQuizRecordsMap = new UniqueQuizRecordsMap();
        assertEquals(expectedUniqueQuizRecordsMap, uniqueQuizRecordsMap);
    }

    @Test
    public void setQuizRecords_nullUniqueQuizRecordsMap_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                uniqueQuizRecordsMap.setQuizRecords((UniqueQuizRecordsMap) null));
    }

    @Test
    public void setQuizRecords_uniqueQuizRecordsMap_replacesOwnMapWithProvidedUniqueQuizRecordsMap() {
        uniqueQuizRecordsMap.add(QUIZ_PHYSICS.getFlsetName(), QUIZ_PHYSICS);
        UniqueQuizRecordsMap expectedUniqueQuizRecordsMap = new UniqueQuizRecordsMap();
        expectedUniqueQuizRecordsMap.add(QUIZ_PHYSICS.getFlsetName(), QUIZ_PHYSICS);
        uniqueQuizRecordsMap.setQuizRecords(expectedUniqueQuizRecordsMap);
        assertEquals(expectedUniqueQuizRecordsMap, uniqueQuizRecordsMap);
    }

    @Test
    public void setQuizRecords_nullMap_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                uniqueQuizRecordsMap.setQuizRecords((Map<FlashcardSetName, Quiz>) null));
    }

    @Test
    public void setQuizRecords_map_replacesOwnMapWithProvidedMap() {
        uniqueQuizRecordsMap.add(QUIZ_PHYSICS.getFlsetName(), QUIZ_PHYSICS);

        Map<FlashcardSetName, Quiz> quizMap = new HashMap<>();
        quizMap.put(QUIZ_ECONOMICS.getFlsetName(), QUIZ_ECONOMICS);

        uniqueQuizRecordsMap.setQuizRecords(quizMap);

        UniqueQuizRecordsMap expectedUniqueQuizRecordsMap = new UniqueQuizRecordsMap();
        expectedUniqueQuizRecordsMap.add(QUIZ_ECONOMICS.getFlsetName(), QUIZ_ECONOMICS);
        assertEquals(expectedUniqueQuizRecordsMap, uniqueQuizRecordsMap);
    }

    @Test
    public void getQuiz() {
        uniqueQuizRecordsMap.add(QUIZ_PHYSICS.getFlsetName(), QUIZ_PHYSICS);
        assertEquals(QUIZ_PHYSICS, uniqueQuizRecordsMap.getQuiz(QUIZ_PHYSICS.getFlsetName()));
    }
}
