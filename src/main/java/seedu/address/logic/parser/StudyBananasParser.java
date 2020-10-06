package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Pattern;

import seedu.address.logic.commands.Command;
import seedu.address.logic.parser.addressbookparsers.AddressBookParser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.flashcardparsers.FlashcardParser;
import seedu.address.logic.parser.parserutils.CommandTypeMatcher;
import seedu.address.logic.parser.quizparsers.QuizParser;
import seedu.address.logic.parser.scheduleparsers.ScheduleParser;

/**
 * Parses user input.
 */
public class StudyBananasParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final CommandTypeMatcher ctm = new CommandTypeMatcher();

        switch (ctm.match(userInput)) {
        case ADDRESSBOOK:
            return new AddressBookParser().parse(userInput);

        case FLASHCARD:
            return new FlashcardParser().parse(userInput);

        case QUIZ:
            return new QuizParser().parse(userInput);

        case TASK:
            return new ScheduleParser().parse(userInput);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
