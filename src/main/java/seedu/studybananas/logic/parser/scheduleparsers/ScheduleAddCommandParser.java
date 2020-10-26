package seedu.studybananas.logic.parser.scheduleparsers;

import static seedu.studybananas.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_DURATION;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_TIME;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_TITLE;
import static seedu.studybananas.logic.parser.parserutils.ParserUtil.arePrefixesPresent;

import seedu.studybananas.logic.commands.schedulecommands.ScheduleAddCommand;
import seedu.studybananas.logic.parser.ArgumentMultimap;
import seedu.studybananas.logic.parser.ArgumentTokenizer;
import seedu.studybananas.logic.parser.Parser;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.logic.parser.parserutils.ParserUtil;
import seedu.studybananas.model.task.DateTime;
import seedu.studybananas.model.task.Description;
import seedu.studybananas.model.task.Duration;
import seedu.studybananas.model.task.Task;
import seedu.studybananas.model.task.Title;

public class ScheduleAddCommandParser implements Parser<ScheduleAddCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ScheduleAddCommand
     * and returns an ScheduleAddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ScheduleAddCommand parse(String args) throws ParseException {

        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_TITLE, PREFIX_DESCRIPTION, PREFIX_TIME, PREFIX_DURATION);

        if (!arePrefixesPresent(argMultimap, PREFIX_TITLE)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, ScheduleAddCommand.MESSAGE_USAGE));
        }

        Title title = ParserUtil.parseTitle(argMultimap.getValue(PREFIX_TITLE).get());
        Description description = ParserUtil.parseDescription(argMultimap.getValue(PREFIX_DESCRIPTION).orElse(null));
        DateTime time = ParserUtil.parseTime(argMultimap.getValue(PREFIX_TIME).orElse(null));
        Duration duration = ParserUtil.parseDuration(argMultimap.getValue(PREFIX_DURATION).orElse(null));

        Task task = new Task(title, description, time, duration);

        return new ScheduleAddCommand(task);
    }
}
