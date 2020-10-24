package seedu.address.logic.parser.scheduleparsers;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.DATETIME_DESC_CS2103T;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.DESCRIPTION_DESC_CS2101;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.DURATION;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.INVALID_DATETIME_DESC;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.INVALID_DURATION;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.INVALID_TITLE_DESC;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.TITLE_DESC_CS2103T;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.VALID_DATETIME_CS2103T;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.VALID_DESCRIPTION_CS2101;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.VALID_DURATION;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.VALID_TITLE_CS2103T;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.schedulecommands.ScheduleEditCommand;
import seedu.address.model.task.DateTime;
import seedu.address.model.task.Description;
import seedu.address.model.task.Duration;
import seedu.address.model.task.Title;

public class ScheduleEditCommandParserTest {

    private final ScheduleEditCommandParser parser = new ScheduleEditCommandParser();

    @Test
    public void parse_validArgs_returnsScheduleDeleteCommand() {

        // valid edited title
        Title editTitle = new Title(VALID_TITLE_CS2103T);
        assertParseSuccess(parser, " 1" + TITLE_DESC_CS2103T,
                new ScheduleEditCommand(INDEX_FIRST, editTitle, null, null, null));

        // valid edited description
        Description editDescription = new Description(VALID_DESCRIPTION_CS2101);
        assertParseSuccess(parser, " 1" + DESCRIPTION_DESC_CS2101,
                new ScheduleEditCommand(INDEX_FIRST, null, editDescription, null, null));

        // valid edited date time
        DateTime editDateTime = new DateTime(VALID_DATETIME_CS2103T);
        assertParseSuccess(parser, " 1" + DATETIME_DESC_CS2103T,
                new ScheduleEditCommand(INDEX_FIRST, null, null, editDateTime, null));

        // valid edited duration
        Duration editDuration = new Duration(VALID_DURATION);
        assertParseSuccess(parser, " 1" + DURATION,
                new ScheduleEditCommand(INDEX_FIRST, null, null, null, editDuration));

        // all the information is valid
        assertParseSuccess(parser, " 1" + TITLE_DESC_CS2103T
                + DESCRIPTION_DESC_CS2101
                + DATETIME_DESC_CS2103T
                + DURATION,
                new ScheduleEditCommand(INDEX_FIRST, editTitle, editDescription, editDateTime, editDuration));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        // no task index given
        assertParseFailure(parser, " T: CS2103T", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                ScheduleEditCommand.MESSAGE_USAGE));

        // no task information is provided
        assertParseFailure(parser, " 1", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                ScheduleEditCommand.MESSAGE_USAGE));

        // invalid edited title format
        assertParseFailure(parser, " 1" + INVALID_TITLE_DESC, Title.MESSAGE_CONSTRAINTS);

        // invalid edited dateTime format and valid title
        assertParseFailure(parser, " 1" + TITLE_DESC_CS2103T + INVALID_DATETIME_DESC,
                DateTime.MESSAGE_CONSTRAINTS);

        // invalid duration
        assertParseFailure(parser, " 1" + INVALID_DURATION, Duration.MESSAGE_CONSTRAINTS);
    }
}
