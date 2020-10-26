package seedu.studybananas.logic.parser.flashcardparsers;

import static seedu.studybananas.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_FLASHCARDSET_NAME;
import static seedu.studybananas.logic.parser.parserutils.ParserUtil.arePrefixesPresent;

import seedu.studybananas.logic.commands.flashcardcommands.AddFlashcardSetCommand;
import seedu.studybananas.logic.parser.ArgumentMultimap;
import seedu.studybananas.logic.parser.ArgumentTokenizer;
import seedu.studybananas.logic.parser.Parser;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.logic.parser.parserutils.ParserUtil;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.flashcard.FlashcardSetName;

public class AddFlashcardSetCommandParser implements Parser<AddFlashcardSetCommand> {
    @Override
    public AddFlashcardSetCommand parse(String userInput) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(userInput, PREFIX_FLASHCARDSET_NAME);

        if (!arePrefixesPresent(argMultimap, PREFIX_FLASHCARDSET_NAME)) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddFlashcardSetCommand.MESSAGE_USAGE));
        }

        FlashcardSetName flashcardSetName =
                ParserUtil.parseFlashcardSetName(argMultimap.getValue(PREFIX_FLASHCARDSET_NAME).get());

        FlashcardSet flashcardSet = new FlashcardSet(flashcardSetName);

        return new AddFlashcardSetCommand(flashcardSet);
    }
}
