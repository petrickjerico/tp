package seedu.address.logic.commands.addressbookcommands;

import static seedu.address.logic.commands.commandtestutils.AddressCommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.commandtestutils.AddressCommandTestUtil.showPersonAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.AddressBookModel;
import seedu.address.model.AddressBookModelManager;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListCommand.
 */
public class ListCommandTest {

    private AddressBookModel model;
    private AddressBookModel expectedModel;

    @BeforeEach
    public void setUp() {
        model = new AddressBookModelManager(getTypicalAddressBook());
        expectedModel = new AddressBookModelManager(model.getAddressBook());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new ListCommand(), model, ListCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        showPersonAtIndex(model, INDEX_FIRST);
        assertCommandSuccess(new ListCommand(), model, ListCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
