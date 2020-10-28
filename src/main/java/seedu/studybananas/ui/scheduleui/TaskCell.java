package seedu.studybananas.ui.scheduleui;

import static java.util.Objects.requireNonNull;
import static seedu.studybananas.ui.util.ScheduleUiUtil.MARGIN_PER_MINUTE;
import static seedu.studybananas.ui.util.ScheduleUiUtil.checkTimePattern;
import static seedu.studybananas.ui.util.ScheduleUiUtil.getMarginFromDateTime;
import static seedu.studybananas.ui.util.ScheduleUiUtil.toAmPmTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.studybananas.model.task.Task;
import seedu.studybananas.ui.UiPart;
import seedu.studybananas.ui.util.Observable;
import seedu.studybananas.ui.util.Observer;
import seedu.studybananas.ui.util.SingletonClickedTaskState;

public class TaskCell extends UiPart<Region> implements Observer<Task> {
    private static final String FXML = "TaskCell.fxml";

    private static final double MINIMUM_CELL_HEIGHT = 13.0; // The height of title label.

    @FXML
    private Label startTime;

    @FXML
    private VBox task;

    @FXML
    private Label title;

    private Task taskObj;
    private SingletonClickedTaskState taskState;

    /**
     * Construct a TaskCell from a {@Code task}
     */
    public TaskCell(Task task) {
        super(FXML);
        requireNonNull(task);
        assert checkTaskValidation(task) : "task must happen today and has duration and a startTime.";
        taskObj = task;
        taskState = SingletonClickedTaskState.getInstance();

        // Set title and startTime
        title.setText(task.getTitle().title);
        startTime.setText(getTimeFromTask(task));

        // Violation of LoD, may need to improve.
        // Calculate the height of the cell;
        double height = getTaskCellHeight();
        this.task.setPrefHeight(height);

        //only shows the title when the duration is less than an hour.
        if (!task.isLongerThanAnHour()) {
            this.task.getChildren().remove(startTime);
            this.task.setAlignment(Pos.CENTER);
        }

        //subscribe to the taskStae
        taskState.register(this);

    }

    @FXML
    private void handleOnClicked() {
        taskState.updateState(taskObj);
    }


    /**
     * Method used to update the startTime.
     * @param startTimeStr must be in the form of hh:mm AM/PM
     */
    public void setStartTime(String startTimeStr) {
        assert checkTimePattern(startTimeStr);
        this.startTime.setText(startTimeStr);
    }

    /**
     * Calculate the margin top by the task for the TimeScale.
     */
    public double marginTop() {
        return getMarginFromDateTime(this.taskObj.getDateTime().get());
    }

    /**
     * Method used to update the title.
     * @param titleStr
     */
    private void setTitle(String titleStr) {
        this.title.setText(titleStr);
    }

    private boolean checkTaskValidation(Task task) {
        return task.getDateTime().isPresent() && task.getDuration().isPresent() && task.happensToday();
    }

    private String getTimeFromTask(Task task) {
        LocalDateTime dateTime = task.getDateTime().get().dateTime;
        DateTimeFormatter formmater = DateTimeFormatter.ofPattern("HH:mm");
        return toAmPmTime(formmater.format(dateTime));
    }

    private double getTaskCellHeight() {
        double calculatedVal = calculateMinuteHappensToday() * MARGIN_PER_MINUTE;
        return calculatedVal < MINIMUM_CELL_HEIGHT ? MINIMUM_CELL_HEIGHT : calculatedVal;
    }

    private double calculateMinuteHappensToday() {
        return taskObj.getNumberOfMinuteHappenToday();
    }

    @Override
    public void subscribe(Observable news) {
        news.register(this);
    }

    @Override
    public void update(Task task) {
        // sequence matters, as task can be null!!
        if (this.taskObj.equals(task)) {
            this.task.setStyle("-fx-background-color: #00a3cc");
            this.title.setStyle("-fx-text-fill: white");
            this.startTime.setStyle("-fx-text-fill: white");
        } else {
            this.task.setStyle("-fx-background-color:  rgba(204, 245, 255, 0.5)");
            this.title.setStyle("-fx-text-fill: #00a3cc");
            this.startTime.setStyle("-fx-text-fill: #00a3cc");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof TaskCell)) {
            return false;
        }

        return this.taskObj.equals(((TaskCell) o).taskObj);
    }

}
