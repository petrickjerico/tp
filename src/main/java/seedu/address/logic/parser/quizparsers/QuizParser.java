package seedu.address.logic.parser.quizparsers;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.quizcommands.CancelCommand;
import seedu.address.logic.commands.quizcommands.CorrectCommand;
import seedu.address.logic.commands.quizcommands.FlipCommand;
import seedu.address.logic.commands.quizcommands.StartCommand;
import seedu.address.logic.commands.quizcommands.ViewScoreCommand;
import seedu.address.logic.commands.quizcommands.WrongCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.QuizModel;

public class QuizParser implements Parser<Command> {

    public static final String MESSAGE_PARSING_ERROR = "";

    @Override
    public Command<? super Model> parse(String userInput) throws ParseException {
        if (userInput.contains("quiz flset:")) {
            userInput = userInput.replace("quiz flset:", "");
            int index = parseNumber(userInput);
            return new StartCommand(index);
        } else if (userInput.contains("view flset quiz:")) {
            userInput = userInput.replace("view flset quiz:", "");
            int index = parseNumber(userInput);
            return new ViewScoreCommand(index);
        }
        switch (userInput) {
        case "cancel":
            return new CancelCommand();
        case "flip":
            return new FlipCommand();
        case "c":
            return new CorrectCommand();
        case "w":
            return new WrongCommand();
        default:
            throw new ParseException(MESSAGE_PARSING_ERROR);
        }
    }

    /**
     * Parses a int number from an inoput string
     * @param input string provided
     * @return an int number
     * @throws ParseException if the format of string is invalid
     */
    public int parseNumber(String input) throws ParseException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new ParseException("Invalid characters provided for flashcard set number");
        }
    }
}
