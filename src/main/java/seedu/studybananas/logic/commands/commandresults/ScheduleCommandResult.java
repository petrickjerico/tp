package seedu.studybananas.logic.commands.commandresults;

public class ScheduleCommandResult extends CommandResult {

    public ScheduleCommandResult(String feedbackToUser) {
        super(feedbackToUser);
    }

    @Override
    public CommmandResultType getCommandResultType() {
        return CommmandResultType.Schedule;
    }

}
