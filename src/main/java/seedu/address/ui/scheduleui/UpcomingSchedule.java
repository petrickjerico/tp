package seedu.address.ui.scheduleui;

import java.sql.Time;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.ui.UiPart;

public class UpcomingSchedule extends UiPart<Region> {
    private static final String FXML = "UpcomingSchedule.fxml";

    @FXML
    private VBox schedule;

    @FXML
    private Label date;

    @FXML
    private Label year;

    @FXML
    private Label day;

    public UpcomingSchedule() {
        super(FXML);
        fillInner();
    }

    private void fillInner() {
        schedule.getChildren().add(new TimeScale().getRoot());
    }
    


}
