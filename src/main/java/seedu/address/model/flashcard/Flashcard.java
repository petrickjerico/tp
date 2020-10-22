package seedu.address.model.flashcard;

import java.util.Objects;

import javafx.beans.property.SimpleStringProperty;

/**
 * Represents a Flashcard in a FlashcardSet.
 */
public class Flashcard {

    private final Question question;
    private final Answer answer;
    private final SimpleStringProperty questionString;
    private final SimpleStringProperty answerString;

    /**
     * Every field must be present and not null.
     */
    public Flashcard(Question question, Answer answer) {
        this.question = question;
        this.answer = answer;
        questionString = new SimpleStringProperty(question.toString());
        answerString = new SimpleStringProperty(answer.toString());
    }

    public Question getQuestion() {
        return question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public String getQuestionString() {
        return questionString.get();
    }

    public void setQuestionString(String question) {
        questionString.set(question);
    }

    public String getAnswerString() {
        return answerString.get();
    }

    public void setAnswerString(String answer) {
        answerString.set(answer);
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

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Flashcard)) {
            return false;
        }

        Flashcard otherFlashcard = (Flashcard) other;
        return otherFlashcard.getQuestion().equals(getQuestion())
                && otherFlashcard.getAnswer().equals(getAnswer());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(question, answer);
    }
}
