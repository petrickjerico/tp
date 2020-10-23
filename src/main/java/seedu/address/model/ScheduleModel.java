package seedu.address.model;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.model.systemlevelmodel.ReadOnlySchedule;
import seedu.address.model.task.Task;

public interface ScheduleModel {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Task> PREDICATE_SHOW_ALL_TASKS = unused -> true;

    /**
     * Replaces schedule data with the data in {@code schedule}.
     */
    void setSchedule(ReadOnlySchedule schedule);

    /** Returns the Schedule */
    ReadOnlySchedule getSchedule();

    /**
     * Returns true if a task with the same identity as {@code task} exists in the schedule.
     */
    boolean hasTask(Task task);

    /**
     * Deletes the given task.
     * The task must exist in the schedule.
     */
    void deleteTask(Task target);

    /**
     * Adds the given task.
     * {@code task} must not already exist in the task.
     */
    void addTask(Task task);

    /**
     * Replaces the given task {@code target} with {@code editedTask}.
     * {@code target} must exist in the schedule.
     * The task identity of {@code editedTask} must not be the same as another existing task in the schedule.
     */
    void setTask(Task target, Task editedTask);

    /** Returns an unmodifiable view of the filtered task list */
    ObservableList<Task> getFilteredTaskList();

    /** Returns an unmodifiable view of tasks that happen today */
    ObservableList<Task> getUpcomingTaskList();


    /**
     * Updates the filter of the filtered task list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredTaskList(Predicate<Task> predicate);

}
