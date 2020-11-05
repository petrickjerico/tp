package seedu.studybananas.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static seedu.studybananas.testutil.SampleTasks.getSampleSchedule;

import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.studybananas.commons.core.GuiSettings;
import seedu.studybananas.model.systemlevelmodel.ReadOnlySchedule;
import seedu.studybananas.model.systemlevelmodel.Schedule;
import seedu.studybananas.model.systemlevelmodel.UserPrefs;
import seedu.studybananas.storage.flashcardstorage.JsonFlashcardBankStorage;
import seedu.studybananas.storage.quizstorage.JsonQuizRecordsStorage;
import seedu.studybananas.storage.schedulestorage.JsonScheduleStorage;

public class StorageManagerTest {

    @TempDir
    public Path testFolder;

    private StorageManager storageManager;

    @BeforeEach
    public void setUp() {
        JsonScheduleStorage scheduleStorage = new JsonScheduleStorage(getTempFilePath("sch"));
        JsonFlashcardBankStorage flashcardBankStorage = new JsonFlashcardBankStorage(getTempFilePath("flbank"));
        JsonQuizRecordsStorage quizRecordsStorage = new JsonQuizRecordsStorage(getTempFilePath("qzrds"));
        JsonUserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(getTempFilePath("prefs"));
        storageManager = new StorageManager(scheduleStorage, flashcardBankStorage,
                quizRecordsStorage, userPrefsStorage);
    }

    private Path getTempFilePath(String fileName) {
        return testFolder.resolve(fileName);
    }

    @Test
    public void prefsReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonUserPrefsStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonUserPrefsStorageTest} class.
         */
        UserPrefs original = new UserPrefs();
        original.setGuiSettings(new GuiSettings(300, 600, 4, 6));
        storageManager.saveUserPrefs(original);
        UserPrefs retrieved = storageManager.readUserPrefs().get();
        assertEquals(original, retrieved);
    }

    @Test
    public void scheduleReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonAddressSchedule} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonScheduleTest} class.
         */
        Schedule original = getSampleSchedule();
        storageManager.saveSchedule(original);
        ReadOnlySchedule retrieved = storageManager.readSchedule().get();
        assertEquals(original, new Schedule(retrieved));
    }

    @Test
    public void getScheduleFilePath() {
        assertNotNull(storageManager.getScheduleFilePath());
    }

    @Test
    public void flashcardBankReadSave() throws Exception {

    }
}
