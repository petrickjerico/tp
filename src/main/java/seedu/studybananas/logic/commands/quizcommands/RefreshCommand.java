package seedu.studybananas.logic.commands.quizcommands;

import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.QuizCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.FlashcardQuizModel;

public class RefreshCommand extends Command<FlashcardQuizModel> {

    public static final String COMMAND_WORD = "refresh";

    @Override
    public CommandResult execute(FlashcardQuizModel model) throws CommandException {

        if (!model.hasStarted()) {
            throw new CommandException(QuizCommand.MESSAGE_QUIZ_NEVER_STARTED);
        }

        return new QuizCommandResult(QuizCommand.getCurrentCommandResult());
    }
}
