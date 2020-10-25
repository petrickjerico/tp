package seedu.address.logic.commands.addressbookcommands;

import static seedu.address.logic.commands.commandtestutils.AddressCommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.commandtestutils.AddressCommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddCommandIntegrationTest {

    private AddressBookModel model;

    @BeforeEach
    public void setUp() {
        model = new AddressBookModelManager(getTypicalAddressBook());
    }

    @Test
    public void execute_newPerson_success() {
        Person validPerson = new PersonBuilder().build();

        AddressBookModel expectedModel = new AddressBookModelManager(model.getAddressBook());
        expectedModel.addPerson(validPerson);

        assertCommandSuccess(new AddCommand(validPerson), model,
                String.format(AddCommand.MESSAGE_SUCCESS, validPerson), expectedModel);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Person personInList = model.getAddressBook().getPersonList().get(0);
        assertCommandFailure(new AddCommand(personInList), model, AddCommand.MESSAGE_DUPLICATE_PERSON);
    }

}
