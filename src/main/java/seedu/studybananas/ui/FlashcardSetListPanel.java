package seedu.studybananas.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.studybananas.commons.core.LogsCenter;
import seedu.studybananas.logic.Logic;
import seedu.studybananas.model.flashcard.FlashcardSet;

/**
 * Panel containing the list of persons.
 */
public class FlashcardSetListPanel extends UiPart<Region> {
    private static final String FXML = "FlashcardSetListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(FlashcardSetListPanel.class);

    @FXML
    private ListView<FlashcardSet> flashcardSetListView;

    private Logic logic;

    /**
     * Creates a {@code TaskListPanel} with the given {@code ObservableList}.
     */
    public FlashcardSetListPanel(Logic logic) {
        super(FXML);
        this.logic = logic;
        flashcardSetListView.setSelectionModel(null);
        flashcardSetListView.setItems(logic.getFilteredFlashcardSetList());
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
                setGraphic(new FlashcardSetCard(logic, flashcardSet, getIndex() + 1).getRoot());
            }
        }
    }

}
