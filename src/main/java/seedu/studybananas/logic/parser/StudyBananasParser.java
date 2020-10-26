package seedu.studybananas.logic.parser;

import static seedu.studybananas.commons.core.Messages.MESSAGE_QUIZ_HAS_STARTED;
import static seedu.studybananas.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Pattern;

import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.logic.parser.flashcardparsers.FlashcardParser;
import seedu.studybananas.logic.parser.parserutils.CommandTypeMatcher;
import seedu.studybananas.logic.parser.quizparsers.QuizParser;
import seedu.studybananas.logic.parser.scheduleparsers.ScheduleParser;
import seedu.studybananas.model.Model;

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
    public Command<? super Model> parseCommand(String userInput, boolean quizIsOngoing) throws ParseException {
        final CommandTypeMatcher ctm = new CommandTypeMatcher();

        if (quizIsOngoing && !ctm.match(userInput).equals(CommandTypeMatcher.CommandType.QUIZ)) {
            throw new ParseException(MESSAGE_QUIZ_HAS_STARTED);
        }

        switch (ctm.match(userInput)) {
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
