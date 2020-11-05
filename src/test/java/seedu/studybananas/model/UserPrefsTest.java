package seedu.studybananas.model;

import static seedu.studybananas.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.studybananas.model.systemlevelmodel.UserPrefs;

public class UserPrefsTest {

    @Test
    public void setGuiSettings_nullGuiSettings_throwsNullPointerException() {
        UserPrefs userPref = new UserPrefs();
        assertThrows(NullPointerException.class, () -> userPref.setGuiSettings(null));
    }

    @Test
    public void setScheduleFilePath_nullPath_throwsNullPointerException() {
        UserPrefs userPrefs = new UserPrefs();
        assertThrows(NullPointerException.class, () -> userPrefs.setScheduleFilePath(null));
    }

    @Test
    public void setFlashcardBankFilePath_nullPath_throwsNullPointerException() {
        UserPrefs userPrefs = new UserPrefs();
        assertThrows(NullPointerException.class, () -> userPrefs.setFlashcardBankFilePath(null));
    }

    @Test
    public void setQuizRecordsFilePath_nullPath_throwsNullPointerException() {
        UserPrefs userPrefs = new UserPrefs();
        assertThrows(NullPointerException.class, () -> userPrefs.setQuizRecordsFilePath(null));
    }
}
