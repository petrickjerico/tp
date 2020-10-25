package seedu.studybananas.logic.commands.quizcommands;

import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.CommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.Model;
import seedu.studybananas.model.flashcard.FlashcardSetName;

public class ViewScoreCommand extends Command<Model> {

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
    public CommandResult execute(Model model) throws CommandException {

        if (model.hasStarted()) {
            throw new CommandException(MESSAGE_UNABLE_TO_VIEW);
        }

        try {
            FlashcardSetName name = model.getFlashcardSet(Index.fromOneBased(index)).getFlashcardSetName();

            String score = model.getQuizRecords(name);
            QuizCommand.updateCommandResult(score);

            return new CommandResult(score);
        } catch (NullPointerException e) {
            throw new CommandException(MESSAGE_QUIZ_NONEXISTENT);
        }
    }
}
