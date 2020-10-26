package seedu.studybananas.logic.commands.quizcommands;

import static java.util.Objects.requireNonNull;

import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.CommandResult;
import seedu.studybananas.logic.commands.QuizCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.QuizModel;

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

        return new QuizCommandResult(MESSAGE_SUCCESS);
    }
}
