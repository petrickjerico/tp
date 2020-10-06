package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.task.Task;

public class TaskCard extends UiPart<Region> {
    private static final String FXML = "TaskListCard.fxml";

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
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public TaskCard(Task task, int displayedIndex) {
        super(FXML);
        this.task = task;
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
