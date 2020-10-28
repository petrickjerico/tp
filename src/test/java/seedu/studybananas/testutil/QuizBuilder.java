package seedu.studybananas.testutil;

import static seedu.studybananas.testutil.TypicalFlashcardSets.PHYSICS;

import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.quiz.Quiz;

public class QuizBuilder {

    public static final FlashcardSet DEFAULT_FLASHCARD_SET = PHYSICS;
    public static final int DEFAULT_INDEX = 1;
    public static final int DEFAULT_TOTAL_SCORE = 3;
    public static final int DEFAULT_POINTS_SCORED = 2;
    public static final boolean[] DEFAULT_SCORE_BOARD = new boolean[]{true, false, true};
    public static final String[] DEFAULT_USER_ANSWERS = new String[]{"correct ans", "wrong ans", null};

    private FlashcardSet flashcardSet;
    private int flashcardSetIndex;
    private int totalScore;
    private int pointsScored;
    private boolean[] scoreboard;
    private String[] userAnswers;

    /**
     * Creates a {@code QuizBuilder} with the default details.
     */
    public QuizBuilder() {
        flashcardSet = DEFAULT_FLASHCARD_SET;
        flashcardSetIndex = DEFAULT_INDEX;
        totalScore = DEFAULT_TOTAL_SCORE;
        pointsScored = DEFAULT_POINTS_SCORED;
        scoreboard = DEFAULT_SCORE_BOARD;
        userAnswers = DEFAULT_USER_ANSWERS;
    }

    /**
     * Initializes the QuizBuilder with the data of {@code QuizToCopy}.
     */
    public QuizBuilder(Quiz quizToCopy) {
        flashcardSet = quizToCopy.getFlashcardSet();
        flashcardSetIndex = quizToCopy.getFlashcardSetIndex();
        totalScore = quizToCopy.getTotalScore();
        pointsScored = quizToCopy.getPointsScored();
        scoreboard = quizToCopy.getResults();
        userAnswers = quizToCopy.getUserAnswers();
    }

    /**
     * Sets the {@code FlashcardSet} of the {@code Quiz} that we are building.
     */
    public QuizBuilder withFlashcardSet(FlashcardSet flashcardSet) {
        this.flashcardSet = flashcardSet;
        return this;
    }

    /**
     * Sets the {@code pointsScored} of the {@code Quiz} that we are building.
     */
    public QuizBuilder withPointsScored(int pointsScored) {
        this.pointsScored = pointsScored;
        return this;
    }

    /**
     * Sets the {@code scoreboard} of the {@code Quiz} that we are building.
     */
    public QuizBuilder withScoreBoard(boolean[] scoreBoard) {
        this.scoreboard = scoreBoard;
        return this;
    }

    /**
     * Sets the {@code userAnswers} of the {@code Quiz} that we are building.
     */
    public QuizBuilder withUserAnswers(String[] userAnswers) {
        this.userAnswers = userAnswers;
        return this;
    }

    /**
     * Builds the quiz with initial values.
     * @return the quiz built
     */
    public Quiz build() {
        return new Quiz(flashcardSetIndex, flashcardSet);
    }

    /**
     * Builds the quiz with default sample after-quiz values.
     * @return the quiz build
     */
    public Quiz buildDefaultQuiz() {
        return new Quiz(flashcardSet, totalScore, pointsScored, scoreboard, userAnswers);
    }
}
