package seedu.studybananas.model;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.model.flashcard.Answer;
import seedu.studybananas.model.flashcard.Flashcard;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.flashcard.FlashcardSetName;
import seedu.studybananas.model.flashcard.Question;
import seedu.studybananas.model.quiz.Quiz;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyFlashcardBank;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyQuizRecords;

public class FlashcardQuizModelManager implements FlashcardQuizModel {

    private final FlashcardModelManager flashcardModelManager;
    private final QuizModelManager quizModelManager;

    /**
     * Initiates a FlashcardQuizModelObject.
     * @param readOnlyFlashcardBank provided
     * @param readOnlyQuizRecords provided
     */
    public FlashcardQuizModelManager(ReadOnlyFlashcardBank readOnlyFlashcardBank,
                                     ReadOnlyQuizRecords readOnlyQuizRecords) {
        flashcardModelManager = new FlashcardModelManager(readOnlyFlashcardBank);
        quizModelManager = new QuizModelManager(readOnlyQuizRecords);
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
    public FlashcardSet getFlashcardSet(Index index) {
        return flashcardModelManager.getFlashcardSet(index);
    }

    @Override
    public void setFlashcardSet(FlashcardSet target, FlashcardSet editedFlashcardSet) {
        flashcardModelManager.setFlashcardSet(target, editedFlashcardSet);
    }

    @Override
    public boolean hasFlashcardSet(FlashcardSet flashcardSet) {
        return flashcardModelManager.hasFlashcardSet(flashcardSet);
    }

    @Override
    public void addFlashcardSet(FlashcardSet flashcardSet) {
        flashcardModelManager.addFlashcardSet(flashcardSet);
    }

    @Override
    public void deleteFlashcardSet(FlashcardSet target) {
        flashcardModelManager.deleteFlashcardSet(target);
        quizModelManager.deleteQuiz(target.getFlashcardSetName());
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

    @Override
    public Question start(Quiz quiz) {
        return quizModelManager.start(quiz);
    }

    @Override
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
    public void deleteQuiz(FlashcardSetName name) {
        quizModelManager.deleteQuiz(name);
    }

    @Override
    public ReadOnlyQuizRecords getAllQuizRecords() {
        return quizModelManager.getAllQuizRecords();
    }

    @Override
    public void saveAnswer(String answer) {
        quizModelManager.saveAnswer(answer);
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof FlashcardQuizModelManager)) {
            return false;
        }

        // state check
        FlashcardQuizModelManager other = (FlashcardQuizModelManager) obj;
        return flashcardModelManager.equals(other.flashcardModelManager)
                && quizModelManager.equals(other.quizModelManager);
    }
}
