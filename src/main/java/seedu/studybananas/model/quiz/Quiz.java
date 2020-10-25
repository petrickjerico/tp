package seedu.studybananas.model.quiz;

import seedu.studybananas.model.flashcard.Answer;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.flashcard.FlashcardSetName;
import seedu.studybananas.model.flashcard.Question;

public class Quiz {

    private final FlashcardSet flashcardSet;
    private final int flashcardSetIndex;
    private final int totalScore;
    private int pointsScored = 0;
    private int currentIndex = 0;
    private final boolean[] scoreboard;
    private final String[] userAnswers;

    /**
     * Creates a quiz from a given flashcard set.
     * @param index provided
     * @param flashcardSet based on index given
     */
    public Quiz(int index, FlashcardSet flashcardSet) {
        this.flashcardSetIndex = index;
        this.flashcardSet = flashcardSet;
        this.totalScore = this.flashcardSet.getFlashcards().size();
        this.scoreboard = new boolean[totalScore];
        this.userAnswers = new String[totalScore];
    }

    /**
     * Creates a Quiz object with the given attributes.
     * @param flashcardSet
     * @param totalScore
     * @param pointsScored
     * @param scoreboard
     */
    public Quiz(FlashcardSet flashcardSet, int totalScore, int pointsScored,
                boolean[] scoreboard, String[] userAnswers) {
        this.totalScore = totalScore;
        this.flashcardSet = flashcardSet;
        this.pointsScored = pointsScored;
        this.scoreboard = scoreboard;
        this.flashcardSetIndex = 0; // index doesn't matter here anymore
        this.userAnswers = userAnswers;
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

    public String[] getUserAnswers() {
        return userAnswers;
    }

    /**
     * Stores the user answer.
     * @param input user answer
     */
    public void saveAnswer(String input) {
        assert currentIndex < totalScore;
        this.userAnswers[currentIndex] = input;
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

    public FlashcardSet getFlashcardSet() {
        return flashcardSet;
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
            if (userAnswers[i] != null) {
                builder.append("Correct Answer: ")
                        .append(flashcardSet.getFlashcards().get(i).getAnswer())
                        .append("\n");
                builder.append(isCorrect).append(". Your Answer: ")
                        .append(userAnswers[i])
                        .append("\n");
            } else {
                builder.append(isCorrect).append("Answer: ")
                        .append(flashcardSet.getFlashcards().get(i).getAnswer())
                        .append("\n");
            }
        }
        return builder.toString();
    }

    public double getPercentageScore() {
        return ((double) pointsScored) / ((double) totalScore) * 100;
    }

    public int getPointsScored() {
        return pointsScored;
    }

    public int getTotalScore() {
        return totalScore;
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
