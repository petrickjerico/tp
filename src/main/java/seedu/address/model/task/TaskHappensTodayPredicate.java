package seedu.address.model.task;

import java.util.function.Predicate;

public class TaskHappensTodayPredicate implements Predicate<Task> {

    @Override
    public boolean test(Task task) {
        return task.happensToday();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TitleContainsKeywordsPredicate); // instanceof handles nulls
    }
}
