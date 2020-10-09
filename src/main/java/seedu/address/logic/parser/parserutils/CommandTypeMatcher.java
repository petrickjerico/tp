package seedu.address.logic.parser.parserutils;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.addressbookcommands.HelpCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class CommandTypeMatcher {
    public enum CommandType {
        ADDRESSBOOK, FLASHCARD, QUIZ, TASK
    }

    /**
     * Match the command to the valid command type.
     * @param command command string
     * @return commandType of the command
     */
    public CommandType match(String command) throws ParseException {

        if (isQuizCommand(command)) {
            return CommandType.QUIZ;
        }

        // switched these 2 bc quiz is more specific
        if (isFlashcardCommand(command)) {
            return CommandType.FLASHCARD;
        }

        if (isTaskCommand(command)) {
            return CommandType.TASK;
        }

        if (isAddressBookCommand(command)) {
            return CommandType.ADDRESSBOOK;
        }

        throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
    }

    private boolean isAddressBookCommand(String command) {
        return true;
    }

    //buggy, temporary, still need to evaluate the pattern
    private boolean isFlashcardCommand(String command) {
        String lowercaseCommand = command.toLowerCase();
        return lowercaseCommand.contains("flset") || lowercaseCommand.contains("fl");
    }

    private boolean isQuizCommand(String command) {
        String lowercaseCommand = command.toLowerCase();
        switch (lowercaseCommand) {
        case "cancel":
        case "c":
        case "flip":
        case "w":
            return true;
        default:
            return lowercaseCommand.contains("quiz");
        }
    }

    //buggy, temporary, still need to evaluate the pattern
    private boolean isTaskCommand(String command) {
        return command.toLowerCase().contains("task");
    }


}
