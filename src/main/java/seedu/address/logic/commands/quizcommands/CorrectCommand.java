package seedu.address.logic.commands.quizcommands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.QuizModel;
import seedu.address.model.flashcard.Question;

public class CorrectCommand extends Command<QuizModel> {

    public static final String COMMAND_WORD = "c";

    public static final Status STATUS = Status.ON_ANSWER;

    @Override
    public CommandResult execute(QuizModel model) throws CommandException {
        requireNonNull(model);

        if (!model.hasStarted()) {
            throw new CommandException(QuizCommand.MESSAGE_QUIZ_NEVER_STARTED);
        }

        if (!QuizCommand.getStatus().equals(STATUS)) {
            throw new CommandException(QuizCommand.MESSAGE_UNAVAIL_ON_QUESTION);
        }

        try {
            model.tallyScore(true);
            Question nextQuestion = model.getQuestion();

            QuizCommand.setStatus(Status.ON_QUESTION);
            QuizCommand.updateCommandResult(nextQuestion.toString());

            return new CommandResult(nextQuestion.toString());

        } catch (NullPointerException | IndexOutOfBoundsException e) {
            QuizCommand.updateCommandResult(null);
            return new CommandResult(model.stopQuiz());
        }
    }
}
