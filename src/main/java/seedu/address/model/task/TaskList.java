package seedu.address.model.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a TaskList that contains tasks.
 */
public class TaskList {
    private final List<Task> tasks = new ArrayList<>();

    /**
     * Initializes a TaskList.
     */
    public TaskList(List<Task> tasks) {
        for (Task task : tasks) {
            this.tasks.add(task);
        }
    }

    public List<Task> getTaskList() {
        return this.tasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof TaskList)) {
            return false;
        } else {
            TaskList otherTaskList = (TaskList) other;
            List<Task> otherTasks = otherTaskList.getTaskList();
            boolean result = true;
            for (Task task : otherTasks) {
                result = result && tasks.contains(task);
            }
            return result;
        }
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(tasks);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        getTaskList().forEach(builder::append);
        return builder.toString();
    }
}
