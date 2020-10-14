package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Example command for parser structure.
 */
public class ExampleCommand extends Command<Model> {
    @Override
    public CommandResult execute(Model model) throws CommandException {
        return null;
    }
}
