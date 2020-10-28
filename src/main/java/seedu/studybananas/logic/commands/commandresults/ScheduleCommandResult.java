package seedu.studybananas.logic.commands.commandresults;

import seedu.studybananas.ui.util.UiStateType;

public class ScheduleCommandResult extends CommandResult {

    public ScheduleCommandResult(String feedbackToUser) {
        super(feedbackToUser);
    }

    @Override
    public UiStateType getCommandResultType() {
        return UiStateType.SCHEDULE;
    }

}
