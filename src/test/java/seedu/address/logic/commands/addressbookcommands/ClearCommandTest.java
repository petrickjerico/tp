package seedu.address.logic.commands.addressbookcommands;

import static seedu.address.logic.commands.commandtestutils.AddressCommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.systemlevelmodel.AddressBook;
import seedu.address.model.systemlevelmodel.FlashcardBank;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.systemlevelmodel.Schedule;
import seedu.address.model.systemlevelmodel.UserPrefs;

public class ClearCommandTest {

    @Test
    public void execute_emptyAddressBook_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyAddressBook_success() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs(), new Schedule(), new FlashcardBank());
        Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs(),
                new Schedule(), new FlashcardBank());
        expectedModel.setAddressBook(new AddressBook());

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
