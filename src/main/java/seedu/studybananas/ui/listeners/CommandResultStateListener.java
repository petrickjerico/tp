package seedu.studybananas.ui.listeners;

import javafx.util.Callback;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.ui.util.Observable;
import seedu.studybananas.ui.util.Observer;
import seedu.studybananas.ui.util.SingletonCommandResultState;

public class CommandResultStateListener implements Observer<CommandResult>, Listener<CommandResult, Void> {
    private SingletonCommandResultState commandResultState;
    private Callback<CommandResult, Void> actionOnStateChange;

    /**
     * Constructor for the CommandResultStateListener.
     */
    public CommandResultStateListener() {
        // subscribe to CommandResultState
        commandResultState = SingletonCommandResultState.getInstance();
        subscribe(commandResultState);
    }

    @Override
    public void subscribe(Observable news) {
        news.register(this);
    }

    @Override
    public void update(CommandResult state) {
        assert actionOnStateChange != null : "need to set onChange when initialize a listener.";
        actionOnStateChange.call(state);
    }

    public void updateState(CommandResult commandResult) {
        commandResultState.updateCommandResult(commandResult);
    }

    @Override
    public void onChange(Callback<CommandResult, Void> action) {
        this.actionOnStateChange = action;
    }
}
