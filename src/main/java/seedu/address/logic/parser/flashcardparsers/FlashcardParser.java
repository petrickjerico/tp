package seedu.address.logic.parser.flashcardparsers;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.ExampleCommand;
import seedu.address.logic.commands.addressbookcommands.HelpCommand;
import seedu.address.logic.commands.flashcardcommands.AddFlashcardCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

public class FlashcardParser implements Parser<Command> {
    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern
            .compile("((\\w+) (\\w+))(\\s.*)?");

    @Override
    public Command parse(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());

        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group(1);

        final String argument = matcher.group(4);

        switch (commandWord) {
        case AddFlashcardCommand.COMMAND_WORD:
            return new AddFlashcardCommandParser().parse(argument);
        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }
}
