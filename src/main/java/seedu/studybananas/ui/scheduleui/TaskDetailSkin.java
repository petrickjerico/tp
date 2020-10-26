package seedu.studybananas.ui.scheduleui;

import static seedu.studybananas.ui.util.ScheduleUiUtil.toAmPmTime;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.studybananas.model.task.Task;
import seedu.studybananas.ui.UiPart;

public class TaskDetailSkin extends UiPart<Region> {
    private static final String FXML = "TaskDetailSkin.fxml";

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
     * Constructor for TaskDetailSkin.
     */
    public TaskDetailSkin(Task task) {
        super(FXML);
        title.setText(task.getTitle().title);
        description.setText(task.getDescription().map(des-> des.description).orElse(""));
        date.setText(task.getDateTime().map(time -> time.getUiFormatDate()).orElse(""));
        time.setText(task.getDateTime().map(time -> toAmPmTime(time.getStandardFormatTime())).orElse(""));
        duration.setText(task.getDuration().map(dur -> String.valueOf(dur.duration)).orElse(""));
    }
}
