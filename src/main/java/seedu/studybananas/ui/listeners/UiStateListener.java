package seedu.studybananas.ui.listeners;

import javafx.util.Callback;
import seedu.studybananas.ui.util.Observable;
import seedu.studybananas.ui.util.Observer;
import seedu.studybananas.ui.util.SingletonUiState;
import seedu.studybananas.ui.util.UiStateType;

public class UiStateListener implements Observer<UiStateType>, Listener<UiStateType, Void> {
    private SingletonUiState uiState;
    private Callback<UiStateType, Void> actionOnChange;

    /**
     * Constructor for UiStateListener.
     */
    public UiStateListener() {
        // subscribe to the uiState.
        uiState = SingletonUiState.getInstance();
        subscribe(uiState);
    }

    @Override
    public void subscribe(Observable news) {
        news.register(this);
    }

    @Override
    public void update(UiStateType state) {
        assert actionOnChange != null : "need to set onChange when initialize a listener.";
        actionOnChange.call(state);
    }

    @Override
    public void onChange(Callback<UiStateType, Void> action) {
        this.actionOnChange = action;
    }

    public void updateState(UiStateType uiStateType) {
        uiState.updateState(uiStateType);
    }
}
