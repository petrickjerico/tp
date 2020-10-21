package seedu.address.ui.scheduleui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.ui.UiPart;

public class TimeScaleCell extends UiPart<Region> {
    private static final String FXML = "TimeScaleCell.fxml";

    @FXML
    private Label time;

    TimeScaleCell(String timeString) {
        super(FXML);
        time.setText(timeString);
    }

    void setMarginTop(int marginTop) {

    }
}
