package seedu.address.logic.commands.quizcommands;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class RefreshCommand extends Command<Model> {
    @Override
    public CommandResult execute(Model model) throws CommandException {
        return new CommandResult(QuizCommand.getCurrentCommandResult());
    }
}
