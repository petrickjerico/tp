package seedu.studybananas.ui.quizui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.studybananas.commons.core.LogsCenter;
import seedu.studybananas.logic.Logic;
import seedu.studybananas.logic.commands.CommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.ui.CommandBox;
import seedu.studybananas.ui.FlashcardSetListPanel;
import seedu.studybananas.ui.FlashcardsDisplay;
import seedu.studybananas.ui.ResultDisplay;
import seedu.studybananas.ui.UiPart;

public class QuizUi extends UiPart<Region> {

    private static final String FXML = "QuizUi.fxml";
    private final Logic logic;
    private final Logger logger = LogsCenter.getLogger(getClass());

    private FlashcardSetListPanel flashcardSetListPanel;
    private ResultDisplay resultDisplay;
    private FlashcardsDisplay flashcardsDisplay;

    @javafx.fxml.FXML
    private StackPane commandBoxPlaceholder;

    @javafx.fxml.FXML
    private StackPane flashcardSetListPanelPlaceholder;

    @FXML
    private StackPane resultDisplayPlaceholder;

    @FXML
    private StackPane flashcardsDisplayPlaceholder;

    /**
     * Constructs a QuizUi object.
     * @param logic provided
     */
    public QuizUi(Logic logic) {
        super(FXML);
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
