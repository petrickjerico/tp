package seedu.studybananas.ui;

import java.util.Arrays;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.util.Callback;
import seedu.studybananas.model.flashcard.Flashcard;

/**
 * A ui for the flashcards that is displayed next to the list of flashcard sets.
 */
public class FlashcardsDisplay extends UiPart<Region> {

    private static final String FXML = "FlashcardsDisplay.fxml";


    @javafx.fxml.FXML
    private TableView<Flashcard> flashcardsDisplay;

    /**
     * Creates a {@code FlashcardsDisplay} with the given {@code FlashcardSet}.
     */
    public FlashcardsDisplay(ObservableList<Flashcard> data) {
        super(FXML);

        flashcardsDisplay.setPlaceholder(new Label("No flashcard to show yet!"));
        flashcardsDisplay.setEditable(false);
        flashcardsDisplay.setItems(data);

        TableColumn<Flashcard, String> flNumbersCol =
                makeFlashcardColumn("No.", 40, p -> new ReadOnlyObjectWrapper<>(
                        String.valueOf(flashcardsDisplay.getItems().indexOf(p.getValue()) + 1)));

        TableColumn<Flashcard, String> questionsCol =
                makeFlashcardColumn("Question", 240, new PropertyValueFactory<>("questionString"));

        TableColumn<Flashcard, String> answersCol =
                makeFlashcardColumn("Answer", 240, new PropertyValueFactory<>("answerString"));

        flashcardsDisplay.getColumns().addAll(Arrays.asList(flNumbersCol, questionsCol, answersCol));
        flashcardsDisplay.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
        flashcardsDisplay.setMinWidth(Double.NEGATIVE_INFINITY);
    }

    /**
     * Private {@code TableColumn} constructor to refactor common initialization methods.
     *
     * @param headerTitle the column's title
     * @param maxWidth the column's max width
     * @param propertyValueFactory {@code Callback} function defining the column's content
     * @return a {@code TableColumn<Flashcard, String>} for the FlashcardsDisplay table.
     */
    private TableColumn<Flashcard, String> makeFlashcardColumn(
            String headerTitle,
            double maxWidth,
            Callback<TableColumn.CellDataFeatures<Flashcard, String>, ObservableValue<String>> propertyValueFactory
    ) {
        TableColumn<Flashcard, String> column = new TableColumn<>(headerTitle);
        column.setPrefWidth(maxWidth);

        // propertyValueFactory defines the Flashcard attribute filling this column
        column.setCellValueFactory(propertyValueFactory);

        // Make texts wrap in a table cell of fixed dimensions. Solution adapted from:
        // https://stackoverflow.com/a/22732723
        column.setCellFactory(tc -> {
            TableCell<Flashcard, String> cell = new TableCell<>();
            Text text = new Text();
            cell.setGraphic(text);
            cell.setPrefHeight(Control.USE_COMPUTED_SIZE);
            text.wrappingWidthProperty().bind(column.widthProperty());
            text.textProperty().bind(cell.itemProperty());
            return cell;
        });

        // Fix the column's position
        column.setReorderable(false);

        // Disable sorting so that flashcard details are consistent with indexes.
        column.setSortable(false);

        // Fix the column's width
        column.setResizable(false);

        return column;
    }

}
