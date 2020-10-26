package seedu.studybananas.testutil;

import seedu.studybananas.model.flashcard.Answer;
import seedu.studybananas.model.flashcard.Flashcard;
import seedu.studybananas.model.flashcard.Question;

public class FlashcardBuilder {

    public static final String DEFAULT_QUESTION = "What is GitHub?";
    public static final String DEFAULT_ANSWER = "GitHub is a code hosting platform "
            + "for version control and collaboration";

    private Question question;
    private Answer answer;

    /**
     * Creates a {@code FlashcardBuilder} with the default details.
     */
    public FlashcardBuilder() {
        question = new Question(DEFAULT_QUESTION);
        answer = new Answer(DEFAULT_ANSWER);
    }

    /**
     * Initializes the FlashcardBuilder with the data of {@code flashcardToCopy}.
     */
    public FlashcardBuilder(Flashcard flashcardToCopy) {
        question = flashcardToCopy.getQuestion();
        answer = flashcardToCopy.getAnswer();
    }

    /**
     * Sets the {@code Question} of the {@code Flashcard} that we are building.
     */
    public FlashcardBuilder withQuestion(String question) {
        this.question = new Question(question);
        return this;
    }

    /**
     * Sets the {@code Answer} of the {@code Flashcard} that we are building.
     */
    public FlashcardBuilder withAnswer(String answer) {
        this.answer = new Answer(answer);
        return this;
    }

    public Flashcard build() {
        return new Flashcard(question, answer);
    }
}
