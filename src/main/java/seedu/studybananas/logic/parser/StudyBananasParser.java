package seedu.studybananas.logic.parser;

import static seedu.studybananas.commons.core.Messages.MESSAGE_QUIZ_HAS_STARTED;

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
        if (quizIsOngoing && isQuizCommand(ctm, trimmedUserInput)) {
            throw new ParseException(MESSAGE_QUIZ_HAS_STARTED);
        }

        switch (ctm.match(trimmedUserInput)) {
        case FLASHCARD:
            return new FlashcardParser().parse(trimmedUserInput);
        case QUIZ:
            return new QuizParser().parse(trimmedUserInput);
        case TASK:
            return new ScheduleParser().parse(trimmedUserInput);
        default:
            return new GeneralParser().parse(trimmedUserInput);
        }
    }

    private boolean isQuizCommand(CommandTypeMatcher ctm, String userInput) throws ParseException {
        CommandTypeMatcher.CommandType quizCommand = CommandTypeMatcher.CommandType.QUIZ;
        return !ctm.match(userInput).equals(quizCommand);
    }
}
