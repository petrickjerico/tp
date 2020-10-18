package seedu.address.logic.commands.flashcardcommands;

import static seedu.address.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalFlashcardSets.getTypicalFlashcardBank;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.FlashcardModel;
import seedu.address.model.FlashcardModelManager;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.flashcard.FlashcardSet;

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

        StringBuilder details = new StringBuilder();
        details.append("\nThere are ");
        details.append(flashcards.size());
        details.append(" flashcards");
        flashcards.forEach(flashcard -> details.append("\n" + flashcard.toString()));

        String expectedMessage = ListFlashcardCommand.MESSAGE_SUCCESS + details;

        assertCommandSuccess(new ListFlashcardCommand(INDEX_FIRST), model,
                expectedMessage, expectedModel);
    }
}
