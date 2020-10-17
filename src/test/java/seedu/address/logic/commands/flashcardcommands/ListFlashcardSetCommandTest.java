package seedu.address.logic.commands.flashcardcommands;

import static seedu.address.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalFlashcardSets.getTypicalFlashcardBank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.FlashcardModel;
import seedu.address.model.FlashcardModelManager;

public class ListFlashcardSetCommandTest {
    private FlashcardModel model;
    private FlashcardModel expectedModel;

    @BeforeEach
    public void setUp() {
        model = new FlashcardModelManager(getTypicalFlashcardBank());
        expectedModel = new FlashcardModelManager(model.getFlashcardBank());
    }

    @Test
    public void execute_list_showsEverything() {
        assertCommandSuccess(new ListFlashcardSetCommand(), model,
                ListFlashcardSetCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
