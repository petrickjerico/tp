package seedu.address.storage.flashcardstorage;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.FileUtil;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.systemlevelmodel.ReadOnlyFlashcardBank;


public class JsonFlashcardBankStorage implements FlashcardBankStorage {

    private static final Logger logger = LogsCenter.getLogger(JsonFlashcardBankStorage.class);

    private final Path filePath;

    public JsonFlashcardBankStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getFlashcardBankFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyFlashcardBank> readFlashcardBank() throws DataConversionException {
        return readFlashcardBank(filePath);
    }

    /**
     * Similar to {@link #readFlashcardBank()}.
     *
     * @param filePath location of the data. Cannot be null.
     * @throws DataConversionException if the file is not in the correct format.
     */
    public Optional<ReadOnlyFlashcardBank> readFlashcardBank(Path filePath) throws DataConversionException {
        requireNonNull(filePath);

        Optional<JsonSerializableFlashcardBank> jsonFlashcardBank = JsonUtil.readJsonFile(
                filePath, JsonSerializableFlashcardBank.class);
        if (!jsonFlashcardBank.isPresent()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonFlashcardBank.get().toModelType());
        } catch (IllegalValueException | IllegalArgumentException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataConversionException(ive);
        }
    }

    @Override
    public void saveFlashcardBank(ReadOnlyFlashcardBank flashcardBank) throws IOException {
        saveFlashcardBank(flashcardBank, filePath);
    }

    /**
     * Similar to {@link #saveFlashcardBank(ReadOnlyFlashcardBank)}.
     *
     * @param filePath location of the data. Cannot be null.
     */
    public void saveFlashcardBank(ReadOnlyFlashcardBank flashcardBank, Path filePath) throws IOException {
        requireNonNull(flashcardBank);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableFlashcardBank(flashcardBank), filePath);
    }
}
