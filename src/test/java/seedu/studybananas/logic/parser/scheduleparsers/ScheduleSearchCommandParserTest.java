package seedu.studybananas.logic.parser.scheduleparsers;

import static seedu.studybananas.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.studybananas.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.studybananas.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import seedu.studybananas.logic.commands.schedulecommands.ScheduleSearchCommand;
import seedu.studybananas.model.task.InfoContainsKeywordsPredicate;

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
                new ScheduleSearchCommand(new InfoContainsKeywordsPredicate(Arrays.asList("CS2101", "CS2103T")));
        assertParseSuccess(parser, "CS2101 CS2103T", expectedSearchCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n CS2101 \n \t CS2103T  \t", expectedSearchCommand);
    }
}
