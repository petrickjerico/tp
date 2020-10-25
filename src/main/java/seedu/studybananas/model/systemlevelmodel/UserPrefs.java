package seedu.studybananas.model.systemlevelmodel;

import static java.util.Objects.requireNonNull;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import seedu.studybananas.commons.core.GuiSettings;

/**
 * Represents User's preferences.
 */
public class UserPrefs implements ReadOnlyUserPrefs {

    private GuiSettings guiSettings = new GuiSettings();
    private Path addressBookFilePath = Paths.get("data" , "addressbook.json").toAbsolutePath();
    private Path scheduleFilePath = Paths.get("data", "schedule.json").toAbsolutePath();
    private Path flashcardBankFilePath = Paths.get("data", "flashcardbank.json").toAbsolutePath();
    private Path quizRecordsFilePath = Paths.get("data", "quizrecords.json").toAbsolutePath();

    /**
     * Creates a {@code UserPrefs} with default values.
     */
    public UserPrefs() {}

    /**
     * Creates a {@code UserPrefs} with the prefs in {@code userPrefs}.
     */
    public UserPrefs(ReadOnlyUserPrefs userPrefs) {
        this();
        resetData(userPrefs);
    }

    /**
     * Resets the existing data of this {@code UserPrefs} with {@code newUserPrefs}.
     */
    public void resetData(ReadOnlyUserPrefs newUserPrefs) {
        requireNonNull(newUserPrefs);
        setGuiSettings(newUserPrefs.getGuiSettings());
        setAddressBookFilePath(newUserPrefs.getAddressBookFilePath());
    }

    public GuiSettings getGuiSettings() {
        return guiSettings;
    }

    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        this.guiSettings = guiSettings;
    }

    public Path getAddressBookFilePath() {
        return addressBookFilePath;
    }

    public void setAddressBookFilePath(Path addressBookFilePath) {
        requireNonNull(addressBookFilePath);
        this.addressBookFilePath = addressBookFilePath;
    }

    public Path getScheduleFilePath() {
        return scheduleFilePath;
    }

    public void setScheduleFilePath(Path scheduleFilePath) {
        requireNonNull(scheduleFilePath);
        this.scheduleFilePath = scheduleFilePath;
    }

    public Path getFlashcardBankFilePath() {
        return flashcardBankFilePath;
    }

    public void setFlashcardBankFilePath(Path flashcardBankFilePath) {
        requireNonNull(flashcardBankFilePath);
        this.flashcardBankFilePath = flashcardBankFilePath;
    }

    public Path getQuizRecordsFilePath() {
        return quizRecordsFilePath;
    }

    public void setQuizRecordsFilePath(Path quizRecordsFilePath) {
        requireNonNull(quizRecordsFilePath);
        this.quizRecordsFilePath = quizRecordsFilePath;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof UserPrefs)) { //this handles null as well.
            return false;
        }

        UserPrefs o = (UserPrefs) other;

        return guiSettings.equals(o.guiSettings)
                && addressBookFilePath.equals(o.addressBookFilePath)
                && scheduleFilePath.equals(o.scheduleFilePath)
                && flashcardBankFilePath.equals(o.flashcardBankFilePath)
                && quizRecordsFilePath.equals(o.quizRecordsFilePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guiSettings, addressBookFilePath,
                scheduleFilePath, flashcardBankFilePath, quizRecordsFilePath);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gui Settings : " + guiSettings);
        sb.append("\nLocal addressbook data file location : " + addressBookFilePath);
        sb.append("\nLocal schedule data file location : " + scheduleFilePath);
        sb.append("\nLocal flashcardbank data file location : " + flashcardBankFilePath);
        sb.append("\nLocal quizrecords data file location : " + quizRecordsFilePath);
        return sb.toString();
    }

}
