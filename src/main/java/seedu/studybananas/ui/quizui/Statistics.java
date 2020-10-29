package seedu.studybananas.ui.quizui;

import javafx.collections.FXCollections;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import seedu.studybananas.model.quiz.Quiz;

public class Statistics {

    private Quiz quiz;
    private StackedBarChart<String, Number> stackedBarChart;

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
        double percentageScore = quiz.getPercentageScore();
        double percentageNotScored = 100 - percentageScore;

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setCategories(
                FXCollections.<String>observableArrayList(
                        ""));

        NumberAxis yAxis = new NumberAxis(0, 100, 1);
        yAxis.setLabel("Percentage %");

        StackedBarChart<String, Number> stackedBarChart =
                new StackedBarChart<>(xAxis, yAxis);
        stackedBarChart.setTitle("Percentage Score");

        XYChart.Series<String, Number> cSeries = new XYChart.Series<>();
        cSeries.setName("Correct - " + String.format("%.0f", percentageScore) + "%");
        cSeries.getData().add(new XYChart.Data<>("", percentageScore));

        XYChart.Series<String, Number> wSeries = new XYChart.Series<>();
        wSeries.setName("Wrong - " + String.format("%.0f", percentageNotScored) + "%");
        wSeries.getData().add(new XYChart.Data<>("", percentageNotScored));

        stackedBarChart.getData().add(cSeries);
        stackedBarChart.getData().add(wSeries);
        this.stackedBarChart = stackedBarChart;
    }

    public StackedBarChart<String, Number> getStackedBarChart() {
        return stackedBarChart;
    }
}
