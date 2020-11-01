package seedu.studybananas.storage.quizstorage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static seedu.studybananas.testutil.Assert.assertThrows;
import static seedu.studybananas.testutil.TypicalQuizzes.QUIZ_PHYSICS;
import static seedu.studybananas.testutil.TypicalQuizzes.getTypicalQuizRecords;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.studybananas.commons.exceptions.DataConversionException;
import seedu.studybananas.model.systemlevelmodel.QuizRecords;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyQuizRecords;

public class JsonQuizRecordsStorageTest {
    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonQuizRecordsStorageTest");

    @TempDir
    public Path testFolder;

    @Test
    public void readQuizRecords_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> readQuizRecords(null));
    }

    private java.util.Optional<ReadOnlyQuizRecords> readQuizRecords(String filePath) throws Exception {
        return new JsonQuizRecordsStorage(Paths.get(filePath)).readQuizRecords(addToTestDataPathIfNotNull(filePath));
    }

    private Path addToTestDataPathIfNotNull(String prefsFileInTestDataFolder) {
        return prefsFileInTestDataFolder != null
                ? TEST_DATA_FOLDER.resolve(prefsFileInTestDataFolder)
                : null;
    }

    @Test
    public void read_missingFile_emptyResult() throws Exception {
        assertFalse(readQuizRecords("NonExistentFile.json").isPresent());
    }

    @Test
    public void read_notJsonFormat_exceptionThrown() {
        assertThrows(DataConversionException.class, () -> readQuizRecords("notJsonFormatQuizRecords.json"));
    }

    @Test
    public void readQuizRecords_invalidQuizRecords_throwDataConversionException() {
        assertThrows(DataConversionException.class, () -> readQuizRecords("invalidQuizRecords.json"));
    }

    @Test
    public void readQuizRecords_invalidAndValidQuizRecords_throwDataConversionException() {
        assertThrows(DataConversionException.class, () -> readQuizRecords("invalidAndValidQuizRecords.json"));
    }

    @Test
    public void readAndSaveQuizRecords_allInOrder_success() throws Exception {
        Path filePath = testFolder.resolve("TempQuizRecords.json");
        QuizRecords original = getTypicalQuizRecords();
        JsonQuizRecordsStorage jsonQuizRecordsStorage = new JsonQuizRecordsStorage(filePath);

        // Save in new file and read back
        jsonQuizRecordsStorage.saveQuizRecords(original, filePath);
        ReadOnlyQuizRecords readBack = jsonQuizRecordsStorage.readQuizRecords(filePath).get();
        assertEquals(original, new QuizRecords(readBack));

        // Modify data, overwrite exiting file, and read back
        original.removeQuiz(QUIZ_PHYSICS.getFlsetName());
        jsonQuizRecordsStorage.saveQuizRecords(original, filePath);
        readBack = jsonQuizRecordsStorage.readQuizRecords(filePath).get();
        assertEquals(original, new QuizRecords(readBack));

        // Save and read without specifying file path
        original.addQuiz(QUIZ_PHYSICS);
        jsonQuizRecordsStorage.saveQuizRecords(original); // file path not specified
        readBack = jsonQuizRecordsStorage.readQuizRecords().get(); // file path not specified
        assertEquals(original, new QuizRecords(readBack));

    }

    @Test
    public void saveQuizRecords_nullQuizRecords_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveQuizRecords(null, "SomeFile.json"));
    }

    /**
     * Saves {@code quizRecords} at the specified {@code filePath}.
     */
    private void saveQuizRecords(ReadOnlyQuizRecords quizRecords, String filePath) {
        try {
            new JsonQuizRecordsStorage(Paths.get(filePath))
                    .saveQuizRecords(quizRecords, addToTestDataPathIfNotNull(filePath));
        } catch (IOException ioe) {
            throw new AssertionError("There should not be an error writing to the file.", ioe);
        }
    }

    @Test
    public void saveQuizRecords_nullFilePath_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> saveQuizRecords(new QuizRecords(), null));
    }
}
