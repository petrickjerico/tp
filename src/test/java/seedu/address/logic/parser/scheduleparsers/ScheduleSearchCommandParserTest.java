package seedu.address.logic.parser.scheduleparsers;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.schedulecommands.ScheduleSearchCommand;
import seedu.address.model.task.TitleContainsKeywordsPredicate;

public class ScheduleSearchCommandParserTest {

    private ScheduleSearchCommandParser parser = new ScheduleSearchCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                ScheduleSearchCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindCommand() {
        // no leading and trailing whitespaces
        ScheduleSearchCommand expectedSearchCommand =
                new ScheduleSearchCommand(new TitleContainsKeywordsPredicate(Arrays.asList("CS2101", "CS2103T")));
        assertParseSuccess(parser, "CS2101 CS2103T", expectedSearchCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n CS2101 \n \t CS2103T  \t", expectedSearchCommand);
    }
}
