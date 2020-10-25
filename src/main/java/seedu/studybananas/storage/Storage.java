package seedu.studybananas.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

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
 * API of the Storage component
 */
public interface Storage extends UserPrefsStorage, ScheduleStorage,
        FlashcardBankStorage, QuizRecordsStorage {

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getScheduleFilePath();

    @Override
    Optional<ReadOnlySchedule> readSchedule() throws DataConversionException, IOException;

    @Override
    void saveSchedule(ReadOnlySchedule schedule) throws IOException;

    @Override
    Path getFlashcardBankFilePath();

    @Override
    Optional<ReadOnlyFlashcardBank> readFlashcardBank() throws DataConversionException, IOException;

    @Override
    void saveFlashcardBank(ReadOnlyFlashcardBank flashcardBank) throws IOException;

    @Override
    Path getQuizRecordsFilePath();

    @Override
    Optional<ReadOnlyQuizRecords> readQuizRecords() throws DataConversionException, IOException;

    @Override
    void saveQuizRecords(ReadOnlyQuizRecords quizRecords) throws IOException;

}
