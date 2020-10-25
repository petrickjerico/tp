package seedu.studybananas.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import seedu.studybananas.commons.core.GuiSettings;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyUserPrefs;

/**
 * The API of the Model component.
 */
public interface Model extends ScheduleModel, FlashcardModel, QuizModel {

    /** {@code Predicate} that always evaluate to true */
    Predicate<FlashcardSet> PREDICATE_SHOW_ALL_FLASHCARDSETS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' schedule file path.
     */
    Path getScheduleFilePath();

    /**
     * Sets the user prefs' schedule file path.
     */
    void setScheduleFilePath(Path scheduleFilePath);

    /**
     * Returns the user prefs' flashcard bank file path.
     */
    Path getFlashcardBankFilePath();

    /**
     * Sets the user prefs' flashcard bank file path.
     */
    void setFlashcardBankFilePath(Path flashcardBankFilePath);
}
