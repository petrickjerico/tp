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
    public static final Flashcard OPPORTUNITY_COST = new FlashcardBuilder()
            .withQuestion("Define the idea of opportunity cost")
            .withAnswer("Benefits or value of the next best alternative forgone")
            .build();
    public static final Flashcard NEGATIVE_EXTERNALITIES = new FlashcardBuilder()
            .withQuestion("What are negative externalities?")
            .withAnswer("Harmful side effects of production or consumption on persons "
                    + "other than the producers or consumers themselves."
                    + "The third parties are not compensated for the external costs.")
            .build();
    public static final Flashcard EXPLAIN_INTEREST_TO_AD = new FlashcardBuilder()
            .withQuestion("Explain how interest rate increasing leads to a decrease in aggregate demand (AD).")
            .withAnswer("increase i/r -> increased cost of borrowing "
                    + "-> decrease in Consumption and Investments -> decrease in AD")
            .build();
    public static final Flashcard CHICKEN_JOKE = new FlashcardBuilder()
            .withQuestion("Why did the chicken cross the road?")
            .withAnswer("To get to the other side")
            .build();
    public static final Flashcard WATCH_JOKE = new FlashcardBuilder()
            .withQuestion("Why did the late dude sit on his watch?")
            .withAnswer("He wanted to be on time")
            .build();
    public static final Flashcard PROCRASTINATION_JOKE = new FlashcardBuilder()
            .withQuestion("Define procrastination")
            .withAnswer("I'll do it later")
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
