package seedu.studybananas.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.studybananas.commons.core.LogsCenter;
import seedu.studybananas.commons.exceptions.DataConversionException;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyFlashcardBank;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyQuizRecords;
import seedu.studybananas.model.systemlevelmodel.ReadOnlySchedule;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyUserPrefs;
import seedu.studybananas.model.systemlevelmodel.UserPrefs;
import seedu.studybananas.storage.flashcardstorage.FlashcardBankStorage;
import seedu.studybananas.storage.quizstorage.QuizRecordsStorage;
import seedu.studybananas.storage.schedulestorage.ScheduleStorage;

/**
 * Manages storage of StudyBananas data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private final ScheduleStorage scheduleStorage;
    private final UserPrefsStorage userPrefsStorage;
    private final FlashcardBankStorage flashcardBankStorage;
    private final QuizRecordsStorage quizRecordsStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code ScheduleStorage}, {@code FlashcardBankStorage},
     * {@code QuizRecordsStorage}, and {@code UserPrefStorage}.
     */
    public StorageManager(ScheduleStorage scheduleStorage, FlashcardBankStorage flashcardBankStorage,
                          QuizRecordsStorage quizRecordsStorage, UserPrefsStorage userPrefsStorage) {
        this.userPrefsStorage = userPrefsStorage;
        this.scheduleStorage = scheduleStorage;
        this.flashcardBankStorage = flashcardBankStorage;
        this.quizRecordsStorage = quizRecordsStorage;
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
        logger.fine("Attempting to read schedule from file: " + filePath);
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

    // ================ QuizRecords methods ==============================

    @Override
    public Path getQuizRecordsFilePath() {
        return quizRecordsStorage.getQuizRecordsFilePath();
    }

    @Override
    public Optional<ReadOnlyQuizRecords> readQuizRecords() throws DataConversionException, IOException {
        return readQuizRecords(quizRecordsStorage.getQuizRecordsFilePath());
    }

    @Override
    public Optional<ReadOnlyQuizRecords> readQuizRecords(Path filePath) throws
            DataConversionException, IOException {
        logger.fine("Attempting to read Quiz Records from file: " + filePath);
        return quizRecordsStorage.readQuizRecords(filePath);
    }

    @Override
    public void saveQuizRecords(ReadOnlyQuizRecords quizRecords) throws IOException {
        saveQuizRecords(quizRecords, quizRecordsStorage.getQuizRecordsFilePath());
    }

    @Override
    public void saveQuizRecords(ReadOnlyQuizRecords quizRecords, Path filePath) throws IOException {
        logger.fine("Attempting to write to Quiz Records data file: " + filePath);
        quizRecordsStorage.saveQuizRecords(quizRecords, filePath);
    }
}
