package seedu.address.model.quiz;

import seedu.address.model.flashcard.Answer;
import seedu.address.model.flashcard.FlashcardSet;
import seedu.address.model.flashcard.Question;

public class Quiz {

    private final FlashcardSet flashcardSet;
    private final int totalScore;
    private int currentIndex = 0;
    private int pointsScored = 0;

    /**
     * Creates a quiz from a given flashcard set.
     * @param flashcardSet
     */
    public Quiz(FlashcardSet flashcardSet) {
        this.flashcardSet = flashcardSet;
        this.totalScore = this.flashcardSet.getFlashcards().size();
    }

    public Question getQuestion() {
        if (currentIndex >= totalScore) {
            return null;
        }
        return flashcardSet.getFlashcards().get(currentIndex).getQuestion();
    }

    public Answer getAnswer() {
        Answer answer = flashcardSet.getFlashcards().get(currentIndex).getAnswer();
        currentIndex++;
        return answer;
    }

    public void setPointsScored() {
        this.pointsScored++;
    }

    public String toString() {
        return "Quiz of " + this.flashcardSet.getName();
    }

    public double getPercentageScore() {
        return ((double) pointsScored) / ((double) totalScore) * 100;
    }
}
