package seedu.address.logic.commands.quizcommands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.flashcard.FlashcardSet;
import seedu.address.model.flashcard.Question;
import seedu.address.model.quiz.Quiz;

public class StartCommand extends Command {

    public static final String MESSAGE_QUIZ_IN_PROGRESS = "Quiz already in progress!";
    public static final String MESSAGE_FLASHCARD_SET_NONEXISTENT = "Flashcard set does not exist";
    public static final String MESSAGE_FLASHCARD_SET_EMPTY = "Flashcard set is empty";
    private final int index;

    public StartCommand(int index) {
        this.index = index;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasStarted()) {
            throw new CommandException(MESSAGE_QUIZ_IN_PROGRESS);
        }

        try {
            FlashcardSet flashcardSet = model.getFlashcardSet(this.index);
            Quiz quiz = new Quiz(this.index, flashcardSet);
            Question firstQuestion = model.start(quiz);
            QuizCommand.setStatus(Status.ON_QUESTION);
            return new CommandResult(firstQuestion.toString());

        } catch (IndexOutOfBoundsException e) {
            throw new CommandException(MESSAGE_FLASHCARD_SET_NONEXISTENT);
        } catch (NullPointerException e) {
            throw new CommandException(MESSAGE_FLASHCARD_SET_EMPTY);
        }
    }
}
