package seedu.studybananas.logic.commands.quizcommands;

import static seedu.studybananas.logic.commands.commandtestutils.QuizRecordsCommandTestUtil.assertCommandSuccess;
import static seedu.studybananas.logic.commands.quizcommands.ViewScoreCommand.MESSAGE_QUIZ_NONEXISTENT;
import static seedu.studybananas.logic.commands.quizcommands.ViewScoreCommand.MESSAGE_UNABLE_TO_VIEW;
import static seedu.studybananas.testutil.Assert.assertThrows;
import static seedu.studybananas.testutil.TypicalFlashcardSets.getTypicalFlashcardBank;
import static seedu.studybananas.testutil.TypicalQuizzes.getTypicalQuizRecords;

import org.junit.jupiter.api.Test;

import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.FlashcardQuizModel;
import seedu.studybananas.model.FlashcardQuizModelManager;
import seedu.studybananas.model.flashcard.FlashcardSetName;
import seedu.studybananas.testutil.QuizBuilder;

public class ViewScoreCommandTest {
    private static final int VALID_INDEX = 1;
    private static final int INVALID_INDEX = 10;
    private static final FlashcardSetName VALID_NAME = new FlashcardSetName("Physics");
    private static final FlashcardSetName INVALID_NAME = new FlashcardSetName("Weird name");

    private final ViewScoreCommand viewScoreCommand = new ViewScoreCommand(VALID_INDEX);
    private final ViewScoreCommand viewScoreCommandWithName = new ViewScoreCommand(VALID_NAME);
    private final FlashcardQuizModel model = new
            FlashcardQuizModelManager(getTypicalFlashcardBank(), getTypicalQuizRecords());

    @Test
    public void execute_nullModel_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> viewScoreCommand.execute(null));
        assertThrows(NullPointerException.class, () -> viewScoreCommandWithName.execute(null));
    }

    @Test
    public void execute_modelQuizStarted_throwsCommandException() {
        model.start(new QuizBuilder().buildDefaultQuiz());
        assertThrows(CommandException.class,
                MESSAGE_UNABLE_TO_VIEW, () -> viewScoreCommand.execute(model));
        assertThrows(CommandException.class,
                MESSAGE_UNABLE_TO_VIEW, () -> viewScoreCommandWithName.execute(model));
    }

    @Test
    public void execute_modelFlashcardSetIndexOutOfBounds_throwsCommandException() {
        ViewScoreCommand invalidIndexScoreCommand = new ViewScoreCommand(INVALID_INDEX);
        assertThrows(CommandException.class,
                MESSAGE_QUIZ_NONEXISTENT, () -> invalidIndexScoreCommand.execute(model));

        ViewScoreCommand invalidNameScoreCommand = new ViewScoreCommand(INVALID_NAME);
        assertThrows(CommandException.class,
                MESSAGE_QUIZ_NONEXISTENT, () -> invalidNameScoreCommand.execute(model));
    }

    @Test
    public void execute_modelViewScore_success() {
        String expectedMessage = model.getQuizRecords(
                new FlashcardSetName("Physics"));
        FlashcardQuizModel expectedModel =
                new FlashcardQuizModelManager(getTypicalFlashcardBank(), getTypicalQuizRecords());

        assertCommandSuccess(viewScoreCommand, model, expectedMessage, expectedModel);

        expectedMessage = model.getQuizRecords(
                new FlashcardSetName("physics"));
        expectedModel =
                new FlashcardQuizModelManager(getTypicalFlashcardBank(), getTypicalQuizRecords());

        assertCommandSuccess(viewScoreCommandWithName, model, expectedMessage, expectedModel);
    }
}
