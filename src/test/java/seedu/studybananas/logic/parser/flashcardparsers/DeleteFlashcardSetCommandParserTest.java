package seedu.studybananas.logic.parser.flashcardparsers;

import static seedu.studybananas.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.studybananas.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.studybananas.testutil.TypicalIndexes.INDEX_FIRST;

import org.junit.jupiter.api.Test;

import seedu.studybananas.commons.core.Messages;
import seedu.studybananas.logic.commands.flashcardcommands.DeleteFlashcardSetCommand;


public class DeleteFlashcardSetCommandParserTest {
    private final DeleteFlashcardSetCommandParser parser = new DeleteFlashcardSetCommandParser();

    @Test
    public void parse_validArgs_returnsDeleteFlashcardSetCommand() {
        assertParseSuccess(parser, "1", new DeleteFlashcardSetCommand(INDEX_FIRST));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", Messages.MESSAGE_INVALID_FLASHCARDSET_DISPLAYED_INDEX);
    }
}
