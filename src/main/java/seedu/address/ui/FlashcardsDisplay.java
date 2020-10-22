package seedu.address.ui;

import static java.util.Objects.requireNonNull;

import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;

/**
 * A ui for the flashcards that is displayed next to the list of flashcard sets.
 */
public class FlashcardsDisplay extends UiPart<Region> {

    private static final String FXML = "FlashcardsDisplay.fxml";

    @javafx.fxml.FXML
    private TextArea flashcardsDisplay;

    public FlashcardsDisplay() {
        super(FXML);
    }

    public void setFlashcardsDisplay(String display) {
        requireNonNull(display);
        flashcardsDisplay.setText(display);
    }

}
