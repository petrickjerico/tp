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
import seedu.studybananas.model.quiz.Quiz;
import seedu.studybananas.ui.CommandBox;
import seedu.studybananas.ui.FlashcardSetListPanel;
import seedu.studybananas.ui.ResultDisplay;
import seedu.studybananas.ui.UiPart;

public class QuizUi extends UiPart<Region> {

    private static final String FXML = "QuizUi.fxml";
    private final Logic logic;
    private final Logger logger = LogsCenter.getLogger(getClass());

    private FlashcardSetListPanel flashcardSetListPanel;
    private ResultDisplay resultDisplay;
    private Statistics statistics;

    @javafx.fxml.FXML
    private StackPane commandBoxPlaceholder;

    @javafx.fxml.FXML
    private StackPane flashcardSetListPanelPlaceholder;

    @FXML
    private StackPane resultDisplayPlaceholder;

    @FXML
    private StackPane statisticsPlaceholder;

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
     * @see seedu.studybananas.logic.Logic#execute(String)
     */
    private CommandResult executeCommand(String commandText) throws CommandException, ParseException {
        try {
            CommandResult commandResult = logic.execute(commandText);
            logger.info("Result: " + commandResult.getFeedbackToUser());
            resultDisplay.setFeedbackToUser(commandResult.getFeedbackToUser());

            Quiz quiz = logic.getQuizRecordsToView();
            if (quiz != null) {
                statistics = new Statistics(quiz);
                statisticsPlaceholder.getChildren().removeAll(statisticsPlaceholder.getChildren());
                statisticsPlaceholder.getChildren().add(statistics.getPieChart());
            }

            return commandResult;
        } catch (CommandException | ParseException e) {
            logger.info("Invalid command: " + commandText);
            resultDisplay.setFeedbackToUser(e.getMessage());
            throw e;
        }
    }

}
