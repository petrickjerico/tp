package seedu.studybananas.model.task;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.studybananas.testutil.SampleTasks.CS2103T_WEEK8_QUIZ;

import org.junit.jupiter.api.Test;

public class TaskHappensTodayPredicateTest {

    @Test
    public void equals() {
        TaskHappensTodayPredicate firstPredicate = new TaskHappensTodayPredicate();
        TaskHappensTodayPredicate secondPredicate = new TaskHappensTodayPredicate();

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same value -> returns true
        assertTrue(firstPredicate.equals(secondPredicate));

        // different types -> returns false
        assertFalse(firstPredicate.equals("hello"));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));
    }

    @Test
    public void test_taskHappensToday_returnsTrue() {
        Task taskStub = new TaskStub(true);
        TaskHappensTodayPredicate predicate = new TaskHappensTodayPredicate();
        assertTrue(predicate.test(taskStub));
    }

    @Test
    public void test_taskDoesNotHappenToday_returnsFalse() {
        Task taskStub = new TaskStub(false);
        TaskHappensTodayPredicate predicate = new TaskHappensTodayPredicate();
        assertFalse(predicate.test(taskStub));
    }

    /**
     * Stub class for Task that only concerns with whether it happens today.
     */
    private class TaskStub extends Task {
        boolean isToday;

        TaskStub(boolean isToday) {
            super(CS2103T_WEEK8_QUIZ.getTitle(), CS2103T_WEEK8_QUIZ.getDescription().get(),
                    CS2103T_WEEK8_QUIZ.getDateTime().get(), CS2103T_WEEK8_QUIZ.getDuration().get());
            this.isToday = isToday;
        }

        @Override
        public boolean happensToday() {
            return isToday;
        }
    }
}
