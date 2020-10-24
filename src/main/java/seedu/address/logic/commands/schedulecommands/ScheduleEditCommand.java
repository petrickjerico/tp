package seedu.address.logic.commands.schedulecommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_DUPLICATED_TASK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DURATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TITLE;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.ScheduleModel;
import seedu.address.model.task.DateTime;
import seedu.address.model.task.Description;
import seedu.address.model.task.Duration;
import seedu.address.model.task.Task;
import seedu.address.model.task.Title;
import seedu.address.model.task.exceptions.DuplicateTaskException;

public class ScheduleEditCommand extends Command<ScheduleModel> {
    public static final String COMMAND_WORD = "edit task";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the task identified by the index number used in the displayed task list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + PREFIX_TITLE + "TITLE (if any) \n"
            + PREFIX_DESCRIPTION + "DESCRIPTION (if any) \n"
            + PREFIX_TIME + "TIME (if any) \n"
            + PREFIX_DURATION + "DURATION (if any) \n"
            + "Example: " + COMMAND_WORD + " 1 T: Household dur: 60";

    public static final String MESSAGE_EDIT_TASK_SUCCESS = "Edited Task: %1$s";

    private final Index targetIndex;
    private final Title title;
    private final Description description;
    private final DateTime dateTime;
    private final Duration duration;

    /**
     * Creates an ScheduleEditCommand to edit the specified task at {@code Index}
     */
    public ScheduleEditCommand(
            Index targetIndex, Title title, Description description, DateTime dateTime, Duration duration) {
        this.targetIndex = targetIndex;
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.duration = duration;
    }

    private Task generateEditedTask(
            Task taskToEdit, Title newTitle, Description newDescription, DateTime newDateTime, Duration newDuration) {
        Title title = newTitle == null ? taskToEdit.getTitle() : newTitle;
        Description description = newDescription == null ? taskToEdit.getDescription().orElse(null) : newDescription;
        DateTime dateTime = newDateTime == null ? taskToEdit.getDateTime().orElse(null) : newDateTime;
        Duration duration = newDuration == null ? taskToEdit.getDuration().orElse(null) : newDuration;
        Task editedTask = new Task(title, description, dateTime, duration);
        return editedTask;
    }

    @Override
    public CommandResult execute(ScheduleModel model) throws CommandException {
        requireNonNull(model);
        List<Task> lastShownList = model.getFilteredTaskList();

        if (targetIndex.getOneBased() > lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }

        try {
            Task taskToEdit = lastShownList.get(targetIndex.getZeroBased());
            Task editedTask = generateEditedTask(taskToEdit, title, description, dateTime, duration);
            model.setTask(taskToEdit, editedTask);
            return new CommandResult(String.format(MESSAGE_EDIT_TASK_SUCCESS, editedTask));
        } catch (DuplicateTaskException e) {
            throw new CommandException(MESSAGE_DUPLICATED_TASK);
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ScheduleEditCommand // instanceof handles nulls
                && targetIndex.equals(((ScheduleEditCommand) other).targetIndex)); // state check
    }
}
