package seedu.studybananas.ui.util;

public interface Observer<T> {
    void subscribe(Observable news);

    void update(T state);
}
