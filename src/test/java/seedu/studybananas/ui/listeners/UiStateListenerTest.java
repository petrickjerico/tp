package seedu.studybananas.ui.listeners;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import javafx.util.Callback;
import seedu.studybananas.ui.util.Observable;
import seedu.studybananas.ui.util.Observer;
import seedu.studybananas.ui.util.UiStateType;

public class UiStateListenerTest {
    private static Callback<UiStateType, Void> callback = commandResult -> {
        assertTrue(true, "the callback is filed.");
        return null;
    };

    // set up
    private UiStateListener listener = new UiStateListener();
    private UiStateType testUiState = UiStateType.FLASHCARD;

    class ObservableStub implements Observable {

        @Override
        public void register(Observer<?> reader) {
            assertEquals(listener, reader);
        }

        @Override
        public void unregister(Observer<?> reader) {

        }

        @Override
        public void inform() {

        }
    }

    @Test
    public void subscribeTest() {
        listener.onChange(callback);
        listener.subscribe(new ObservableStub());
    }

    @Test
    public void updateStateTest() {
        listener.onChange(callback);
        listener.updateState(testUiState);
    }
}
