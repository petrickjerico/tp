package seedu.studybananas.ui.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.ScheduleCommandResult;

public class SingletonCommandResultStateTest {
    private static final String feedbackPlackholder = "";
    private static final CommandResult testCommandResult = new ScheduleCommandResult(feedbackPlackholder);

    @Test
    public void singletonTest() {
        SingletonCommandResultState commandResultState = SingletonCommandResultState.getInstance();
        SingletonCommandResultState commandResultStateCopy = SingletonCommandResultState.getInstance();

        assertEquals(SingletonCommandResultState.getInstance(), SingletonCommandResultState.getInstance());
        assertEquals(commandResultState, SingletonCommandResultState.getInstance());
        assertEquals(commandResultState, commandResultStateCopy);

    }

    @Test
    public synchronized void unregisterTest() {
        // set up
        SingletonCommandResultState commandResultState = SingletonCommandResultState.getInstance();
        ObserverUnregisterTestStub observerStub = new ObserverUnregisterTestStub();

        // execute
        commandResultState.register(observerStub);
        commandResultState.unregister(observerStub);

        // check if the observerStub is unregistered successfully.
        commandResultState.inform();
    }

    @Test
    public synchronized void registerTest() {
        // set up
        SingletonCommandResultState commandResultState = SingletonCommandResultState.getInstance();
        ObserverStub observerStub = new ObserverStub();

        // execute
        commandResultState.register(observerStub);

        // check if the observerStub is registered successfully.
        commandResultState.inform();

        // clean up
        commandResultState.unregister(observerStub);
    }


    @Test
    public synchronized void updateStateTest() {
        // set up
        SingletonCommandResultState commandResultState = SingletonCommandResultState.getInstance();
        ObserverUpdateStateDifferentTypeTestStub observerStubUpdate = new ObserverUpdateStateDifferentTypeTestStub();
        ObserverUpdateStateSameTypeTestStub observerStubNoUpdate = new ObserverUpdateStateSameTypeTestStub();

        commandResultState.register(observerStubUpdate);

        // EP1 different StateType
        commandResultState.updateCommandResult(testCommandResult);

        // EP2 same StateType
        commandResultState.register(observerStubNoUpdate);
        commandResultState.updateCommandResult(testCommandResult);

        //clean up
        commandResultState.unregister(observerStubNoUpdate);
        commandResultState.unregister(observerStubUpdate);

    }




    class ObserverStub implements Observer<CommandResult> {

        @Override
        public void subscribe(Observable news) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void update(CommandResult state) {
            assertTrue(true, "the Observer has been registered correctly");
        }
    }

    class ObserverUpdateStateSameTypeTestStub implements Observer<CommandResult> {

        @Override
        public void subscribe(Observable news) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void update(CommandResult state) {
            assertTrue(false, "Observer should not be informed when the state is not updated");
        }
    }

    class ObserverUnregisterTestStub implements Observer<CommandResult> {

        @Override
        public void subscribe(Observable news) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void update(CommandResult state) {
            assertTrue(false, "Observer should not be informed cuz it has already been unregistered.");
        }
    }

    class ObserverUpdateStateDifferentTypeTestStub implements Observer<CommandResult> {

        @Override
        public void subscribe(Observable news) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void update(CommandResult state) {
            assertTrue(true, "the Observer has been registered correctly");
            assertEquals(state, testCommandResult);
        }
    }
}
