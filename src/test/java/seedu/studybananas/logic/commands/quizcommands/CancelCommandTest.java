package seedu.studybananas.logic.commands.quizcommands;

import static seedu.studybananas.logic.commands.commandtestutils.QuizRecordsCommandTestUtil.assertCommandSuccess;
import static seedu.studybananas.logic.commands.quizcommands.CancelCommand.MESSAGE_SUCCESS;
import static seedu.studybananas.logic.commands.quizcommands.QuizCommandUtil.MESSAGE_QUIZ_NEVER_STARTED;
import static seedu.studybananas.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.QuizModel;
import seedu.studybananas.model.QuizModelManager;
import seedu.studybananas.model.quiz.Quiz;
import seedu.studybananas.model.systemlevelmodel.QuizRecords;
import seedu.studybananas.testutil.QuizBuilder;

public class CancelCommandTest {

    private final CancelCommand cancelCommand = new CancelCommand();
    private final QuizModel model = new
            QuizModelManager(new QuizRecords());

    @Test
    public void execute_nullModel_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> cancelCommand.execute(null));
    }

    @Test
    public void execute_modelQuizNeverStarted_throwsCommandException() {
        assertThrows(CommandException.class,
                MESSAGE_QUIZ_NEVER_STARTED, () -> cancelCommand.execute(model));
    }

    @Test
    public void execute_modelCancelQuiz_success() {
        Quiz quiz = new QuizBuilder().build();
        model.start(quiz);
        QuizCommandUtil.setStatus(Status.ON_QUESTION);

        QuizModel expectedModel = new QuizModelManager(new QuizRecords());
        assertCommandSuccess(cancelCommand, model, MESSAGE_SUCCESS, expectedModel);
    }
}
