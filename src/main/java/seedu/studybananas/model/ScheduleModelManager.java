package seedu.studybananas.model;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.studybananas.model.systemlevelmodel.ReadOnlySchedule;
import seedu.studybananas.model.systemlevelmodel.Schedule;
import seedu.studybananas.model.task.Task;
import seedu.studybananas.model.task.TaskHappensTodayPredicate;

public class ScheduleModelManager implements ScheduleModel {
    private final Schedule schedule;
    private final FilteredList<Task> filteredTasks;
    private FilteredList<Task> todayTasks;

    /**
     * Create ScheduleModelManager from {@schedule}
     * @param schedule
     */
    public ScheduleModelManager(ReadOnlySchedule schedule) {
        this.schedule = new Schedule(schedule);
        filteredTasks = new FilteredList<>(this.schedule.getTaskList());
        todayTasks = new FilteredList<>(this.schedule.getTaskList());
    }
    @Override
    public void setSchedule(ReadOnlySchedule schedule) {
        this.schedule.resetData(schedule);
    }

    @Override
    public ReadOnlySchedule getSchedule() {
        return schedule;
    }

    @Override
    public boolean hasTask(Task task) {
        requireNonNull(task);
        return schedule.hasTask(task);
    }

    @Override
    public void deleteTask(Task target) {
        schedule.removeTask(target);
        updateTodaysTask(PREDICATE_SHOW_ALL_TASKS);
    }

    @Override
    public void addTask(Task task) {
        schedule.addTask(task);
        updateFilteredTaskList(PREDICATE_SHOW_ALL_TASKS);
    }

    @Override
    public void setTask(Task target, Task editedTask) {
        schedule.setTask(target, editedTask);
    }

    //=========== Filtered Task List Accessors =============================================================

    @Override
    public ObservableList<Task> getFilteredTaskList() {
        return filteredTasks;
    }

    @Override
    public ObservableList<Task> getUpcomingTaskList() {
        todayTasks.setPredicate(new TaskHappensTodayPredicate());
        return todayTasks;
    }

    @Override
    public void updateFilteredTaskList(Predicate<Task> predicate) {
        requireNonNull(predicate);
        filteredTasks.setPredicate(predicate);
        updateTodaysTask(predicate);
    }

    private void updateTodaysTask(Predicate<Task> predicate) {
        todayTasks.setPredicate(task -> predicate.test(task) && new TaskHappensTodayPredicate().test(task));
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ScheduleModelManager)) {
            return false;
        }

        // state check
        ScheduleModelManager other = (ScheduleModelManager) obj;
        return filteredTasks.equals(other.filteredTasks);
    }

}
