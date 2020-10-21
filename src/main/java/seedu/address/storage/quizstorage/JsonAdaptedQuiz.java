package seedu.address.storage.quizstorage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.flashcard.FlashcardSet;
import seedu.address.model.quiz.Quiz;
import seedu.address.storage.flashcardstorage.JsonAdaptedFlashcardSet;

public class JsonAdaptedQuiz {

    public static final String MESSAGE_MISSING_FIELD = "Quiz's %s field is missing.";

    private final JsonAdaptedFlashcardSet flset;
    private final int totalScore;
    private final int pointsScored;
    private final boolean[] scoreboard;

    /**
     * Creates a JsonAdaptedQuiz object.
     * @param flset flashcard set provided
     * @param totalScore of the quiz
     * @param pointsScored during the quiz
     * @param scoreboard recorded during the quiz
     */
    @JsonCreator
    public JsonAdaptedQuiz(@JsonProperty("flashcardSet") JsonAdaptedFlashcardSet flset,
                    @JsonProperty("totalScore") int totalScore,
                    @JsonProperty("pointsScored") int pointsScored,
                    @JsonProperty("scoreboard") boolean[] scoreboard) {
        this.flset = flset;
        this.pointsScored = pointsScored;
        this.totalScore = totalScore;
        this.scoreboard = scoreboard;
    }

    /**
     * Converts a given {@code Quiz} into this class for Jackson use.
     */
    public JsonAdaptedQuiz(Quiz source) {
        flset = new JsonAdaptedFlashcardSet(source.getFlashcardSet());
        pointsScored = source.getPointsScored();
        totalScore = source.getTotalScore();
        scoreboard = source.getResults();
    }

    /**
     * Converts this Jackson-friendly adapted quiz object into the model's {@code Quiz} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted quiz.
     */
    public Quiz toModelType() throws IllegalValueException {

        if (flset == null) {
            throw new IllegalValueException(String.format(MESSAGE_MISSING_FIELD,
                    FlashcardSet.class.getSimpleName()));
        }
        if (totalScore == 0) {
            throw new IllegalValueException(String.format(MESSAGE_MISSING_FIELD,
                    "total score"));
        }
        if (scoreboard == null || scoreboard.length == 0) {
            throw new IllegalValueException(String.format(MESSAGE_MISSING_FIELD,
                    "scoreboard"));
        }

        final FlashcardSet flashcardSet = flset.toModelType();
        return new Quiz(flashcardSet, totalScore, pointsScored, scoreboard);
    }

}
