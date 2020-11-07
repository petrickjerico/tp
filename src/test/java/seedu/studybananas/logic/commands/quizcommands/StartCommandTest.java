package seedu.studybananas.logic.commands.quizcommands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.studybananas.logic.commands.commandtestutils.QuizRecordsCommandTestUtil.assertCommandSuccess;
import static seedu.studybananas.logic.commands.quizcommands.QuizCommandUtil.MESSAGE_AVAIL_ON_QUESTION;
import static seedu.studybananas.logic.commands.quizcommands.StartCommand.MESSAGE_FLASHCARD_SET_EMPTY;
import static seedu.studybananas.logic.commands.quizcommands.StartCommand.MESSAGE_FLASHCARD_SET_NONEXISTENT;
import static seedu.studybananas.logic.commands.quizcommands.StartCommand.MESSAGE_QUIZ_IN_PROGRESS;
import static seedu.studybananas.testutil.Assert.assertThrows;
import static seedu.studybananas.testutil.TypicalFlashcardSets.getTypicalFlashcardBank;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.FlashcardQuizModel;
import seedu.studybananas.model.FlashcardQuizModelManager;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.flashcard.FlashcardSetName;
import seedu.studybananas.model.systemlevelmodel.FlashcardBank;
import seedu.studybananas.model.systemlevelmodel.QuizRecords;
import seedu.studybananas.testutil.FlashcardSetBuilder;
import seedu.studybananas.testutil.QuizBuilder;

public class StartCommandTest {

    private static final int VALID_INDEX = 1;
    private static final int INVALID_INDEX = 10;
    private static final FlashcardSetName VALID_NAME = new FlashcardSetName("physics");
    private static final FlashcardSetName INVALID_NAME = new FlashcardSetName("Weird name");


    private final StartCommand startCommand = new StartCommand(VALID_INDEX);
    private final StartCommand startCommandWithName = new StartCommand(VALID_NAME);
    private final FlashcardQuizModel model = new
            FlashcardQuizModelManager(getTypicalFlashcardBank(), new QuizRecords());

    @Test
    public void execute_nullModel_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> startCommand.execute(null));
        assertThrows(NullPointerException.class, () -> startCommandWithName.execute(null));
    }

    @Test
    public void execute_modelQuizStarted_throwsCommandException() {
        model.start(new QuizBuilder().buildDefaultQuiz());
        assertThrows(CommandException.class,
                MESSAGE_QUIZ_IN_PROGRESS, () -> startCommand.execute(model));
        assertThrows(CommandException.class,
                MESSAGE_QUIZ_IN_PROGRESS, () -> startCommandWithName.execute(model));
    }

    @Test
    public void execute_modelFlashcardSetIndexOutOfBounds_throwsCommandException() {
        StartCommand invalidIndexStartCommand = new StartCommand(INVALID_INDEX);
        assertThrows(CommandException.class,
                MESSAGE_FLASHCARD_SET_NONEXISTENT, () -> invalidIndexStartCommand.execute(model));

        StartCommand invalidNameStartCommand = new StartCommand(INVALID_NAME);
        assertThrows(CommandException.class,
                MESSAGE_FLASHCARD_SET_NONEXISTENT, () -> invalidNameStartCommand.execute(model));
    }

    @Test
    public void execute_modelFlashcardSetIsEmpty_throwsCommandException() {
        List<FlashcardSet> flashcardSets = new ArrayList<>();
        flashcardSets.add(new FlashcardSetBuilder().build()); // empty flset

        FlashcardBank flashcardBank = new FlashcardBank();
        flashcardBank.setFlashcardSets(flashcardSets);

        FlashcardQuizModel model = new FlashcardQuizModelManager(flashcardBank, new QuizRecords());
        assertThrows(CommandException.class,
                MESSAGE_FLASHCARD_SET_EMPTY, () -> startCommand.execute(model));
        assertThrows(CommandException.class,
                MESSAGE_FLASHCARD_SET_EMPTY, () -> startCommandWithName.execute(model));
    }

    @Test
    public void execute_modelStartQuiz_success() {
        String expectedMessage = MESSAGE_AVAIL_ON_QUESTION;
        FlashcardQuizModel expectedModel =
                new FlashcardQuizModelManager(getTypicalFlashcardBank(), new QuizRecords());

        assertCommandSuccess(startCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_modelStartQuizWithName_success() {
        String expectedMessage = MESSAGE_AVAIL_ON_QUESTION;
        FlashcardQuizModel expectedModel =
                new FlashcardQuizModelManager(getTypicalFlashcardBank(), new QuizRecords());

        assertCommandSuccess(startCommandWithName, model, expectedMessage, expectedModel);
    }

    @Test
    public void test_getQuizIndex() {
        assertEquals(Index.fromOneBased(VALID_INDEX), startCommand.getQuizIndex());
    }

    @Test
    public void test_getFlashcardSetName() {
        assertEquals(VALID_NAME, startCommandWithName.getFlashcardSetName());
    }
}
