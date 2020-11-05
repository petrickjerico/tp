package seedu.studybananas.logic.commands.quizcommands;

import static java.util.Objects.requireNonNull;
import static seedu.studybananas.logic.commands.commandresults.QuizCommandResultType.ANSWER;

import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.QuizCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.QuizModel;
import seedu.studybananas.model.flashcard.Answer;
import seedu.studybananas.ui.quizui.QuizCard;

public class AnswerCommand extends Command<QuizModel> {

    public static final String COMMAND_WORD = "ans:";
    public static final int STARTING_INDEX_OF_ANSWER = 4;
    public static final Status STATUS = Status.ON_QUESTION;

    private final String answer;

    public AnswerCommand(String answer) {
        this.answer = answer;
    }

    @Override
    public CommandResult execute(QuizModel model) throws CommandException {
        requireNonNull(model);

        if (!model.hasStarted()) {
            throw new CommandException(QuizCommandUtil.MESSAGE_QUIZ_NEVER_STARTED);
        }

        if (!QuizCommandUtil.getStatus().equals(STATUS)) {
            throw new CommandException(QuizCommandUtil.MESSAGE_UNAVAIL_ON_ANSWER);
        }

        model.saveAnswer(answer);
        QuizCard.setQuestion(model.getQuestion());
        String userAnswerToShow = "Your answer: " + answer + "\n\n";
        Answer answer = model.getAnswer();

        QuizCommandUtil.setStatus(Status.ON_ANSWER);

        String answerStringToShow = userAnswerToShow + "\nCorrect answer: " + answer.toString()
                + QuizCommandUtil.SPECIAL_LITERAL
                + QuizCommandUtil.MESSAGE_AVAIL_ON_ANSWER;
        QuizCommandUtil.updateCommandResult(answerStringToShow);

        return new QuizCommandResult(answerStringToShow, model.getQuiz(), ANSWER);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AnswerCommand // instanceof handles nulls
                && answer.equals(((AnswerCommand) other).answer)); // state check
    }
}
