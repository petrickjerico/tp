package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static seedu.address.testutil.SampleTasks.getSampleSchedule;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.address.commons.core.GuiSettings;
import seedu.address.model.systemlevelmodel.AddressBook;
import seedu.address.model.systemlevelmodel.ReadOnlyAddressBook;
import seedu.address.model.systemlevelmodel.ReadOnlySchedule;
import seedu.address.model.systemlevelmodel.Schedule;
import seedu.address.model.systemlevelmodel.UserPrefs;
import seedu.address.storage.flashcardstorage.JsonFlashcardBankStorage;
import seedu.address.storage.schedulestorage.JsonScheduleStorage;

public class StorageManagerTest {

    @TempDir
    public Path testFolder;

    private StorageManager storageManager;

    @BeforeEach
    public void setUp() {
        JsonAddressBookStorage addressBookStorage = new JsonAddressBookStorage(getTempFilePath("ab"));
        JsonScheduleStorage scheduleStorage = new JsonScheduleStorage(getTempFilePath("sch"));
        JsonFlashcardBankStorage flashcardBankStorage = new JsonFlashcardBankStorage(getTempFilePath("flbank"));
        JsonUserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(getTempFilePath("prefs"));
        storageManager = new StorageManager(scheduleStorage, flashcardBankStorage,
                addressBookStorage, userPrefsStorage);
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
    public void addressBookReadSave() throws Exception {
        /*
         * Note: This is an integration test that verifies the StorageManager is properly wired to the
         * {@link JsonAddressBookStorage} class.
         * More extensive testing of UserPref saving/reading is done in {@link JsonAddressBookStorageTest} class.
         */
        AddressBook original = getTypicalAddressBook();
        storageManager.saveAddressBook(original);
        ReadOnlyAddressBook retrieved = storageManager.readAddressBook().get();
        assertEquals(original, new AddressBook(retrieved));
    }

    @Test
    public void getAddressBookFilePath() {
        assertNotNull(storageManager.getAddressBookFilePath());
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
}
