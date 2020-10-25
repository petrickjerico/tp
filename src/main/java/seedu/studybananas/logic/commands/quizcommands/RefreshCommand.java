package seedu.studybananas.logic.commands.quizcommands;

import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.CommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.Model;

public class RefreshCommand extends Command<Model> {
    @Override
    public CommandResult execute(Model model) throws CommandException {
        return new CommandResult(QuizCommand.getCurrentCommandResult());
    }
}
