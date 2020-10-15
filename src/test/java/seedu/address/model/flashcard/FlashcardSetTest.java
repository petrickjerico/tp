package seedu.address.model.flashcard;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalFlashcardSets.ECONOMICS;
import static seedu.address.testutil.TypicalFlashcardSets.PHYSICS;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.FlashcardSetBuilder;

public class FlashcardSetTest {

    @Test
    public void equals() {
        // same object -> returns true
        assertTrue(PHYSICS.equals(PHYSICS));

        // null -> returns false
        assertFalse(PHYSICS.equals(null));

        // different flashcard set name -> returns false
        FlashcardSet editedPhysics = new FlashcardSetBuilder(PHYSICS)
                .withFlashcardSetName("Economics")
                .build();
        assertFalse(PHYSICS.equals(editedPhysics));

        // different flashcards in list, but same name -> returns true
        editedPhysics = new FlashcardSetBuilder(PHYSICS)
                 .withFlashcards(ECONOMICS.getFlashcards())
                 .build();
        assertTrue(PHYSICS.equals(editedPhysics));
    }

}
