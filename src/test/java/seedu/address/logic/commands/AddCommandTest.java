package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.addressbookcommands.AddCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyFlashcardBank;
import seedu.address.model.ReadOnlySchedule;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.flashcard.Answer;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.flashcard.FlashcardSet;
import seedu.address.model.flashcard.Question;
import seedu.address.model.person.Person;
import seedu.address.model.quiz.Quiz;
import seedu.address.model.task.Task;
import seedu.address.testutil.PersonBuilder;

public class AddCommandTest {

    @Test
    public void constructor_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddCommand(null));
    }

    @Test
    public void execute_personAcceptedByModel_addSuccessful() throws Exception {
        ModelStubAcceptingPersonAdded modelStub = new ModelStubAcceptingPersonAdded();
        Person validPerson = new PersonBuilder().build();

        CommandResult commandResult = new AddCommand(validPerson).execute(modelStub);

        assertEquals(String.format(AddCommand.MESSAGE_SUCCESS, validPerson), commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validPerson), modelStub.personsAdded);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Person validPerson = new PersonBuilder().build();
        AddCommand addCommand = new AddCommand(validPerson);
        ModelStub modelStub = new ModelStubWithPerson(validPerson);

        assertThrows(CommandException.class, AddCommand.MESSAGE_DUPLICATE_PERSON, () -> addCommand.execute(modelStub));
    }

    @Test
    public void equals() {
        Person alice = new PersonBuilder().withName("Alice").build();
        Person bob = new PersonBuilder().withName("Bob").build();
        AddCommand addAliceCommand = new AddCommand(alice);
        AddCommand addBobCommand = new AddCommand(bob);

        // same object -> returns true
        assertTrue(addAliceCommand.equals(addAliceCommand));

        // same values -> returns true
        AddCommand addAliceCommandCopy = new AddCommand(alice);
        assertTrue(addAliceCommand.equals(addAliceCommandCopy));

        // different types -> returns false
        assertFalse(addAliceCommand.equals(1));

        // null -> returns false
        assertFalse(addAliceCommand.equals(null));

        // different person -> returns false
        assertFalse(addAliceCommand.equals(addBobCommand));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePerson(Person target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPerson(Person target, Person editedPerson) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Person> getFilteredPersonList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPersonList(Predicate<Person> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getScheduleFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setScheduleFilePath(Path scheduleFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setSchedule(ReadOnlySchedule schedule) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlySchedule getSchedule() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasTask(Task task) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteTask(Task target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addTask(Task task) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setTask(Task target, Task editedTask) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Task> getFilteredTaskList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredTaskList(Predicate<Task> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setFlashcardBank(ReadOnlyFlashcardBank flashcardBank) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyFlashcardBank getFlashcardBank() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasFlashcardSet(FlashcardSet flashcardSet) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteFlashcardSet(FlashcardSet target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Flashcard getFlashcard(FlashcardSet flashcardSet, Index flashcardIndex) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setFlashcard(FlashcardSet flashcardSet, Flashcard target, Flashcard editedFlashcard) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasFlashcard(FlashcardSet flashcardSet, Flashcard flashcard) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addFlashcard(FlashcardSet flashcardSet, Flashcard flashcard) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteFlashcard(FlashcardSet flashcardSet, Index flashcardIndex) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addFlashcardSet(FlashcardSet flashcardSet) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setFlashcardSet(FlashcardSet target, FlashcardSet editedFlashcardSet) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<FlashcardSet> getFlashcardSetList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredFlashcardSetList(Predicate<FlashcardSet> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public FlashcardSet getFlashcardSet(Index index) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Question start(Quiz quiz) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasStarted() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void tallyScore(boolean isCorrect) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Question getQuestion() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Answer getAnswer() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public double stopQuiz() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public String getQuizRecords(int index) {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single person.
     */
    private class ModelStubWithPerson extends ModelStub {
        private final Person person;

        ModelStubWithPerson(Person person) {
            requireNonNull(person);
            this.person = person;
        }

        @Override
        public boolean hasPerson(Person person) {
            requireNonNull(person);
            return this.person.isSamePerson(person);
        }
    }

    /**
     * A Model stub that always accept the person being added.
     */
    private class ModelStubAcceptingPersonAdded extends ModelStub {
        final ArrayList<Person> personsAdded = new ArrayList<>();

        @Override
        public boolean hasPerson(Person person) {
            requireNonNull(person);
            return personsAdded.stream().anyMatch(person::isSamePerson);
        }

        @Override
        public void addPerson(Person person) {
            requireNonNull(person);
            personsAdded.add(person);
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            return new AddressBook();
        }
    }

}
