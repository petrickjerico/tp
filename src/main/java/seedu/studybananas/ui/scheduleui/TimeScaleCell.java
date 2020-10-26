package seedu.studybananas.ui.scheduleui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.studybananas.ui.UiPart;

public class TimeScaleCell extends UiPart<Region> {
    private static final String FXML = "TimeScaleCell.fxml";

    @FXML
    private Label time;

    private String timeStr;

    TimeScaleCell(String timeString) {
        super(FXML);
        time.setText(timeString);
        //memoize the time, for hiding purpose.
        this.timeStr = timeString;
    }

    public void hideTime() {
        time.setText("  ");
    }

    public void recoverTime() {
        time.setText(timeStr);
    }
}
