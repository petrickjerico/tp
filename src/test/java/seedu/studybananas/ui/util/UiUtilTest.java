package seedu.studybananas.ui.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.studybananas.logic.commands.commandresults.GeneralCommandResult.GeneralCommandType.EXIT;
import static seedu.studybananas.logic.commands.commandresults.GeneralCommandResult.GeneralCommandType.HELP;

import org.junit.jupiter.api.Test;

import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.GeneralCommandResult;
import seedu.studybananas.logic.commands.commandresults.ScheduleCommandResult;

public class UiUtilTest {
    @Test
    public void isGeneralCommand_validType() {
        String feedBackPlaceholder = "";
        GeneralCommandResult helpCommandResult = new GeneralCommandResult(feedBackPlaceholder, HELP);
        GeneralCommandResult exitCommandResult = new GeneralCommandResult(feedBackPlaceholder, EXIT);
        CommandResult invalidCommandResult = new ScheduleCommandResult(feedBackPlaceholder);

        // EP1 general command
        assertTrue(UiUtil.isGeneralCommand(helpCommandResult));
        assertTrue(UiUtil.isGeneralCommand(exitCommandResult));

        // EP2 invalid command result type
        assertFalse(UiUtil.isGeneralCommand(invalidCommandResult));
    }
}
