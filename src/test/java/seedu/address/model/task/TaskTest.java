package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalTasks.CS2100_TUTORIAL_HOMEWORK;
import static seedu.address.testutil.TypicalTasks.CS2103T_WEEK8_QUIZ;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.TaskBuilder;

public class TaskTest {

    @Test
    public void equals() {
        // same object -> returns true
        assertTrue(CS2103T_WEEK8_QUIZ.equals(CS2103T_WEEK8_QUIZ));

        // null -> returns false
        assertFalse(CS2103T_WEEK8_QUIZ.equals(null));

        // different title -> returns false
        Task editedCs2103T = new TaskBuilder(CS2103T_WEEK8_QUIZ).withTitle("CS2101").build();
        assertFalse(CS2103T_WEEK8_QUIZ.equals(editedCs2103T));

        // different description -> returns false
        editedCs2103T = new TaskBuilder(CS2103T_WEEK8_QUIZ).withDescription("Week 9 quiz").build();
        assertFalse(CS2103T_WEEK8_QUIZ.equals(editedCs2103T));

        // different dateTime -> returns false
        editedCs2103T = new TaskBuilder(CS2103T_WEEK8_QUIZ).withDateTime("2020-09-30 12:00").build();
        assertFalse(CS2103T_WEEK8_QUIZ.equals(editedCs2103T));

        // same title, same description, same dateTime -> returns true
        editedCs2103T = new TaskBuilder(CS2103T_WEEK8_QUIZ).withTitle("CS2103T")
                .withDescription("Week 8 Quiz")
                .withDateTime("2020-09-27 12:00").build();
        assertTrue(CS2103T_WEEK8_QUIZ.equals(editedCs2103T));
    }

    @Test
    public void isSameTask() {
        // same values -> returns true
        Task cs2103Copy = new TaskBuilder(CS2103T_WEEK8_QUIZ).build();
        assertTrue(CS2103T_WEEK8_QUIZ.isSameTask(cs2103Copy));

        // same object -> returns true
        assertTrue(CS2103T_WEEK8_QUIZ.isSameTask(CS2103T_WEEK8_QUIZ));

        // null -> returns false
        assertFalse(CS2103T_WEEK8_QUIZ.isSameTask(null));

        // different task -> returns false
        assertFalse(CS2103T_WEEK8_QUIZ.isSameTask(CS2100_TUTORIAL_HOMEWORK));

        // different title -> returns false
        Task editedCs2103T = new TaskBuilder(CS2103T_WEEK8_QUIZ).withTitle("CS2101").build();
        assertFalse(CS2103T_WEEK8_QUIZ.isSameTask(editedCs2103T));

        // different description -> returns false
        editedCs2103T = new TaskBuilder(CS2103T_WEEK8_QUIZ).withDescription("Week 9 Tutorial").build();
        assertFalse(CS2103T_WEEK8_QUIZ.isSameTask(editedCs2103T));

        // different time -> returns true
        editedCs2103T = new TaskBuilder(CS2103T_WEEK8_QUIZ).withDateTime("2020-09-30 12:30").build();
        assertFalse(CS2103T_WEEK8_QUIZ.isSameTask(editedCs2103T));
    }
}
