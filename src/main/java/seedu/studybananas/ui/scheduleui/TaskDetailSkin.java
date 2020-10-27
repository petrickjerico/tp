package seedu.studybananas.ui.scheduleui;

import static seedu.studybananas.ui.util.ScheduleUiUtil.toAmPmTime;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.studybananas.model.task.Task;
import seedu.studybananas.ui.UiPart;
import seedu.studybananas.ui.util.Observable;
import seedu.studybananas.ui.util.Observer;
import seedu.studybananas.ui.util.SingletonClickedTaskState;

public class TaskDetailSkin extends UiPart<Region> implements Observer<Task> {
    private static final String FXML = "TaskDetailSkin.fxml";

    private SingletonClickedTaskState taskState;

    @FXML
    private Label title;
    @FXML
    private Label description;
    @FXML
    private Label date;
    @FXML
    private Label time;
    @FXML
    private Label duration;

    /**
     * Default constructor for TaskDetailSkin
     */
    public TaskDetailSkin() {
        super(FXML);
        title.setText("Untitled");
        description.setText("Click on the task on the time scale to view its detail");
        taskState = SingletonClickedTaskState.getInstance();

        // subscribe to the Task State
        subscribe(taskState);

        // handle wrap text
        description.setWrapText(true);
    }

    public void setTask(Task task) {
        title.setText(task.getTitle().title);
        description.setText(task.getDescription().map(des-> des.description).orElse(
                "Add description by edit command"));
        date.setText(task.getDateTime().map(time -> time.getUiFormatDate()).orElse(""));
        time.setText(task.getDateTime().map(time -> toAmPmTime(time.getStandardFormatTime())).orElse(""));
        duration.setText(task.getDuration().map(dur -> String.valueOf(dur.duration)).orElse(""));
    }

    @Override
    public void subscribe(Observable news) {
        news.register(this);
    }

    @Override
    public void update(Task state) {
        setTask(state);
    }
}
