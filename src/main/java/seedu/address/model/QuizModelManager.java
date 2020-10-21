package seedu.address.model;

import seedu.address.model.flashcard.Answer;
import seedu.address.model.flashcard.FlashcardSetName;
import seedu.address.model.flashcard.Question;
import seedu.address.model.quiz.Quiz;
import seedu.address.model.systemlevelmodel.QuizRecords;
import seedu.address.model.systemlevelmodel.ReadOnlyQuizRecords;

public class QuizModelManager implements QuizModel {

    private final QuizRecords quizRecords;
    private Quiz quiz;

    public QuizModelManager(ReadOnlyQuizRecords quizRecords) {
        this.quizRecords = new QuizRecords(quizRecords);
    }

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
    public String stopQuiz() {
        String score = this.quiz.toString();
        quizRecords.addQuiz(quiz);
        this.quiz = null;
        return score;
    }

    @Override
    public void cancelQuiz() {
        this.quiz = null;
    }

    @Override
    public String getQuizRecords(FlashcardSetName flashcardSetName) {
        return this.quizRecords.getQuiz(flashcardSetName).toString();
    }

    @Override
    public void deleteQuiz(FlashcardSetName name) {
        quizRecords.removeQuiz(name);
    }

    @Override
    public ReadOnlyQuizRecords getAllQuizRecords() {
        return quizRecords;
    }
}
