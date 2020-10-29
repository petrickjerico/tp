package seedu.studybananas.model.quiz;

import seedu.studybananas.model.flashcard.Answer;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.flashcard.FlashcardSetName;
import seedu.studybananas.model.flashcard.Question;

/**
 * Represents a quiz pertaining to a flashcard set.
 */
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

    /**
     * Returns the next {@code Question} in the quiz.
     * If the last question is reached, it returns null.
     * @return the question of the next flashcard
     */
    public Question getQuestion() {
        if (currentIndex >= totalScore) {
            return null;
        }
        return flashcardSet.getFlashcards().get(currentIndex).getQuestion();
    }

    /**
     * Returns the {@code Answer} to the current question in the quiz.
     * Also increases the index to prepare to get the next question.
     * @return answer of the current flashcard
     */
    public Answer getAnswer() {
        Answer answer = flashcardSet.getFlashcards().get(currentIndex).getAnswer();
        currentIndex++;
        return answer;
    }

    /**
     * Returns the user answers saved for the quiz.
     * @return userAnswers
     */
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

    /**
     * Returns the flashcard set index of the flashcard set.
     * @return int flashcardSetIndex
     */
    public int getFlashcardSetIndex() {
        return this.flashcardSetIndex;
    }

    /**
     * Sets the points scored based on whether a question
     * is answered correctly.
     * @param isCorrect boolean
     */
    public void setPointsScored(boolean isCorrect) {
        scoreboard[currentIndex - 1] = isCorrect;
        if (isCorrect) {
            pointsScored++;
        }
    }

    /**
     * Obtains the records for the correctness of answers in the quiz.
     * @return boolean[] scoreboard
     */
    public boolean[] getResults() {
        return scoreboard;
    }

    /**
     * Returns the {@code FlashcardSet} in the quiz.
     * @return FlashcardSet flashcardSet
     */
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
        builder.append("Total score for " + flashcardSet.getName() + " = ")
                .append(pointsScored).append("/").append(totalScore).append("\n\n");
        try {
            for (int i = 0; i < totalScore; i++) {
                String isCorrect = scoreboard[i] ? "\u2713" : "\u2718";
                builder.append(i + 1).append(". Question: ")
                        .append(flashcardSet.getFlashcards().get(i).getQuestion())
                        .append("\n");
                builder.append("Correct Answer: ")
                        .append(flashcardSet.getFlashcards().get(i).getAnswer())
                        .append("\n");
                if (userAnswers[i] != null) {
                    builder.append(isCorrect).append(". Your Answer: ")
                            .append(userAnswers[i])
                            .append("\n\n");
                } else {
                    builder.append(isCorrect).append(". Your Answer: (not stored)")
                            .append("\n\n");
                }
            }
            return builder.toString();
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     * Obtains the percentage score of the quiz.
     * @return double percentage score
     */
    public double getPercentageScore() {
        return ((double) pointsScored) / ((double) totalScore) * 100;
    }

    /**
     * Obtains the points scored for the quiz.
     * @return int pointsScored
     */
    public int getPointsScored() {
        return pointsScored;
    }

    /**
     * Returns the total score.
     * @return int totalScore
     */
    public int getTotalScore() {
        return totalScore;
    }

    /**
     * Returns the {@code FlashcardSetName} of the quiz.
     * @return FlashcardSetName name of flashcard set
     */
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
        return otherQuiz.getFlsetName().equals(flashcardSet.getName());
    }

    public String getQuizName() {
        return "Quiz: " + this.flashcardSet.getFlashcardSetName().toString();
    }
}
