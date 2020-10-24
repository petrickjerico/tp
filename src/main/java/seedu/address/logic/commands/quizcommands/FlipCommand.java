package seedu.address.logic.commands.quizcommands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.QuizModel;
import seedu.address.model.flashcard.Answer;

public class FlipCommand extends Command<QuizModel> {

    public static final String COMMAND_WORD = "flip";
    public static final Status STATUS = Status.ON_QUESTION;

    @Override
    public CommandResult execute(QuizModel model) throws CommandException {
        requireNonNull(model);

        if (!model.hasStarted()) {
            throw new CommandException(QuizCommand.MESSAGE_QUIZ_NEVER_STARTED);
        }

        if (!QuizCommand.getStatus().equals(STATUS)) {
            throw new CommandException(QuizCommand.MESSAGE_UNAVAIL_ON_ANSWER);
        }

        Answer answer = model.getAnswer();

        QuizCommand.setStatus(Status.ON_ANSWER);

        String answerStringToShow = "Correct answer: " + answer.toString()
                + QuizCommand.MESSAGE_AVAIL_ON_ANSWER;
        QuizCommand.updateCommandResult(answerStringToShow);

        return new CommandResult(answerStringToShow);
    }
}
