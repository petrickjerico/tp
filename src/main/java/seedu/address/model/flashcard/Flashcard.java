package seedu.address.model.flashcard;

/**
 * Represents a Flashcard in a FlashcardSet.
 */
public class Flashcard {

    private final Question question;
    private final Answer answer;

    /**
     * Every field must be present and not null.
     */
    public Flashcard(Question question, Answer answer) {
        this.question = question;
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public Answer getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Question: ")
                .append(getQuestion())
                .append(" Answer: ")
                .append(getAnswer());
        return builder.toString();
    }
}
