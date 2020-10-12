package seedu.address.logic.commands.schedulecommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_TASKS;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.ScheduleModel;

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
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
