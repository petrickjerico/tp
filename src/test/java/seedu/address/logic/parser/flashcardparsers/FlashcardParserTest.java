package seedu.address.logic.parser.flashcardparsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.flashcardcommands.ListFlashcardSetCommand;
import seedu.address.logic.parser.exceptions.ParseException;


public class FlashcardParserTest {

    private FlashcardParser parser = new FlashcardParser();

    @Test
    public void parse_invalidCommand_throwsParseException() {
        // empty string
        assertThrows(ParseException.class, String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE), (
        ) -> parser.parse(""));

        // contain only one word
        assertThrows(ParseException.class, String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE), (
        ) -> parser.parse("one"));

        // invalid input
        assertThrows(ParseException.class, MESSAGE_UNKNOWN_COMMAND, () -> parser.parse("one two"));
    }

    @Test
    public void parse_listCommand_returnListFlashcardSetCommand() throws ParseException {
        ListFlashcardSetCommand expectedCommand = new ListFlashcardSetCommand();
        ListFlashcardSetCommand listCommand = (ListFlashcardSetCommand) parser
                .parse(ListFlashcardSetCommand.COMMAND_WORD);
        assertEquals(expectedCommand, listCommand);
    }
}
