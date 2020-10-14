package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.index.Index;
import seedu.address.model.flashcard.Answer;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.flashcard.FlashcardSet;
import seedu.address.model.flashcard.Question;
import seedu.address.model.person.Person;
import seedu.address.model.quiz.Quiz;
import seedu.address.model.task.Task;

/**
 * Represents the in-memory model of the address book data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final AddressBook addressBook;
    private final UserPrefs userPrefs;
    private final FilteredList<Person> filteredPersons;
    private final Schedule schedule;
    private final FilteredList<Task> filteredTasks;
    private final FlashcardBank flashcardBank;
    private final FilteredList<FlashcardSet> filteredFlashcardSets;
    private final Map<Integer, Quiz> quizRecords = new HashMap<>();
    private Quiz quiz;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ModelManager(ReadOnlyAddressBook addressBook, ReadOnlyUserPrefs userPrefs,
                        ReadOnlySchedule schedule, ReadOnlyFlashcardBank flashcardBank) {
        super();
        requireAllNonNull(addressBook, schedule, userPrefs);

        logger.fine("Initializing with address book: " + addressBook + " , user prefs "
                + userPrefs + " , and schedule: " + schedule);

        this.addressBook = new AddressBook(addressBook);
        this.schedule = new Schedule(schedule);
        this.flashcardBank = new FlashcardBank(flashcardBank);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredPersons = new FilteredList<>(this.addressBook.getPersonList());
        filteredTasks = new FilteredList<>(this.schedule.getTaskList());
        filteredFlashcardSets = new FilteredList<>(this.flashcardBank.getFlashcardSetList());
    }

    public ModelManager() {
        this(new AddressBook(), new UserPrefs(), new Schedule(), new FlashcardBank());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getAddressBookFilePath() {
        return userPrefs.getAddressBookFilePath();
    }

    @Override
    public void setAddressBookFilePath(Path addressBookFilePath) {
        requireNonNull(addressBookFilePath);
        userPrefs.setAddressBookFilePath(addressBookFilePath);
    }

    @Override
    public Path getScheduleFilePath() {
        return userPrefs.getScheduleFilePath();
    }

    @Override
    public void setScheduleFilePath(Path scheduleFilePath) {
        requireNonNull(scheduleFilePath);
        userPrefs.setScheduleFilePath(scheduleFilePath);
    }

    //=========== AddressBook ================================================================================

    @Override
    public void setAddressBook(ReadOnlyAddressBook addressBook) {
        this.addressBook.resetData(addressBook);
    }

    @Override
    public ReadOnlyAddressBook getAddressBook() {
        return addressBook;
    }

    @Override
    public boolean hasPerson(Person person) {
        requireNonNull(person);
        return addressBook.hasPerson(person);
    }

    @Override
    public void deletePerson(Person target) {
        addressBook.removePerson(target);
    }

    @Override
    public void addPerson(Person person) {
        addressBook.addPerson(person);
        updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
    }

    @Override
    public void setPerson(Person target, Person editedPerson) {
        requireAllNonNull(target, editedPerson);

        addressBook.setPerson(target, editedPerson);
    }

    //=========== Filtered Person List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Person} backed by the internal list of
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<Person> getFilteredPersonList() {
        return filteredPersons;
    }

    @Override
    public void updateFilteredPersonList(Predicate<Person> predicate) {
        requireNonNull(predicate);
        filteredPersons.setPredicate(predicate);
    }

    //=========== Schedule =================================================================================

    @Override
    public void setSchedule(ReadOnlySchedule schedule) {
        this.schedule.resetData(schedule);
    }

    @Override
    public ReadOnlySchedule getSchedule() {
        return schedule;
    }

    @Override
    public boolean hasTask(Task task) {
        requireNonNull(task);
        return schedule.hasTask(task);
    }

    @Override
    public void deleteTask(Task target) {
        schedule.removeTask(target);
    }

    @Override
    public void addTask(Task task) {
        schedule.addTask(task);
        updateFilteredTaskList(PREDICATE_SHOW_ALL_TASKS);
    }

    @Override
    public void setTask(Task target, Task editedTask) {
        schedule.setTask(target, editedTask);
    }

    //=========== Filtered Task List Accessors =============================================================

    @Override
    public ObservableList<Task> getFilteredTaskList() {
        return filteredTasks;
    }

    @Override
    public void updateFilteredTaskList(Predicate<Task> predicate) {
        requireNonNull(predicate);
        filteredTasks.setPredicate(predicate);
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return addressBook.equals(other.addressBook)
                && userPrefs.equals(other.userPrefs)
                && filteredPersons.equals(other.filteredPersons)
                && filteredTasks.equals(other.filteredTasks)
                && filteredFlashcardSets.equals(other.filteredFlashcardSets);
    }

    //=========== Flashcard =============================================================

    @Override
    public Flashcard getFlashcard(FlashcardSet flashcardSet, Index flashcardIndex) {
        return flashcardSet.getFlashcard(flashcardIndex.getZeroBased());
    }

    @Override
    public void setFlashcard(FlashcardSet flashcardSet, Flashcard target, Flashcard editedFlashcard) {
        flashcardSet.setFlashcard(target, editedFlashcard);
    }

    @Override
    public boolean hasFlashcard(FlashcardSet flashcardSet, Flashcard flashcard) {
        return flashcardSet.hasFlashcard(flashcard);
    }

    @Override
    public void addFlashcard(FlashcardSet flashcardSet, Flashcard flashcard) {
        flashcardSet.addFlashcard(flashcard);
    }

    @Override
    public void deleteFlashcard(FlashcardSet flashcardSet, Index flashcardIndex) {
        flashcardSet.deleteFlashcard(flashcardIndex);
    }

    //=========== Flashcard Set =============================================================

    @Override
    public FlashcardSet getFlashcardSet(Index index) {
        return filteredFlashcardSets.get(index.getZeroBased());
    }

    @Override
    public void setFlashcardSet(FlashcardSet target, FlashcardSet editedFlashcardSet) {
        flashcardBank.setFlashcardSet(target, editedFlashcardSet);
    }

    @Override
    public boolean hasFlashcardSet(FlashcardSet flashcardSet) {
        requireNonNull(flashcardSet);
        return flashcardBank.hasFlashcardSet(flashcardSet);
    }

    @Override
    public void addFlashcardSet(FlashcardSet flashcardSet) {
        flashcardBank.addFlashcardSet(flashcardSet);
    }

    @Override
    public void deleteFlashcardSet(FlashcardSet target) {
        flashcardBank.removeFlashcardSet(target);
    }

    //=========== Filtered Flashcard Set Accessors =============================================================

    @Override
    public ObservableList<FlashcardSet> getFlashcardSetList() {
        return filteredFlashcardSets;
    }

    @Override
    public void updateFilteredFlashcardSetList(Predicate<FlashcardSet> predicate) {
        requireNonNull(predicate);
        filteredFlashcardSets.setPredicate(predicate);
    }

    //=========== Flashcard Bank =============================================================

    @Override
    public void setFlashcardBank(ReadOnlyFlashcardBank flashcardBank) {
        this.flashcardBank.resetData(flashcardBank);
    }

    @Override
    public ReadOnlyFlashcardBank getFlashcardBank() {
        return flashcardBank;
    }

    //=========== Quiz =============================================================

    @Override
    public Question start(Quiz quiz) {
        this.quiz = quiz;
        return getQuestion();
    }

    public boolean hasStarted() {
        return this.quiz != null;
    }

    @Override
    public void tallyScore(boolean isCorrect) {
        this.quiz.setPointsScored(isCorrect);
    }

    @Override
    public Question getQuestion() {
        return this.quiz.getQuestion();
    }

    @Override
    public Answer getAnswer() {
        return this.quiz.getAnswer();
    }

    @Override
    public double stopQuiz() {
        double score = this.quiz.getPercentageScore();
        quizRecords.put(quiz.getFlashcardSetIndex(), quiz);
        this.quiz = null;
        return score;
    }

    @Override
    public String getQuizRecords(int index) {
        return this.quizRecords.get(index).toString();
    }
}
