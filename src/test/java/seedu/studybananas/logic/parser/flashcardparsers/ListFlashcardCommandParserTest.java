package seedu.studybananas.logic.parser.flashcardparsers;

import static seedu.studybananas.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.studybananas.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.studybananas.testutil.TypicalIndexes.INDEX_FIRST;

import org.junit.jupiter.api.Test;

import seedu.studybananas.commons.core.Messages;
import seedu.studybananas.logic.commands.flashcardcommands.ListFlashcardCommand;


public class ListFlashcardCommandParserTest {
    private final ListFlashcardCommandParser parser = new ListFlashcardCommandParser();

    @Test
    public void parse_validArgs_returnsListFlashcardCommand() {
        assertParseSuccess(parser, "1", new ListFlashcardCommand(INDEX_FIRST));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", Messages.MESSAGE_INVALID_FLASHCARDSET_DISPLAYED_INDEX);
    }
}
