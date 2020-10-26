package seedu.studybananas.ui.quizui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import seedu.studybananas.model.quiz.Quiz;

public class Statistics {

    private PieChart pieChart;
    private Quiz quiz;

    /**
     * Constructs a Statistics object.
     * @param quiz provided
     */
    public Statistics(Quiz quiz) {
        this.quiz = quiz;
        setStatistics(this.quiz);
    }

    private void setStatistics(Quiz quiz) {

        if (quiz == null) {
            return;
        }

        int pointsScored = quiz.getPointsScored();
        int totalScore = quiz.getTotalScore();
        int pointsNotScored = totalScore - pointsScored;

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Answered wrongly", pointsNotScored),
                new PieChart.Data("Answered Correctly", pointsScored));

        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("Quiz score for " + quiz.getFlsetName());
        this.pieChart = pieChart;
    }

    public PieChart getPieChart() {
        return pieChart;
    }
}
