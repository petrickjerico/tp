package seedu.studybananas.logic.parser.flashcardparsers;

import static seedu.studybananas.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.ANSWER_DESC_OPPORTUNITY_COST;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.ANSWER_DESC_SECOND_LAW;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.FLSET_INDEX_DESC_ONE;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.FLSET_INDEX_DESC_TWO;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.INVALID_ANSWER_DESC;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.INVALID_FLSET_INDEX_NEGATIVE;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.INVALID_FLSET_INDEX_NON_INTEGER;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.INVALID_INDEX_ERROR_MESSAGE;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.INVALID_QUESTION_DESC;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.QUESTION_DESC_OPPORTUNITY_COST;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.QUESTION_DESC_SECOND_LAW;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.VALID_ANSWER_SECOND_LAW;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.VALID_QUESTION_SECOND_LAW;
import static seedu.studybananas.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.studybananas.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.logic.commands.flashcardcommands.AddFlashcardCommand;
import seedu.studybananas.model.flashcard.Answer;
import seedu.studybananas.model.flashcard.Flashcard;
import seedu.studybananas.model.flashcard.Question;
import seedu.studybananas.testutil.FlashcardBuilder;


public class AddFlashcardCommandParserTest {
    private final AddFlashcardCommandParser parser = new AddFlashcardCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        Flashcard expectedFlashcard = new FlashcardBuilder().withQuestion(VALID_QUESTION_SECOND_LAW)
                .withAnswer(VALID_ANSWER_SECOND_LAW).build();
        Index expectedIndex = Index.fromOneBased(1);

        // valid
        assertParseSuccess(parser, FLSET_INDEX_DESC_ONE + QUESTION_DESC_SECOND_LAW + ANSWER_DESC_SECOND_LAW,
                new AddFlashcardCommand(expectedFlashcard, expectedIndex));

        // multiple questions - last question accepted
        assertParseSuccess(parser, FLSET_INDEX_DESC_ONE + QUESTION_DESC_OPPORTUNITY_COST
                        + QUESTION_DESC_SECOND_LAW + ANSWER_DESC_SECOND_LAW,
                new AddFlashcardCommand(expectedFlashcard, expectedIndex));

        // multiple answers - last answer accepted
        assertParseSuccess(parser, FLSET_INDEX_DESC_ONE + QUESTION_DESC_SECOND_LAW
                        + ANSWER_DESC_OPPORTUNITY_COST + ANSWER_DESC_SECOND_LAW,
                new AddFlashcardCommand(expectedFlashcard, expectedIndex));

        // multiple flset index - last flset index accepted
        assertParseSuccess(parser, FLSET_INDEX_DESC_TWO + FLSET_INDEX_DESC_ONE
                        + QUESTION_DESC_SECOND_LAW + ANSWER_DESC_SECOND_LAW,
                new AddFlashcardCommand(expectedFlashcard, expectedIndex));

    }

    @Test
    public void parse_missingFields_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddFlashcardCommand.MESSAGE_USAGE);

        // missing index prefix
        assertParseFailure(parser, QUESTION_DESC_SECOND_LAW + ANSWER_DESC_SECOND_LAW,
                expectedMessage);

        // missing question prefix
        assertParseFailure(parser, FLSET_INDEX_DESC_ONE + ANSWER_DESC_SECOND_LAW,
                expectedMessage);

        // missing answer prefix
        assertParseFailure(parser, FLSET_INDEX_DESC_ONE + QUESTION_DESC_SECOND_LAW,
                expectedMessage);
    }

    @Test
    public void parse_invalidValue_failure() {
        // negative flset index
        assertParseFailure(parser, INVALID_FLSET_INDEX_NEGATIVE + QUESTION_DESC_SECOND_LAW + ANSWER_DESC_SECOND_LAW,
                INVALID_INDEX_ERROR_MESSAGE);

        // non-number flset index
        assertParseFailure(parser, INVALID_FLSET_INDEX_NON_INTEGER + QUESTION_DESC_SECOND_LAW + ANSWER_DESC_SECOND_LAW,
                INVALID_INDEX_ERROR_MESSAGE);

        // invalid question
        assertParseFailure(parser, FLSET_INDEX_DESC_ONE + INVALID_QUESTION_DESC + ANSWER_DESC_SECOND_LAW,
                Question.MESSAGE_CONSTRAINTS);

        // invalid answer
        assertParseFailure(parser, FLSET_INDEX_DESC_ONE + QUESTION_DESC_SECOND_LAW + INVALID_ANSWER_DESC,
                Answer.MESSAGE_CONSTRAINTS);
    }
}
