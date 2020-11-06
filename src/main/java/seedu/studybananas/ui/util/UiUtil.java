package seedu.studybananas.ui.util;

import javafx.stage.Stage;
import seedu.studybananas.commons.core.GuiSettings;
import seedu.studybananas.logic.Logic;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.GeneralCommandResult;
import seedu.studybananas.ui.HelpWindow;

public class UiUtil {
    /**
     * Handles General Command.
     * @param commandResult
     */
    public static void handleGeneralCommand(GeneralCommandResult commandResult) {
        switch (commandResult.getGeneralCommandType()) {
        case HELP:
            handleHelpWindow();
            break;
        case EXIT:
            handleExit();
            break;
        default:
            assert false : "you should check isGeneralCommand First";
        }
    }

    private static void handleHelpWindow() {
        HelpWindow helpWindow = GlobalState.getInstance().getHelpWindow();
        if (!helpWindow.isShowing()) {
            helpWindow.show();
        } else {
            helpWindow.focus();
        }
    }

    private static void handleExit() {
        // Get global state.
        Stage primaryStage = GlobalState.getInstance().getPrimaryStage();
        HelpWindow helpWindow = GlobalState.getInstance().getHelpWindow();
        Logic logic = GlobalState.getInstance().getLogic();

        GuiSettings guiSettings = new GuiSettings(primaryStage.getWidth(), primaryStage.getHeight(),
                (int) primaryStage.getX(), (int) primaryStage.getY());
        logic.setGuiSettings(guiSettings);
        helpWindow.hide();
        primaryStage.hide();
    }

    /**
     * Checks if {@Code commandResult} is a general command.
     */
    public static boolean isGeneralCommand(CommandResult commandResult) {
        return commandResult.getCommandResultType() == UiStateType.GENERAL;
    }
}
