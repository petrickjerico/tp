package seedu.studybananas.logic.commands.schedulecommands;

import static java.util.Objects.requireNonNull;
import static seedu.studybananas.commons.core.Messages.MESSAGE_DUPLICATED_TASK;
import static seedu.studybananas.commons.core.Messages.MESSAGE_OVERLAP_TASK;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_DURATION;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_TIME;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_TITLE;

import java.util.List;

import seedu.studybananas.commons.core.Messages;
import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.ScheduleCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.ScheduleModel;
import seedu.studybananas.model.task.DateTime;
import seedu.studybananas.model.task.Description;
import seedu.studybananas.model.task.Duration;
import seedu.studybananas.model.task.Task;
import seedu.studybananas.model.task.Title;

public class ScheduleEditCommand extends Command<ScheduleModel> {
    public static final String COMMAND_WORD = "edit task";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the task identified by the index number used in the displayed task list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + PREFIX_TITLE + "TITLE (if any) \n"
            + PREFIX_DESCRIPTION + "DESCRIPTION (if any) \n"
            + PREFIX_TIME + "TIME (if any) \n"
            + PREFIX_DURATION + "DURATION (if any in minutes) \n"
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

        //try {
        Task taskToEdit = lastShownList.get(targetIndex.getZeroBased());
        Task editedTask = generateEditedTask(taskToEdit, title, description, dateTime, duration);
        if (taskToEdit.isSameTask(editedTask) || model.hasTask(editedTask)) {
            throw new CommandException(MESSAGE_DUPLICATED_TASK);
        }
        if (model.isTaskOverlapped(taskToEdit, editedTask)) {
            throw new CommandException(MESSAGE_OVERLAP_TASK);
        }
        model.setTask(taskToEdit, editedTask);
        return new ScheduleCommandResult(String.format(MESSAGE_EDIT_TASK_SUCCESS, editedTask));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ScheduleEditCommand // instanceof handles nulls
                && targetIndex.equals(((ScheduleEditCommand) other).targetIndex)); // state check
    }
}
