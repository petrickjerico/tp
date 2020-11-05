package seedu.studybananas.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.Model;

public class HelpCommand extends Command<Model> {

    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_SUCCESS = "The help table is opened!";
    public static final String MESSAGE_USAGE = "Type help in the command box to view all the available commands " +
            "or click the help button at the bottom of the sidebar";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        return null;
    }
}
