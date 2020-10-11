package seedu.address.logic.commands.quizcommands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class CancelCommand extends Command {

    public static final String COMMAND_WORD = "cancel";
    public static final String MESSAGE_SUCCESS = "Quiz cancelled!";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (!model.hasStarted()) {
            throw new CommandException(QuizCommand.MESSAGE_QUIZ_NEVER_STARTED);
        }

        model.stopQuiz();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
