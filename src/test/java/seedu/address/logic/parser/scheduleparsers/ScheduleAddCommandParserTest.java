package seedu.address.logic.parser.scheduleparsers;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.commandtestutils.AddressCommandTestUtil.PREAMBLE_NON_EMPTY;
import static seedu.address.logic.commands.commandtestutils.AddressCommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.DATETIME_DESC_CS2101;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.DATETIME_DESC_CS2103T;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.DESCRIPTION_DESC_CS2101;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.DESCRIPTION_DESC_CS2103T;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.INVALID_DATETIME_DESC;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.INVALID_TITLE_DESC;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.TITLE_DESC_CS2101;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.TITLE_DESC_CS2103T;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.VALID_DATETIME_CS2103T;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.VALID_DESCRIPTION_CS2103T;
import static seedu.address.logic.commands.commandtestutils.ScheduleCommandTestUtil.VALID_TITLE_CS2103T;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.schedulecommands.ScheduleAddCommand;
import seedu.address.model.task.DateTime;
import seedu.address.model.task.Task;
import seedu.address.model.task.Title;
import seedu.address.testutil.TaskBuilder;

public class ScheduleAddCommandParserTest {
    private final ScheduleAddCommandParser parser = new ScheduleAddCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        Task expectedTask = new TaskBuilder().withTitle(VALID_TITLE_CS2103T).withDescription(VALID_DESCRIPTION_CS2103T)
                .withDateTime(VALID_DATETIME_CS2103T).build();

        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + TITLE_DESC_CS2103T + DESCRIPTION_DESC_CS2103T
                + DATETIME_DESC_CS2103T, new ScheduleAddCommand(expectedTask));

        // multiple titles - last title accepted
        assertParseSuccess(parser, TITLE_DESC_CS2101 + TITLE_DESC_CS2103T + DESCRIPTION_DESC_CS2103T
                + DATETIME_DESC_CS2103T, new ScheduleAddCommand(expectedTask));

        // multiple descriptions - last description accepted
        assertParseSuccess(parser, TITLE_DESC_CS2103T + DESCRIPTION_DESC_CS2101 + DESCRIPTION_DESC_CS2103T
                + DATETIME_DESC_CS2103T, new ScheduleAddCommand(expectedTask));

        // multiple emails - last email accepted
        assertParseSuccess(parser, TITLE_DESC_CS2103T + DESCRIPTION_DESC_CS2103T + DATETIME_DESC_CS2101
                + DATETIME_DESC_CS2103T, new ScheduleAddCommand(expectedTask));

    }

    @Test
    public void parse_optionalFieldsMissing_success() {
        // no dateTime
        Task expectedTaskWithoutDateTime = new TaskBuilder().withTitle(VALID_TITLE_CS2103T)
                .withDescription(VALID_DESCRIPTION_CS2103T).withDateTime("").build();
        assertParseSuccess(parser, TITLE_DESC_CS2103T + DESCRIPTION_DESC_CS2103T,
                new ScheduleAddCommand(expectedTaskWithoutDateTime));

        // no description
        Task expectedTaskWithoutDescription = new TaskBuilder().withTitle(VALID_TITLE_CS2103T).withDescription("")
                .withDateTime(VALID_DATETIME_CS2103T).build();
        assertParseSuccess(parser, TITLE_DESC_CS2103T + DATETIME_DESC_CS2103T,
                new ScheduleAddCommand(expectedTaskWithoutDescription));

        // no dateTime and no description
        Task expectedTaskWithOnlyTitle = new TaskBuilder().withTitle(VALID_TITLE_CS2103T).withDescription("")
                .withDateTime("").build();
        assertParseSuccess(parser, TITLE_DESC_CS2103T,
                new ScheduleAddCommand(expectedTaskWithOnlyTitle));
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, ScheduleAddCommand.MESSAGE_USAGE);

        // missing title prefix
        assertParseFailure(parser, VALID_TITLE_CS2103T + DESCRIPTION_DESC_CS2103T + DATETIME_DESC_CS2103T,
                expectedMessage);

    }

    @Test
    public void parse_invalidValue_failure() {
        // invalid title
        assertParseFailure(parser, INVALID_TITLE_DESC + DESCRIPTION_DESC_CS2103T + DATETIME_DESC_CS2103T,
                Title.MESSAGE_CONSTRAINTS);

        // invalid email
        assertParseFailure(parser, TITLE_DESC_CS2103T + DESCRIPTION_DESC_CS2103T + INVALID_DATETIME_DESC,
                DateTime.MESSAGE_CONSTRAINTS);


        // two invalid values, only first invalid value reported
        assertParseFailure(parser, INVALID_TITLE_DESC + DATETIME_DESC_CS2103T,
                Title.MESSAGE_CONSTRAINTS);

        // non-empty preamble
        assertParseFailure(parser, PREAMBLE_NON_EMPTY + TITLE_DESC_CS2103T + DESCRIPTION_DESC_CS2103T
                        + DATETIME_DESC_CS2103T,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, ScheduleAddCommand.MESSAGE_USAGE));
    }
}
