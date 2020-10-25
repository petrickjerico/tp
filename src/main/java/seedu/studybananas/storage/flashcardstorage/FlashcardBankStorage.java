package seedu.studybananas.storage.flashcardstorage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.studybananas.commons.exceptions.DataConversionException;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyFlashcardBank;

/**
 * Represents a storage for {@link ReadOnlyFlashcardBank}.
 */
public interface FlashcardBankStorage {
    /**
     * Returns the file path of the data file.
     */
    Path getFlashcardBankFilePath();

    /**
     * Returns FlashcardBank data as a {@link ReadOnlyFlashcardBank}.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<ReadOnlyFlashcardBank> readFlashcardBank() throws DataConversionException, IOException;

    /**
     * @see #getFlashcardBankFilePath()
     */
    Optional<ReadOnlyFlashcardBank> readFlashcardBank(Path filePath) throws DataConversionException, IOException;

    /**
     * Saves the given {@link ReadOnlyFlashcardBank} to the storage.
     * @param schedule cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveFlashcardBank(ReadOnlyFlashcardBank schedule) throws IOException;

    /**
     * @see #saveFlashcardBank(ReadOnlyFlashcardBank)
     */
    void saveFlashcardBank(ReadOnlyFlashcardBank schedule, Path filePath) throws IOException;
}
