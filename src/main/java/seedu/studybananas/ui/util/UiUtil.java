package seedu.studybananas.ui.util;

import seedu.studybananas.logic.commands.commandresults.CommandResult;

public class UiUtil {
    public static void handleGeneralCommand(CommandResult commandResult) {

    }

    public static boolean isGeneralCommand(CommandResult commandResult) {
        return commandResult.getCommandResultType() == UiStateType.GENERAL;
    }
}
