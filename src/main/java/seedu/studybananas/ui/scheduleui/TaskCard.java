package seedu.studybananas.ui.scheduleui;

import static seedu.studybananas.ui.util.ScheduleUiUtil.constructQuizDescription;
import static seedu.studybananas.ui.util.ScheduleUiUtil.replaceComponent;
import static seedu.studybananas.ui.util.ScheduleUiUtil.toAmPmTime;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.studybananas.logic.Logic;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.model.task.Task;
import seedu.studybananas.ui.UiPart;
import seedu.studybananas.ui.util.SingletonCommandResultState;
import seedu.studybananas.ui.util.SingletonUiState;

public class TaskCard extends UiPart<Region> {
    private static final String FXML = "TaskListCard.fxml";
    private static final String[] BACKGROUND_COLOR = new String[]{
        "#ff6666", //red
        "#3366ff;", //blue
        "#cc66ff", //purple
    };
    public final Task task;

    @FXML
    private Label id;
    @FXML
    private HBox cardPane;
    @FXML
    private HBox descriptionPane;
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

    private SingletonCommandResultState commandResultState;
    private SingletonUiState uiState;
    private Logic logic;

    /**
     * Creates a {@code TaskCode} with the given {@code Task} and index to display.
     */
    public TaskCard(Task task, int displayedIndex, Logic logic) {
        super(FXML);
        this.task = task;
        this.logic = logic;
        cardPane.setStyle("-fx-background-color: " + BACKGROUND_COLOR[displayedIndex % 3]);
        id.setText(String.valueOf(displayedIndex));
        title.setText(task.getTitle().title);
        date.setText(task.getDateTime().map(time -> time.getUiFormatDate()).orElse(""));
        time.setText(task.getDateTime().map(time -> toAmPmTime(time.getStandardFormatTime())).orElse(""));
        duration.setText(task.getDuration().map(dur -> Integer.toString(dur.duration)).orElse(""));

        //set up description
        String descriptionStr = task.getDescription().map(des-> des.description).orElse("");
        handleDescription(descriptionStr);

        // observe the states
        commandResultState = SingletonCommandResultState.getInstance();
        uiState = SingletonUiState.getInstance();
    }

    private void handleDescription(String description) {
        try {
            QuizDescription descripLabel = constructQuizDescription(description, logic);
            replaceComponent(this.description, descripLabel.getRoot(), descriptionPane);
        } catch (ParseException | IndexOutOfBoundsException e) {
            this.description.setText(description);
        }
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof TaskCard)) {
            return false;
        }

        // state check
        TaskCard card = (TaskCard) other;
        return id.getText().equals(card.id.getText())
                && task.equals(card.task);
    }
}
