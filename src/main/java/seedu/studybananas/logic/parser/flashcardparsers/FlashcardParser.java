package seedu.studybananas.logic.parser.flashcardparsers;

import static seedu.studybananas.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.studybananas.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.HelpCommand;
import seedu.studybananas.logic.commands.flashcardcommands.*;
import seedu.studybananas.logic.parser.Parser;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.model.FlashcardModel;


public class FlashcardParser implements Parser<Command> {
    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern
            .compile("((\\w+) (\\w+))(\\s.*)?");

    @Override
    public Command<FlashcardModel> parse(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());

        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group(1).toLowerCase();

        final String argument = toTokenizableString(matcher.group(4));

        switch (commandWord) {
        case AddFlashcardCommand.COMMAND_WORD:
            return new AddFlashcardCommandParser().parse(argument);
        case AddFlashcardSetCommand.COMMAND_WORD:
            return new AddFlashcardSetCommandParser().parse(argument);
        case DeleteFlashcardCommand.COMMAND_WORD:
            return new DeleteFlashcardCommandParser().parse(argument);
        case DeleteFlashcardSetCommand.COMMAND_WORD:
            return new DeleteFlashcardSetCommandParser().parse(argument);
        case ListFlashcardCommand.COMMAND_WORD:
            return new ListFlashcardCommandParser().parse(argument);
        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    private String toTokenizableString(String str) {
        return str == null ? "" : str;
    }
}
