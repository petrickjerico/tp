package seedu.address.model.quiz;

import seedu.address.model.flashcard.Answer;
import seedu.address.model.flashcard.FlashcardSet;
import seedu.address.model.flashcard.FlashcardSetName;
import seedu.address.model.flashcard.Question;

public class Quiz {

    private final FlashcardSet flashcardSet;
    private final int flashcardSetIndex;
    private final int totalScore;
    private int pointsScored = 0;
    private int currentIndex = 0;
    private final boolean[] scoreboard;

    /**
     * Creates a quiz from a given flashcard set.
     * @param index
     * @param flashcardSet
     */
    public Quiz(int index, FlashcardSet flashcardSet) {
        this.flashcardSetIndex = index;
        this.flashcardSet = flashcardSet;
        this.totalScore = this.flashcardSet.getFlashcards().size();
        this.scoreboard = new boolean[totalScore];
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

    public int getFlashcardSetIndex() {
        return this.flashcardSetIndex;
    }

    public void setPointsScored(boolean isCorrect) {
        scoreboard[currentIndex - 1] = isCorrect;
        if (isCorrect) {
            pointsScored++;
        }
    }

    public boolean[] getResults() {
        return scoreboard;
    }

    /**
     * Gives the string representation of the quiz,
     * using its score records.
     * @return string representation
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Total score = ").append(pointsScored).append("/").append(totalScore).append("\n");
        builder.append("Percentage scored = ").append(getPercentageScore()).append("\n");
        for (int i = 0; i < totalScore; i++) {
            String isCorrect = scoreboard[i] ? "\u2713" : "\u2718";
            builder.append(i + 1).append(". Question: ")
                    .append(flashcardSet.getFlashcards().get(i).getQuestion())
                    .append("\n");
            builder.append(isCorrect).append(". Answer: ")
                    .append(flashcardSet.getFlashcards().get(i).getAnswer())
                    .append("\n");
        }
        return builder.toString();
    }

    public double getPercentageScore() {
        return ((double) pointsScored) / ((double) totalScore) * 100;
    }

    public FlashcardSetName getFlsetName() {
        return flashcardSet.getFlashcardSetName();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Quiz)) {
            return false;
        }

        Quiz otherQuiz = (Quiz) other;
        return otherQuiz.getFlashcardSetIndex() == (this.flashcardSetIndex);
    }
}
