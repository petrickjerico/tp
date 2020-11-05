package seedu.studybananas.logic.parser.flashcardparsers;

import seedu.studybananas.commons.core.Messages;
import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.logic.commands.flashcardcommands.ListFlashcardCommand;
import seedu.studybananas.logic.parser.Parser;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.logic.parser.parserutils.ParserUtil;

public class ListFlashcardCommandParser implements Parser<ListFlashcardCommand> {

    @Override
    public ListFlashcardCommand parse(String userInput) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(userInput);
            return new ListFlashcardCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(Messages.MESSAGE_INVALID_FLASHCARDSET_DISPLAYED_INDEX);
        }
    }

}
