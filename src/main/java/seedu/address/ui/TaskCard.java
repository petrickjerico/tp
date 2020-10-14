package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.task.Task;

public class TaskCard extends UiPart<Region> {
    private static final String FXML = "TaskListCard.fxml";
    private static final String[] BACKGROUND_COLOR = new String[]{
            "linear-gradient(to right, #ff7f50, #6a5acd);",
            "linear-gradient(to right, #D2F064, #4BC61A);",
            "linear-gradient(to right, #EAC887, #E6D4B3);"};
    public final Task task;

    @FXML
    private Label id;
    @FXML
    private HBox cardPane;
    @FXML
    private Label title;
    @FXML
    private Label description;
    @FXML
    private Label time;

    /**
     * Creates a {@code TaskCode} with the given {@code Task} and index to display.
     */
    public TaskCard(Task task, int displayedIndex) {
        super(FXML);
        this.task = task;
        cardPane.setStyle("-fx-background-color: " + BACKGROUND_COLOR[displayedIndex % 3]);
        id.setText(displayedIndex + ". ");
        title.setText(task.getTitle().title);
        description.setText(task.getDescription().map(des-> des.description).orElse(""));
        time.setText(task.getDateTime().map(time -> time.toString()).orElse(""));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PersonCard)) {
            return false;
        }

        // state check
        TaskCard card = (TaskCard) other;
        return id.getText().equals(card.id.getText())
                && task.equals(card.task);
    }
}
