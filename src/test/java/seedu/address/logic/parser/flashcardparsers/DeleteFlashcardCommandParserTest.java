package seedu.address.logic.parser.flashcardparsers;

import static seedu.address.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.INVALID_INDEX_ERROR_MESSAGE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.flashcardcommands.DeleteFlashcardCommand;

public class DeleteFlashcardCommandParserTest {
    private final DeleteFlashcardCommandParser parser = new DeleteFlashcardCommandParser();

    @Test
    public void parse_validArgs_returnsDeleteFlashcardCommand() {
        assertParseSuccess(parser, " flset:1 fl:1", new DeleteFlashcardCommand(INDEX_FIRST, INDEX_FIRST));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        // negative flset index and fl index
        assertParseFailure(parser, " flset:-1 fl:-1", INVALID_INDEX_ERROR_MESSAGE);

        // non-integer flset index and fl index
        assertParseFailure(parser, " flset:A fl:A", INVALID_INDEX_ERROR_MESSAGE);
    }
}
