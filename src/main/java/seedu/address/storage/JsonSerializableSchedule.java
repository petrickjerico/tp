package seedu.address.storage;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.systemlevelmodel.ReadOnlySchedule;
import seedu.address.model.systemlevelmodel.Schedule;
import seedu.address.model.task.Task;

/**
 * An Immutable Schedule that is serializable to JSON format.
 */
@JsonRootName(value = "schedule")
public class JsonSerializableSchedule {
    public static final String MESSAGE_DUPLICATE_PERSON = "Tasks list contains duplicate task(s).";

    private final List<JsonAdaptedTask> tasks = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableSchedule} with the given tasks.
     */
    @JsonCreator
    public JsonSerializableSchedule(@JsonProperty("tasks") List<JsonAdaptedTask> tasks) {
        this.tasks.addAll(tasks);
    }

    /**
     * Converts a given {@code ReadOnlySchedule} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableAddressBook}.
     */
    public JsonSerializableSchedule(ReadOnlySchedule source) {
        tasks.addAll(source.getTaskList().stream().map(JsonAdaptedTask::new).collect(Collectors.toList()));
    }

    /**
     * Converts this schedule into the model's {@code Schedule} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public Schedule toModelType() throws IllegalValueException {
        Schedule schedule = new Schedule();
        for (JsonAdaptedTask jsonAdaptedTask : tasks) {
            Task task = jsonAdaptedTask.toModelType();
            if (schedule.hasTask(task)) {
                throw new IllegalValueException(MESSAGE_DUPLICATE_PERSON);
            }
            schedule.addTask(task);
        }
        return schedule;
    }
}
