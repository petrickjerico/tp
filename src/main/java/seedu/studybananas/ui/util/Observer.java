package seedu.studybananas.ui.util;

public interface Observer {
    void subscribe(Observable news);

    void update(UiStateType state);
}
