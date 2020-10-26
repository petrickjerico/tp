package seedu.studybananas.ui.quizui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import seedu.studybananas.model.flashcard.Answer;
import seedu.studybananas.model.flashcard.Question;
import seedu.studybananas.model.quiz.Quiz;
import seedu.studybananas.ui.ResultDisplay;

import static java.util.Objects.requireNonNull;

public class QuizCard extends ResultDisplay {
    private static final String FXML = "QuizCard.fxml";
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

    private void setFeedbackToUser(String userAnswer, String instruction) {
        requireNonNull(userAnswer, instruction);
        this.labelQuestion.setText(quiz.getQuestion().question);
        this.answer.setText(userAnswer);
        this.instruction.setText(instruction);
    }

    public void setFeedbackToUser(String feedbackToUser) {
        String[] splittedFeedback = parsing(feedbackToUser);
        if (doesContainAnswer(splittedFeedback)) {
            setFeedbackToUser(splittedFeedback[0], splittedFeedback[1]);
        } else {
            setFeedbackToUser("", splittedFeedback[0]);
        }
    }

    private String[] parsing(String feedbackToUser) {
        String[] splittedFeedback = feedbackToUser.split("STUDYBANANAS");
        return splittedFeedback;
    }

    private boolean doesContainAnswer(String[] splittedFeedback) {
        return splittedFeedback.length == 2;
    }
}
