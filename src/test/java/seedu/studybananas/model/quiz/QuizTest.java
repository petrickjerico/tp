package seedu.studybananas.model.quiz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static seedu.studybananas.testutil.QuizBuilder.DEFAULT_POINTS_SCORED;
import static seedu.studybananas.testutil.QuizBuilder.DEFAULT_TOTAL_SCORE;
import static seedu.studybananas.testutil.TypicalFlashcardSets.ECONOMICS;
import static seedu.studybananas.testutil.TypicalFlashcardSets.PHYSICS;
import static seedu.studybananas.testutil.TypicalFlashcards.DECAY_CONSTANT;
import static seedu.studybananas.testutil.TypicalFlashcards.HOOKES_LAW;
import static seedu.studybananas.testutil.TypicalFlashcards.NEWTONS_SECOND_LAW;
import static seedu.studybananas.testutil.TypicalQuizzes.QUIZ_ECONOMICS;
import static seedu.studybananas.testutil.TypicalQuizzes.QUIZ_PHYSICS;

import org.junit.jupiter.api.Test;

import seedu.studybananas.model.flashcard.Answer;
import seedu.studybananas.model.flashcard.Question;
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

    @Test
    public void test_getQuestionGetAnswerFlow_success() {

        Quiz quizPhysics = new QuizBuilder(QUIZ_PHYSICS).buildDefaultQuiz();

        Question firstQuestion = quizPhysics.getQuestion();
        assertEquals(NEWTONS_SECOND_LAW.getQuestion(), firstQuestion);

        Answer firstAns = quizPhysics.getAnswer();
        assertEquals(NEWTONS_SECOND_LAW.getAnswer(), firstAns);

        Question secondQuestion = quizPhysics.getQuestion();
        assertEquals(HOOKES_LAW.getQuestion(), secondQuestion);

        Answer secondAns = quizPhysics.getAnswer();
        assertEquals(HOOKES_LAW.getAnswer(), secondAns);

        Question thirdQuestion = quizPhysics.getQuestion();
        assertEquals(DECAY_CONSTANT.getQuestion(), thirdQuestion);

        Answer thirdAns = quizPhysics.getAnswer();
        assertEquals(DECAY_CONSTANT.getAnswer(), thirdAns);

        // checks question returns null when end is reached
        Question endOfQuiz = quizPhysics.getQuestion();
        assertNull(endOfQuiz);
    }

    @Test
    public void test_getPercentageScore() {
        Quiz quizPhysics = new QuizBuilder(QUIZ_PHYSICS).buildDefaultQuiz();

        double defaultPercentageScore = (double) DEFAULT_POINTS_SCORED / (double) DEFAULT_TOTAL_SCORE * 100;
        assertEquals(defaultPercentageScore, quizPhysics.getPercentageScore());
    }

    @Test
    public void test_saveAnswer() {
        Quiz quizPhysics = new QuizBuilder(QUIZ_PHYSICS).buildDefaultQuiz();

        // check initial answer
        String initialAnswer = quizPhysics.getUserAnswers()[0]; // default index is 0
        String userAnswer = "3 happy bunnies";
        assertNotEquals(initialAnswer, userAnswer);

        quizPhysics.saveAnswer(userAnswer);
        assertEquals(quizPhysics.getUserAnswers()[0], userAnswer);
    }

    @Test
    public void test_setPointsScored() {
        Quiz quizPhysics = new QuizBuilder(QUIZ_PHYSICS).buildDefaultQuiz();

        quizPhysics.getAnswer(); // establishes the index to the first question

        boolean answerIsCorrect = true;
        boolean answerIsWrong = false;

        int initialScore = quizPhysics.getPointsScored();
        int scoreAfterCorrect = initialScore + 1;

        quizPhysics.setPointsScored(answerIsCorrect);
        assertEquals(quizPhysics.getResults()[0], answerIsCorrect); // default index is 0
        assertEquals(scoreAfterCorrect, quizPhysics.getPointsScored());

        int scoreAfterWrong = scoreAfterCorrect; // doesn't increase score

        quizPhysics.setPointsScored(answerIsWrong);
        assertEquals(quizPhysics.getResults()[0], answerIsWrong); // default index is 0
        assertEquals(scoreAfterWrong, quizPhysics.getPointsScored());
    }

}
