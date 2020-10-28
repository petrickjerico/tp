package seedu.studybananas.logic.commands.schedulecommands;

import static java.util.Objects.requireNonNull;
import static seedu.studybananas.model.Model.PREDICATE_SHOW_ALL_TASKS;

import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.ScheduleCommandResult;
import seedu.studybananas.model.ScheduleModel;

/**
 * Lists all tasks in the Schedule to the user.
 */
public class ScheduleListCommand extends Command<ScheduleModel> {
    public static final String COMMAND_WORD = "list task";

    public static final String MESSAGE_SUCCESS = "Listed all tasks.";


    @Override
    public CommandResult execute(ScheduleModel model) {
        requireNonNull(model);
        model.updateFilteredTaskList(PREDICATE_SHOW_ALL_TASKS);
        return new ScheduleCommandResult(MESSAGE_SUCCESS);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        return obj instanceof ScheduleListCommand;
    }
}
