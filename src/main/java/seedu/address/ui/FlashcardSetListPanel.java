package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.flashcard.FlashcardSet;

/**
 * Panel containing the list of persons.
 */
public class FlashcardSetListPanel extends UiPart<Region> {
    private static final String FXML = "FlashcardSetListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(FlashcardSetListPanel.class);

    @javafx.fxml.FXML
    private ListView<FlashcardSet> flashcardSetListView;

    /**
     * Creates a {@code TaskListPanel} with the given {@code ObservableList}.
     */
    public FlashcardSetListPanel(ObservableList<FlashcardSet> flashcardSets) {
        super(FXML);
        flashcardSetListView.setItems(flashcardSets);
        flashcardSetListView.setCellFactory(listView -> new FlashcardSetListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Task} using a {@code TaskCard}.
     */
    class FlashcardSetListViewCell extends ListCell<FlashcardSet> {
        @Override
        protected void updateItem(FlashcardSet flashcardSet, boolean empty) {
            super.updateItem(flashcardSet, empty);

            setStyle("-fx-padding: 4px");

            if (empty || flashcardSet == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new FlashcardSetCard(flashcardSet, getIndex() + 1).getRoot());
            }
        }
    }

}
