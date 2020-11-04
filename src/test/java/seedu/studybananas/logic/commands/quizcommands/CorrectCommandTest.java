package seedu.studybananas.logic.commands.quizcommands;

import static seedu.studybananas.logic.commands.commandtestutils.QuizRecordsCommandTestUtil.assertCommandSuccess;
import static seedu.studybananas.logic.commands.quizcommands.QuizCommandUtil.MESSAGE_AVAIL_ON_QUESTION;
import static seedu.studybananas.logic.commands.quizcommands.QuizCommandUtil.MESSAGE_QUIZ_NEVER_STARTED;
import static seedu.studybananas.logic.commands.quizcommands.QuizCommandUtil.MESSAGE_UNAVAIL_ON_QUESTION;
import static seedu.studybananas.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.QuizModel;
import seedu.studybananas.model.QuizModelManager;
import seedu.studybananas.model.quiz.Quiz;
import seedu.studybananas.model.systemlevelmodel.QuizRecords;
import seedu.studybananas.testutil.QuizBuilder;

public class CorrectCommandTest {

    private final CorrectCommand correctCommand = new CorrectCommand();
    private final QuizModel model = new
            QuizModelManager(new QuizRecords());

    @Test
    public void execute_nullModel_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> correctCommand.execute(null));
    }

    @Test
    public void execute_modelQuizNeverStarted_throwsCommandException() {
        assertThrows(CommandException.class,
                MESSAGE_QUIZ_NEVER_STARTED, () -> correctCommand.execute(model));
    }

    @Test
    public void execute_modelCommandNotAvailable_throwsCommandException() {
        model.start(new QuizBuilder().build());
        QuizCommandUtil.setStatus(Status.ON_QUESTION);
        assertThrows(CommandException.class, MESSAGE_UNAVAIL_ON_QUESTION, () -> correctCommand.execute(model));
    }

    @Test
    public void execute_modelCorrectAnswer_success() {
        Quiz quiz = new QuizBuilder().build();
        model.start(quiz);
        model.getAnswer();

        QuizCommandUtil.setStatus(Status.ON_ANSWER);
        String expectedMessage = MESSAGE_AVAIL_ON_QUESTION;

        QuizModel expectedModel = new QuizModelManager(new QuizRecords());
        assertCommandSuccess(correctCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_modelCorrectAnswerLastIndex_stopsQuiz() {
        Quiz quiz = new QuizBuilder().build();
        model.start(quiz);
        model.getAnswer();
        model.getAnswer();
        model.getAnswer(); // increments index to last

        Quiz expectedQuiz = new QuizBuilder().build();
        QuizModel expectedModel = new QuizModelManager(new QuizRecords());
        expectedModel.start(expectedQuiz);

        expectedQuiz.getAnswer();
        expectedQuiz.getAnswer();
        expectedQuiz.getAnswer(); // increments index to last
        expectedQuiz.setPointsScored(true);
        String expectedMessage = expectedModel.stopQuiz();

        QuizCommandUtil.setStatus(Status.ON_ANSWER);
        assertCommandSuccess(correctCommand, model, expectedMessage, expectedModel);
    }
}
