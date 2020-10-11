package seedu.address.logic.parser.scheduleparsers;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.schedulecommands.ScheduleSearchCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.task.TitleContainsKeywordsPredicate;

public class ScheduleSearchCommandParser implements Parser<ScheduleSearchCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the ScheduleSearchCommand
     * and returns a ScheduleSearchCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ScheduleSearchCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ScheduleSearchCommand.MESSAGE_USAGE));
        }

        String[] titleKeywords = trimmedArgs.split("\\s+");

        return new ScheduleSearchCommand(new TitleContainsKeywordsPredicate(Arrays.asList(titleKeywords)));
    }
}
