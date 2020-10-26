package seedu.studybananas.logic.commands.flashcardcommands;

import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.assertCommandSuccess;
import static seedu.studybananas.testutil.TypicalFlashcardSets.getTypicalFlashcardBank;
import static seedu.studybananas.testutil.TypicalIndexes.INDEX_FIRST;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.studybananas.model.FlashcardModel;
import seedu.studybananas.model.FlashcardModelManager;
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

        String expectedMessage = String.format(
                ListFlashcardCommand.MESSAGE_SUCCESS + "\n" + "There are %d flashcards in the set %s.",
                flashcardSet.getSize(), flashcardSet.getName().name);

        assertCommandSuccess(new ListFlashcardCommand(INDEX_FIRST), model,
                expectedMessage, expectedModel);
    }
}
