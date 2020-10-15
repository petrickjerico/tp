package seedu.address.model.flashcard;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalFlashcards.DECAY_CONSTANT;
import static seedu.address.testutil.TypicalFlashcards.NEWTONS_SECOND_LAW;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.FlashcardBuilder;

public class FlashcardTest {

    @Test
    public void equals() {
        // same object -> returns true
        assertTrue(NEWTONS_SECOND_LAW.equals(NEWTONS_SECOND_LAW));

        // null -> returns false
        assertFalse(NEWTONS_SECOND_LAW.equals(null));

        // different question -> returns false
        Flashcard editedSecondLaw = new FlashcardBuilder(NEWTONS_SECOND_LAW)
                .withQuestion("Lenz's Law of Electromagnetic Induction")
                .build();
        assertFalse(NEWTONS_SECOND_LAW.equals(editedSecondLaw));

        // different answer -> returns false
        editedSecondLaw = new FlashcardBuilder(NEWTONS_SECOND_LAW)
                .withAnswer("The polarity of the induced emf is to produce an "
                        + "induced magnetic field that opposes the change in flux")
                .build();
        assertFalse(NEWTONS_SECOND_LAW.equals(editedSecondLaw));

        // same values -> returns true
        Flashcard secondLawCopy = new FlashcardBuilder(NEWTONS_SECOND_LAW).build();
        assertTrue(NEWTONS_SECOND_LAW.equals(secondLawCopy));

        // different flashcard -> returns false
        assertFalse(NEWTONS_SECOND_LAW.equals(DECAY_CONSTANT));
    }

}
