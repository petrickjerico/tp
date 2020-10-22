package seedu.address.storage.quizstorage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.systemlevelmodel.ReadOnlyQuizRecords;

public interface QuizRecordsStorage {

    Path getQuizRecordsFilePath();

    Optional<ReadOnlyQuizRecords> readQuizRecords() throws DataConversionException, IOException;

    Optional<ReadOnlyQuizRecords> readQuizRecords(Path filePath) throws
            DataConversionException, IOException;

    void saveQuizRecords(ReadOnlyQuizRecords quizRecords) throws IOException;

    void saveQuizRecords(ReadOnlyQuizRecords quizRecords, Path filePath) throws IOException;
}
