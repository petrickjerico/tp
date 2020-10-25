package seedu.studybananas.logic.commands.flashcardcommands;

import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.assertCommandSuccess;
import static seedu.studybananas.testutil.TypicalFlashcardSets.getTypicalFlashcardBank;
import static seedu.studybananas.testutil.TypicalIndexes.INDEX_FIRST;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.studybananas.model.FlashcardModel;
import seedu.studybananas.model.FlashcardModelManager;
import seedu.studybananas.model.flashcard.Flashcard;
import seedu.studybananas.model.flashcard.FlashcardSet;

public class ListFlashcardCommandTest {
    private FlashcardModel model;
    private FlashcardModel expectedModel;

    @BeforeEach
    public void setUp() {
        model = new FlashcardModelManager(getTypicalFlashcardBank());
        expectedModel = new FlashcardModelManager(model.getFlashcardBank());
    }

    @Test
    public void execute_list_showsEverything() {
        FlashcardSet flashcardSet = expectedModel.getFlashcardSet(INDEX_FIRST);
        List<Flashcard> flashcards = flashcardSet.getFlashcards();

        String expectedMessage = String.format(
                ListFlashcardCommand.MESSAGE_SUCCESS + "\n" + "There are %d flashcards",
                flashcards.size());

        assertCommandSuccess(new ListFlashcardCommand(INDEX_FIRST), model,
                expectedMessage, expectedModel);
    }
}
