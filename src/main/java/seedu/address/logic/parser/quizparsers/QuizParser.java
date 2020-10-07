package seedu.address.logic.parser.quizparsers;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.quizcommands.CancelCommand;
import seedu.address.logic.commands.quizcommands.CorrectCommand;
import seedu.address.logic.commands.quizcommands.FlipCommand;
import seedu.address.logic.commands.quizcommands.StartCommand;
import seedu.address.logic.commands.quizcommands.WrongCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;

public class QuizParser implements Parser<Command> {

    public static final String MESSAGE_PARSING_ERROR = "";

    @Override
    public Command parse(String userInput) throws ParseException {
        if (userInput.contains("quiz flset:")) {
            userInput = userInput.replace("quiz flset:", "");
            try {
                int index = Integer.parseInt(userInput);
                return new StartCommand(index);
            } catch (NumberFormatException e) {
                throw new ParseException("Invalid characters provided for flashcard set number");
            }
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
}
