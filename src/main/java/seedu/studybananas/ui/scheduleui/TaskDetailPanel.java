package seedu.studybananas.ui.scheduleui;

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
import seedu.studybananas.ui.TaskListPanel;
import seedu.studybananas.ui.UiPart;
import seedu.studybananas.ui.commons.PositiveResponse;
import seedu.studybananas.ui.commons.ResponsePopUp;
import seedu.studybananas.ui.commons.WarningResponse;

public class TaskDetailPanel extends UiPart<Region> {
    private static final String FXML = "TaskDetailPanel.fxml";

    private final Logger logger = LogsCenter.getLogger(getClass());

    private final Logic logic;

    // Independent Ui parts residing in this Ui container
    private TaskListPanel taskListPanel;
    private ResponsePopUp responsePopUp;
    private TaskDetailSkin taskDetailCard;

    @FXML
    private StackPane commandBoxPlaceholder;

    @FXML
    private StackPane taskListPanelPlaceholder;

    @FXML
    private StackPane taskDetailCardPlaceholder;

    /**
     * Constructor for ScheduleUi.
     */
    public TaskDetailPanel(Logic logic, ResponsePopUp responsePopUp) {
        super(FXML);

        // Set dependencies
        this.logic = logic;
        this.responsePopUp = responsePopUp;


        taskListPanel = new TaskListPanel(logic.getFilteredTaskList());
        taskListPanelPlaceholder.getChildren().add(taskListPanel.getRoot());

        CommandBox commandBox = new CommandBox(this::executeCommand);
        commandBoxPlaceholder.getChildren().add(commandBox.getRoot());
    }



    public TaskListPanel getTaskListPanel() {
        return taskListPanel;
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
            responsePopUp.setContent(new PositiveResponse(commandResult.getFeedbackToUser()));
            responsePopUp.open();
            return commandResult;
        } catch (CommandException | ParseException e) {
            logger.info("Invalid command: " + commandText);
            responsePopUp.setContent(new WarningResponse(e.getMessage()));
            responsePopUp.open();
            throw e;
        }
    }
}
