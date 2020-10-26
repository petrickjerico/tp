package seedu.studybananas.logic.parser.flashcardparsers;

import static seedu.studybananas.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.NAME_DESC_ECONOMICS;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.NAME_DESC_PHYSICS;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.NAME_DESC_PHYSICS_EXTRA_WHITESPACE;
import static seedu.studybananas.logic.commands.commandtestutils.FlashcardBankCommandTestUtil.VALID_FLSET_NAME_PHYSICS;
import static seedu.studybananas.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.studybananas.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.studybananas.logic.commands.flashcardcommands.AddFlashcardSetCommand;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.testutil.FlashcardSetBuilder;

public class AddFlashcardSetCommandParserTest {
    private final AddFlashcardSetCommandParser parser = new AddFlashcardSetCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        FlashcardSet expectedFlashcardSet = new FlashcardSetBuilder().withFlashcardSetName(VALID_FLSET_NAME_PHYSICS)
                .build();

        String a = AddFlashcardSetCommand.COMMAND_WORD + NAME_DESC_PHYSICS;
        // valid
        assertParseSuccess(parser, NAME_DESC_PHYSICS,
                new AddFlashcardSetCommand(expectedFlashcardSet));

        // extra whitespace between parameter and value
        assertParseSuccess(parser, NAME_DESC_PHYSICS_EXTRA_WHITESPACE,
                new AddFlashcardSetCommand(expectedFlashcardSet));

        // multiple names - last name accepted
        assertParseSuccess(parser, NAME_DESC_ECONOMICS
                + NAME_DESC_PHYSICS, new AddFlashcardSetCommand(expectedFlashcardSet));
    }

    @Test
    public void parse_missingFields_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddFlashcardSetCommand.MESSAGE_USAGE);

        // missing name prefix
        assertParseFailure(parser, VALID_FLSET_NAME_PHYSICS,
                expectedMessage);
    }

}
