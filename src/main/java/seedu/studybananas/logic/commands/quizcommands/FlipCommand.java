package seedu.studybananas.logic.commands.quizcommands;

import static java.util.Objects.requireNonNull;
import static seedu.studybananas.logic.commands.commandresults.QuizCommandResultType.FLIP;

import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.QuizCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.QuizModel;
import seedu.studybananas.model.flashcard.Answer;
import seedu.studybananas.ui.quizui.QuizCard;

public class FlipCommand extends Command<QuizModel> {

    public static final String COMMAND_WORD = "flip";
    public static final Status STATUS = Status.ON_QUESTION;

    @Override
    public CommandResult execute(QuizModel model) throws CommandException {
        requireNonNull(model);

        if (!model.hasStarted()) {
            throw new CommandException(QuizCommandUtil.MESSAGE_QUIZ_NEVER_STARTED);
        }

        if (!QuizCommandUtil.getStatus().equals(STATUS)) {
            throw new CommandException(QuizCommandUtil.MESSAGE_UNAVAIL_ON_ANSWER);
        }
        QuizCard.setQuestion(model.getQuestion());
        Answer answer = model.getAnswer();

        QuizCommandUtil.setStatus(Status.ON_ANSWER);

        String answerStringToShow = "Correct answer: " + answer.toString() + "\n\n"
                + QuizCommandUtil.SPECIAL_LITERAL
                + QuizCommandUtil.MESSAGE_AVAIL_ON_ANSWER;
        QuizCommandUtil.updateCommandResult(answerStringToShow);

        return new QuizCommandResult(answerStringToShow, model.getQuiz(), FLIP);
    }
}
