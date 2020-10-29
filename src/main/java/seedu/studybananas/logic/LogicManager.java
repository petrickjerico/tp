package seedu.studybananas.logic;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.studybananas.commons.core.GuiSettings;
import seedu.studybananas.commons.core.LogsCenter;
import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.logic.parser.StudyBananasParser;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.model.Model;
import seedu.studybananas.model.flashcard.Flashcard;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.quiz.Quiz;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyFlashcardBank;
import seedu.studybananas.model.systemlevelmodel.ReadOnlySchedule;
import seedu.studybananas.model.task.Task;
import seedu.studybananas.storage.Storage;

/**
 * The main LogicManager of the app.
 */
public class LogicManager implements Logic {
    public static final String FILE_OPS_ERROR_MESSAGE = "Could not save data to file: ";
    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    private final Model model;
    private final Storage storage;
    private final StudyBananasParser studyBananasParser;

    /**
     * Constructs a {@code LogicManager} with the given {@code Model} and {@code Storage}.
     */
    public LogicManager(Model model, Storage storage) {
        this.model = model;
        this.storage = storage;
        studyBananasParser = new StudyBananasParser();
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");

        CommandResult commandResult;
        Command<? super Model> command = studyBananasParser.parseCommand(commandText, model.hasStarted());
        commandResult = command.execute(model);

        try {
            storage.saveSchedule(model.getSchedule());
            storage.saveFlashcardBank(model.getFlashcardBank());
            storage.saveQuizRecords(model.getAllQuizRecords());
        } catch (IOException ioe) {
            throw new CommandException(FILE_OPS_ERROR_MESSAGE + ioe, ioe);
        }

        return commandResult;
    }

    @Override
    public CommandResult execute(Command command) throws CommandException {
        logger.info("----------------[USER COMMAND][" + command + "]");

        CommandResult commandResult;
        commandResult = command.execute(model);

        try {
            storage.saveSchedule(model.getSchedule());
            storage.saveFlashcardBank(model.getFlashcardBank());
            storage.saveQuizRecords(model.getAllQuizRecords());
        } catch (IOException ioe) {
            throw new CommandException(FILE_OPS_ERROR_MESSAGE + ioe, ioe);
        }

        return commandResult;
    }

    @Override
    public FlashcardSet getFlashcardSetFromIndex(Index idx) {
        return model.getFlashcardSet(idx);
    }



    @Override
    public Command parse(String commandText) throws ParseException {
        return studyBananasParser.parseCommand(commandText, false);
    }

    @Override
    public ReadOnlySchedule getSchedule() {
        return model.getSchedule();
    }

    @Override
    public ObservableList<Task> getFilteredTaskList() {
        return model.getFilteredTaskList();
    }

    @Override
    public ObservableList<Task> getUpcomingTaskList() {
        return model.getUpcomingTaskList();
    }

    @Override
    public Path getScheduleFilePath() {
        return model.getScheduleFilePath();
    }

    @Override
    public ReadOnlyFlashcardBank getFlashcardBank() {
        return model.getFlashcardBank();
    }

    @Override
    public ObservableList<FlashcardSet> getFilteredFlashcardSetList() {
        return model.getFilteredFlashcardSetList();
    }

    @Override
    public Path getFlashcardBankFilePath() {
        return model.getFlashcardBankFilePath();
    }

    @Override
    public ObservableList<Flashcard> getFlashcardSetToView() {
        return model.getFlashcardSetToView();
    }

    @Override
    public void setFlashcardSetToView(FlashcardSet flashcardSet) {
        model.setFlashcardSetToView(flashcardSet);
    }

    @Override
    public Quiz getQuizRecordsToView() {
        return model.getQuizRecordsToView();
    }

    @Override
    public GuiSettings getGuiSettings() {
        return model.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        model.setGuiSettings(guiSettings);
    }
}
