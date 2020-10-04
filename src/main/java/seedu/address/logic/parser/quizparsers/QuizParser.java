package seedu.address.logic.parser.quizparsers;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.ExampleCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;

public class QuizParser implements Parser<Command> {
    @Override
    public Command parse(String userInput) throws ParseException {
        return new ExampleCommand();
    }
}
