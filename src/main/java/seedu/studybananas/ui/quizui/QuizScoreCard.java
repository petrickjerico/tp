package seedu.studybananas.ui.quizui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import seedu.studybananas.ui.commons.ResultDisplay;

public class QuizScoreCard extends ResultDisplay {

    private static final String FXML = "QuizScoreCard.fxml";

    @FXML
    private Label score;

    public QuizScoreCard() {
        super(FXML);
    }

    public void setFeedbackToUser(String feedbackToUser) {
        this.score.setText(feedbackToUser);
    }
}
