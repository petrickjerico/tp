package seedu.studybananas.model.flashcard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.studybananas.testutil.Assert.assertThrows;
import static seedu.studybananas.testutil.TypicalFlashcardSets.ECONOMICS;
import static seedu.studybananas.testutil.TypicalFlashcardSets.PHYSICS;
import static seedu.studybananas.testutil.TypicalFlashcards.DECAY_CONSTANT;
import static seedu.studybananas.testutil.TypicalFlashcards.HOOKES_LAW;
import static seedu.studybananas.testutil.TypicalFlashcards.NEWTONS_SECOND_LAW;
import static seedu.studybananas.testutil.TypicalFlashcards.OPPORTUNITY_COST;
import static seedu.studybananas.testutil.TypicalIndexes.INDEX_FIRST;

import org.junit.jupiter.api.Test;

import seedu.studybananas.commons.core.index.Index;
import seedu.studybananas.model.flashcard.exceptions.DuplicateFlashcardException;
import seedu.studybananas.model.flashcard.exceptions.FlashcardNotFoundException;
import seedu.studybananas.testutil.FlashcardBuilder;
import seedu.studybananas.testutil.FlashcardSetBuilder;

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

    @Test
    public void contains_nullFlashcard_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> PHYSICS.hasFlashcard(null));
    }

    @Test
    public void contains_flashcardNotInSet_returnsFalse() {
        assertFalse(PHYSICS.hasFlashcard(OPPORTUNITY_COST));
    }

    @Test
    public void contains_flashcardInSet_returnsTrue() {
        assertTrue(PHYSICS.hasFlashcard(NEWTONS_SECOND_LAW));
    }

    @Test
    public void contains_flashcardWithSameInformationInSet_returnsTrue() {
        Flashcard editedSecondLaw = new FlashcardBuilder(NEWTONS_SECOND_LAW).build();
        assertTrue(PHYSICS.hasFlashcard(editedSecondLaw));
    }

    @Test
    public void add_nullflashcard_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> PHYSICS.addFlashcard(null));
    }

    @Test
    public void add_duplicateFlashcard_throwsDuplicateFlashcardException() {
        assertThrows(DuplicateFlashcardException.class, () -> PHYSICS.addFlashcard(NEWTONS_SECOND_LAW));
    }

    @Test
    public void setFlashcard_nullTargetFlashcard_throwsFlashcardNotFoundException() {
        assertThrows(FlashcardNotFoundException.class, () -> PHYSICS.setFlashcard(null, NEWTONS_SECOND_LAW));
    }

    @Test
    public void setFlashcard_nullEditedFlashcard_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> PHYSICS.setFlashcard(NEWTONS_SECOND_LAW, null));
    }

    @Test
    public void setFlashcard_targetFlashcardNotInSet_throwsFlashcardNotFoundException() {
        assertThrows(FlashcardNotFoundException.class, () -> PHYSICS.setFlashcard(
                OPPORTUNITY_COST, NEWTONS_SECOND_LAW));
    }

    @Test
    public void setFlashcard_editedFlashcardIsSameFlashcard_success() {
        FlashcardSet expectedFlset = new FlashcardSetBuilder(PHYSICS).build();
        FlashcardSet physics = new FlashcardSetBuilder(PHYSICS).build();
        physics.setFlashcard(NEWTONS_SECOND_LAW, NEWTONS_SECOND_LAW);
        assertEquals(expectedFlset, physics);
    }

    @Test
    public void setFlashcard_editedFlashcardHasDifferentIdentity_success() {
        FlashcardSet expectedFlset = new FlashcardSetBuilder(PHYSICS).build();
        FlashcardSet physics = new FlashcardSetBuilder(PHYSICS).build();
        physics.setFlashcard(NEWTONS_SECOND_LAW, OPPORTUNITY_COST);
        assertNotEquals(physics.getFlashcard(0), expectedFlset.getFlashcard(0));
    }

    @Test
    public void setFlashcard_editedFlashcardHasNonUniqueIdentity_throwsDuplicateFlashcardException() {
        assertThrows(DuplicateFlashcardException.class, () -> PHYSICS.setFlashcard(
                NEWTONS_SECOND_LAW, DECAY_CONSTANT));
    }

    @Test
    public void delete_nullFlashcard_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> PHYSICS.deleteFlashcard(null));
    }

    @Test
    public void delete_flashcardDoesNotExist_throwsFlashcardNotFoundException() {
        assertThrows(FlashcardNotFoundException.class, () -> PHYSICS.deleteFlashcard(Index.fromZeroBased(3)));
    }

    @Test
    public void delete_existingFlashcard_deletesFlashcard() {
        FlashcardSet physics = new FlashcardSetBuilder(PHYSICS).build();
        physics.deleteFlashcard(INDEX_FIRST);
        FlashcardSet expectedPhysics = new FlashcardSetBuilder()
                .addFlashcard(HOOKES_LAW)
                .addFlashcard(DECAY_CONSTANT)
                .build();
        assertEquals(expectedPhysics, physics);
    }

}
