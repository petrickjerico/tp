package seedu.studybananas.ui.scheduleui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import seedu.studybananas.commons.core.LogsCenter;
import seedu.studybananas.logic.Logic;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.GeneralCommandResult;
import seedu.studybananas.logic.commands.commandresults.ScheduleCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.ui.UiPart;
import seedu.studybananas.ui.commons.CommandBox;
import seedu.studybananas.ui.commons.PositiveResponse;
import seedu.studybananas.ui.commons.ResponsePopUp;
import seedu.studybananas.ui.commons.WarningResponse;
import seedu.studybananas.ui.listeners.CommandResultStateListener;
import seedu.studybananas.ui.listeners.UiStateListener;
import seedu.studybananas.ui.util.GlobalState;
import seedu.studybananas.ui.util.UiStateType;
import seedu.studybananas.ui.util.UiUtil;

public class TaskDetailPanel extends UiPart<Region> {
    private static final String FXML = "TaskDetailPanel.fxml";
    private final Callback<CommandResult, Void> actionOnCommandResultChange = new Callback<CommandResult, Void>() {
        @Override
        public Void call(CommandResult state) {
            if (shouldRender(state)) {
                logger.info("Result: " + state.getFeedbackToUser());
                responsePopUp.setContent(new PositiveResponse(state.getFeedbackToUser()));
                responsePopUp.open();
            }
            return null;
        }
    };

    // empty callback
    private final Callback<UiStateType, Void> actionOnUiStateChange = (uiStateType) -> {
        return null;
    };

    private final Logger logger = LogsCenter.getLogger(getClass());

    private final Logic logic;

    // Independent Ui parts residing in this Ui container
    private TaskListPanel taskListPanel;
    private ResponsePopUp responsePopUp;
    private TaskDetailSkin taskDetailCard;
    private CommandResultStateListener commandResultStateListener;
    private UiStateListener uiStateListener;


    @FXML
    private StackPane commandBoxPlaceholder;

    @FXML
    private StackPane taskListPanelPlaceholder;

    @FXML
    private StackPane taskDetailCardPlaceholder;

    /**
     * Constructor for ScheduleUi.
     */
    public TaskDetailPanel() {
        super(FXML);

        // Set dependencies
        this.logic = GlobalState.getInstance().getLogic();
        this.responsePopUp = GlobalState.getInstance().getResponsePopUp();

        TaskDetailSkin taskDetailSkin = new TaskDetailSkin(logic);
        taskDetailCardPlaceholder.getChildren().add(taskDetailSkin.getRoot());

        taskListPanel = new TaskListPanel(logic.getFilteredTaskList(), logic);
        taskListPanelPlaceholder.getChildren().add(taskListPanel.getRoot());

        CommandBox commandBox = new CommandBox(this::executeCommand);
        commandBoxPlaceholder.getChildren().add(commandBox.getRoot());
        GlobalState globalState = GlobalState.getInstance();
        globalState.setScheduleCommandBox(commandBox);

        // set up listener
        commandResultStateListener = new CommandResultStateListener();
        uiStateListener = new UiStateListener();
        commandResultStateListener.onChange(actionOnCommandResultChange);
        uiStateListener.onChange(actionOnUiStateChange);

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
            if (UiUtil.isGeneralCommand(commandResult)) {
                UiUtil.handleGeneralCommand((GeneralCommandResult) commandResult);
                return commandResult;
            }
            uiStateListener.updateState(commandResult.getCommandResultType());
            commandResultStateListener.updateState(commandResult);
            return commandResult;
        } catch (CommandException | ParseException e) {
            logger.info("Invalid command: " + commandText);
            responsePopUp.setContent(new WarningResponse(e.getMessage()));
            responsePopUp.open();
            throw e;
        }
    }


    private boolean shouldRender(CommandResult commandResult) {
        return commandResult instanceof ScheduleCommandResult;
    }
}
