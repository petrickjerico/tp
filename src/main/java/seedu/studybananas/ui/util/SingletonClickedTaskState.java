package seedu.studybananas.ui.util;

import java.util.ArrayList;
import java.util.List;

import seedu.studybananas.model.task.Task;

public class SingletonClickedTaskState implements Observable {

    private static SingletonClickedTaskState instance;

    private List<Observer> observers = new ArrayList<>();
    private Task clickedTask;

    private SingletonClickedTaskState() {
        clickedTask = null;
    }

    public static synchronized SingletonClickedTaskState getInstance() {
        if (instance == null) {
            instance = new SingletonClickedTaskState();
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
            observer.update(clickedTask);
        }
    }

    /**
     * update the state.
     */
    public void updateState(Task task) {
        this.clickedTask = task;
        inform();
    }
}
