package seedu.studybananas.logic.commands;

import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.Model;

/**
 * Example command for parser structure.
 */
public class ExampleCommand extends Command<Model> {
    @Override
    public CommandResult execute(Model model) throws CommandException {
        return null;
    }
}
