package seedu.studybananas.logic.parser.flashcardparsers;

import static seedu.studybananas.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_ANSWER;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_FLASHCARDSET;
import static seedu.studybananas.logic.parser.CliSyntax.PREFIX_QUESTION;
import static seedu.studybananas.logic.parser.parserutils.ParserUtil.arePrefixesPresent;

import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.logic.commands.flashcardcommands.AddFlashcardCommand;
import seedu.studybananas.logic.parser.ArgumentMultimap;
import seedu.studybananas.logic.parser.ArgumentTokenizer;
import seedu.studybananas.logic.parser.Parser;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.logic.parser.parserutils.ParserUtil;
import seedu.studybananas.model.flashcard.Answer;
import seedu.studybananas.model.flashcard.Flashcard;
import seedu.studybananas.model.flashcard.Question;


public class AddFlashcardCommandParser implements Parser<AddFlashcardCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddFlashcardCommand
     * and returns an AddFlashcardCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public AddFlashcardCommand parse(String userInput) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(userInput, PREFIX_FLASHCARDSET, PREFIX_ANSWER, PREFIX_QUESTION);

        if (!arePrefixesPresent(argMultimap, PREFIX_FLASHCARDSET, PREFIX_ANSWER, PREFIX_QUESTION)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddFlashcardCommand.MESSAGE_USAGE));
        }

        Index flashcardSetIndex = ParserUtil.parseIndex(argMultimap.getValue(PREFIX_FLASHCARDSET).get());
        Question question = ParserUtil.parseQuestion(argMultimap.getValue(PREFIX_QUESTION).get());
        Answer answer = ParserUtil.parseAnswer(argMultimap.getValue(PREFIX_ANSWER).get());

        Flashcard flashcard = new Flashcard(question, answer);

        return new AddFlashcardCommand(flashcard, flashcardSetIndex);
    }
}
