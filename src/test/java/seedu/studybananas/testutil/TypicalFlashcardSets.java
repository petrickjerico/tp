package seedu.studybananas.testutil;

import static seedu.studybananas.testutil.TypicalFlashcards.CHICKEN_JOKE;
import static seedu.studybananas.testutil.TypicalFlashcards.DECAY_CONSTANT;
import static seedu.studybananas.testutil.TypicalFlashcards.EXPLAIN_INTEREST_TO_AD;
import static seedu.studybananas.testutil.TypicalFlashcards.HOOKES_LAW;
import static seedu.studybananas.testutil.TypicalFlashcards.NEGATIVE_EXTERNALITIES;
import static seedu.studybananas.testutil.TypicalFlashcards.NEWTONS_SECOND_LAW;
import static seedu.studybananas.testutil.TypicalFlashcards.OPPORTUNITY_COST;
import static seedu.studybananas.testutil.TypicalFlashcards.PROCRASTINATION_JOKE;
import static seedu.studybananas.testutil.TypicalFlashcards.WATCH_JOKE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.systemlevelmodel.FlashcardBank;

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
        FlashcardSet physics = new FlashcardSetBuilder(PHYSICS).build();
        FlashcardSet economics = new FlashcardSetBuilder(ECONOMICS).build();
        FlashcardSet icebreakerJokes = new FlashcardSetBuilder(ICEBREAKER_JOKES).build();
        return new ArrayList<>(Arrays.asList(physics, economics, icebreakerJokes));
    }
}
