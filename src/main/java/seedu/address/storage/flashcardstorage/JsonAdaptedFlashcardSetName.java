package seedu.address.storage.flashcardstorage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.flashcard.FlashcardSetName;

public class JsonAdaptedFlashcardSetName {

    private final String name;

    /**
     * Constructs a {@code JsonAdaptedFlashcardSetName} with the given {@code name}.
     */
    @JsonCreator
    public JsonAdaptedFlashcardSetName(String name) {
        this.name = name;
    }

    /**
     * Converts a given {@code name} into this class for Jackson use.
     */
    public JsonAdaptedFlashcardSetName(FlashcardSetName source) {
        name = source.toString();
    }

    @JsonValue
    public String getName() {
        return name;
    }

    /**
     * Converts this Jackson-friendly adapted dateTime object into the model's {@code FlashcardSetName} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted dateTime.
     */
    public FlashcardSetName toModelType() throws IllegalValueException {
        if (!FlashcardSetName.isValidName(name)) {
            throw new IllegalValueException(FlashcardSetName.MESSAGE_CONSTRAINTS);
        }
        return new FlashcardSetName(name);
    }
}
