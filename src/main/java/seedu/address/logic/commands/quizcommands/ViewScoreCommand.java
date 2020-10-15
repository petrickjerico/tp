package seedu.address.logic.commands.quizcommands;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.QuizModel;

public class ViewScoreCommand extends Command<QuizModel> {

    public static final String MESSAGE_UNABLE_TO_VIEW =
            "Unable to view score as quiz is in progress. "
                    + "Please cancel or finish the quiz to view";
    public static final String MESSAGE_QUIZ_NONEXISTENT =
            "Quiz records for this flashcard set does not exist";
    private final int index;

    public ViewScoreCommand(int index) {
        this.index = index;
    }

    @Override
    public CommandResult execute(QuizModel model) throws CommandException {

        if (model.hasStarted()) {
            throw new CommandException(MESSAGE_UNABLE_TO_VIEW);
        }

        try {
            String score = model.getQuizRecords(index);
            return new CommandResult(score);
        } catch (NullPointerException e) {
            throw new CommandException(MESSAGE_QUIZ_NONEXISTENT);
        }
    }
}
