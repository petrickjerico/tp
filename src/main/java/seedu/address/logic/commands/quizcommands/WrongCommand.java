package seedu.address.logic.commands.quizcommands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.QuizModel;
import seedu.address.model.flashcard.Question;

public class WrongCommand extends Command<QuizModel> {

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
            model.tallyScore(false);
            Question nextQuestion = model.getQuestion();

            QuizCommand.setStatus(Status.ON_QUESTION);

            String questionStringToShow = nextQuestion.toString()
                    + QuizCommand.MESSAGE_AVAIL_ON_QUESTION;
            QuizCommand.updateCommandResult(questionStringToShow);

            return new CommandResult(questionStringToShow);

        } catch (NullPointerException | IndexOutOfBoundsException e) {
            QuizCommand.updateCommandResult(null);
            return new CommandResult(model.stopQuiz());
        }
    }
}
