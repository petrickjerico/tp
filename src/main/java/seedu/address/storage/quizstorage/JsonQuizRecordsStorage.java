package seedu.address.storage.quizstorage;

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
import seedu.address.model.systemlevelmodel.ReadOnlyQuizRecords;

public class JsonQuizRecordsStorage implements QuizRecordsStorage {

    private static final Logger logger = LogsCenter.getLogger(JsonQuizRecordsStorage.class);

    private final Path filePath;

    public JsonQuizRecordsStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getQuizRecordsFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyQuizRecords> readQuizRecords() throws DataConversionException {
        return readQuizRecords(filePath);
    }

    /**
     * Similar to {@link #readQuizRecords}.
     *
     * @param filePath location of the data. Cannot be null.
     * @throws DataConversionException if the file is not in the correct format.
     */
    @Override
    public Optional<ReadOnlyQuizRecords> readQuizRecords(Path filePath) throws DataConversionException {
        requireNonNull(filePath);

        Optional<JsonSerializableQuizRecords> jsonQuizRecords = JsonUtil.readJsonFile(
                filePath, JsonSerializableQuizRecords.class);
        if (!jsonQuizRecords.isPresent()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonQuizRecords.get().toModelType());
        } catch (IllegalValueException | IllegalArgumentException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataConversionException(ive);
        }
    }

    @Override
    public void saveQuizRecords(ReadOnlyQuizRecords quizRecords) throws IOException {
        saveQuizRecords(quizRecords, filePath);
    }

    /**
     * Similar to {@link #saveQuizRecords(ReadOnlyQuizRecords)}.
     *
     * @param filePath location of the data. Cannot be null.
     */
    @Override
    public void saveQuizRecords(ReadOnlyQuizRecords quizRecords, Path filePath) throws IOException {
        requireNonNull(quizRecords);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableQuizRecords(quizRecords), filePath);
    }
}
