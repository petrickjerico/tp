package seedu.studybananas.ui.util;

import java.util.ArrayList;
import java.util.List;

import seedu.studybananas.logic.commands.commandresults.CommandResult;

public class SingletonCommandResultState implements Observable {
    private static SingletonCommandResultState instance;

    private List<Observer> observers = new ArrayList<>();
    private CommandResult commandResult;

    private SingletonCommandResultState() {
        commandResult = null;
    }

    public static synchronized SingletonCommandResultState getInstance() {
        if (instance == null) {
            instance = new SingletonCommandResultState();
        }
        return instance;
    }


    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void inform() {
        for (Observer observer: observers) {
            observer.update(commandResult);
        }
    }

    /**
     * update the state.
     */
    public void updateCommandResult(CommandResult commandResult) {

        if (this.commandResult != null && this.commandResult.equals(commandResult)) {
            return;
        }

        this.commandResult = commandResult;
        inform();
    }
}
