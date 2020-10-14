package seedu.address.ui.util;


import java.util.ArrayList;
import java.util.List;

public class SingletonUiState implements Observable {

    private static SingletonUiState instance;

    private UiStateType uiState;
    private List<Observer> observers = new ArrayList<>();

    private SingletonUiState() {
        this.uiState = UiStateType.SCHEDULE;
    }

    public static synchronized SingletonUiState getInstance() {
        if (instance == null) {
            instance = new SingletonUiState();
        }
        return instance;
    }

    public UiStateType getUiState() {
        return this.uiState;
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
            observer.update(this.uiState);
        }
    }

    /**
     * update the unique UiState.
     * @param state
     */
    public void updateState(UiStateType state) {
        this.uiState = state;
        inform();
    }
}
