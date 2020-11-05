package seedu.studybananas.ui.scheduleui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.paint.Paint;
import seedu.studybananas.logic.Logic;
import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.QuizErrorCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.logic.commands.quizcommands.StartCommand;
import seedu.studybananas.ui.UiPart;
import seedu.studybananas.ui.util.SingletonCommandResultState;
import seedu.studybananas.ui.util.SingletonUiState;
import seedu.studybananas.ui.util.UiStateType;

public class QuizDescription extends UiPart<Region> {
    private static final String FXML = "QuizDescription.fxml";

    @FXML
    private Label description;

    private SingletonUiState uiState;
    private SingletonCommandResultState commandResultState;
    private Command quizStartCommand;
    private Logic logic;

    /**
     * Constructor for QuizDescription.
     */
    public QuizDescription(String description, Command quizStartCommand, Logic logic) {
        super(FXML);
        assert quizStartCommand instanceof StartCommand : "You should only construct a QuizDescription Label "
                + "if the description is start command";
        this.description.setText(description);
        this.quizStartCommand = quizStartCommand;
        this.logic = logic;

        // weird bug!
        this.description.setTextFill(Paint.valueOf("#ffffff"));

        uiState = SingletonUiState.getInstance();
        commandResultState = SingletonCommandResultState.getInstance();
    }

    @FXML
    private void handleMouseClicked() {
        try {
            CommandResult commandResult = logic.execute(quizStartCommand);
            commandResultState.updateCommandResult(commandResult);
            uiState.updateState(UiStateType.QUIZ);
        } catch (CommandException e) {
            uiState.updateState(UiStateType.QUIZ);
            commandResultState.updateCommandResult(new QuizErrorCommandResult(e.getMessage()));
        }
    }
}
