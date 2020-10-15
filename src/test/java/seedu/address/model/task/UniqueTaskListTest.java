package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.SampleTasks.CS2100_TUTORIAL_HOMEWORK;
import static seedu.address.testutil.SampleTasks.CS2103T_WEEK8_QUIZ;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.model.task.exceptions.DuplicateTaskException;
import seedu.address.model.task.exceptions.TaskNotFoundException;
import seedu.address.testutil.TaskBuilder;

public class UniqueTaskListTest {

    private final UniqueTaskList uniqueTaskList = new UniqueTaskList();

    @Test
    public void contains_nullTask_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueTaskList.contains(null));
    }

    @Test
    public void contains_taskNotInList_returnsFalse() {
        assertFalse(uniqueTaskList.contains(CS2103T_WEEK8_QUIZ));
    }

    @Test
    public void contains_taskInList_returnsTrue() {
        uniqueTaskList.add(CS2103T_WEEK8_QUIZ);
        assertTrue(uniqueTaskList.contains(CS2103T_WEEK8_QUIZ));
    }

    @Test
    public void contains_taskWithSameInformationInList_returnsTrue() {
        uniqueTaskList.add(CS2103T_WEEK8_QUIZ);
        Task editedCs2103T = new TaskBuilder(CS2103T_WEEK8_QUIZ)
                .withDescription("Week 8 Quiz").withDateTime("2020-09-27 12:00")
                .build();
        assertTrue(uniqueTaskList.contains(editedCs2103T));
    }

    @Test
    public void add_nullTask_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueTaskList.add(null));
    }

    @Test
    public void add_duplicateTask_throwsDuplicateTaskException() {
        uniqueTaskList.add(CS2103T_WEEK8_QUIZ);
        assertThrows(DuplicateTaskException.class, () -> uniqueTaskList.add(CS2103T_WEEK8_QUIZ));
    }

    @Test
    public void setTask_nullTargetTask_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueTaskList.setTask(null, CS2103T_WEEK8_QUIZ));
    }

    @Test
    public void setTask_nullEditedTask_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueTaskList.setTask(CS2103T_WEEK8_QUIZ, null));
    }

    @Test
    public void setTask_targetTaskNotInList_throwsTaskNotFoundException() {
        assertThrows(TaskNotFoundException.class, () -> uniqueTaskList.setTask(CS2103T_WEEK8_QUIZ, CS2103T_WEEK8_QUIZ));
    }

    @Test
    public void setTask_editedTaskIsSameTask_success() {
        uniqueTaskList.add(CS2103T_WEEK8_QUIZ);
        uniqueTaskList.setTask(CS2103T_WEEK8_QUIZ, CS2103T_WEEK8_QUIZ);
        UniqueTaskList expectedUniqueTaskList = new UniqueTaskList();
        expectedUniqueTaskList.add(CS2103T_WEEK8_QUIZ);
        assertEquals(expectedUniqueTaskList, uniqueTaskList);
    }

    @Test
    public void setPerson_editedTaskHasDifferentIdentity_success() {
        uniqueTaskList.add(CS2103T_WEEK8_QUIZ);
        uniqueTaskList.setTask(CS2103T_WEEK8_QUIZ, CS2100_TUTORIAL_HOMEWORK);
        UniqueTaskList expectedUniqueTaskList = new UniqueTaskList();
        expectedUniqueTaskList.add(CS2100_TUTORIAL_HOMEWORK);
        assertEquals(expectedUniqueTaskList, uniqueTaskList);
    }

    @Test
    public void setTask_editedTaskHasNonUniqueIdentity_throwsDuplicateTaskException() {
        uniqueTaskList.add(CS2103T_WEEK8_QUIZ);
        uniqueTaskList.add(CS2100_TUTORIAL_HOMEWORK);
        assertThrows(DuplicateTaskException.class, () -> uniqueTaskList.setTask(
                CS2103T_WEEK8_QUIZ, CS2100_TUTORIAL_HOMEWORK));
    }

    @Test
    public void remove_nullTask_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueTaskList.remove(null));
    }

    @Test
    public void remove_taskDoesNotExist_throwsTaskNotFoundException() {
        assertThrows(TaskNotFoundException.class, () -> uniqueTaskList.remove(CS2100_TUTORIAL_HOMEWORK));
    }

    @Test
    public void remove_existingTask_removesTask() {
        uniqueTaskList.add(CS2103T_WEEK8_QUIZ);
        uniqueTaskList.remove(CS2103T_WEEK8_QUIZ);
        UniqueTaskList expectedUniqueTaskList = new UniqueTaskList();
        assertEquals(expectedUniqueTaskList, uniqueTaskList);
    }

    @Test
    public void setTasks_nullUniqueTaskList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueTaskList.setTasks((UniqueTaskList) null));
    }

    @Test
    public void setTasks_uniqueTaskList_replacesOwnListWithProvidedUniqueTaskList() {
        uniqueTaskList.add(CS2103T_WEEK8_QUIZ);
        UniqueTaskList expectedUniqueTaskList = new UniqueTaskList();
        expectedUniqueTaskList.add(CS2100_TUTORIAL_HOMEWORK);
        uniqueTaskList.setTasks(expectedUniqueTaskList);
        assertEquals(expectedUniqueTaskList, uniqueTaskList);
    }

    @Test
    public void setTasks_nullList_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> uniqueTaskList.setTasks((List<Task>) null));
    }

    @Test
    public void setTasks_list_replacesOwnListWithProvidedList() {
        uniqueTaskList.add(CS2103T_WEEK8_QUIZ);
        List<Task> taskList = Collections.singletonList(CS2100_TUTORIAL_HOMEWORK);
        uniqueTaskList.setTasks(taskList);
        UniqueTaskList expectedUniqueTaskList = new UniqueTaskList();
        expectedUniqueTaskList.add(CS2100_TUTORIAL_HOMEWORK);
        assertEquals(expectedUniqueTaskList, uniqueTaskList);
    }

    @Test
    public void setTasks_listWithDuplicateTasks_throwsDuplicateTaskException() {
        List<Task> listWithDuplicateTasks = Arrays.asList(CS2103T_WEEK8_QUIZ, CS2103T_WEEK8_QUIZ);
        assertThrows(DuplicateTaskException.class, () -> uniqueTaskList.setTasks(listWithDuplicateTasks));
    }

    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> uniqueTaskList
                .asUnmodifiableObservableList().remove(0));
    }
}
