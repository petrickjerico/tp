package seedu.studybananas.ui.quizui;

import static java.util.Objects.requireNonNull;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import seedu.studybananas.model.flashcard.Question;
import seedu.studybananas.model.quiz.Quiz;
import seedu.studybananas.ui.ResultDisplay;

public class QuizCard extends ResultDisplay {
    private static final String FXML = "QuizCard.fxml";

    private static Question question;

    private Quiz quiz;
    @FXML
    private Label labelQuestion;
    @FXML
    private Label answer;
    @FXML
    private Label instruction;

    public QuizCard() {
        super(FXML);
    }

    public QuizCard(Quiz quiz) {
        this.quiz = quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public static void setQuestion(Question q) {
        if (q != null) {
            question = q;
        } else {
            question = null;
            throw new NullPointerException();
        }
    }

    private void setFeedbackToUser(String userAnswer, String instruction) {
        requireNonNull(userAnswer, instruction);
        this.labelQuestion.setText(question != null ? question.question : "");
        this.answer.setText(userAnswer);
        this.instruction.setText(instruction);
    }

    public void setFeedbackToUser(String feedbackToUser) {
        String[] splittedFeedback = parsingAnswer(feedbackToUser);
        if (isEndOfQuiz(feedbackToUser)) {
            setFeedbackToUser(parsingStatistic(feedbackToUser)[1], "");
        } else if (doesContainAnswer(splittedFeedback)) {
            setFeedbackToUser(splittedFeedback[0], splittedFeedback[1]);
        } else {
            setFeedbackToUser("", splittedFeedback[0]);
        }
    }

    private String[] parsingAnswer(String feedbackToUser) {
        String[] splittedFeedback = feedbackToUser.split("STUDYBANANAS");
        return splittedFeedback;
    }

    private String[] parsingStatistic(String feedbackToUser) {
        String[] statistics = feedbackToUser.split(Quiz.END_OF_QUIZ);
        return statistics;
    }

    private boolean isEndOfQuiz(String feedbackToUser) {
        return feedbackToUser.startsWith(Quiz.END_OF_QUIZ);
    }

    private boolean doesContainAnswer(String[] splittedFeedback) {
        return splittedFeedback.length == 2;
    }
}
