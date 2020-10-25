package seedu.studybananas.logic.commands.schedulecommands;

import static java.util.Objects.requireNonNull;

import seedu.studybananas.commons.core.Messages;
import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.CommandResult;
import seedu.studybananas.model.ScheduleModel;
import seedu.studybananas.model.task.InfoContainsKeywordsPredicate;

public class ScheduleSearchCommand extends Command<ScheduleModel> {
    public static final String COMMAND_WORD = "search task";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all tasks whose names contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " CS2100";

    private final InfoContainsKeywordsPredicate predicate;

    public ScheduleSearchCommand(InfoContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(ScheduleModel model) {
        requireNonNull(model);
        model.updateFilteredTaskList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_TASKS_LISTED_OVERVIEW, model.getFilteredTaskList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ScheduleSearchCommand // instanceof handles nulls
                && predicate.equals(((ScheduleSearchCommand) other).predicate)); // state check
    }
}
