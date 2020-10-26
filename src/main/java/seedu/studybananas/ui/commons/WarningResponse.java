package seedu.studybananas.ui.commons;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WarningResponse extends Response {
    private static final String FXML = "WarningResponse.fxml";

    @FXML
    private Label response;

    /**
     * Constructor for the PositiveResponse.
     */
    public WarningResponse(String response) {
        super(FXML);
        this.response.setText(response);
    }

}

