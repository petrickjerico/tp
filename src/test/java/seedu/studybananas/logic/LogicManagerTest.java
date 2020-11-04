package seedu.studybananas.logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.studybananas.commons.core.Messages.MESSAGE_INVALID_FLASHCARDSET_DISPLAYED_INDEX;
import static seedu.studybananas.commons.core.Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX;
import static seedu.studybananas.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.NAME_DESC_PHYSICS;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.VALID_FLSET_NAME_PHYSICS;
import static seedu.studybananas.logic.commands.commandtestutils.ScheduleCommandTestUtil.DATETIME_DESC_CS2103T;
import static seedu.studybananas.logic.commands.commandtestutils.ScheduleCommandTestUtil.DESCRIPTION_DESC_CS2103T;
import static seedu.studybananas.logic.commands.commandtestutils.ScheduleCommandTestUtil.DURATION;
import static seedu.studybananas.logic.commands.commandtestutils.ScheduleCommandTestUtil.TITLE_DESC_CS2103T;
import static seedu.studybananas.logic.commands.commandtestutils.ScheduleCommandTestUtil.VALID_DATETIME_CS2103T;
import static seedu.studybananas.logic.commands.commandtestutils.ScheduleCommandTestUtil.VALID_DESCRIPTION_CS2103T;
import static seedu.studybananas.logic.commands.commandtestutils.ScheduleCommandTestUtil.VALID_DURATION;
import static seedu.studybananas.logic.commands.commandtestutils.ScheduleCommandTestUtil.VALID_TITLE_CS2103T;
import static seedu.studybananas.testutil.Assert.assertThrows;

import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.logic.commands.flashcardcommands.AddFlashcardSetCommand;
import seedu.studybananas.logic.commands.quizcommands.StartCommand;
import seedu.studybananas.logic.commands.schedulecommands.ScheduleAddCommand;
import seedu.studybananas.logic.commands.schedulecommands.ScheduleListCommand;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.model.Model;
import seedu.studybananas.model.ModelManager;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.systemlevelmodel.FlashcardBank;
import seedu.studybananas.model.systemlevelmodel.QuizRecords;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyFlashcardBank;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyQuizRecords;
import seedu.studybananas.model.systemlevelmodel.ReadOnlySchedule;
import seedu.studybananas.model.systemlevelmodel.Schedule;
import seedu.studybananas.model.systemlevelmodel.UserPrefs;
import seedu.studybananas.model.task.Task;
import seedu.studybananas.storage.JsonUserPrefsStorage;
import seedu.studybananas.storage.StorageManager;
import seedu.studybananas.storage.flashcardstorage.JsonFlashcardBankStorage;
import seedu.studybananas.storage.quizstorage.JsonQuizRecordsStorage;
import seedu.studybananas.storage.schedulestorage.JsonScheduleStorage;
import seedu.studybananas.testutil.FlashcardSetBuilder;
import seedu.studybananas.testutil.TaskBuilder;

public class LogicManagerTest {
    private static final IOException DUMMY_IO_EXCEPTION = new IOException("dummy exception");

    @TempDir
    public Path temporaryFolder;

    private final Model model = new ModelManager();
    private Logic logic;

    @BeforeEach
    public void setUp() {
        JsonScheduleStorage scheduleStorage =
                new JsonScheduleStorage(temporaryFolder.resolve("schedule.json"));
        JsonFlashcardBankStorage flashcardBankStorage =
                new JsonFlashcardBankStorage(temporaryFolder.resolve("flashcardbank.json"));
        JsonQuizRecordsStorage quizRecordsStorage =
                new JsonQuizRecordsStorage(temporaryFolder.resolve("quizrecords.json"));
        JsonUserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(temporaryFolder.resolve("userPrefs.json"));
        StorageManager storage = new StorageManager(scheduleStorage, flashcardBankStorage,
                quizRecordsStorage, userPrefsStorage);
        logic = new LogicManager(model, storage);
    }

    @Test
    public void execute_invalidCommandFormat_throwsParseException() {
        String invalidCommand = "uicfhmowqewca";
        assertParseException(invalidCommand, MESSAGE_UNKNOWN_COMMAND);
    }

    @Test
    public void parse_invalidCommandFormat_throwsParseException() {
        String invalidCommand = "uicfhmowqewca";
        assertThrows(ParseException.class, () -> logic.parse(invalidCommand));
    }

    @Test
    public void execute_scheduleCommandExecutionError_throwsCommandException() {
        String deleteTaskCommand = "delete task 15";
        assertCommandException(deleteTaskCommand, MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
    }

    @Test
    public void execute_flashcardCommandExecutionError_throwsCommandException() {
        String addFlashcardCommand = "add fl flset:9 q:konnichiwa a:hello";
        assertCommandException(addFlashcardCommand, MESSAGE_INVALID_FLASHCARDSET_DISPLAYED_INDEX);
    }

    @Test
    public void execute_quizCommandExecutionError_throwsCommandException() {
        String quizCommand = "quiz flset:5";
        assertCommandException(quizCommand, StartCommand.MESSAGE_FLASHCARD_SET_NONEXISTENT);
    }

    @Test
    public void execute_validScheduleCommand_success() throws Exception {
        String listTaskCommand = ScheduleListCommand.COMMAND_WORD;
        assertCommandSuccess(listTaskCommand, ScheduleListCommand.MESSAGE_SUCCESS, model);
    }

    @Test
    public void execute_quizCommandExecution_success() throws Exception {
        StartCommand startQuizCommand = new StartCommand(1);
        assertCommandObjectException(startQuizCommand, StartCommand.MESSAGE_FLASHCARD_SET_NONEXISTENT);
    }

    @Test
    public void getFilteredTaskList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> logic.getFilteredTaskList().remove(0));
    }

    @Test
    public void getFilteredFlashcardSetList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> logic.getFilteredFlashcardSetList().remove(0));
    }

    @Test
    public void getFlashcardSetToView_modifyList_throwsIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> logic.getFlashcardSetToView().remove(0));
    }

    @Test
    public void getQuizRecordsToView_equalsNull() {
        assertEquals(null, logic.getQuizRecordsToView());
    }

    @Test
    public void getFlashcardBank_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () ->
                logic.getFlashcardBank().getFlashcardSetList().remove(0));
    }

    @Test
    public void getSchedule_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () ->
                logic.getSchedule().getTaskList().remove(0));
    }

    @Test
    public void getUpcomingTaskList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> logic.getUpcomingTaskList().remove(0));
    }

    @Test
    public void execute_storageThrowsIoException_throwsCommandException() {
        // Setup LogicManager with JsonScheduleStorageIoExceptionThrowingStub,
        // JsonFlashcardBankStorageIoExceptionThrowingStub and
        // JsonQuizRecordsStorageIoExceptionThrowingStub
        JsonScheduleStorage scheduleStorage =
                new JsonScheduleStorageIoExceptionThrowingStub(
                        temporaryFolder.resolve("ioExceptionSchedule.json"));
        JsonFlashcardBankStorage flashcardBankStorage =
                new JsonFlashcardBankStorageIoExceptionThrowingStub(
                        temporaryFolder.resolve("ioExceptionFlashcardBank.json"));
        JsonQuizRecordsStorage quizRecordsStorage =
                new JsonQuizRecordsStorageIoExceptionThrowingStub(
                        temporaryFolder.resolve("ioExceptionQuizRecords.json"));
        JsonUserPrefsStorage userPrefsStorage =
                new JsonUserPrefsStorage(temporaryFolder.resolve("ioExceptionUserPrefs.json"));
        StorageManager storage = new StorageManager(scheduleStorage, flashcardBankStorage,
                quizRecordsStorage, userPrefsStorage);
        logic = new LogicManager(model, storage);

        // Execute add task command
        String addTaskCommand = ScheduleAddCommand.COMMAND_WORD + TITLE_DESC_CS2103T
                + DESCRIPTION_DESC_CS2103T + DATETIME_DESC_CS2103T
                + DURATION;
        Task expectedTask = new TaskBuilder().withTitle(VALID_TITLE_CS2103T)
                .withDescription(VALID_DESCRIPTION_CS2103T)
                .withDateTime(VALID_DATETIME_CS2103T)
                .withDuration(VALID_DURATION)
                .build();
        ModelManager expectedModel = new ModelManager();
        expectedModel.addTask(expectedTask);
        String expectedMessage = LogicManager.FILE_OPS_ERROR_MESSAGE + DUMMY_IO_EXCEPTION;
        assertCommandFailure(addTaskCommand, CommandException.class, expectedMessage, expectedModel);

        // Execute add flashcard set command
        String addFlashcardSetCommand = AddFlashcardSetCommand.COMMAND_WORD + NAME_DESC_PHYSICS;
        FlashcardSet expectedFlashcardSet = new FlashcardSetBuilder()
                .withFlashcardSetName(VALID_FLSET_NAME_PHYSICS).build();
        expectedModel.addFlashcardSet(expectedFlashcardSet);
        assertCommandFailure(addFlashcardSetCommand, CommandException.class, expectedMessage, expectedModel);
    }

    /**
     * Executes the command and confirms that
     * - no exceptions are thrown <br>
     * - the feedback message is equal to {@code expectedMessage} <br>
     * - the internal model manager state is the same as that in {@code expectedModel} <br>
     * @see #assertCommandFailure(String, Class, String, Model)
     */
    private void assertCommandSuccess(String inputCommand, String expectedMessage,
            Model expectedModel) throws CommandException, ParseException {
        CommandResult result = logic.execute(inputCommand);
        assertEquals(expectedModel, model);
    }

    /**
     * Executes the command, confirms that a ParseException is thrown and that the result message is correct.
     * @see #assertCommandFailure(String, Class, String, Model)
     */
    private void assertParseException(String inputCommand, String expectedMessage) {
        assertCommandFailure(inputCommand, ParseException.class, expectedMessage);
    }

    /**
     * Executes the command, confirms that a CommandException is thrown and that the result message is correct.
     * @see #assertCommandFailure(String, Class, String, Model)
     */
    private void assertCommandException(String inputCommand, String expectedMessage) {
        assertCommandFailure(inputCommand, CommandException.class, expectedMessage);
    }

    /**
     * Executes the command, confirms that a CommandException is thrown and that the result message is correct.
     * @see #assertCommandObjectFailure(Command, Class, String, Model)
     */
    private void assertCommandObjectException(Command inputCommand, String expectedMessage) {
        assertCommandObjectFailure(inputCommand, CommandException.class, expectedMessage);
    }

    /**
     * Executes the command, confirms that the exception is thrown and that the result message is correct.
     * @see #assertCommandFailure(String, Class, String, Model)
     */
    private void assertCommandFailure(String inputCommand, Class<? extends Throwable> expectedException,
            String expectedMessage) {
        Model expectedModel = new ModelManager(new UserPrefs(),
                new Schedule(), new FlashcardBank(), new QuizRecords());
        assertCommandFailure(inputCommand, expectedException, expectedMessage, expectedModel);
    }

    /**
     * Executes the command, confirms that the exception is thrown and that the result message is correct.
     * @see #assertCommandObjectFailure(Command, Class, String, Model)
     */
    private void assertCommandObjectFailure(Command inputCommand, Class<? extends Throwable> expectedException,
                                      String expectedMessage) {
        Model expectedModel = new ModelManager(new UserPrefs(),
                new Schedule(), new FlashcardBank(), new QuizRecords());
        assertCommandObjectFailure(inputCommand, expectedException, expectedMessage, expectedModel);
    }

    /**
     * Executes the command and confirms that
     * - the {@code expectedException} is thrown <br>
     * - the resulting error message is equal to {@code expectedMessage} <br>
     * - the internal model manager state is the same as that in {@code expectedModel} <br>
     * @see #assertCommandSuccess(String, String, Model)
     */
    private void assertCommandFailure(String inputCommand, Class<? extends Throwable> expectedException,
            String expectedMessage, Model expectedModel) {
        assertThrows(expectedException, expectedMessage, () -> logic.execute(inputCommand));
        assertEquals(expectedModel, model);
    }

    /**
     * Executes the command and confirms that
     * - the {@code expectedException} is thrown <br>
     * - the resulting error message is equal to {@code expectedMessage} <br>
     * - the internal model manager state is the same as that in {@code expectedModel} <br>
     */
    private void assertCommandObjectFailure(Command inputCommand, Class<? extends Throwable> expectedException,
                                      String expectedMessage, Model expectedModel) {
        assertThrows(expectedException, expectedMessage, () -> logic.execute(inputCommand));
        assertEquals(expectedModel, model);
    }

    private static class JsonFlashcardBankStorageIoExceptionThrowingStub extends JsonFlashcardBankStorage {
        private JsonFlashcardBankStorageIoExceptionThrowingStub(Path filePath) {
            super(filePath);
        }

        @Override
        public void saveFlashcardBank(ReadOnlyFlashcardBank flashcardBank, Path filePath) throws IOException {
            throw DUMMY_IO_EXCEPTION;
        }
    }

    private static class JsonScheduleStorageIoExceptionThrowingStub extends JsonScheduleStorage {
        private JsonScheduleStorageIoExceptionThrowingStub(Path filePath) {
            super(filePath);
        }

        @Override
        public void saveSchedule(ReadOnlySchedule schedule, Path filePath) throws IOException {
            throw DUMMY_IO_EXCEPTION;
        }
    }

    private static class JsonQuizRecordsStorageIoExceptionThrowingStub extends JsonQuizRecordsStorage {
        private JsonQuizRecordsStorageIoExceptionThrowingStub(Path filePath) {
            super(filePath);
        }

        @Override
        public void saveQuizRecords(ReadOnlyQuizRecords quizRecords, Path filePath) throws IOException {
            throw DUMMY_IO_EXCEPTION;
        }
    }
}
