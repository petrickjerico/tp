package seedu.studybananas.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.studybananas.logic.commands.commandresults.GeneralCommandResult.GeneralCommandType.EXIT;

import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.GeneralCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.Model;

public class ExitCommand extends Command<Model> {
    public static final String COMMAND_WORD = "exit";

    public static final String MESSAGE_SUCCESS = "Exit";
    public static final String MESSAGE_USAGE = "Type exit in the command box to exit study bananas "
            + "or click the exit button at the bottom of the sidebar";


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        return new GeneralCommandResult(MESSAGE_SUCCESS, EXIT);
    }
}
