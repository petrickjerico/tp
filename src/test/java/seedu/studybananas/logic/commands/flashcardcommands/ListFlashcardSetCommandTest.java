package seedu.studybananas.logic.commands.flashcardcommands;

import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.assertCommandSuccess;
import static seedu.studybananas.testutil.TypicalFlashcardSets.getTypicalFlashcardBank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.studybananas.model.FlashcardModel;
import seedu.studybananas.model.FlashcardModelManager;
import seedu.studybananas.model.flashcard.FlashcardSet;

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
        ObservableList<FlashcardSet> flashcardSets = model.getFilteredFlashcardSetList();

        StringBuilder details = new StringBuilder();
        details.append("\nThere are ");
        details.append(flashcardSets.size());
        details.append(" sets");
        flashcardSets.forEach(flashcardSet -> details.append("\n" + flashcardSet.toString()));

        String expectedMessage = ListFlashcardSetCommand.MESSAGE_SUCCESS + details;
        assertCommandSuccess(new ListFlashcardSetCommand(), model,
                expectedMessage, expectedModel);
    }
}
