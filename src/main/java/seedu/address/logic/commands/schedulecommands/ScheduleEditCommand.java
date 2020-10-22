package seedu.address.logic.commands.schedulecommands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.ScheduleModel;
import seedu.address.model.task.DateTime;
import seedu.address.model.task.Description;
import seedu.address.model.task.Task;
import seedu.address.model.task.Title;

public class ScheduleEditCommand extends Command<ScheduleModel> {
    public static final String COMMAND_WORD = "edit task";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the task identified by the index number used in the displayed task list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_EDIT_TASK_SUCCESS = "Edited Task: %1$s";

    private final Index targetIndex;
    private final Title title;
    private final Description description;
    private final DateTime dateTime;

    public ScheduleEditCommand(Index targetIndex, Title title, Description description, DateTime dateTime) {
        this.targetIndex = targetIndex;
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
    }

    private Task generateEditedTask(Task taskToEdit, Title newTitle, Description newDescription, DateTime newDateTime) {
        Title title = newTitle == null ? taskToEdit.getTitle() : newTitle;
        Description description = newDescription == null ? taskToEdit.getDescription().get() : newDescription;
        DateTime dateTime = newDateTime == null ? taskToEdit.getDateTime().get() : newDateTime;
        Task editedTask = new Task(title, description, dateTime);
        return editedTask;
    }

    @Override
    public CommandResult execute(ScheduleModel model) throws CommandException {
        requireNonNull(model);
        List<Task> lastShownList = model.getFilteredTaskList();

        if (targetIndex.getOneBased() > lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }

        Task taskToEdit = lastShownList.get(targetIndex.getZeroBased());
        Task editedTask = generateEditedTask(taskToEdit, title, description, dateTime);
        model.setTask(taskToEdit, editedTask);
        return new CommandResult(String.format(MESSAGE_EDIT_TASK_SUCCESS, editedTask));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ScheduleEditCommand // instanceof handles nulls
                && targetIndex.equals(((ScheduleEditCommand) other).targetIndex)); // state check
    }
}
