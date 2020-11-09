package seedu.studybananas.ui.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class SingletonUiStateTest {
    private static final UiStateType testUiStateType = UiStateType.FLASHCARD;
    private static final UiStateType defaultUiStateType = UiStateType.SCHEDULE;

    @Test
    @Order(1)
    public void singletonTest() {
        SingletonUiState uiState = SingletonUiState.getInstance();
        SingletonUiState uiStateCopy = SingletonUiState.getInstance();

        assertEquals(SingletonUiState.getInstance(), SingletonUiState.getInstance());
        assertEquals(uiState, SingletonUiState.getInstance());
        assertEquals(uiState, uiStateCopy);

    }

    @Test
    @Order(2)
    public synchronized void registerTest() {
        SingletonUiState uiState = SingletonUiState.getInstance();
        ObserverStub observerStub = new ObserverStub();

        uiState.register(observerStub);
        // check if the observerStub is registered successfully.
        uiState.inform();
    }

    @Test
    @Order(3)
    public synchronized void unregisterTest() {
        SingletonUiState uiState = SingletonUiState.getInstance();
        ObserverUnregisterTestStub observerStub = new ObserverUnregisterTestStub();

        uiState.register(observerStub);
        uiState.unregister(observerStub);
        // check if the observerStub is unregistered successfully.
        uiState.inform();
    }

    @Test
    @Order(4)
    public void updateStateTest_sameState_noUpdateFiled() {
        SingletonUiState uiState = SingletonUiState.getInstance();
        ObserverUpdateStateSameTypeTestStub observerStubNoUpdate = new ObserverUpdateStateSameTypeTestStub();
        uiState.updateState(testUiStateType);
        uiState.register(observerStubNoUpdate);

        // EP1 same StateType
        uiState.updateState(testUiStateType);

        uiState.unregister(observerStubNoUpdate);

    }

    @Test
    @Order(5)
    public void updateStateTest() {
        SingletonUiState uiState = SingletonUiState.getInstance();
        ObserverUpdateStateDifferentTypeTestStub observerStubUpdate = new ObserverUpdateStateDifferentTypeTestStub();
        uiState.updateState(defaultUiStateType);
        uiState.register(observerStubUpdate);

        // EP2 different StateType
        uiState.updateState(testUiStateType);
        assertEquals(testUiStateType, uiState.getUiState());

    }



    class ObserverStub implements Observer<UiStateType> {

        @Override
        public void subscribe(Observable news) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void update(UiStateType state) {
            assertTrue(true, "the Observer has been registered correctly");
        }
    }

    class ObserverUpdateStateSameTypeTestStub implements Observer<UiStateType> {

        @Override
        public void subscribe(Observable news) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void update(UiStateType state) {
            assertTrue(false, "Observer should not be informed when the state is not updated");
        }
    }

    class ObserverUnregisterTestStub implements Observer<UiStateType> {

        @Override
        public void subscribe(Observable news) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void update(UiStateType state) {
            assertTrue(false, "Observer should not be informed cuz it has already been unregistered.");
        }
    }

    class ObserverUpdateStateDifferentTypeTestStub implements Observer<UiStateType> {

        @Override
        public void subscribe(Observable news) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void update(UiStateType state) {
            assertTrue(true, "the Observer has been registered correctly");
            assertEquals(state, testUiStateType);
        }
    }
}
