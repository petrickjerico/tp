package seedu.studybananas.model.systemlevelmodel;

import java.nio.file.Path;

import seedu.studybananas.commons.core.GuiSettings;

/**
 * Unmodifiable view of user prefs.
 */
public interface ReadOnlyUserPrefs {

    GuiSettings getGuiSettings();

    Path getAddressBookFilePath();
    Path getScheduleFilePath();
    Path getFlashcardBankFilePath();
}
