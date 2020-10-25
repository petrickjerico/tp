package seedu.address.ui;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.util.Callback;
import seedu.address.model.flashcard.Flashcard;

/**
 * A ui for the flashcards that is displayed next to the list of flashcard sets.
 */
public class FlashcardsDisplay extends UiPart<Region> {

    private static final String FXML = "FlashcardsDisplay.fxml";
    private static final String EMPTY_SET = "[no set selected to list]";


    @javafx.fxml.FXML
    private TableView flashcardsDisplay;

    @FXML
    private Label name;

    /**
     * Creates a {@code FlashcardsDisplay} with the given {@code FlashcardSet}.
     */
    public FlashcardsDisplay(ObservableList<Flashcard> data) {
        super(FXML);

        flashcardsDisplay.setEditable(false);

        TableColumn flNumbersCol = new TableColumn("No.");
        flNumbersCol.setMinWidth(30);
        flNumbersCol.setCellValueFactory(
                (Callback<TableColumn.CellDataFeatures<Flashcard, String>, ObservableValue<String>>) p ->
                        new ReadOnlyObjectWrapper(flashcardsDisplay.getItems().indexOf(p.getValue()) + 1));
        flNumbersCol.setSortable(false);

        TableColumn questionsCol = new TableColumn("Q");
        questionsCol.setMinWidth(100);
        questionsCol.setCellValueFactory(
                new PropertyValueFactory<Flashcard, String>("questionString")
        );

        TableColumn answersCol = new TableColumn("A");
        answersCol.setMinWidth(100);
        answersCol.setCellValueFactory(
                new PropertyValueFactory<Flashcard, String>("answerString")
        );

        flashcardsDisplay.setItems(data);
        flashcardsDisplay.getColumns().addAll(flNumbersCol, questionsCol, answersCol);
        flashcardsDisplay.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
}
