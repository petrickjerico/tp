package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.systemlevelmodel.ReadOnlyAddressBook;
import seedu.address.model.systemlevelmodel.ReadOnlyFlashcardBank;
import seedu.address.model.systemlevelmodel.ReadOnlySchedule;
import seedu.address.model.systemlevelmodel.ReadOnlyUserPrefs;
import seedu.address.model.systemlevelmodel.UserPrefs;
import seedu.address.storage.flashcardstorage.FlashcardBankStorage;
import seedu.address.storage.schedulestorage.ScheduleStorage;

/**
 * API of the Storage component
 */
public interface Storage extends AddressBookStorage, UserPrefsStorage, ScheduleStorage, FlashcardBankStorage {

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getAddressBookFilePath();

    @Override
    Optional<ReadOnlyAddressBook> readAddressBook() throws DataConversionException, IOException;

    @Override
    void saveAddressBook(ReadOnlyAddressBook addressBook) throws IOException;

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

}
