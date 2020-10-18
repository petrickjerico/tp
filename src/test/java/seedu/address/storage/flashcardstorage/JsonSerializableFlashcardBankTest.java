package seedu.address.storage.flashcardstorage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalFlashcardSets.getTypicalFlashcardBank;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.systemlevelmodel.FlashcardBank;

public class JsonSerializableFlashcardBankTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableFlashcardBankTest");
    private static final Path TYPICAL_FLASHCARD_SETS_FILE = TEST_DATA_FOLDER.resolve("typicalFlashcardSets.json");
    private static final Path DUPLICATE_FLASHCARD_SETS_FILE = TEST_DATA_FOLDER.resolve("duplicateFlashcardSets.json");

    @Test
    public void toModelType_typicalFlashcardSetsFile_success() throws Exception {
        JsonSerializableFlashcardBank dataFromFile = JsonUtil.readJsonFile(TYPICAL_FLASHCARD_SETS_FILE,
                JsonSerializableFlashcardBank.class).get();
        FlashcardBank flashcardBankFromFile = dataFromFile.toModelType();
        FlashcardBank typicalFlashcardBank = getTypicalFlashcardBank();
        assertEquals(typicalFlashcardBank, flashcardBankFromFile);
    }

    @Test
    public void toModelType_duplicateFlashcardSets_throwsIllegalValueException() throws Exception {
        JsonSerializableFlashcardBank dataFromFile = JsonUtil.readJsonFile(DUPLICATE_FLASHCARD_SETS_FILE,
                JsonSerializableFlashcardBank.class).get();
        assertThrows(IllegalValueException.class, JsonSerializableFlashcardBank.MESSAGE_DUPLICATE_FLASHCARD_SETS,
                dataFromFile::toModelType);
    }
}
