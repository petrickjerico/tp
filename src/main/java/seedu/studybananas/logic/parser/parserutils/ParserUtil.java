package seedu.studybananas.logic.parser.parserutils;

import static java.util.Objects.requireNonNull;

import java.util.stream.Stream;

import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.commons.util.StringUtil;
import seedu.studybananas.logic.parser.ArgumentMultimap;
import seedu.studybananas.logic.parser.Prefix;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.model.flashcard.Answer;
import seedu.studybananas.model.flashcard.FlashcardSetName;
import seedu.studybananas.model.flashcard.Question;
import seedu.studybananas.model.task.DateTime;
import seedu.studybananas.model.task.Description;
import seedu.studybananas.model.task.Duration;
import seedu.studybananas.model.task.Title;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Invalid index, please provide positive integer.";

    /**
     * Parses {@code numericString} and checks whether the string is numeric.
     * @param numericString
     * @return true if the string is numeric, false otherwise.
     */
    public static boolean isNumeric(String numericString) {
        boolean isNumber = numericString.chars().allMatch(Character::isDigit);
        return isNumber;
    }

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    //=========== Schedule/Task =============================================================
    /**
     * Parses {@code String title} into a {@code Title}.
     *
     * @throws ParseException if the given {@code title} is invalid.
     */
    public static Title parseTitle(String title) throws ParseException {
        requireNonNull(title);
        String trimmedTitle = title.trim();
        if (!Title.isValidTitle(trimmedTitle)) {
            throw new ParseException(Title.MESSAGE_CONSTRAINTS);
        }
        return new Title(title);
    }

    /**
     * Parses {@code String description} into a {@code Description}.
     *
     * @throws ParseException if the given {@code description} is invalid.
     */
    public static Description parseDescription(String description) throws ParseException {
        if (description == null) {
            return null;
        }

        String trimmedDescription = description.trim();
        if (!Description.isValidDescription(trimmedDescription)) {
            throw new ParseException(Description.MESSAGE_CONSTRAINTS);
        }
        return new Description(description);
    }

    /**
     * Parses {@code String time} into a {@code Time}.
     *
     * @throws ParseException if the given {@code time} is invalid.
     */
    public static DateTime parseTime(String time) throws ParseException {
        if (time == null) {
            return null;
        }

        String trimmedTime = time.trim();
        if (!DateTime.isValidDateTime(trimmedTime)) {
            throw new ParseException(DateTime.MESSAGE_CONSTRAINTS);
        }
        return new DateTime(time);
    }

    /**
     * Parses {@code String duration} into a {@code Duration}.
     *
     * @throws ParseException if the given {@code duration} is invalid.
     */
    public static Duration parseDuration(String duration) throws ParseException {
        if (duration == null) {
            return null;
        }

        String trimmedDuration = duration.trim();
        if (!Duration.isValidDuration(trimmedDuration)) {
            throw new ParseException(Duration.MESSAGE_CONSTRAINTS);
        }
        return new Duration(trimmedDuration);
    }



    //=========== Flashcard =============================================================
    /**
     * Parses {@code String question} into a {@code Question}.
     *
     * @throws ParseException if the given {@code question} is invalid.
     */
    public static Question parseQuestion(String question) throws ParseException {
        requireNonNull(question);
        String trimmedQuestion = question.trim();
        if (!Question.isValidQuestion(trimmedQuestion)) {
            throw new ParseException(Question.MESSAGE_CONSTRAINTS);
        }
        return new Question(question);
    }

    /**
     * Parses {@code String answer} into a {@code Answer}.
     *
     * @throws ParseException if the given {@code answer} is invalid.
     */
    public static Answer parseAnswer(String answer) throws ParseException {
        requireNonNull(answer);
        String trimmedAnswer = answer.trim();
        if (!Answer.isValidAnswer(trimmedAnswer)) {
            throw new ParseException(Answer.MESSAGE_CONSTRAINTS);
        }
        return new Answer(answer);
    }

    //=========== Flashcard Set =============================================================
    /**
     * Parses {@code String flashcarsSetName} into a {@code Name} for flashcard set.
     *
     * @throws ParseException if the given {@code flashcardSetName} is invalid.
     */
    public static FlashcardSetName parseFlashcardSetName(String flashcardSetName)
            throws ParseException {
        requireNonNull(flashcardSetName);
        String trimmedName = flashcardSetName.trim();
        if (!FlashcardSetName.isValidName(trimmedName)) {
            throw new ParseException(FlashcardSetName.MESSAGE_CONSTRAINTS);
        }
        return new FlashcardSetName(flashcardSetName);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    public static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
