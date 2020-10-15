package seedu.address.testutil;

import static seedu.address.testutil.TypicalFlashcards.CHICKEN_JOKE;
import static seedu.address.testutil.TypicalFlashcards.DECAY_CONSTANT;
import static seedu.address.testutil.TypicalFlashcards.EXPLAIN_INTEREST_TO_AD;
import static seedu.address.testutil.TypicalFlashcards.HOOKES_LAW;
import static seedu.address.testutil.TypicalFlashcards.NEGATIVE_EXTERNALITIES;
import static seedu.address.testutil.TypicalFlashcards.NEWTONS_SECOND_LAW;
import static seedu.address.testutil.TypicalFlashcards.OPPORTUNITY_COST;
import static seedu.address.testutil.TypicalFlashcards.PROCRASTINATION_JOKE;
import static seedu.address.testutil.TypicalFlashcards.WATCH_JOKE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.flashcard.FlashcardSet;
import seedu.address.model.systemlevelmodel.FlashcardBank;

public class TypicalFlashcardSets {

    public static final FlashcardSet PHYSICS = new FlashcardSetBuilder()
            .addFlashcard(NEWTONS_SECOND_LAW)
            .addFlashcard(HOOKES_LAW)
            .addFlashcard(DECAY_CONSTANT)
            .build();
    public static final FlashcardSet ECONOMICS = new FlashcardSetBuilder()
            .withFlashcardSetName("Economics")
            .addFlashcard(OPPORTUNITY_COST)
            .addFlashcard(NEGATIVE_EXTERNALITIES)
            .addFlashcard(EXPLAIN_INTEREST_TO_AD)
            .build();
    public static final FlashcardSet ICEBREAKER_JOKES = new FlashcardSetBuilder()
            .withFlashcardSetName("Icebreaker jokes")
            .addFlashcard(CHICKEN_JOKE)
            .addFlashcard(WATCH_JOKE)
            .addFlashcard(PROCRASTINATION_JOKE)
            .build();

    private TypicalFlashcardSets() {} // prevents instantiation

    /**
     * Returns a {@code FlashcardBank} with all the typical flashcard sets.
     */
    public static FlashcardBank getTypicalFlashcardBank() {
        FlashcardBank flashcardBank = new FlashcardBank();
        for (FlashcardSet flset : getTypicalFlashcards()) {
            flashcardBank.addFlashcardSet(flset);
        }
        return flashcardBank;
    }

    public static List<FlashcardSet> getTypicalFlashcards() {
        return new ArrayList<>(Arrays.asList(PHYSICS, ECONOMICS, ICEBREAKER_JOKES));
    }
}
