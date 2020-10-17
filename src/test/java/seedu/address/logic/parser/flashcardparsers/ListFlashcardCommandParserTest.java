package seedu.address.logic.parser.flashcardparsers;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.flashcardcommands.ListFlashcardCommand;


public class ListFlashcardCommandParserTest {
    private final ListFlashcardCommandParser parser = new ListFlashcardCommandParser();

    @Test
    public void parse_validArgs_returnsListFlashcardCommand() {
        assertParseSuccess(parser, "1", new ListFlashcardCommand(INDEX_FIRST));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                ListFlashcardCommand.MESSAGE_USAGE));
    }
}
