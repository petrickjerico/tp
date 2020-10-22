package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.address.logic.Logic;
import seedu.address.ui.scheduleui.TaskDetailPanel;
import seedu.address.ui.scheduleui.UpcomingSchedule;

public class ScheduleUi extends UiPart<Region> {
    private static final String FXML = "ScheduleUi.fxml";

    @FXML
    private StackPane upcomingSchedulePlaceholder;

    @FXML
    private StackPane taskDetailPanelPlaceholder;

    ScheduleUi (Logic logic) {
        super(FXML);
        upcomingSchedulePlaceholder.getChildren().add(new UpcomingSchedule(logic).getRoot());
        taskDetailPanelPlaceholder.getChildren().add(new TaskDetailPanel(logic).getRoot());
    }

}
