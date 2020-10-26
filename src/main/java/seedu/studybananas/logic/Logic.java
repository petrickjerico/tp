package seedu.studybananas.logic;

import java.nio.file.Path;

import javafx.collections.ObservableList;
import seedu.studybananas.commons.core.GuiSettings;
import seedu.studybananas.logic.commands.CommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.model.Model;
import seedu.studybananas.model.flashcard.Flashcard;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.quiz.Quiz;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyFlashcardBank;
import seedu.studybananas.model.systemlevelmodel.ReadOnlySchedule;
import seedu.studybananas.model.task.Task;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, ParseException;

    /**
     * Returns the Schedule.
     *
     * @see Model#getSchedule()
     */
    ReadOnlySchedule getSchedule();

    /** Returns an unmodifiable view of the filtered list of tasks */
    ObservableList<Task> getFilteredTaskList();

    /** Returns an unmodifiable view of the filtered list of tasks */
    ObservableList<Task> getUpcomingTaskList();

    /**
     * Returns the user prefs' schedule file path.
     */
    Path getScheduleFilePath();



    /**
     * Returns the Flashcard Bank.
     *
     * @see Model#getFlashcardBank() ()
     */
    ReadOnlyFlashcardBank getFlashcardBank();

    /** Returns an unmodifiable view of the filtered list of flashcard sets */
    ObservableList<FlashcardSet> getFilteredFlashcardSetList();

    /**
     * Returns the user prefs' flashcard bank file path.
     */
    Path getFlashcardBankFilePath();

    /** Returns the selected flashcards to view */
    ObservableList<Flashcard> getFlashcardSetToView();


    /**
     * Returns the quiz queried.
     */
    Quiz getQuizRecordsToView();


    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);


}
