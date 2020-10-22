package seedu.address.logic.parser.quizparsers;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.quizcommands.AnswerCommand;
import seedu.address.logic.commands.quizcommands.CancelCommand;
import seedu.address.logic.commands.quizcommands.CorrectCommand;
import seedu.address.logic.commands.quizcommands.FlipCommand;
import seedu.address.logic.commands.quizcommands.RefreshCommand;
import seedu.address.logic.commands.quizcommands.StartCommand;
import seedu.address.logic.commands.quizcommands.ViewScoreCommand;
import seedu.address.logic.commands.quizcommands.WrongCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;

public class QuizParser implements Parser<Command> {

    public static final String MESSAGE_PARSING_ERROR =
            "The command for quiz is invalid. Please check the command format and try again.";

    @Override
    public Command<? super Model> parse(String userInput) throws ParseException {
        if (userInput.startsWith("quiz flset:")) {
            userInput = userInput.replace("quiz flset:", "");
            int index = parseNumber(userInput);
            return new StartCommand(index);
        } else if (userInput.startsWith("quiz score flset:")) {
            userInput = userInput.replace("quiz score flset:", "");
            int index = parseNumber(userInput);
            return new ViewScoreCommand(index);
        } else if (userInput.startsWith("quiz store flset:")) {
            userInput = userInput.replace("quiz store flset:", "");
            int index = parseNumber(userInput);
            return new StartCommand(index);
        } else if (userInput.startsWith("ans:")) {
            userInput = userInput.replace("ans:", "");
            return new AnswerCommand(userInput);
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
        case "refresh":
            return new RefreshCommand();
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
