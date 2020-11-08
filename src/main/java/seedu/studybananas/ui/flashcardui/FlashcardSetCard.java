package seedu.studybananas.ui.flashcardui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import seedu.studybananas.logic.Logic;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.ui.UiPart;
import seedu.studybananas.ui.util.SingletonClickedFlashcardSetState;

public class FlashcardSetCard extends UiPart<Region> {
    private static final String FXML = "FlashcardSetCard.fxml";

    class StyleCombination {
        public final String backgroundColor;
        public final String innerColor;
        public final Image intersectImage;
        StyleCombination(String backgroundColor, String innerColor, Image intersectImage) {
            this.backgroundColor = backgroundColor;
            this.innerColor = innerColor;
            this.intersectImage = intersectImage;
        }
    }
    public final FlashcardSet flashcardSet;

    private Image blueIntersect = new Image(this.getClass()
            .getResourceAsStream("/images/blue-intersection.png"));
    private Image yellowIntersect = new Image(this.getClass()
            .getResourceAsStream("/images/yellow-intersection.png"));
    private Image pinkIntersect = new Image(this.getClass()
            .getResourceAsStream("/images/pink-intersection.png"));

    private final StyleCombination[] styles = new StyleCombination[] {
        new StyleCombination("#ABD6F5", "#ED78E8", pinkIntersect), //Tertiary
        new StyleCombination("#F5DBAB", "#7886ED", blueIntersect), //Primary
        new StyleCombination("#7886ED", "#F5DBAB", yellowIntersect) //Secondary
    };

    private SingletonClickedFlashcardSetState flashcardSetState;

    @FXML
    private Label id;
    @FXML
    private StackPane cardPane;
    @FXML
    private Label title;
    @FXML
    private Circle circle;
    @FXML
    private ImageView intersect;

    /**
     * Creates a {@code TaskCode} with the given {@code Task} and index to display.
     */
    public FlashcardSetCard(FlashcardSet flashcardSet, int displayedIndex) {
        super(FXML);
        this.flashcardSet = flashcardSet;
        StyleCombination style = this.styles[displayedIndex % 3];
        cardPane.setStyle("-fx-background-color: " + style.backgroundColor + "; "
                + "-fx-background-radius: 10; -fx-border-radius: 10;");
        id.setText(String.valueOf(displayedIndex) + ". ");
        title.setText(flashcardSet.getName().name);

        id.setStyle("-fx-text-fill: " + style.innerColor + "; -fx-font-weight: bold; -fx-font-family: Arial;");
        title.setStyle("-fx-text-fill: " + style.innerColor + "; -fx-font-weight: bold; -fx-font-family: Arial;");
        circle.setStyle("-fx-fill: " + style.innerColor);

        intersect.setImage(style.intersectImage);

        // get access to the state without subscribing to it.
        flashcardSetState = SingletonClickedFlashcardSetState.getInstance();
    }

    @FXML
    private void handleMouseClicked() {
        flashcardSetState.updateState(this.flashcardSet);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FlashcardSetCard)) {
            return false;
        }

        // state check
        FlashcardSetCard card = (FlashcardSetCard) other;
        return id.getText().equals(card.id.getText())
                && flashcardSet.equals(card.flashcardSet);
    }

}
