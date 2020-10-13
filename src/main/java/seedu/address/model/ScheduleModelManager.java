package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.model.systemlevelmodel.ReadOnlySchedule;
import seedu.address.model.systemlevelmodel.Schedule;
import seedu.address.model.task.Task;

public class ScheduleModelManager implements ScheduleModel {
    private final Schedule schedule;
    private final FilteredList<Task> filteredTasks;

    public ScheduleModelManager(ReadOnlySchedule schedule) {
        this.schedule = new Schedule(schedule);
        filteredTasks = new FilteredList<>(this.schedule.getTaskList());
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
    public void updateFilteredTaskList(Predicate<Task> predicate) {
        requireNonNull(predicate);
        filteredTasks.setPredicate(predicate);
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
