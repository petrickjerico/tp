package seedu.studybananas.ui.listeners;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import javafx.util.Callback;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.ScheduleCommandResult;
import seedu.studybananas.ui.util.Observable;
import seedu.studybananas.ui.util.Observer;

public class CommandResultStateListenerTest {
    private static Callback<CommandResult, Void> callback = commandResult -> {
        assertTrue(true, "the callback is filed.");
        return null;
    };

    // set up
    private CommandResultStateListener listener = new CommandResultStateListener();
    private CommandResult commandResultStub = new ScheduleCommandResult("my stub");

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
        listener.updateState(commandResultStub);
    }
}
