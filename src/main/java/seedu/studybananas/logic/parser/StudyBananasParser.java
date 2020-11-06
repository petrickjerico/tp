package seedu.studybananas.logic.parser;

import static seedu.studybananas.commons.core.Messages.MESSAGE_QUIZ_HAS_STARTED;
import static seedu.studybananas.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.logic.parser.flashcardparsers.FlashcardParser;
import seedu.studybananas.logic.parser.generalparsers.GeneralParser;
import seedu.studybananas.logic.parser.parserutils.CommandTypeMatcher;
import seedu.studybananas.logic.parser.quizparsers.QuizParser;
import seedu.studybananas.logic.parser.scheduleparsers.ScheduleParser;
import seedu.studybananas.model.Model;

/**
 * Parses user input.
 */
public class StudyBananasParser {

    /**
     * Parses user input into command for execution.
     *
     * @param userInput Full user input string.
     * @return The command based on the user input.
     * @throws ParseException If the user input does not conform the expected format.
     */
    public Command<? super Model> parseCommand(String userInput, boolean quizIsOngoing) throws ParseException {
        final CommandTypeMatcher ctm = new CommandTypeMatcher();
        String trimmedUserInput = userInput.trim();


        switch (ctm.match(trimmedUserInput)) {
        case FLASHCARD:
            return parseCommand(new FlashcardParser(), trimmedUserInput, false, quizIsOngoing);
        case QUIZ:
            return parseCommand(new QuizParser(), trimmedUserInput, true, quizIsOngoing);
        case TASK:
            return parseCommand(new ScheduleParser(), trimmedUserInput, false, quizIsOngoing);
        case GENERAL:
            return parseCommand(new GeneralParser(), trimmedUserInput, true, quizIsOngoing);
        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }


    private Command parseCommand(Parser parser, String userInput, boolean immuneToQuiz, boolean quizIsOngoing)
            throws ParseException {
        if (immuneToQuiz) {
            return parser.parse(userInput);
        }

        if (quizIsOngoing) {
            throw new ParseException(MESSAGE_QUIZ_HAS_STARTED);
        }

        return parser.parse(userInput);

    }
}
