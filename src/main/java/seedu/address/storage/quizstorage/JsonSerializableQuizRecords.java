package seedu.address.storage.quizstorage;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.flashcard.FlashcardSetName;
import seedu.address.model.quiz.Quiz;
import seedu.address.model.systemlevelmodel.QuizRecords;
import seedu.address.model.systemlevelmodel.ReadOnlyQuizRecords;
import seedu.address.storage.flashcardstorage.JsonAdaptedFlashcardSetName;

public class JsonSerializableQuizRecords {

    private final Map<JsonAdaptedFlashcardSetName, JsonAdaptedQuiz> quizzes = new HashMap<>();

    /**
     * Constructs a {@code JsonSerializableQuizRecords} with the given flashcardSets.
     */
    @JsonCreator
    public JsonSerializableQuizRecords(@JsonProperty("quizzes") Map<JsonAdaptedFlashcardSetName,
            JsonAdaptedQuiz> quizzes) {
        this.quizzes.putAll(quizzes);
    }

    /**
     * Converts a given {@code ReadOnlyQuizRecords} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableAddressBook}.
     */
    public JsonSerializableQuizRecords(ReadOnlyQuizRecords source) {
        Map<FlashcardSetName, Quiz> quizMap = source.getQuizRecordsMap();
        for (Map.Entry<FlashcardSetName, Quiz> pair : quizMap.entrySet()) {
            JsonAdaptedQuiz jsonAdaptedQuiz = new JsonAdaptedQuiz(pair.getValue());
            JsonAdaptedFlashcardSetName jsonAdaptedFlashcardSetName =
                    new JsonAdaptedFlashcardSetName(pair.getKey());
            quizzes.put(jsonAdaptedFlashcardSetName, jsonAdaptedQuiz);
        }
    }

    /**
     * Converts this quizRecords into the model's {@code QuizRecords} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public QuizRecords toModelType() throws IllegalValueException {
        QuizRecords quizRecords = new QuizRecords();
        for (Map.Entry<JsonAdaptedFlashcardSetName, JsonAdaptedQuiz> pair : quizzes.entrySet()) {
            JsonAdaptedQuiz jsonAdaptedQuiz = pair.getValue();
            Quiz quiz = jsonAdaptedQuiz.toModelType();
            quizRecords.addQuiz(quiz);
        }
        return quizRecords;
    }
}
