package seedu.studybananas.ui.commons;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.studybananas.ui.UiPart;

public class PositiveResponse extends UiPart<Region> {
    private static final String FXML = "PositiveResponse.fxml";

    @FXML
    private Label response;

    /**
     * Constructor for the PositiveResponse.
     */
    public PositiveResponse(String response) {
        super(FXML);
        this.response.setText(response);
    }

}
