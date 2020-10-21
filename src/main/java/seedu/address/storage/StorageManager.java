package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.systemlevelmodel.ReadOnlyAddressBook;
import seedu.address.model.systemlevelmodel.ReadOnlyFlashcardBank;
import seedu.address.model.systemlevelmodel.ReadOnlyQuizRecords;
import seedu.address.model.systemlevelmodel.ReadOnlySchedule;
import seedu.address.model.systemlevelmodel.ReadOnlyUserPrefs;
import seedu.address.model.systemlevelmodel.UserPrefs;
import seedu.address.storage.flashcardstorage.FlashcardBankStorage;
import seedu.address.storage.schedulestorage.ScheduleStorage;

/**
 * Manages storage of AddressBook data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private final AddressBookStorage addressBookStorage;
    private final ScheduleStorage scheduleStorage;
    private final UserPrefsStorage userPrefsStorage;
    private final FlashcardBankStorage flashcardBankStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code AddressBookStorage} and {@code UserPrefStorage}.
     */
    public StorageManager(ScheduleStorage scheduleStorage, FlashcardBankStorage flashcardBankStorage,
                          AddressBookStorage addressBookStorage, UserPrefsStorage userPrefsStorage) {
        this.addressBookStorage = addressBookStorage;
        this.userPrefsStorage = userPrefsStorage;
        this.scheduleStorage = scheduleStorage;
        this.flashcardBankStorage = flashcardBankStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }


    // ================ AddressBook methods ==============================

    @Override
    public Path getAddressBookFilePath() {
        return addressBookStorage.getAddressBookFilePath();
    }

    @Override
    public Optional<ReadOnlyAddressBook> readAddressBook() throws DataConversionException, IOException {
        return readAddressBook(addressBookStorage.getAddressBookFilePath());
    }

    @Override
    public Optional<ReadOnlyAddressBook> readAddressBook(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read address data from file: " + filePath);
        return addressBookStorage.readAddressBook(filePath);
    }

    @Override
    public void saveAddressBook(ReadOnlyAddressBook addressBook) throws IOException {
        saveAddressBook(addressBook, addressBookStorage.getAddressBookFilePath());
    }

    @Override
    public void saveAddressBook(ReadOnlyAddressBook addressBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to addressbook data file: " + filePath);
        addressBookStorage.saveAddressBook(addressBook, filePath);
    }


    // ================ Schedule methods ==============================

    @Override
    public Path getScheduleFilePath() {
        return scheduleStorage.getScheduleFilePath();
    }

    @Override
    public Optional<ReadOnlySchedule> readSchedule() throws DataConversionException, IOException {
        return readSchedule(scheduleStorage.getScheduleFilePath());
    }

    @Override
    public Optional<ReadOnlySchedule> readSchedule(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read address schedule from file: " + filePath);
        return scheduleStorage.readSchedule(filePath);
    }

    @Override
    public void saveSchedule(ReadOnlySchedule schedule) throws IOException {
        saveSchedule(schedule, scheduleStorage.getScheduleFilePath());
    }

    @Override
    public void saveSchedule(ReadOnlySchedule schedule, Path filePath) throws IOException {
        logger.fine("Attempting to write to schedule data file: " + filePath);
        scheduleStorage.saveSchedule(schedule, filePath);
    }

    // ================ FlashcardBank methods ==============================

    @Override
    public Path getFlashcardBankFilePath() {
        return flashcardBankStorage.getFlashcardBankFilePath();
    }

    @Override
    public Optional<ReadOnlyFlashcardBank> readFlashcardBank() throws DataConversionException, IOException {
        return readFlashcardBank(flashcardBankStorage.getFlashcardBankFilePath());
    }

    @Override
    public Optional<ReadOnlyFlashcardBank> readFlashcardBank(Path filePath) throws
            DataConversionException, IOException {
        logger.fine("Attempting to read FlashcardBank from file: " + filePath);
        return flashcardBankStorage.readFlashcardBank(filePath);
    }

    @Override
    public void saveFlashcardBank(ReadOnlyFlashcardBank flashcardBank) throws IOException {
        saveFlashcardBank(flashcardBank, flashcardBankStorage.getFlashcardBankFilePath());
    }

    @Override
    public void saveFlashcardBank(ReadOnlyFlashcardBank flashcardBank, Path filePath) throws IOException {
        logger.fine("Attempting to write to FlashcardBank data file: " + filePath);
        flashcardBankStorage.saveFlashcardBank(flashcardBank, filePath);
    }

    @Override
    public Path getQuizRecordsFilePath() {
        return null;
    }

    @Override
    public Optional<ReadOnlyQuizRecords> readQuizRecords() throws DataConversionException, IOException {
        return Optional.empty();
    }

    @Override
    public void saveQuizRecords(ReadOnlyQuizRecords quizRecords) throws IOException {

    }
}
