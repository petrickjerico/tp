package seedu.studybananas.logic.commands.quizcommands;

import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.CommandResult;
import seedu.studybananas.logic.commands.QuizCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.FlashcardQuizModel;
import seedu.studybananas.model.flashcard.FlashcardSetName;

public class ViewScoreCommand extends Command<FlashcardQuizModel> {

    public static final String COMMAND_WORD = "quiz score flset:";

    public static final String MESSAGE_UNABLE_TO_VIEW =
            "Unable to view score as quiz is in progress. "
                    + "Cancel or finish the quiz to view recent quiz score.";
    public static final String MESSAGE_QUIZ_NONEXISTENT =
            "Quiz records for this flashcard set does not exist.";
    private final int index;

    public ViewScoreCommand(int index) {
        this.index = index;
    }

    @Override
    public CommandResult execute(FlashcardQuizModel model) throws CommandException {

        if (model.hasStarted()) {
            throw new CommandException(MESSAGE_UNABLE_TO_VIEW);
        }

        try {
            FlashcardSetName name = model.getFlashcardSet(Index.fromOneBased(index)).getFlashcardSetName();

            model.setQuizRecordsToView(name);

            String score = model.getQuizRecords(name);
            QuizCommand.updateCommandResult(score);

            return new QuizCommandResult(score);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            throw new CommandException(MESSAGE_QUIZ_NONEXISTENT);
        }
    }
}
