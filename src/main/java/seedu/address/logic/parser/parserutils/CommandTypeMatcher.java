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

        if (isFlashcardCommand(command)) {
            return CommandType.FLASHCARD;
        }

        if (isTaskCommand(command)) {
            return CommandType.TASK;
        }

        if (isQuizCommand(command)) {
            return CommandType.QUIZ;
        }

        if (isAddressBookCommand(command)) {
            return CommandType.ADDRESSBOOK;
        }

        throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
    }

    private String getFirstWord(String userInput) {
        String[] splittedWords = userInput.split(" ");
        return splittedWords[0];
    }

    private String getSecondWord(String userInput) {
        String[] splittedWords = userInput.split(" ");
        return splittedWords[1];
    }

    private boolean doesContainTwoOrMoreWords(String userInput) {
        String[] splittedWords = userInput.split(" ");
        return splittedWords.length > 1;
    }

    private boolean isAddressBookCommand(String command) {
        return true;
    }

    private boolean isFlashcardCommand(String command) {
        String lowercaseCommand = command.toLowerCase();
        return doesContainTwoOrMoreWords(command) && (
                getSecondWord(lowercaseCommand).equals("flset") || getSecondWord(lowercaseCommand).equals("fl"));
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
            return doesContainTwoOrMoreWords(lowercaseCommand) && (
                    getFirstWord(lowercaseCommand).equals("quiz"));
        }
    }

    private boolean isTaskCommand(String command) {
        return doesContainTwoOrMoreWords(command) && (
                getSecondWord(command).toLowerCase().equals("task"));
    }
}
