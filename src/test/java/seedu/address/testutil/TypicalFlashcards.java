package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.flashcard.FlashcardSet;
import seedu.address.model.flashcard.FlashcardSetName;

/**
 * A utility class containing a list of {@code Flashcard} objects to be used in tests.
 */
public class TypicalFlashcards {

    public static final Flashcard NEWTONS_SECOND_LAW = new FlashcardBuilder()
            .withQuestion("Newton's Second Law")
            .withAnswer("The rate of change of momentum of a body is directly proportional"
                    + " to the resultant force acting on it"
                    + " and occurs in the direction of the force")
            .build();
    public static final Flashcard HOOKES_LAW = new FlashcardBuilder()
            .withQuestion("Hooke's Law")
            .withAnswer("The change in length x of the material is directly proportional"
                    + "to the resultant force applied to it, "
                    + "provided that the limit of proportionality is not exceeded")
            .build();
    public static final Flashcard DECAY_CONSTANT = new FlashcardBuilder()
            .withQuestion("Decay constant")
            .withAnswer("Probability of a radioactive nucleus decaying per unit time")
            .build();

    public static final String KEYWORD_MATCHING_PTERODACTYL = "Pterodactyl"; // A keyword that matches PTERODACTYL

    private TypicalFlashcards() {} // prevents instantiation

    /**
     * Returns a {@code FlashcardSet} with all the typical flashcards.
     */
    public static FlashcardSet getTypicalFlashcardSet() {
        FlashcardSetName physics = new FlashcardSetName("Physics");
        FlashcardSet flset = new FlashcardSet(physics);
        for (Flashcard flashcard : getTypicalFlashcards()) {
            flset.addFlashcard(flashcard);
        }
        return flset;
    }

    public static List<Flashcard> getTypicalFlashcards() {
        return new ArrayList<>(Arrays.asList(NEWTONS_SECOND_LAW, HOOKES_LAW, DECAY_CONSTANT));
    }
}
