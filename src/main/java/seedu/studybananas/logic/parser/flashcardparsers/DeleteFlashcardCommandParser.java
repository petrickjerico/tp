package seedu.studybananas.logic.parser.flashcardparsers;

import static seedu.studybananas.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_FLASHCARD;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_FLASHCARDSET;
import static seedu.studybananas.logic.parser.parserutils.ParserUtil.arePrefixesPresent;

import seedu.studybananas.commons.core.Messages;
import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.logic.commands.flashcardcommands.DeleteFlashcardCommand;
import seedu.studybananas.logic.parser.ArgumentMultimap;
import seedu.studybananas.logic.parser.ArgumentTokenizer;
import seedu.studybananas.logic.parser.Parser;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.logic.parser.parserutils.ParserUtil;

public class DeleteFlashcardCommandParser implements Parser<DeleteFlashcardCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the DeleteFlashcardSetCommand
     * and returns an DeleteFlashcardSetCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public DeleteFlashcardCommand parse(String userInput) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(userInput, PREFIX_FLASHCARDSET, PREFIX_FLASHCARD);

        if (!arePrefixesPresent(argMultimap, PREFIX_FLASHCARDSET, PREFIX_FLASHCARD)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteFlashcardCommand.MESSAGE_USAGE));
        }

        Index flashcardSetIndex;
        Index flashcardIndex;

        try {
            flashcardSetIndex = ParserUtil.parseIndex(argMultimap.getValue(PREFIX_FLASHCARDSET).get());
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(Messages.MESSAGE_INVALID_FLASHCARDSET_DISPLAYED_INDEX), pe);
        }

        try {
            flashcardIndex = ParserUtil.parseIndex(argMultimap.getValue(PREFIX_FLASHCARD).get());
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(Messages.MESSAGE_INVALID_FLASHCARD_INDEX), pe);
        }

        return new DeleteFlashcardCommand(flashcardSetIndex, flashcardIndex);
    }
}
