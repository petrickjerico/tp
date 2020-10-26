package seedu.studybananas.logic.parser.scheduleparsers;


import static seedu.studybananas.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.studybananas.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.HelpCommand;
import seedu.studybananas.logic.commands.schedulecommands.ScheduleAddCommand;
import seedu.studybananas.logic.commands.schedulecommands.ScheduleDeleteCommand;
import seedu.studybananas.logic.commands.schedulecommands.ScheduleEditCommand;
import seedu.studybananas.logic.commands.schedulecommands.ScheduleListCommand;
import seedu.studybananas.logic.commands.schedulecommands.ScheduleSearchCommand;
import seedu.studybananas.logic.parser.Parser;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.model.ScheduleModel;

public class ScheduleParser implements Parser<Command> {
    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern
            .compile("((\\w+) (\\w+))(\\s.*)?");

    @Override
    public Command<ScheduleModel> parse(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());

        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }
        final String commandWord = matcher.group(1).toLowerCase();
        //temporary to solve the bug...
        final String arguments = toTokenizableString(matcher.group(4));

        switch (commandWord) {
        case ScheduleListCommand.COMMAND_WORD:
            return new ScheduleListCommand();
        case ScheduleAddCommand.COMMAND_WORD:
            return new ScheduleAddCommandParser().parse(arguments);
        case ScheduleDeleteCommand.COMMAND_WORD:
            return new ScheduleDeleteCommandParser().parse(arguments);
        case ScheduleSearchCommand.COMMAND_WORD:
            return new ScheduleSearchCommandParser().parse(arguments);
        case ScheduleEditCommand.COMMAND_WORD:
            return new ScheduleEditCommandParser().parse(arguments);
        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }

    }

    private String toTokenizableString(String str) {
        return str == null ? "" : str;
    }
}
