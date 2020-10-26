package seedu.studybananas.ui.scheduleui;

import static seedu.studybananas.ui.util.ScheduleUiUtil.checkTimePattern;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.studybananas.ui.UiPart;

public class CurrentTimePointer extends UiPart<Region> {
    private static final String FXML = "CurrentTimePointer.fxml";

    @FXML
    private Label currentTime;
    @FXML
    private HBox currentTimePointer;

    /**
     * Constructor of CurrentTimePointer
     * @param time must be the format of hh:mm AM/PM
     */
    public CurrentTimePointer(String time) {
        super(FXML);
        assert checkTimePattern(time);
        currentTime.setText(time);
    }

    public void updateTime(String time) {
        currentTime.setText(time);
    }


}
