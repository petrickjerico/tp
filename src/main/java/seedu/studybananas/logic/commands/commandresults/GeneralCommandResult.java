package seedu.studybananas.logic.commands.commandresults;

import static seedu.studybananas.ui.util.UiStateType.GENERAL;

import seedu.studybananas.ui.util.UiStateType;

public class GeneralCommandResult extends CommandResult {
    public enum GeneralCommandType {
        HELP, EXIT;
    }

    private final GeneralCommandType commandType;

    /**
     * Constructs GeneralCommandResult from feedbackToUser and {@Code commandType}.
     */
    public GeneralCommandResult(String feedbackToUser, GeneralCommandType commandType) {
        super(feedbackToUser);
        this.commandType = commandType;
    }

    @Override
    public UiStateType getCommandResultType() {
        return GENERAL;
    }

    public GeneralCommandType getGeneralCommandType() {
        return commandType;
    }
}
