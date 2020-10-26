package seedu.studybananas.logic.commands.quizcommands;

import static java.util.Objects.requireNonNull;

import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.CommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.QuizModel;
import seedu.studybananas.model.flashcard.Answer;

public class AnswerCommand extends Command<QuizModel> {

    public static final String COMMAND_WORD = "ans:";
    public static final Status STATUS = Status.ON_QUESTION;
    private final String answer;

    public AnswerCommand(String answer) {
        this.answer = answer;
    }

    @Override
    public CommandResult execute(QuizModel model) throws CommandException {
        requireNonNull(model);

        if (!model.hasStarted()) {
            throw new CommandException(QuizCommand.MESSAGE_QUIZ_NEVER_STARTED);
        }

        if (!QuizCommand.getStatus().equals(STATUS)) {
            throw new CommandException(QuizCommand.MESSAGE_UNAVAIL_ON_ANSWER);
        }

        model.saveAnswer(answer);
        String userAnswerToShow = "Your answer: " + answer;
        Answer answer = model.getAnswer();

        QuizCommand.setStatus(Status.ON_ANSWER);

        String answerStringToShow = userAnswerToShow + "\nCorrect answer: " + answer.toString()
                + QuizCommand.MESSAGE_AVAIL_ON_ANSWER;
        QuizCommand.updateCommandResult(answerStringToShow);

        return new CommandResult(answerStringToShow);
    }
}
