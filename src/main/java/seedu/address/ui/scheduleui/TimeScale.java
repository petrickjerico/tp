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

    // Solution adapted from Stack Overflow
    // https://stackoverflow.com/questions/25498747/javafx-gridpane-observablelist-and-listchangelistener
    private final ListChangeListener<Task> taskListener = new ListChangeListener<Task>() {
        @Override
        public void onChanged(Change<? extends Task> c) {
            while (c.next()) {
                if (c.wasAdded()) {
                    for (Task task : c.getAddedSubList()) {
                        addTaskToTimeScale(task);
                    }
                } else if (c.wasRemoved()) {
                    for (Task task : c.getRemoved()) {
                        removeTaskFromTimeScale(task);
                    }
                } else if (c.getAddedSize() == 0) {

                } else {
                    assert false : "should never reach here, this system does not support object editting.";
                }
            }
        }
    };

    private List<TimeScaleCell> timeScaleCells = new ArrayList<>();
    private CurrentTimePointer currentTimePointer;
    private ObservableList<Task> tasks;

    @FXML
    private StackPane timeScale;

    @FXML
    private ScrollPane scrollPane;

    /**
     * Constructor of the TimeScale.
     * @param tasks the task list that TimeScale listens to.
     */
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
        timeScaleCells.add(new TimeScaleCell("12 AM"));
        for (int i = 1; i < 12; i++) {
            timeScaleCells.add(new TimeScaleCell(i + " AM"));
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
            addTaskToTimeScale(task);
        }

    }

    private void addTaskToTimeScale(Task task) {
        TaskCell taskCell = new TaskCell(task);

        //bind the TaskCell to the Task
        task.setTaskCellBind(taskCell);

        timeScale.getChildren().add(taskCell.getRoot());
        timeScale.setMargin(taskCell.getRoot(), new Insets(taskCell.marginTop(), 0, 0, 40));
    }

    private void addTaskToTimeScale(int taskId) {
        addTaskToTimeScale(tasks.get(taskId));
    }

    private void removeTaskFromTimeScale(Task task) {
        timeScale.getChildren().remove(task.getTaskCellBind().getRoot());
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

    /**
     * Places a {@Code Node} in the TimeScale with marginTop being {@Code marginTop}.
     * @param node node to place
     * @param marginTop marginTop of the node
     */
    public void placeItem(Node node, double marginTop) {
        timeScale.getChildren().add(node);
        timeScale.setMargin(node, new Insets(marginTop, 0, 0, 0));
    }

    /**
     * Places the {@Code CurrentTimePointer} with the initial {@Code marginTop}.
     * @param marginTop initial marginTop
     */
    public void placeCurrentTime(CurrentTimePointer currentTimePointer, double marginTop) {
        placeItem(currentTimePointer.getRoot(), marginTop);
        this.currentTimePointer = currentTimePointer;
    }

    /**
     * Updates the position of {@CurrentTimePosition}.
     * @param newMarginTop
     */
    public void updateCurrentTimePosition(double newMarginTop) {
        timeScale.setMargin(currentTimePointer.getRoot(), new Insets(newMarginTop, 0, 0, 0));

    }

    /**
     * Handles the overlap of timeScale and the currentTimePointer
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
        } else if (minute > 15) {
            timeScaleCells.get(hour).recoverTime();
            timeScaleCells.get(hour + 1).recoverTime();
        } else if (minute >= 45) {
            TimeScaleCell overlappedCell = timeScaleCells.get(hour + 1);
            overlappedCell.hideTime();
        }

    }

    private void handleListener() {
        tasks.addListener(taskListener);
    }
}
