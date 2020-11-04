package seedu.studybananas.logic.commands.quizcommands;

import static seedu.studybananas.logic.commands.commandtestutils.QuizRecordsCommandTestUtil.assertCommandSuccess;
import static seedu.studybananas.logic.commands.quizcommands.QuizCommandUtil.MESSAGE_QUIZ_NEVER_STARTED;
import static seedu.studybananas.logic.commands.quizcommands.QuizCommandUtil.MESSAGE_UNAVAIL_ON_ANSWER;
import static seedu.studybananas.testutil.Assert.assertThrows;
import static seedu.studybananas.testutil.TypicalFlashcards.NEWTONS_SECOND_LAW;

import org.junit.jupiter.api.Test;

import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.QuizModel;
import seedu.studybananas.model.QuizModelManager;
import seedu.studybananas.model.quiz.Quiz;
import seedu.studybananas.model.systemlevelmodel.QuizRecords;
import seedu.studybananas.testutil.QuizBuilder;

public class AnswerCommandTest {

    private static final String VALID_ANSWER = "Random answer here";

    private final AnswerCommand answerCommand = new AnswerCommand(VALID_ANSWER);
    private final QuizModel model = new
            QuizModelManager(new QuizRecords());

    @Test
    public void execute_nullModel_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> answerCommand.execute(null));
    }

    @Test
    public void execute_modelQuizNeverStarted_throwsCommandException() {
        assertThrows(CommandException.class,
                MESSAGE_QUIZ_NEVER_STARTED, () -> answerCommand.execute(model));
    }

    @Test
    public void execute_modelCommandNotAvailable_throwsCommandException() {
        model.start(new QuizBuilder().build());
        QuizCommandUtil.setStatus(Status.ON_ANSWER);
        assertThrows(CommandException.class, MESSAGE_UNAVAIL_ON_ANSWER, () -> answerCommand.execute(model));
    }

    @Test
    public void execute_modelAnswerQuiz_success() {
        Quiz quiz = new QuizBuilder().build();
        model.start(quiz);

        QuizCommandUtil.setStatus(Status.ON_QUESTION);
        String userAnswerToShow = "Your answer: " + VALID_ANSWER + "\n\n";
        String expectedAnswerStringToShow = userAnswerToShow + "\nCorrect answer: "
                + NEWTONS_SECOND_LAW.getAnswerString()
                + QuizCommandUtil.SPECIAL_LITERAL
                + QuizCommandUtil.MESSAGE_AVAIL_ON_ANSWER;

        QuizModel expectedModel = new QuizModelManager(new QuizRecords());
        assertCommandSuccess(answerCommand, model, expectedAnswerStringToShow, expectedModel);
    }
}
