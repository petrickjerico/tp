package seedu.studybananas.ui.util;

import seedu.studybananas.ui.CommandBox;

public class GlobalState {
    private static GlobalState instance;
    private CommandBox scheduleCommandBox;
    private CommandBox flashcardCommandBox;
    private CommandBox quizCommandBox;


    private GlobalState() { }

    public static synchronized GlobalState getInstance() {
        if (instance == null) {
            instance = new GlobalState();
        }
        return instance;
    }
    public void setScheduleCommandBox(CommandBox scheduleCommandBox) {
        this.scheduleCommandBox = scheduleCommandBox;
    }

    public void setFlashcardCommandBox(CommandBox flashcardCommandBox) {
        this.flashcardCommandBox = flashcardCommandBox;
    }

    public void setQuizCommandBox(CommandBox quizCommandBox) {
        this.quizCommandBox = quizCommandBox;
    }

    public void focusScheduleCommandBox() {
        scheduleCommandBox.setCommandBoxToFocus();
    }

    public void focusFlashcardCommandBox() {
        flashcardCommandBox.setCommandBoxToFocus();
    }

    public void focusQuizCommandBox() {
        quizCommandBox.setCommandBoxToFocus();
    }
}
