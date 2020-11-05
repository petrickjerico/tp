package seedu.studybananas.logic.commands.quizcommands;

import static seedu.studybananas.logic.commands.commandtestutils.QuizRecordsCommandTestUtil.assertCommandSuccess;
import static seedu.studybananas.logic.commands.quizcommands.QuizCommandUtil.MESSAGE_QUIZ_NEVER_STARTED;
import static seedu.studybananas.testutil.Assert.assertThrows;
import static seedu.studybananas.testutil.TypicalFlashcardSets.getTypicalFlashcardBank;

import org.junit.jupiter.api.Test;

import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.QuizCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.FlashcardQuizModel;
import seedu.studybananas.model.FlashcardQuizModelManager;
import seedu.studybananas.model.quiz.Quiz;
import seedu.studybananas.model.systemlevelmodel.QuizRecords;
import seedu.studybananas.testutil.QuizBuilder;

public class RefreshCommandTest {
    private final RefreshCommand refreshCommand = new RefreshCommand();
    private final FlashcardQuizModel model = new
            FlashcardQuizModelManager(getTypicalFlashcardBank(), new QuizRecords());

    @Test
    public void execute_nullModel_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> refreshCommand.execute(null));
    }

    @Test
    public void execute_modelQuizNeverStarted_throwsCommandException() {
        assertThrows(CommandException.class,
                MESSAGE_QUIZ_NEVER_STARTED, () -> refreshCommand.execute(model));
    }

    @Test
    public void execute_modelRefreshQuiz_success() {
        Quiz quiz = new QuizBuilder().build();
        model.start(quiz);

        FlashcardQuizModel expectedModel = new FlashcardQuizModelManager(getTypicalFlashcardBank(), new QuizRecords());
        assertCommandSuccess(refreshCommand, model, RefreshCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
