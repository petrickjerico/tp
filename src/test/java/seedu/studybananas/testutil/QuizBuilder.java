package seedu.studybananas.testutil;

import static seedu.studybananas.testutil.TypicalFlashcardSets.PHYSICS;

import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.quiz.Quiz;

public class QuizBuilder {

    public static final FlashcardSet DEFAULT_FLASHCARD_SET = PHYSICS;
    public static final int DEFAULT_INDEX = 1;

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
    }

    /**
     * Initializes the QuizBuilder with the data of {@code QuizToCopy}.
     */
    public QuizBuilder(Quiz quizToCopy) {
        flashcardSet = quizToCopy.getFlashcardSet();
        flashcardSetIndex = quizToCopy.getFlashcardSetIndex();
    }

    /**
     * Sets the {@code FlashcardSet} of the {@code Quiz} that we are building.
     */
    public QuizBuilder withFlashcardSet(FlashcardSet flashcardSet) {
        this.flashcardSet = flashcardSet;
        return this;
    }

    public Quiz build() {
        return new Quiz(flashcardSetIndex, flashcardSet);
    }
}
