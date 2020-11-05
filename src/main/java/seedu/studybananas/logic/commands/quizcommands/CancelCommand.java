package seedu.studybananas.logic.commands.quizcommands;

import static java.util.Objects.requireNonNull;
import static seedu.studybananas.logic.commands.commandresults.QuizCommandResultType.CANCEL;

import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.QuizCommandResult;
import seedu.studybananas.logic.commands.commandresults.QuizCommandResultType;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.QuizModel;
import seedu.studybananas.ui.quizui.QuizCard;

public class CancelCommand extends Command<QuizModel> {

    public static final String COMMAND_WORD = "cancel";

    public static final String MESSAGE_SUCCESS = "Quiz cancelled! "
            + "Don't worry, your cancelled quiz scores are not recorded.";

    @Override
    public CommandResult execute(QuizModel model) throws CommandException {
        requireNonNull(model);
        try {
            if (!model.hasStarted()) {
                throw new CommandException(QuizCommandUtil.MESSAGE_QUIZ_NEVER_STARTED);
            }

            model.cancelQuiz();
            QuizCard.setQuestion(null);
            QuizCommandUtil.updateCommandResult(QuizCommandUtil.MESSAGE_QUIZ_NEVER_STARTED);

            return new QuizCommandResult(MESSAGE_SUCCESS, CANCEL);
        } catch (NullPointerException e) {
            return new QuizCommandResult(MESSAGE_SUCCESS, CANCEL);
        }
    }
}
