package seedu.address.logic;

import java.nio.file.Path;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.flashcard.FlashcardSet;
import seedu.address.model.person.Person;
import seedu.address.model.systemlevelmodel.ReadOnlyAddressBook;
import seedu.address.model.systemlevelmodel.ReadOnlyFlashcardBank;
import seedu.address.model.systemlevelmodel.ReadOnlySchedule;
import seedu.address.model.task.Task;

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
     * Returns the AddressBook.
     *
     * @see seedu.address.model.Model#getAddressBook()
     */
    ReadOnlyAddressBook getAddressBook();

    /** Returns an unmodifiable view of the filtered list of persons */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();



    /**
     * Returns the Schedule.
     *
     * @see seedu.address.model.Model#getSchedule()
     */
    ReadOnlySchedule getSchedule();

    /** Returns an unmodifiable view of the filtered list of tasks */
    ObservableList<Task> getFilteredTaskList();

    /**
     * Returns the user prefs' schedule file path.
     */
    Path getScheduleFilePath();



    /**
     * Returns the Flashcard Bank.
     *
     * @see seedu.address.model.Model#getSchedule()
     */
    ReadOnlyFlashcardBank getFlashcardBank();

    /** Returns an unmodifiable view of the filtered list of flashcard sets */
    ObservableList<FlashcardSet> getFilteredFlashcardSetList();

    /**
     * Returns the user prefs' flashcard bank file path.
     */
    Path getFlashcardBankFilePath();

    /** Returns the selected flashcards to view */
    FlashcardSet getFlashcardSetToView();


    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);


}
