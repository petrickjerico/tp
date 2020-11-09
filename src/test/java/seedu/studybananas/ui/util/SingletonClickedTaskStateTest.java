package seedu.studybananas.ui.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.studybananas.model.task.Task;
import seedu.studybananas.model.task.Title;

public class SingletonClickedTaskStateTest {
    private static final String titlePlaceHolder = "my title";
    private static final Task testTask = new Task(new TitleStub(titlePlaceHolder), null, null, null);

    static class TitleStub extends Title {
        /**
         * Constructs a {@code Title}.
         *
         * @param title A valid title.
         */
        public TitleStub(String title) {
            super(title);
        }
    }

    @Test
    public void singletonTest() {
        SingletonClickedTaskState clickedTaskState = SingletonClickedTaskState.getInstance();
        SingletonClickedTaskState clickedTaskStateCopy = SingletonClickedTaskState.getInstance();

        assertEquals(SingletonClickedTaskState.getInstance(), SingletonClickedTaskState.getInstance());
        assertEquals(clickedTaskState, SingletonClickedTaskState.getInstance());
        assertEquals(clickedTaskState, clickedTaskStateCopy);

    }

    @Test
    public void unregisterTest() {
        // set up
        SingletonClickedTaskState clickedTaskState = SingletonClickedTaskState.getInstance();
        ObserverUnregisterTestStub observerStub = new ObserverUnregisterTestStub();

        // execute
        clickedTaskState.register(observerStub);
        clickedTaskState.unregister(observerStub);

        // check if the observerStub is unregistered successfully.
        clickedTaskState.inform();
    }

    @Test
    public void registerTest() {
        // set up
        SingletonClickedTaskState clickedTaskState = SingletonClickedTaskState.getInstance();
        ObserverStub observerStub = new ObserverStub();

        // execute
        clickedTaskState.register(observerStub);

        // check if the observerStub is registered successfully.
        clickedTaskState.inform();

        // clean up
        clickedTaskState.unregister(observerStub);
    }


    @Test
    public void updateStateTest() {
        // set up
        SingletonClickedTaskState clickedTaskState = SingletonClickedTaskState.getInstance();
        ObserverUpdateStateDifferentTypeTestStub observerStubUpdate = new ObserverUpdateStateDifferentTypeTestStub();
        ObserverUpdateStateSameTypeTestStub observerStubNoUpdate = new ObserverUpdateStateSameTypeTestStub();

        clickedTaskState.register(observerStubUpdate);

        // EP1 different StateType
        clickedTaskState.updateState(testTask);

        // EP2 same StateType
        clickedTaskState.register(observerStubNoUpdate);
        clickedTaskState.updateState(testTask);

        //clean up
        clickedTaskState.unregister(observerStubNoUpdate);
        clickedTaskState.unregister(observerStubUpdate);

    }




    class ObserverStub implements Observer<Task> {

        @Override
        public void subscribe(Observable news) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void update(Task state) {
            assertTrue(true, "the Observer has been registered correctly");
        }
    }

    class ObserverUpdateStateSameTypeTestStub implements Observer<Task> {

        @Override
        public void subscribe(Observable news) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void update(Task state) {
            assertTrue(false, "Observer should not be informed when the state is not updated");
        }
    }

    class ObserverUnregisterTestStub implements Observer<Task> {

        @Override
        public void subscribe(Observable news) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void update(Task state) {
            assertTrue(false, "Observer should not be informed cuz it has already been unregistered.");
        }
    }

    class ObserverUpdateStateDifferentTypeTestStub implements Observer<Task> {

        @Override
        public void subscribe(Observable news) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void update(Task state) {
            assertTrue(true, "the Observer has been registered correctly");
            assertEquals(state, testTask);
        }
    }
}
