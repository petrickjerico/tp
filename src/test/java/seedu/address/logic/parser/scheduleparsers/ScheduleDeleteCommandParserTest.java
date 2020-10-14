package seedu.address.logic.parser.scheduleparsers;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.schedulecommands.ScheduleDeleteCommand;

public class ScheduleDeleteCommandParserTest {

    private final ScheduleDeleteCommandParser parser = new ScheduleDeleteCommandParser();

    @Test
    public void parse_validArgs_returnsScheduleDeleteCommand() {
        assertParseSuccess(parser, "1", new ScheduleDeleteCommand(INDEX_FIRST));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                ScheduleDeleteCommand.MESSAGE_USAGE));
    }
}
