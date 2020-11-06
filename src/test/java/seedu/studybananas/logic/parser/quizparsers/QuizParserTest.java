package seedu.studybananas.logic.parser.quizparsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.studybananas.logic.parser.quizparsers.QuizParser.MESSAGE_PARSING_ERROR;
import static seedu.studybananas.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.studybananas.logic.commands.quizcommands.AnswerCommand;
import seedu.studybananas.logic.commands.quizcommands.CancelCommand;
import seedu.studybananas.logic.commands.quizcommands.CorrectCommand;
import seedu.studybananas.logic.commands.quizcommands.FlipCommand;
import seedu.studybananas.logic.commands.quizcommands.RefreshCommand;
import seedu.studybananas.logic.commands.quizcommands.StartCommand;
import seedu.studybananas.logic.commands.quizcommands.ViewScoreCommand;
import seedu.studybananas.logic.commands.quizcommands.WrongCommand;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.model.flashcard.FlashcardSetName;

public class QuizParserTest {

    private final QuizParser parser = new QuizParser();

    @Test
    public void parse_invalidCommand_throwsParseException() {
        // empty string
        assertThrows(ParseException.class, MESSAGE_PARSING_ERROR, (
        ) -> parser.parse(""));

        // invalid input
        assertThrows(ParseException.class, MESSAGE_PARSING_ERROR, (
        ) -> parser.parse("hello"));
    }

    @Test
    public void parseNumber_success() throws ParseException {
        String validNumberString = "9";
        int validNumber = 9;

        int parsedNumber = parser.parseNumber(validNumberString);
        assertEquals(validNumber, parsedNumber);
    }

    @Test
    public void parseNumber_invalidNumber_throwsParseException() {
        String invalidNumberCharacter = "A";
        String invalidNumberString = "one";

        assertThrows(ParseException.class, () -> parser.parseNumber(invalidNumberCharacter));
        assertThrows(ParseException.class, () -> parser.parseNumber(invalidNumberString));
    }

    @Test
    public void parse_startCommand_returnsStartCommand() throws ParseException {
        StartCommand expectedCommand = new StartCommand(1);
        StartCommand startCommand = (StartCommand) parser.parse("quiz flset:1");
        assertEquals(expectedCommand, startCommand);

        expectedCommand = new StartCommand(new FlashcardSetName("physics"));
        startCommand = (StartCommand) parser.parse("quiz flset: physics");
        assertEquals(expectedCommand, startCommand);
    }

    @Test
    public void parse_viewScoreCommand_returnsViewScoreCommand() throws ParseException {
        ViewScoreCommand expectedCommand = new ViewScoreCommand(1);
        ViewScoreCommand viewScoreCommand = (ViewScoreCommand) parser.parse("quiz score flset:1");
        assertEquals(expectedCommand, viewScoreCommand);

        expectedCommand = new ViewScoreCommand(new FlashcardSetName("economics"));
        viewScoreCommand = (ViewScoreCommand) parser.parse("quiz score flset:   ecOnoMics");
        assertEquals(expectedCommand, viewScoreCommand);
    }

    @Test
    public void parse_answerCommand_returnsAnswerCommand() throws ParseException {
        String answer = "Random answer here";
        AnswerCommand expectedCommand = new AnswerCommand(answer);
        AnswerCommand answerCommand = (AnswerCommand) parser.parse("ans:Random answer here");
        assertEquals(expectedCommand, answerCommand);
    }

    @Test
    public void parse_cancelCommand_returnsCancelCommand() throws ParseException {
        CancelCommand expectedCommand = new CancelCommand();
        CancelCommand cancelCommand = (CancelCommand) parser.parse("cancel");
        assertEquals(expectedCommand, cancelCommand);
    }

    @Test
    public void parse_flipCommand_returnsFlipCommand() throws ParseException {
        FlipCommand expectedCommand = new FlipCommand();
        FlipCommand flipCommand = (FlipCommand) parser.parse("flip");
        assertEquals(expectedCommand, flipCommand);
    }

    @Test
    public void parse_correctCommand_returnsCorrectCommand() throws ParseException {
        CorrectCommand expectedCommand = new CorrectCommand();
        CorrectCommand correctCommand = (CorrectCommand) parser.parse("c");
        assertEquals(expectedCommand, correctCommand);
    }

    @Test
    public void parse_refreshCommand_returnsRefreshCommand() throws ParseException {
        RefreshCommand expectedCommand = new RefreshCommand();
        RefreshCommand refreshCommand = (RefreshCommand) parser.parse("refresh");
        assertEquals(expectedCommand, refreshCommand);
    }

    @Test
    public void parse_wrongCommand_returnsWrongCommand() throws ParseException {
        WrongCommand expectedCommand = new WrongCommand();
        WrongCommand wrongCommand = (WrongCommand) parser.parse("w");
        assertEquals(expectedCommand, wrongCommand);
    }
}
