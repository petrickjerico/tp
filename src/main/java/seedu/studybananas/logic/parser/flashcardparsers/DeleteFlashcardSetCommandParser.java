package seedu.studybananas.logic.parser.flashcardparsers;

import seedu.studybananas.commons.core.Messages;
import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.logic.commands.flashcardcommands.DeleteFlashcardSetCommand;
import seedu.studybananas.logic.parser.Parser;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.logic.parser.parserutils.ParserUtil;


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
            throw new ParseException(Messages.MESSAGE_INVALID_FLASHCARDSET_DISPLAYED_INDEX);
        }
    }
}
