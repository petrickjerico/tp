package seedu.studybananas.logic.parser.scheduleparsers;

import static seedu.studybananas.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.studybananas.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.studybananas.testutil.TypicalIndexes.INDEX_FIRST;

import org.junit.jupiter.api.Test;

import seedu.studybananas.commons.core.Messages;
import seedu.studybananas.logic.commands.schedulecommands.ScheduleDeleteCommand;

public class ScheduleDeleteCommandParserTest {

    private final ScheduleDeleteCommandParser parser = new ScheduleDeleteCommandParser();

    @Test
    public void parse_validArgs_returnsScheduleDeleteCommand() {
        assertParseSuccess(parser, "1", new ScheduleDeleteCommand(INDEX_FIRST));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
    }
}
