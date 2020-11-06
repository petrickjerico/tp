package seedu.studybananas.ui;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.studybananas.logic.Logic;
import seedu.studybananas.ui.commons.ResponsePopUp;
import seedu.studybananas.ui.scheduleui.TaskDetailPanel;
import seedu.studybananas.ui.scheduleui.UpcomingSchedule;
import seedu.studybananas.ui.util.GlobalState;

public class ScheduleUi extends UiPart<Region> {
    private static final String FXML = "ScheduleUi.fxml";

    @FXML
    private StackPane upcomingSchedulePlaceholder;

    @FXML
    private StackPane taskDetailPanelPlaceholder;

    ScheduleUi (ResponsePopUp responsePopUp) {
        super(FXML);
        Logic logic = GlobalState.getInstance().getLogic();
        upcomingSchedulePlaceholder.getChildren().add(new UpcomingSchedule(logic).getRoot());
        taskDetailPanelPlaceholder.getChildren().add(new TaskDetailPanel(logic, responsePopUp).getRoot());
    }


}
