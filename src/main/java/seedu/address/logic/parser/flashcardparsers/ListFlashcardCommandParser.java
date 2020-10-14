package seedu.address.logic.parser.flashcardparsers;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.flashcardcommands.ListFlashcardCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.parserutils.ParserUtil;

public class ListFlashcardCommandParser implements Parser<ListFlashcardCommand> {

    @Override
    public ListFlashcardCommand parse(String userInput) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(userInput);
            return new ListFlashcardCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListFlashcardCommand.MESSAGE_USAGE), pe);
        }
    }

}
