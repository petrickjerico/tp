package seedu.studybananas.ui.quizui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.studybananas.commons.core.LogsCenter;
import seedu.studybananas.logic.Logic;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.QuizCommandResult;
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
    private QuizScoreCard quizScoreDisplay;

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

            // special case for view quiz score
            Quiz quiz = logic.getQuizRecordsToView();
            if (quiz != null) {

                // replace quiz card with quiz score card
                quizScoreDisplay = new QuizScoreCard();
                quizCard.getChildren().removeAll(quizCard.getChildren());
                quizCard.getChildren().add(quizScoreDisplay.getRoot());

                // show score
                quizScoreDisplay.setFeedbackToUser(commandResult.getFeedbackToUser());

                // show stacked bar chart
                statistics = new Statistics(quiz);
                statisticsPlaceholder.getChildren().removeAll(statisticsPlaceholder.getChildren());
                statisticsPlaceholder.getChildren().add(statistics.getStackedBarChart());
                return commandResult;
            }

            // re-initialise the quiz card
            quizCard.getChildren().removeAll(quizCard.getChildren());
            quizCard.getChildren().add(resultDisplay.getRoot());

            // show quiz
            resultDisplay.setQuiz(commandResult.getQuiz());
            resultDisplay.setFeedbackToUser(commandResult.getFeedbackToUser());

            // remove statistics
            statisticsPlaceholder.getChildren().removeAll(statisticsPlaceholder.getChildren());
            return commandResult;

        } catch (CommandException | ParseException e) {
            logger.info("Invalid command: " + commandText);
            resultDisplay.setFeedbackToUser(e.getMessage());
            throw e;
        }
    }

}
