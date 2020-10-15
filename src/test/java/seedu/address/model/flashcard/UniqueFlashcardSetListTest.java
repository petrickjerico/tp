package seedu.address.model.flashcard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalFlashcardSets.ECONOMICS;
import static seedu.address.testutil.TypicalFlashcardSets.PHYSICS;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.model.flashcard.exceptions.DuplicateFlashcardSetException;
import seedu.address.model.flashcard.exceptions.FlashcardSetNotFoundException;
import seedu.address.testutil.FlashcardSetBuilder;

public class UniqueFlashcardSetListTest {

    private final UniqueFlashcardSetList uniqueFlsetList = new UniqueFlashcardSetList();

    @Test
    public void contains_nullFlashcardSet_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFlsetList.contains(null));
    }

    @Test
    public void contains_flashcardSetNotInList_returnsFalse() {
        assertFalse(uniqueFlsetList.contains(PHYSICS));
    }

    @Test
    public void contains_flashcardSetInList_returnsTrue() {
        uniqueFlsetList.add(PHYSICS);
        assertTrue(uniqueFlsetList.contains(PHYSICS));
    }

    @Test
    public void contains_flashcardSetWithSameInformationInList_returnsTrue() {
        uniqueFlsetList.add(PHYSICS);
        FlashcardSet editedPhysics = new FlashcardSetBuilder(PHYSICS).build();
        assertTrue(uniqueFlsetList.contains(editedPhysics));
    }

    @Test
    public void add_nullFlashcardSet_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFlsetList.add(null));
    }

    @Test
    public void add_duplicateFlashcardSet_throwsDuplicateFlashcardSetException() {
        uniqueFlsetList.add(PHYSICS);
        assertThrows(DuplicateFlashcardSetException.class, () -> uniqueFlsetList.add(PHYSICS));
    }

    @Test
    public void setFlashcardSet_nullTargetFlashcardSet_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFlsetList.setFlashcardSet(null, PHYSICS));
    }

    @Test
    public void setFlashcardSet_nullEditedFlashcardSet_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFlsetList.setFlashcardSet(PHYSICS, null));
    }

    @Test
    public void setFlashcardSet_targetFlashcardSetNotInList_throwsFlashcardSetNotFoundException() {
        assertThrows(FlashcardSetNotFoundException.class, () -> uniqueFlsetList.setFlashcardSet(PHYSICS, PHYSICS));
    }

    @Test
    public void setFlashcardSet_editedFlashcardSetIsSameFlashcardSet_success() {
        uniqueFlsetList.add(PHYSICS);
        uniqueFlsetList.setFlashcardSet(PHYSICS, PHYSICS);
        UniqueFlashcardSetList expectedUniqueFlsetList = new UniqueFlashcardSetList();
        expectedUniqueFlsetList.add(PHYSICS);
        assertEquals(expectedUniqueFlsetList, uniqueFlsetList);
    }

    @Test
    public void setFlashcardSet_editedFlashcardSetHasDifferentIdentity_success() {
        uniqueFlsetList.add(PHYSICS);
        uniqueFlsetList.setFlashcardSet(PHYSICS, ECONOMICS);
        UniqueFlashcardSetList expectedUniqueFlsetList = new UniqueFlashcardSetList();
        expectedUniqueFlsetList.add(ECONOMICS);
        assertEquals(expectedUniqueFlsetList, uniqueFlsetList);
    }

    @Test
    public void setFlashcardSet_editedFlashcardSetHasNonUniqueIdentity_throwsDuplicateFlashcardSetException() {
        uniqueFlsetList.add(PHYSICS);
        uniqueFlsetList.add(ECONOMICS);
        assertThrows(DuplicateFlashcardSetException.class, () -> uniqueFlsetList.setFlashcardSet(
                PHYSICS, ECONOMICS));
    }

    @Test
    public void remove_nullFlashcardSet_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFlsetList.remove(null));
    }

    @Test
    public void remove_flashcardSetDoesNotExist_throwsFlashcardSetNotFoundException() {
        assertThrows(FlashcardSetNotFoundException.class, () -> uniqueFlsetList.remove(ECONOMICS));
    }

    @Test
    public void remove_existingFlashcardSet_removesFlashcardSet() {
        uniqueFlsetList.add(PHYSICS);
        uniqueFlsetList.remove(PHYSICS);
        UniqueFlashcardSetList expectedUniqueFlsetList = new UniqueFlashcardSetList();
        assertEquals(expectedUniqueFlsetList, uniqueFlsetList);
    }

    @Test
    public void setFlashcardSet_nullUniqueFlashcardSetList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFlsetList.setFlashcardSets((UniqueFlashcardSetList) null));
    }

    @Test
    public void setFlashcardSet_uniqueFlashcardSetList_replacesOwnListWithProvidedUniqueFlashcardSetList() {
        uniqueFlsetList.add(PHYSICS);
        UniqueFlashcardSetList expectedUniqueFlsetList = new UniqueFlashcardSetList();
        expectedUniqueFlsetList.add(ECONOMICS);
        uniqueFlsetList.setFlashcardSets(expectedUniqueFlsetList);
        assertEquals(expectedUniqueFlsetList, uniqueFlsetList);
    }

    @Test
    public void setFlashcardSet_nullList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueFlsetList.setFlashcardSets((List<FlashcardSet>) null));
    }

    @Test
    public void setFlashcardSet_list_replacesOwnListWithProvidedList() {
        uniqueFlsetList.add(PHYSICS);
        List<FlashcardSet> flsetList = Collections.singletonList(ECONOMICS);
        uniqueFlsetList.setFlashcardSets(flsetList);
        UniqueFlashcardSetList expectedUniqueFlsetList = new UniqueFlashcardSetList();
        expectedUniqueFlsetList.add(ECONOMICS);
        assertEquals(expectedUniqueFlsetList, uniqueFlsetList);
    }

    @Test
    public void setFlashcardSet_listWithDuplicateFlashcardSet_throwsDuplicateFlashcardSetException() {
        List<FlashcardSet> listWithDuplicateFlsets = Arrays.asList(PHYSICS, PHYSICS);
        assertThrows(DuplicateFlashcardSetException.class, () ->
                uniqueFlsetList.setFlashcardSets(listWithDuplicateFlsets));
    }

    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> uniqueFlsetList
                .asUnmodifiableObservableList().remove(0));
    }
}
