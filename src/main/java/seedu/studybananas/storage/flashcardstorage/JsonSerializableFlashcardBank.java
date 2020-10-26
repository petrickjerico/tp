package seedu.studybananas.storage.flashcardstorage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.studybananas.commons.exceptions.IllegalValueException;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.systemlevelmodel.FlashcardBank;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyFlashcardBank;


public class JsonSerializableFlashcardBank {
    public static final String MESSAGE_DUPLICATE_FLASHCARD_SETS =
            "FlashcardSets list contains duplicate flashcardSet(s).";

    private final List<JsonAdaptedFlashcardSet> flashcardSets = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableFlashcardBank} with the given flashcardSets.
     */
    @JsonCreator
    public JsonSerializableFlashcardBank(@JsonProperty("flashcardSets") List<JsonAdaptedFlashcardSet> flashcardSets) {
        this.flashcardSets.addAll(flashcardSets);
    }

    /**
     * Converts a given {@code ReadOnlyFlashcardBank} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableAddressBook}.
     */
    public JsonSerializableFlashcardBank(ReadOnlyFlashcardBank source) {
        flashcardSets.addAll(source.getFlashcardSetList().stream()
                .map(JsonAdaptedFlashcardSet::new).collect(Collectors.toList()));
    }

    /**
     * Converts this flashcardBank into the model's {@code FlashcardBank} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public FlashcardBank toModelType() throws IllegalValueException {
        FlashcardBank flashcardBank = new FlashcardBank();
        for (JsonAdaptedFlashcardSet jsonAdaptedFlashcardSet : flashcardSets) {
            FlashcardSet flashcardSet = jsonAdaptedFlashcardSet.toModelType();
            if (flashcardBank.hasFlashcardSet(flashcardSet)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_FLASHCARD_SETS);
            }
            flashcardBank.addFlashcardSet(flashcardSet);
        }
        return flashcardBank;
    }
}
