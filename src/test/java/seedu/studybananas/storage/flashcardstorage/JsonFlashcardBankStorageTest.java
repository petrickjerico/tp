package seedu.studybananas.storage.flashcardstorage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static seedu.studybananas.testutil.Assert.assertThrows;
import static seedu.studybananas.testutil.TypicalFlashcardSets.PHYSICS;
import static seedu.studybananas.testutil.TypicalFlashcardSets.getTypicalFlashcardBank;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.studybananas.commons.exceptions.DataConversionException;
import seedu.studybananas.model.systemlevelmodel.FlashcardBank;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyFlashcardBank;
import seedu.studybananas.testutil.FlashcardSetBuilder;

public class JsonFlashcardBankStorageTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonFlashcardBankStorageTest");

    @TempDir
    public Path testFolder;

    @Test
    public void readFlashcardBank_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> readFlashcardBank(null));
    }

    private java.util.Optional<ReadOnlyFlashcardBank> readFlashcardBank(String filePath) throws Exception {
        return new JsonFlashcardBankStorage(Paths.get(filePath))
                .readFlashcardBank(addToTestDataPathIfNotNull(filePath));
    }

    private Path addToTestDataPathIfNotNull(String prefsFileInTestDataFolder) {
        return prefsFileInTestDataFolder != null
                ? TEST_DATA_FOLDER.resolve(prefsFileInTestDataFolder)
                : null;
    }

    @Test
    public void read_missingFile_emptyResult() throws Exception {
        assertFalse(readFlashcardBank("NonExistentFile.json").isPresent());
    }

    @Test
    public void read_notJsonFormat_exceptionThrown() {
        assertThrows(DataConversionException.class, () -> readFlashcardBank("notJsonFormatFlashcardBank.json"));
    }

    @Test
    public void readFlashcardBank_invalidFlashcardSetFlashcardBank_throwDataConversionException() {
        assertThrows(DataConversionException.class, () -> readFlashcardBank("invalidFlashcardSet.json"));
    }

    @Test
    public void readFlashcardBank_invalidAndValidFlashcardSet_throwDataConversionException() {
        assertThrows(DataConversionException.class, () -> readFlashcardBank("invalidAndValidFlashcardSet.json"));
    }

    @Test
    public void readFlashcardBank_invalidFlashcardFlashcardBank_throwDataConversionException() {
        assertThrows(DataConversionException.class, () -> readFlashcardBank("invalidFlashcard.json"));
    }

    @Test
    public void readFlashcardBank_invalidAndValidFlashcard_throwDataConversionException() {
        assertThrows(DataConversionException.class, () -> readFlashcardBank("invalidAndValidFlashcard.json"));
    }

    @Test
    public void readAndSaveFlashcardBank_allInOrder_success() throws Exception {
        Path filePath = testFolder.resolve("TempFlashcardBank.json");
        FlashcardBank original = getTypicalFlashcardBank();
        JsonFlashcardBankStorage jsonFlashcardBankStorage = new JsonFlashcardBankStorage(filePath);

        // Save in new file and read back
        jsonFlashcardBankStorage.saveFlashcardBank(original, filePath);
        ReadOnlyFlashcardBank readBack = jsonFlashcardBankStorage.readFlashcardBank(filePath).get();
        assertEquals(original, new FlashcardBank(readBack));

        // Modify data, overwrite exiting file, and read back
        original.setFlashcardSet(PHYSICS, new FlashcardSetBuilder().build());
        jsonFlashcardBankStorage.saveFlashcardBank(original, filePath);
        readBack = jsonFlashcardBankStorage.readFlashcardBank(filePath).get();
        assertEquals(original, new FlashcardBank(readBack));

        // Save and read without specifying file path
        String validFlsetName = "Chemistry";
        original.addFlashcardSet(new FlashcardSetBuilder()
                .withFlashcardSetName(validFlsetName)
                .build());
        jsonFlashcardBankStorage.saveFlashcardBank(original); // file path not specified
        readBack = jsonFlashcardBankStorage.readFlashcardBank().get(); // file path not specified
        assertEquals(original, new FlashcardBank(readBack));

    }

    @Test
    public void saveFlashcardBank_nullFlashcardBank_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveFlashcardBank(null, "SomeFile.json"));
    }

    /**
     * Saves {@code schedule} at the specified {@code filePath}.
     */
    private void saveFlashcardBank(ReadOnlyFlashcardBank flashcardBank, String filePath) {
        try {
            new JsonFlashcardBankStorage(Paths.get(filePath))
                    .saveFlashcardBank(flashcardBank, addToTestDataPathIfNotNull(filePath));
        } catch (IOException ioe) {
            throw new AssertionError("There should not be an error writing to the file.", ioe);
        }
    }

    @Test
    public void saveFlashcardBank_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveFlashcardBank(new FlashcardBank(), null));
    }
}
