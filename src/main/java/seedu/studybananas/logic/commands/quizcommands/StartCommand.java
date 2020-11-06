package seedu.studybananas.logic.commands.quizcommands;

import static java.util.Objects.requireNonNull;
import static seedu.studybananas.logic.commands.commandresults.QuizCommandResultType.START;

import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.commandresults.CommandResult;
import seedu.studybananas.logic.commands.commandresults.QuizCommandResult;
import seedu.studybananas.logic.commands.exceptions.CommandException;
import seedu.studybananas.model.FlashcardQuizModel;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.flashcard.FlashcardSetName;
import seedu.studybananas.model.flashcard.Question;
import seedu.studybananas.model.quiz.Quiz;
import seedu.studybananas.ui.quizui.QuizCard;

public class StartCommand extends Command<FlashcardQuizModel> {

    public static final String COMMAND_WORD = "quiz flset:";
    public static final String MESSAGE_QUIZ_IN_PROGRESS = "A quiz is already in progress! "
            + "Key 'refresh' to see current question/answer. \n"
            + "To stop the current quiz, key 'cancel'.";

    public static final String MESSAGE_FLASHCARD_SET_NONEXISTENT =
            "Flashcard set does not exist\nPlease provide a valid index or set name";

    public static final String MESSAGE_FLASHCARD_SET_EMPTY =
            "Flashcard set is empty\nPlease fill it with flashcards";

    private final int index;
    private final FlashcardSetName flashcardSetName;
    private FlashcardSet flashcardSet;

    private FlashcardQuizModel model;

    /**
     * Constructs a StartCommand based on the index provided.
     * @param index of the flashcard set
     */
    public StartCommand(int index) {
        this.index = index;
        this.flashcardSetName = null;
    }

    /**
     * Constructs a StartCommand based on the name provided.
     * @param name of the flashcard set
     */
    public StartCommand(FlashcardSetName name) {
        this.index = 0;
        this.flashcardSetName = name;
    }

    @Override
    public CommandResult execute(FlashcardQuizModel model) throws CommandException {
        requireNonNull(model);

        this.model = model;

        if (model.hasStarted()) {
            throw new CommandException(MESSAGE_QUIZ_IN_PROGRESS);
        }

        try {
            if (index == 0) {
                flashcardSet = model.getFlashcardSet(flashcardSetName);
            } else {
                Index indexWrapper = Index.fromOneBased(index);
                flashcardSet = model.getFlashcardSet(indexWrapper);
            }

            if (flashcardSet == null) {
                throw new CommandException(MESSAGE_FLASHCARD_SET_NONEXISTENT);
            }

            if (flashcardSet.getSize() == 0) { // check for empty flashcard set
                throw new CommandException(MESSAGE_FLASHCARD_SET_EMPTY);
            }

            Quiz quiz = new Quiz(this.index, flashcardSet);
            Question firstQuestion = model.start(quiz);
            QuizCard.setQuestion(firstQuestion);
            QuizCommandUtil.setStatus(Status.ON_QUESTION);

            String feedback = QuizCommandUtil.MESSAGE_AVAIL_ON_QUESTION;
            QuizCommandUtil.updateCommandResult(feedback);

            return new QuizCommandResult(feedback, quiz, START);

        } catch (IndexOutOfBoundsException e) {
            throw new CommandException(MESSAGE_FLASHCARD_SET_NONEXISTENT);
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof StartCommand // instanceof handles nulls
                && index == (((StartCommand) other).index)); // state check
    }

    /**
     * Get the {@Code Index} of the flashcardSet for the quiz.
     */
    public Index getQuizIndex() {
        return Index.fromOneBased(index);
    }

    /**
     * Get the {@Code FlashcardSetName} of the flashcardSet for the quiz.
     */
    public FlashcardSetName getFlashcardSetName() {
        return flashcardSetName;
    }
}
