package seedu.studybananas.ui.quizui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.studybananas.commons.core.LogsCenter;
import seedu.studybananas.logic.Logic;
import seedu.studybananas.logic.commands.CommandResult;
import seedu.studybananas.logic.commands.QuizCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.model.quiz.Quiz;
import seedu.studybananas.ui.CommandBox;
import seedu.studybananas.ui.FlashcardSetListPanel;
import seedu.studybananas.ui.UiPart;

public class QuizUi extends UiPart<Region> {

    private static final String FXML = "QuizUi.fxml";
    private final Logic logic;
    private final Logger logger = LogsCenter.getLogger(getClass());

    private FlashcardSetListPanel flashcardSetListPanel;
    private Statistics statistics;
    private QuizCard resultDisplay;

    @FXML
    private StackPane flashcardSetListPanelPlaceholder;

    @FXML
    private StackPane commandBoxPlaceholder;

    @FXML
    private StackPane statisticsPlaceholder;

    @FXML
    private StackPane quizCard;

    /**
     * Constructs a QuizUi object.
     * @param logic provided
     */
    public QuizUi(Logic logic) {
        super(FXML);
        this.logic = logic;

        flashcardSetListPanel = new FlashcardSetListPanel(logic.getFilteredFlashcardSetList());
        flashcardSetListPanelPlaceholder.getChildren().add(flashcardSetListPanel.getRoot());

        resultDisplay = new QuizCard();
        quizCard.getChildren().add(resultDisplay.getRoot());

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
            QuizCommandResult commandResult = (QuizCommandResult) logic.execute(commandText); //include check instanceof
            logger.info("Result: " + commandResult.getFeedbackToUser());
            resultDisplay.setQuiz(commandResult.getQuiz());
            resultDisplay.setFeedbackToUser(commandResult.getFeedbackToUser());

            Quiz quiz = logic.getQuizRecordsToView();
            if (quiz != null) {
                statistics = new Statistics(quiz);
                statisticsPlaceholder.getChildren().removeAll(statisticsPlaceholder.getChildren());
                statisticsPlaceholder.getChildren().add(statistics.getStackedBarChart());
                return commandResult;
            }

            statisticsPlaceholder.getChildren().removeAll(statisticsPlaceholder.getChildren());
            return commandResult;
        } catch (CommandException | ParseException e) {
            logger.info("Invalid command: " + commandText);
            resultDisplay.setFeedbackToUser(e.getMessage());
            throw e;
        }
    }

}
