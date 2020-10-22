package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.Logic;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;

public class FlashcardUi extends UiPart<Region> {
    private static final String FXML = "FlashcardUi.fxml";

    private final Logger logger = LogsCenter.getLogger(getClass());

    private final Logic logic;

    // Independent Ui parts residing in this Ui container
    private FlashcardSetListPanel flashcardSetListPanel;
    private ResultDisplay resultDisplay;

    @javafx.fxml.FXML
    private StackPane commandBoxPlaceholder;

    @FXML
    private StackPane flashcardSetListPanelPlaceholder;

    @FXML
    private StackPane resultDisplayPlaceholder;

    @FXML
    private StackPane flashcardDisplay;

    /**
     * Constructor for ScheduleUi.
     */
    public FlashcardUi(Logic logic) {
        super(FXML);

        // Set dependencies
        this.logic = logic;

        flashcardSetListPanel = new FlashcardSetListPanel(logic.getFilteredFlashcardSetList());
        flashcardSetListPanelPlaceholder.getChildren().add(flashcardSetListPanel.getRoot());

        resultDisplay = new ResultDisplay();
        resultDisplayPlaceholder.getChildren().add(resultDisplay.getRoot());

        CommandBox commandBox = new CommandBox(this::executeCommand);
        commandBoxPlaceholder.getChildren().add(commandBox.getRoot());
    }



    public FlashcardSetListPanel getFlashcardSetListPanel() {
        return flashcardSetListPanel;
    }

    /**
     * Executes the command and returns the result.
     *
     * @see seedu.address.logic.Logic#execute(String)
     */
    private CommandResult executeCommand(String commandText) throws CommandException, ParseException {
        try {
            CommandResult commandResult = logic.execute(commandText);
            logger.info("Result: " + commandResult.getFeedbackToUser());
            resultDisplay.setFeedbackToUser(commandResult.getFeedbackToUser());

            return commandResult;
        } catch (CommandException | ParseException e) {
            logger.info("Invalid command: " + commandText);
            resultDisplay.setFeedbackToUser(e.getMessage());
            throw e;
        }
    }
}
