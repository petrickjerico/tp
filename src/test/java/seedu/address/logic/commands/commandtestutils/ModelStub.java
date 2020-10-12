package seedu.address.logic.commands.commandtestutils;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.index.Index;
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

public class ModelStub implements Model {
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

    public void addFlashcard(Flashcard flashcard, Index flashcardSetIndex) {
        // TODO: AddFlashcard implementation.
    }

    @Override
    public FlashcardSet getFlashcardSet(int index) {
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
