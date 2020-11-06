package seedu.studybananas.logic.parser.generalparsers;

import static seedu.studybananas.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.ExitCommand;
import seedu.studybananas.logic.commands.HelpCommand;
import seedu.studybananas.logic.parser.Parser;
import seedu.studybananas.logic.parser.exceptions.ParseException;

public class GeneralParser implements Parser<Command> {
    @Override
    public Command parse(String userInput) throws ParseException {

        if (userInput.toLowerCase().equals(HelpCommand.COMMAND_WORD)) {
            return new HelpCommand();
        }

        if (userInput.toLowerCase().equals(ExitCommand.COMMAND_WORD)) {
            return new ExitCommand();
        }

        throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
    }
}
