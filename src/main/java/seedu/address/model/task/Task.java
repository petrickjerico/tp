package seedu.address.model.task;

import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

/**
 * Represents a Task in the StudyBananas.
 */
public class Task {

    private final Title title;
    private final Optional<Description> description;
    private final Optional<Date> date;
    private final Optional<DateTime> dateTime;

    /**
     * Initializes a Task.
     * @param title       Title of the task.
     * @param description Description of the task.
     * @param dateTime    Date and Time of the task (Optional)
     */
    public Task(Title title, Description description, DateTime dateTime) {
        requireNonNull(title);
        this.title = title;
        this.description = Optional.ofNullable(description);
        this.date = Optional.empty();
        this.dateTime = Optional.ofNullable(dateTime);
    }

    public Optional<Description> getDescription() {
        return description;
    }

    public Date getDate() {
        return date.orElse(null);
    }

    public Optional<DateTime> getDateTime() {
        return dateTime;
    }

    public Title getTitle() {
        return title;
    }

    private boolean hasTime() {
        return getDateTime().isPresent();
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

        Task otherTask = (Task) other;
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
                && otherTask.dateTime.equals(this.dateTime);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(description, date, dateTime);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Title: ")
                .append(getTitle() + "\n")
                .append("Description: ")
                .append(getDescription() + "\n")
                .append(hasTime() ? getDateTime() : "");
        return builder.toString();
    }
}
