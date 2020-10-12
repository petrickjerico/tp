package seedu.address.storage.flashcard;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.flashcard.Answer;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.flashcard.Question;

public class JsonAdaptedFlashcard {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Flashcard's %s field is missing!";

    private final String question;
    private final String answer;

    /**
     * Constructs a {@code JsonAdaptedFlashcard} with the given flashcard details.
     */
    @JsonCreator
    public JsonAdaptedFlashcard(@JsonProperty("question") String question,
                           @JsonProperty("answer") String answer) {
        this.question = question;
        this.answer = answer;
    }

    /**
     * Converts a given {@code Flashcard} into this class for Jackson use.
     */
    public JsonAdaptedFlashcard(Flashcard source) {
        question = source.getQuestion().toString();
        answer = source.getAnswer().toString();
    }

    /**
     * Converts this Jackson-friendly adapted flashcard object into the model's {@code Flashcard} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted flashcard.
     */
    public Flashcard toModelType() throws IllegalValueException {

        if (question == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Question.class.getSimpleName()));
        }
        if (answer == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Answer.class.getSimpleName()));
        }
        final Question modelQuestion = new Question(question);
        final Answer modelAnswer = new Answer(answer);

        return new Flashcard(modelQuestion, modelAnswer);
    }
}
