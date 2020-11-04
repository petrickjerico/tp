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

public class FlipCommandTest {

    private final FlipCommand flipCommand = new FlipCommand();
    private final QuizModel model = new
            QuizModelManager(new QuizRecords());

    @Test
    public void execute_nullModel_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> flipCommand.execute(null));
    }

    @Test
    public void execute_modelQuizNeverStarted_throwsCommandException() {
        assertThrows(CommandException.class,
                MESSAGE_QUIZ_NEVER_STARTED, () -> flipCommand.execute(model));
    }

    @Test
    public void execute_modelCommandNotAvailable_throwsCommandException() {
        model.start(new QuizBuilder().build());
        QuizCommandUtil.setStatus(Status.ON_ANSWER);
        assertThrows(CommandException.class, MESSAGE_UNAVAIL_ON_ANSWER, () -> flipCommand.execute(model));
    }

    @Test
    public void execute_modelAnswerQuiz_success() {
        Quiz quiz = new QuizBuilder().build();
        model.start(quiz);

        QuizCommandUtil.setStatus(Status.ON_QUESTION);
        String expectedAnswerStringToShow = "Correct answer: "
                + NEWTONS_SECOND_LAW.getAnswerString() + "\n\n"
                + QuizCommandUtil.SPECIAL_LITERAL
                + QuizCommandUtil.MESSAGE_AVAIL_ON_ANSWER;

        QuizModel expectedModel = new QuizModelManager(new QuizRecords());
        assertCommandSuccess(flipCommand, model, expectedAnswerStringToShow, expectedModel);
    }
}
