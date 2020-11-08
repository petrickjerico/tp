package seedu.studybananas.ui;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.studybananas.ui.scheduleui.TaskDetailPanel;
import seedu.studybananas.ui.scheduleui.UpcomingSchedule;

public class ScheduleUi extends UiPart<Region> {
    private static final String FXML = "ScheduleUi.fxml";

    @FXML
    private StackPane upcomingSchedulePlaceholder;

    @FXML
    private StackPane taskDetailPanelPlaceholder;

    ScheduleUi () {
        super(FXML);
        upcomingSchedulePlaceholder.getChildren().add(new UpcomingSchedule().getRoot());
        taskDetailPanelPlaceholder.getChildren().add(new TaskDetailPanel().getRoot());
    }


}
