package seedu.address.testutil;

import seedu.address.model.task.DateTime;
import seedu.address.model.task.Description;
import seedu.address.model.task.Task;
import seedu.address.model.task.Title;

/**
 * A utility class to help with building Task objects.
 */
public class TaskBuilder {

    public static final String DEFAULT_TITLE = "CS2103T";
    public static final String DEFAULT_DESCRIPTION = "Weekly team meeting";
    public static final String DEFAULT_DATE_TIME = "2020-10-10 13:00";

    private Title title;
    private Description description;
    private DateTime dateTime;

    /**
     * Creates a {@code TaskBuilder} with the default details.
     */
    public TaskBuilder() {
        title = new Title(DEFAULT_TITLE);
        description = new Description(DEFAULT_DESCRIPTION);
        dateTime = new DateTime(DEFAULT_DATE_TIME);
    }

    /**
     * Initializes the TaskBuilder with the data of {@code taskToCopy}.
     */
    public TaskBuilder(Task taskToCopy) {
        title = taskToCopy.getTitle();
        description = taskToCopy.getDescription().orElse(null);
        dateTime = taskToCopy.getDateTime().orElse(null);
    }

    /**
     * Sets the {@code Title} of the {@code Task} that we are building.
     */
    public TaskBuilder withTitle(String title) {
        this.title = new Title(title);
        return this;
    }

    /**
     * Sets the {@code Description} of the {@code Task} that we are building.
     */
    public TaskBuilder withDescription(String description) {
        this.description = description.equals("") ? null : new Description(description);
        return this;
    }

    /**
     * Sets the {@code DateTime} of the {@code Task} that we are building.
     */
    public TaskBuilder withDateTime(String dateTime) {
        this.dateTime = dateTime.equals("") ? null : new DateTime(dateTime);
        return this;
    }

    public Task build() {
        return new Task(title, description, dateTime);
    }

}
