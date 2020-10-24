package seedu.address.logic.commands.quizcommands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.flashcard.FlashcardSet;
import seedu.address.model.flashcard.Question;
import seedu.address.model.quiz.Quiz;

//The abstraction has to be clarified.
public class StartCommand extends Command<Model> {

    public static final String MESSAGE_QUIZ_IN_PROGRESS = "A quiz is already in progress! "
            + "Key 'refresh' to see current question/answer. \n"
            + "To stop the current quiz, key 'cancel'.";
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
            Index indexWrapper = Index.fromOneBased(index);
            FlashcardSet flashcardSet = model.getFlashcardSet(indexWrapper);

            if (flashcardSet.getSize() == 0) { // check for empty flashcard set
                throw new CommandException(MESSAGE_FLASHCARD_SET_EMPTY);
            }

            Quiz quiz = new Quiz(this.index, flashcardSet);
            Question firstQuestion = model.start(quiz);

            QuizCommand.setStatus(Status.ON_QUESTION);

            String questionStringtoShow = firstQuestion.toString()
                    + QuizCommand.MESSAGE_AVAIL_ON_QUESTION;
            QuizCommand.updateCommandResult(questionStringtoShow);

            return new CommandResult(questionStringtoShow);

        } catch (IndexOutOfBoundsException e) {
            throw new CommandException(MESSAGE_FLASHCARD_SET_NONEXISTENT);
        }
    }
}
