package seedu.studybananas.logic.commands.quizcommands;

import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.QuizCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.FlashcardQuizModel;

public class RefreshCommand extends Command<FlashcardQuizModel> {

    public static final String COMMAND_WORD = "refresh";

    @Override
    public QuizCommandResult execute(FlashcardQuizModel model) throws CommandException {
        return new QuizCommandResult(QuizCommand.getCurrentCommandResult());
    }
}
