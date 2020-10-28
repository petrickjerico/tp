package seedu.studybananas.model;

import static java.util.Objects.requireNonNull;
import static seedu.studybananas.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.studybananas.commons.core.GuiSettings;
import seedu.studybananas.commons.core.LogsCenter;
import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.model.flashcard.Answer;
import seedu.studybananas.model.flashcard.Flashcard;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.flashcard.FlashcardSetName;
import seedu.studybananas.model.flashcard.Question;
import seedu.studybananas.model.quiz.Quiz;
import seedu.studybananas.model.systemlevelmodel.FlashcardBank;
import seedu.studybananas.model.systemlevelmodel.QuizRecords;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyFlashcardBank;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyQuizRecords;
import seedu.studybananas.model.systemlevelmodel.ReadOnlySchedule;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyUserPrefs;
import seedu.studybananas.model.systemlevelmodel.Schedule;
import seedu.studybananas.model.systemlevelmodel.UserPrefs;
import seedu.studybananas.model.task.Task;

/**
 * Represents the in-memory model of the study bananas data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final ScheduleModelManager scheduleModelManager;
    private final FlashcardQuizModelManager flashcardQuizModelManager;
    private final UserPrefs userPrefs;

    /**
     * Initializes a ModelManager with the given studyBananas and userPrefs.
     */
    public ModelManager(ReadOnlyUserPrefs userPrefs,
                        ReadOnlySchedule schedule, ReadOnlyFlashcardBank flashcardBank,
                        ReadOnlyQuizRecords quizRecords) {
        super();
        requireAllNonNull(schedule, userPrefs, flashcardBank, quizRecords);

        logger.fine("Initializing with user prefs "
                + userPrefs + " , and schedule: " + schedule);

        scheduleModelManager = new ScheduleModelManager(schedule);
        flashcardQuizModelManager = new FlashcardQuizModelManager(flashcardBank, quizRecords);
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
                && flashcardQuizModelManager.equals(other.flashcardQuizModelManager);
    }

    //=========== Quiz =============================================================
    @Override
    public Question start(Quiz quiz) {
        return flashcardQuizModelManager.start(quiz);
    }

    public boolean hasStarted() {
        return flashcardQuizModelManager.hasStarted();
    }

    @Override
    public void tallyScore(boolean isCorrect) {
        flashcardQuizModelManager.tallyScore(isCorrect);
    }

    @Override
    public Question getQuestion() {
        return flashcardQuizModelManager.getQuestion();
    }

    @Override
    public Quiz getQuiz() {
        return flashcardQuizModelManager.getQuiz();
    }

    @Override
    public Answer getAnswer() {
        return flashcardQuizModelManager.getAnswer();
    }

    @Override
    public String stopQuiz() {
        return flashcardQuizModelManager.stopQuiz();
    }

    @Override
    public void cancelQuiz() {
        flashcardQuizModelManager.cancelQuiz();
    }

    @Override
    public String getQuizRecords(FlashcardSetName name) {
        return flashcardQuizModelManager.getQuizRecords(name);
    }

    @Override
    public Quiz getQuizRecordsToView() {
        return flashcardQuizModelManager.getQuizRecordsToView();
    }

    @Override
    public void setQuizRecordsToView(FlashcardSetName name) {
        flashcardQuizModelManager.setQuizRecordsToView(name);
    }

    @Override
    public ReadOnlyQuizRecords getAllQuizRecords() {
        return flashcardQuizModelManager.getAllQuizRecords();
    }

    @Override
    public void deleteQuiz(FlashcardSetName name) {
        flashcardQuizModelManager.deleteQuiz(name);
    }

    @Override
    public void saveAnswer(String answer) {
        flashcardQuizModelManager.saveAnswer(answer);
    }

    @Override
    public void setFlashcardBank(ReadOnlyFlashcardBank flashcardBank) {
        flashcardQuizModelManager.setFlashcardBank(flashcardBank);
    }

    @Override
    public ReadOnlyFlashcardBank getFlashcardBank() {
        return flashcardQuizModelManager.getFlashcardBank();
    }

    @Override
    public FlashcardSet getFlashcardSet(Index index) {
        return flashcardQuizModelManager.getFlashcardSet(index);
    }

    @Override
    public boolean hasFlashcardSet(FlashcardSet flashcardSet) {
        return flashcardQuizModelManager.hasFlashcardSet(flashcardSet);
    }

    @Override
    public void deleteFlashcardSet(FlashcardSet target) {
        flashcardQuizModelManager.deleteFlashcardSet(target);
    }

    @Override
    public Flashcard getFlashcard(FlashcardSet flashcardSet, Index flashcardIndex) {
        return flashcardQuizModelManager.getFlashcard(flashcardSet, flashcardIndex);
    }

    @Override
    public void setFlashcard(FlashcardSet flashcardSet, Flashcard target, Flashcard editedFlashcard) {
        flashcardQuizModelManager.setFlashcard(flashcardSet, target, editedFlashcard);
    }

    @Override
    public boolean hasFlashcard(FlashcardSet flashcardSet, Flashcard flashcard) {
        return flashcardQuizModelManager.hasFlashcard(flashcardSet, flashcard);
    }

    @Override
    public void addFlashcard(FlashcardSet flashcardSet, Flashcard flashcard) {
        flashcardQuizModelManager.addFlashcard(flashcardSet, flashcard);
    }

    @Override
    public void deleteFlashcard(FlashcardSet flashcardSet, Index flashcardIndex) {
        flashcardQuizModelManager.deleteFlashcard(flashcardSet, flashcardIndex);
    }

    @Override
    public void addFlashcardSet(FlashcardSet flashcardSet) {
        flashcardQuizModelManager.addFlashcardSet(flashcardSet);
    }

    @Override
    public void setFlashcardSet(FlashcardSet target, FlashcardSet editedFlashcardSet) {
        flashcardQuizModelManager.setFlashcardSet(target, editedFlashcardSet);
    }

    @Override
    public ObservableList<FlashcardSet> getFilteredFlashcardSetList() {
        return flashcardQuizModelManager.getFilteredFlashcardSetList();
    }

    @Override
    public void updateFilteredFlashcardSetList(Predicate<FlashcardSet> predicate) {
        flashcardQuizModelManager.updateFilteredFlashcardSetList(predicate);
    }

    @Override
    public ObservableList<Flashcard> getFlashcardSetToView() {
        return flashcardQuizModelManager.getFlashcardSetToView();
    }

    @Override
    public void setFlashcardSetToView(Index index) {
        flashcardQuizModelManager.setFlashcardSetToView(index);
    }

    @Override
    public void setFlashcardSetToView(FlashcardSet flashcardSet) {
        flashcardQuizModelManager.setFlashcardSetToView(flashcardSet);
    }

}
