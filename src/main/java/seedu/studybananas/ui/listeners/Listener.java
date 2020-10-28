package seedu.studybananas.ui.listeners;

import javafx.util.Callback;

public interface Listener<T, R> {
    void onChange(Callback<T, R> action);
}
