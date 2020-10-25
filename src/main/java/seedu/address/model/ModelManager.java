package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.index.Index;
import seedu.address.model.flashcard.Answer;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.flashcard.FlashcardSet;
import seedu.address.model.flashcard.FlashcardSetName;
import seedu.address.model.flashcard.Question;
import seedu.address.model.quiz.Quiz;
import seedu.address.model.systemlevelmodel.FlashcardBank;
import seedu.address.model.systemlevelmodel.QuizRecords;
import seedu.address.model.systemlevelmodel.ReadOnlyFlashcardBank;
import seedu.address.model.systemlevelmodel.ReadOnlyQuizRecords;
import seedu.address.model.systemlevelmodel.ReadOnlySchedule;
import seedu.address.model.systemlevelmodel.ReadOnlyUserPrefs;
import seedu.address.model.systemlevelmodel.Schedule;
import seedu.address.model.systemlevelmodel.UserPrefs;
import seedu.address.model.task.Task;

/**
 * Represents the in-memory model of the address book data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final ScheduleModelManager scheduleModelManager;
    private final FlashcardModelManager flashcardModelManager;
    private final QuizModelManager quizModelManager;
    private final UserPrefs userPrefs;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ModelManager(ReadOnlyUserPrefs userPrefs,
                        ReadOnlySchedule schedule, ReadOnlyFlashcardBank flashcardBank,
                        ReadOnlyQuizRecords quizRecords) {
        super();
        requireAllNonNull(schedule, userPrefs, flashcardBank, quizRecords);

        logger.fine("Initializing with user prefs "
                + userPrefs + " , and schedule: " + schedule);

        scheduleModelManager = new ScheduleModelManager(schedule);
        flashcardModelManager = new FlashcardModelManager(flashcardBank);
        quizModelManager = new QuizModelManager(quizRecords);
        this.userPrefs = new UserPrefs(userPrefs);
    }

    public ModelManager() {
        this(new UserPrefs(), new Schedule(), new FlashcardBank(), new QuizRecords());
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

    @Override
    public Path getFlashcardBankFilePath() {
        return userPrefs.getFlashcardBankFilePath();
    }

    @Override
    public void setFlashcardBankFilePath(Path flashcardBankFilePath) {
        requireNonNull(flashcardBankFilePath);
        userPrefs.setFlashcardBankFilePath(flashcardBankFilePath);
    }

    //=========== Schedule =================================================================================

    @Override
    public void setSchedule(ReadOnlySchedule schedule) {
        this.scheduleModelManager.setSchedule(schedule);
    }

    @Override
    public ReadOnlySchedule getSchedule() {
        return this.scheduleModelManager.getSchedule();
    }

    @Override
    public boolean hasTask(Task task) {
        return this.scheduleModelManager.hasTask(task);
    }

    @Override
    public void deleteTask(Task target) {
        this.scheduleModelManager.deleteTask(target);
    }

    @Override
    public void addTask(Task task) {
        this.scheduleModelManager.addTask(task);
    }

    @Override
    public void setTask(Task target, Task editedTask) {
        scheduleModelManager.setTask(target, editedTask);
    }

    //=========== Filtered Task List Accessors =============================================================

    @Override
    public ObservableList<Task> getFilteredTaskList() {
        return scheduleModelManager.getFilteredTaskList();
    }

    @Override
    public ObservableList<Task> getUpcomingTaskList() {
        return scheduleModelManager.getUpcomingTaskList();
    }

    @Override
    public void updateFilteredTaskList(Predicate<Task> predicate) {
        this.scheduleModelManager.updateFilteredTaskList(predicate);
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
        return userPrefs.equals(other.userPrefs)
                && scheduleModelManager.equals(other.scheduleModelManager)
                && flashcardModelManager.equals(other.flashcardModelManager);
    }

    //=========== Quiz =============================================================
    @Override
    public Question start(Quiz quiz) {
        return quizModelManager.start(quiz);
    }

    public boolean hasStarted() {
        return quizModelManager.hasStarted();
    }

    @Override
    public void tallyScore(boolean isCorrect) {
        quizModelManager.tallyScore(isCorrect);
    }

    @Override
    public Question getQuestion() {
        return quizModelManager.getQuestion();
    }

    @Override
    public Answer getAnswer() {
        return quizModelManager.getAnswer();
    }

    @Override
    public String stopQuiz() {
        return quizModelManager.stopQuiz();
    }

    @Override
    public void cancelQuiz() {
        quizModelManager.cancelQuiz();
    }

    @Override
    public String getQuizRecords(FlashcardSetName name) {
        return quizModelManager.getQuizRecords(name);
    }

    @Override
    public ReadOnlyQuizRecords getAllQuizRecords() {
        return quizModelManager.getAllQuizRecords();
    }

    @Override
    public void deleteQuiz(FlashcardSetName name) {
        quizModelManager.deleteQuiz(name);
    }

    @Override
    public void saveAnswer(String answer) {
        quizModelManager.saveAnswer(answer);
    }

    @Override
    public void setFlashcardBank(ReadOnlyFlashcardBank flashcardBank) {
        flashcardModelManager.setFlashcardBank(flashcardBank);
    }

    @Override
    public ReadOnlyFlashcardBank getFlashcardBank() {
        return flashcardModelManager.getFlashcardBank();
    }

    @Override
    public FlashcardSet getFlashcardSet(Index index) {
        return flashcardModelManager.getFlashcardSet(index);
    }

    @Override
    public boolean hasFlashcardSet(FlashcardSet flashcardSet) {
        return flashcardModelManager.hasFlashcardSet(flashcardSet);
    }

    @Override
    public void deleteFlashcardSet(FlashcardSet target) {
        flashcardModelManager.deleteFlashcardSet(target);
        quizModelManager.deleteQuiz(target.getFlashcardSetName());
    }

    @Override
    public Flashcard getFlashcard(FlashcardSet flashcardSet, Index flashcardIndex) {
        return flashcardModelManager.getFlashcard(flashcardSet, flashcardIndex);
    }

    @Override
    public void setFlashcard(FlashcardSet flashcardSet, Flashcard target, Flashcard editedFlashcard) {
        flashcardModelManager.setFlashcard(flashcardSet, target, editedFlashcard);
    }

    @Override
    public boolean hasFlashcard(FlashcardSet flashcardSet, Flashcard flashcard) {
        return flashcardModelManager.hasFlashcard(flashcardSet, flashcard);
    }

    @Override
    public void addFlashcard(FlashcardSet flashcardSet, Flashcard flashcard) {
        flashcardModelManager.addFlashcard(flashcardSet, flashcard);
    }

    @Override
    public void deleteFlashcard(FlashcardSet flashcardSet, Index flashcardIndex) {
        flashcardModelManager.deleteFlashcard(flashcardSet, flashcardIndex);
    }

    @Override
    public void addFlashcardSet(FlashcardSet flashcardSet) {
        flashcardModelManager.addFlashcardSet(flashcardSet);
    }

    @Override
    public void setFlashcardSet(FlashcardSet target, FlashcardSet editedFlashcardSet) {
        flashcardModelManager.setFlashcardSet(target, editedFlashcardSet);
    }

    @Override
    public ObservableList<FlashcardSet> getFilteredFlashcardSetList() {
        return flashcardModelManager.getFilteredFlashcardSetList();
    }

    @Override
    public void updateFilteredFlashcardSetList(Predicate<FlashcardSet> predicate) {
        flashcardModelManager.updateFilteredFlashcardSetList(predicate);
    }

    @Override
    public FlashcardSet getFlashcardSetToView() {
        return flashcardModelManager.getFlashcardSetToView();
    }

    @Override
    public void setFlashcardSetToView(FlashcardSet flashcardSet) {
        flashcardModelManager.setFlashcardSetToView(flashcardSet);
    }
}
