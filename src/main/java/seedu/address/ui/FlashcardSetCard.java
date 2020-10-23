package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.flashcard.FlashcardSet;

public class FlashcardSetCard extends UiPart<Region> {
    private static final String FXML = "FlashcardSetCard.fxml";
    private static final String[] BACKGROUND_COLOR = new String[]{
        "#ff6666", //red
        "#3366ff;", //blue
        "#cc66ff", //purple
    };
    public final FlashcardSet flashcardSet;

    @javafx.fxml.FXML
    private Label id;
    @FXML
    private HBox cardPane;
    @FXML
    private Label title;

    /**
     * Creates a {@code TaskCode} with the given {@code Task} and index to display.
     */
    public FlashcardSetCard(FlashcardSet flashcardSet, int displayedIndex) {
        super(FXML);
        this.flashcardSet = flashcardSet;
        cardPane.setStyle("-fx-background-color: " + BACKGROUND_COLOR[displayedIndex % 3]);
        id.setText(String.valueOf(displayedIndex));
        title.setText(flashcardSet.getName().name);
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
        FlashcardSetCard card = (FlashcardSetCard) other;
        return id.getText().equals(card.id.getText())
                && flashcardSet.equals(card.flashcardSet);
    }
}
