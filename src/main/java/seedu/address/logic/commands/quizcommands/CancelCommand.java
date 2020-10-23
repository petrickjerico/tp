package seedu.address.logic.commands.quizcommands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.QuizModel;

public class CancelCommand extends Command<QuizModel> {

    public static final String COMMAND_WORD = "cancel";
    public static final String MESSAGE_SUCCESS = "Quiz cancelled! "
            + "Don't worry, your cancelled quiz scores are not recorded.";

    @Override
    public CommandResult execute(QuizModel model) throws CommandException {
        requireNonNull(model);

        if (!model.hasStarted()) {
            throw new CommandException(QuizCommand.MESSAGE_QUIZ_NEVER_STARTED);
        }

        model.cancelQuiz();
        QuizCommand.updateCommandResult(QuizCommand.MESSAGE_QUIZ_NEVER_STARTED);

        return new CommandResult(MESSAGE_SUCCESS);
    }
}
