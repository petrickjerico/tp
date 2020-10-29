package seedu.studybananas.ui.commons;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.studybananas.ui.UiPart;

public class CommandHelpLabel extends UiPart<Region> {
    private static final String FXML = "CommandHelpLabel.fxml";

    @FXML
    HBox labelPane;
    @FXML
    Label command;
    @FXML
    Label argument;
    @FXML
    Label description;

    public CommandHelpLabel(String command, String argument, String description) {
        super(FXML);
        this.command.setText(command);
        this.description.setText(description);

        // remove argument label when argument does not exist
        if (argument == null) {
            labelPane.getChildren().remove(this.argument);
        } else {
            this.argument.setText(argument);
        }


    }
}
