package seedu.address.model.task;

import static java.util.Objects.requireNonNull;

import java.util.Objects;
import java.util.Optional;

/**
 * Represents a Task in the StudyBananas.
 */
public class Task {

    private final Title title;
    private final Optional<Description> description;
    private final Optional<DateTime> dateTime;
    private final Optional<Duration> duration;

    /**
     * Initializes a Task.
     * @param title       Title of the task.
     * @param description Description of the task.
     * @param dateTime    Date and Time of the task (Optional)
     */
    public Task(Title title, Description description, DateTime dateTime, Duration duration) {
        requireNonNull(title);
        this.title = title;
        this.description = Optional.ofNullable(description);
        this.dateTime = Optional.ofNullable(dateTime);
        this.duration = Optional.ofNullable(duration);
    }

    public Optional<Description> getDescription() {
        return description;
    }

    public Optional<DateTime> getDateTime() {
        return dateTime;
    }

    public Optional<Duration> getDuration() {
        return duration;
    }

    public Title getTitle() {
        return title;
    }

    private boolean hasDate() {
        return !dateTime.isEmpty();
    }

    /**
     * Returns true if both tasks have the same title and description.
     * This defines a weaker notion of equality between two tasks.
     */
    public boolean isSameTask(Task other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Task)) {
            return false;
        }

        Task otherTask = other;
        return otherTask.getTitle().rigorousEquals(this.getTitle())
                && (other.getDescription().equals(this.getDescription())
                || haveSameDescription(otherTask, this));
    }

    private boolean bothHaveDescription(Task t1, Task t2) {
        return t1.getDescription().isPresent() && t2.getDescription().isPresent();
    }

    private boolean haveSameDescription(Task t1, Task t2) {
        return bothHaveDescription(t1, t2) && t1.getDescription().get().rigorousEquals(t2.getDescription().get());
    }

    private StringBuilder getDescriptionString() {
        StringBuilder emptyString = new StringBuilder("");
        return description.map(desc ->
                new StringBuilder("Description: ")
                        .append(desc.toString() + "\n")).orElse(emptyString);
    }

    private StringBuilder getDateTimeString() {
        StringBuilder emptyString = new StringBuilder("");
        return dateTime.map(time ->
                new StringBuilder("Time: ")
                        .append(time.toString() + "\n")).orElse(emptyString);
    }

    private StringBuilder getDurationString() {
        StringBuilder emptyString = new StringBuilder("");
        return duration.map(time ->
                new StringBuilder("Duration: ")
                        .append(time.toString() + "\n")).orElse(emptyString);
    }

    public boolean happensToday() {
        return duration.isPresent() && dateTime.isPresent() && dateTime.get().isToday();
    }
    /**
     * Returns true if both tasks have the same identity and data fields.
     * This defines a stronger notion of equality between two tasks.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Task)) {
            return false;
        }

        Task otherTask = (Task) other;
        return otherTask.getTitle().equals(this.getTitle())
                && otherTask.getDescription().equals(this.getDescription())
                && otherTask.dateTime.equals(this.dateTime)
                && otherTask.duration.equals(this.duration);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(title, description, dateTime, duration);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Title: ")
                .append(getTitle() + "\n")
                .append(getDescriptionString())
                .append(getDateTimeString())
                .append(getDurationString());
        return builder.toString();
    }
}
