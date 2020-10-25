package seedu.studybananas.logic.parser.scheduleparsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.studybananas.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.studybananas.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.studybananas.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.studybananas.logic.commands.HelpCommand;
import seedu.studybananas.logic.commands.schedulecommands.ScheduleListCommand;
import seedu.studybananas.logic.parser.exceptions.ParseException;

public class ScheduleParserTest {

    private ScheduleParser parser = new ScheduleParser();

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
    public void parse_listCommand_returnScheduleListCommand() throws ParseException {
        ScheduleListCommand expectedCommand = new ScheduleListCommand();
        ScheduleListCommand listCommand = (ScheduleListCommand) parser.parse("list task");
        assertEquals(expectedCommand, listCommand);
    }
}
