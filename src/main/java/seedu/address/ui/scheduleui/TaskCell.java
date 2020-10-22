package seedu.address.ui.scheduleui;

import static java.util.Objects.requireNonNull;
import static seedu.address.ui.util.ScheduleUiUtil.checkTimePattern;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.ui.UiPart;

public class TaskCell extends UiPart<Region> {
    private static final String FXML = "TaskCell.fxml";

    @FXML
    private Label startTime;

    @FXML
    private VBox task;

    @FXML
    private Label title;

    private String startTimeStr;
    private String titleStr;

    /**
     * Constructor of taskCell.
     * @param startTime must be in the form of hh:mm AM/PM
     */
    public TaskCell(String startTime, String title) {
        super(FXML);
        requireNonNull(startTime, title);
        assert checkTimePattern(startTime);

        this.startTime.setText(startTime);
        this.title.setText(title);
        this.startTimeStr = startTime;
        this.titleStr = title;
    }

    /**
     * Method used to update the startTime.
     * @param startTimeStr must be in the form of hh:mm AM/PM
     */
    public void setStartTime(String startTimeStr) {
        assert checkTimePattern(startTimeStr);
        this.startTimeStr = startTimeStr;
        this.startTime.setText(startTimeStr);
    }

    /**
     * Method used to update the title.
     * @param titleStr
     */
    public void setTitle(String titleStr) {
        this.titleStr = titleStr;
        this.title.setText(titleStr);
    }
}
