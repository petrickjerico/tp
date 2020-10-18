package seedu.address.logic.parser.flashcardparsers;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_FLASHCARDSET_NAME;
import static seedu.address.logic.parser.parserutils.ParserUtil.arePrefixesPresent;

import seedu.address.logic.commands.flashcardcommands.AddFlashcardSetCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.parserutils.ParserUtil;
import seedu.address.model.flashcard.FlashcardSet;
import seedu.address.model.flashcard.FlashcardSetName;

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
