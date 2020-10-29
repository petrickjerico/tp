package seedu.studybananas.logic.commands.quizcommands;

import static java.util.Objects.requireNonNull;

import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.QuizCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.QuizModel;
import seedu.studybananas.ui.quizui.QuizCard;

public class WrongCommand extends Command<QuizModel> {

    public static final String COMMAND_WORD = "w";
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

            QuizCommand.setStatus(Status.ON_QUESTION);
            String questionStringToShow = QuizCommand.MESSAGE_AVAIL_ON_QUESTION;
            QuizCommand.updateCommandResult(questionStringToShow);
            QuizCard.setQuestion(model.getQuestion());
            return new QuizCommandResult(questionStringToShow, model.getQuiz());

        } catch (NullPointerException | IndexOutOfBoundsException e) {
            QuizCommand.updateCommandResult(null);
            model.setQuizRecordsToView(model.getQuiz().getFlsetName());
            return new QuizCommandResult(model.stopQuiz());
        }
    }
}