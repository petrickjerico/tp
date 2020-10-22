package seedu.address.ui.scheduleui;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.address.model.task.Task;
import seedu.address.ui.UiPart;

public class TimeScale extends UiPart<Region> {
    private static final String FXML = "TimeScale.fxml";

    /*private static final ListChangeListener<Task> taskListener = new ListChangeListener<Task>() {
        @Override
        public void onChanged(Change<? extends Task> c) {
            while (c.next()) {

            }
        }
    }*/

    private List<TimeScaleCell> timeScaleCells = new ArrayList<>();
    private CurrentTimePointer currentTimePointer;
    private ObservableList<Task> tasks;

    @FXML
    private StackPane timeScale;

    @FXML
    private ScrollPane scrollPane;

    public TimeScale(ObservableList<Task> tasks) {
        super(FXML);
        this.tasks = tasks;

        //ui set-up
        init();
        setMargin();

        //listener set-up
        handleListener();

    }

    private void init() {
        //set morning
        timeScaleCells.add(new TimeScaleCell( "12 AM"));
        for (int i = 1; i < 12; i++) {
            timeScaleCells.add(new TimeScaleCell( i + " AM"));
        }

        //set noon
        timeScaleCells.add(new TimeScaleCell("Noon"));

        //set afternnon
        for (int i = 1; i < 12; i++) {
            timeScaleCells.add(new TimeScaleCell(i + " PM"));
        }

        //repeat 12 AM
        timeScaleCells.add(new TimeScaleCell("12 AM"));

        //style, temporary, todo: move to fxml/css
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setFitToWidth(true);

        //add taskCell
        for (Task task : tasks) {
            TaskCell taskCell = new TaskCell(task);
            timeScale.getChildren().add(taskCell.getRoot());
            timeScale.setMargin(taskCell.getRoot(), new Insets(taskCell.marginTop(), 0, 0, 40));
        }

    }

    /**
     * Stackpane would squeeze everything in the same place, time function is used to list the timeScaleCells.
     */
    private void setMargin() {
        for (int i = 0; i < timeScaleCells.size(); i++) {
            timeScale.getChildren().add(timeScaleCells.get(i).getRoot());
            timeScale.setMargin(timeScaleCells.get(i).getRoot(), new Insets(i * 40, 0, 0, 0));
        }
    }

    public void placeItem(Node node, double marginTop) {
        timeScale.getChildren().add(node);
        timeScale.setMargin(node, new Insets(marginTop, 0, 0, 0));
    }

    public void placeCurrentTime(CurrentTimePointer currentTimePointer, double marginTop) {
        placeItem(currentTimePointer.getRoot(), marginTop);
        this.currentTimePointer = currentTimePointer;
    }

    public void updateCurrentTimePosition(double newMarginTop){
        timeScale.setMargin(currentTimePointer.getRoot(), new Insets(newMarginTop, 0, 0, 0));

    }

    /**
     * Handle the overlap of timeScale and the currentTimePointer
     * @param time time has to be in the format of HH:mm.
     */
    public void handleOverlap(String time) {
        assert time.matches("^([0-12]|2[0-3]):[0-5][0-9]$");
        String[] splitTime = time.split(":");
        int hour = Integer.valueOf(splitTime[0]);
        int minute = Integer.valueOf(splitTime[1]);

        // ugly implementation, should try to improve.
        // a bit violate LoD.
        if (minute <= 15) {
            //hour is one-based, and the timeScaleCell starts from 12AM
            TimeScaleCell overlappedCell = timeScaleCells.get(hour);
            overlappedCell.hideTime();
        } else if (minute > 15){
            timeScaleCells.get(hour).recoverTime();
            timeScaleCells.get(hour + 1).recoverTime();
        } else if (minute >= 45) {
            TimeScaleCell overlappedCell = timeScaleCells.get(hour + 1);
            overlappedCell.hideTime();
        }

    }

    private void handleListener() {
        //tasks.addListener();
    }
}
