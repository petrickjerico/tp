package seedu.studybananas.ui.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.studybananas.logic.LogicManager;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.model.Model;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.flashcard.FlashcardSetName;
import seedu.studybananas.storage.Storage;

public class SingletonClickedFlashcardSetStateTest {
    private static final String flashcardSetNamePlackholder = "my flashcard set";
    private static final FlashcardSet testFlashcardSet = new FlashcardSet(
            new FlashardSetNameStub(flashcardSetNamePlackholder));

    static class FlashardSetNameStub extends FlashcardSetName {

        /**
         * Constructs a {@code Name}.
         *
         * @param name A valid name.
         */
        public FlashardSetNameStub(String name) {
            super(name);
        }
    }

    private GlobalState globalState = GlobalState.getInstance();


    class LogicStub extends LogicManager {

        /**
         * Constructs a {@code LogicManager} with the given {@code Model} and {@code Storage}.
         *
         * @param model
         * @param storage
         */
        public LogicStub(Model model, Storage storage) {
            super(model, storage);
        }

        @Override
        public void setFlashcardSetToView(FlashcardSet flashcardSet) {
            assertEquals(flashcardSet, testFlashcardSet);
            System.out.println("here");
        }

    }

    @Test
    public void singletonTest() {
        // set up global state before test starts
        globalState.setLogic(new LogicStub(null, null));

        SingletonClickedFlashcardSetState clickedFlashcardSetState = SingletonClickedFlashcardSetState.getInstance();
        SingletonClickedFlashcardSetState clickedFlashcardSetStateCopy =
                SingletonClickedFlashcardSetState.getInstance();

        assertEquals(SingletonClickedFlashcardSetState.getInstance(), SingletonClickedFlashcardSetState.getInstance());
        assertEquals(clickedFlashcardSetState, SingletonClickedFlashcardSetState.getInstance());
        assertEquals(clickedFlashcardSetState, clickedFlashcardSetStateCopy);

    }

    @Test
    public void unregisterTest() {
        // set up
        SingletonClickedFlashcardSetState clickedFlashcardSetState = SingletonClickedFlashcardSetState.getInstance();
        ObserverUnregisterTestStub observerStub = new ObserverUnregisterTestStub();

        // execute
        clickedFlashcardSetState.register(observerStub);
        clickedFlashcardSetState.unregister(observerStub);

        // check if the observerStub is unregistered successfully.
        clickedFlashcardSetState.inform();
    }

    @Test
    public void registerTest() {
        // set up global state before test starts
        globalState.setLogic(new LogicStub(null, null));

        // set up
        SingletonClickedFlashcardSetState clickedFlashcardSetState = SingletonClickedFlashcardSetState.getInstance();
        ObserverStub observerStub = new ObserverStub();

        // execute
        clickedFlashcardSetState.register(observerStub);

        // check if the observerStub is registered successfully.
        clickedFlashcardSetState.inform();

        // clean up
        clickedFlashcardSetState.unregister(observerStub);
    }


    @Test
    public void updateStateTest() {
        // set up global state before test starts
        globalState.setLogic(new LogicStub(null, null));

        // set up
        SingletonClickedFlashcardSetState clickedFlashcardSetState = SingletonClickedFlashcardSetState.getInstance();
        ObserverUpdateStateDifferentTypeTestStub observerStubUpdate = new ObserverUpdateStateDifferentTypeTestStub();
        ObserverUpdateStateSameTypeTestStub observerStubNoUpdate = new ObserverUpdateStateSameTypeTestStub();

        clickedFlashcardSetState.register(observerStubUpdate);

        // EP1 different StateType
        clickedFlashcardSetState.updateState(testFlashcardSet);

        // EP2 same StateType
        clickedFlashcardSetState.register(observerStubNoUpdate);
        clickedFlashcardSetState.updateState(testFlashcardSet);

        //clean up
        clickedFlashcardSetState.unregister(observerStubNoUpdate);
        clickedFlashcardSetState.unregister(observerStubUpdate);

    }




    class ObserverStub implements Observer<CommandResult> {

        @Override
        public void subscribe(Observable news) {
            assert false : "should not use this method in this stub.";
        }

        @Override
        public void update(CommandResult state) {
            assertTrue(true, "the Observer has been registered correctly");
        }
    }

    class ObserverUpdateStateSameTypeTestStub implements Observer<FlashcardSet> {

        @Override
        public void subscribe(Observable news) {
            assert false : "should not use this method in this stub.";
        }

        @Override
        public void update(FlashcardSet state) {
            assertTrue(false, "Observer should not be informed when the state is not updated");
        }
    }

    class ObserverUnregisterTestStub implements Observer<FlashcardSet> {

        @Override
        public void subscribe(Observable news) {
            assert false : "should not use this method in this stub.";
        }

        @Override
        public void update(FlashcardSet state) {
            assertTrue(false, "Observer should not be informed cuz it has already been unregistered.");
        }
    }

    class ObserverUpdateStateDifferentTypeTestStub implements Observer<FlashcardSet> {

        @Override
        public void subscribe(Observable news) {
            assert false : "should not use this method in this stub.";
        }

        @Override
        public void update(FlashcardSet state) {
            assertTrue(true, "the Observer has been registered correctly");
            assertEquals(state, testFlashcardSet);
        }
    }
}
