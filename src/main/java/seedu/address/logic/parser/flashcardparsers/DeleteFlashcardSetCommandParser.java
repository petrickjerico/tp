package seedu.address.logic.parser.flashcardparsers;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.flashcardcommands.DeleteFlashcardSetCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.parserutils.ParserUtil;


public class DeleteFlashcardSetCommandParser implements Parser<DeleteFlashcardSetCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteFlashcardSetCommand
     * and returns an DeleteFlashcardSetCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public DeleteFlashcardSetCommand parse(String userInput) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(userInput);
            return new DeleteFlashcardSetCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteFlashcardSetCommand.MESSAGE_USAGE), pe);
        }
    }
}
