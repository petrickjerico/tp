package seedu.studybananas.logic.commands.schedulecommands;

import static java.util.Objects.requireNonNull;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_TIME;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_TITLE;

import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.ScheduleCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.ScheduleModel;
import seedu.studybananas.model.task.Task;

public class ScheduleAddCommand extends Command<ScheduleModel> {
    public static final String COMMAND_WORD = "add task";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a task to the schedule. \n"
            + "Parameters: \n"
            + PREFIX_TITLE + "TITLE \n"
            + PREFIX_DESCRIPTION + "DESCRIPTION \n"
            + "[" + PREFIX_TIME + "TIME] ";

    public static final String MESSAGE_SUCCESS = "New task added: %1$s";
    public static final String MESSAGE_DUPLICATE_TASK = "This task already exists in the schedule";

    private final Task toAdd;

    /**
     * Creates an ScheduleAddCommand to add the specified {@code Task}
     */
    public ScheduleAddCommand(Task task) {
        requireNonNull(task);
        toAdd = task;
    }

    @Override
    public CommandResult execute(ScheduleModel model) throws CommandException {
        requireNonNull(model);

        if (model.hasTask(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_TASK);
        }

        model.addTask(toAdd);

        return new ScheduleCommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ScheduleAddCommand // instanceof handles nulls
                && toAdd.equals(((ScheduleAddCommand) other).toAdd));
    }
}
