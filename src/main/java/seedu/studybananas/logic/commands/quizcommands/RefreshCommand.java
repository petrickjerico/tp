package seedu.studybananas.logic.commands.quizcommands;

import static java.util.Objects.requireNonNull;
import static seedu.studybananas.logic.commands.commandresults.QuizCommandResultType.REFRESH;

import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.QuizCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.FlashcardQuizModel;

public class RefreshCommand extends Command<FlashcardQuizModel> {

    public static final String COMMAND_WORD = "refresh";
    public static final String MESSAGE_SUCCESS = "The quiz is refreshed.\n You can proceed on your quiz now!";

    @Override
    public CommandResult execute(FlashcardQuizModel model) throws CommandException {
        requireNonNull(model);

        if (!model.hasStarted()) {
            throw new CommandException(QuizCommandUtil.MESSAGE_QUIZ_NEVER_STARTED);
        }

        return new QuizCommandResult(QuizCommandUtil.getCurrentCommandResult(), REFRESH);
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof RefreshCommand;
    }
}
