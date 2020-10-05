package seedu.address.model.task;

import static java.util.Objects.requireNonNull;

import java.util.Objects;
import java.util.Optional;

/**
 * Represents a Task in the StudyBananas.
 */
public class Task {

    private final Title title;
    private final Description description;
    private final Optional<Date> date;
    private final Optional<DateTime> dateTime;

    /**
     * Initializes a Task.
     * @param description Description of the task.
     * @param date        Date of the task (Optional)
     * @param dateTime    Date and Time of the task (Optional)
     */
    public Task(Title title, Description description, Date date, DateTime dateTime) {
        requireNonNull(title);
        this.title = title;
        this.description = description;
        this.date = Optional.ofNullable(date);
        this.dateTime = Optional.ofNullable(dateTime);
    }

    public Description getDescription() {
        return description;
    }

    public Date getDate() {
        return date.orElse(null);
    }

    public DateTime getDateTime() {
        return dateTime.orElse(null);
    }

    public Title getTitle() {
        return title;
    }

    private boolean hasDate() {
        return !date.isEmpty() || !dateTime.isEmpty();
    }

    private boolean hasTime() {
        return !date.isEmpty() && dateTime.isEmpty();
    }

    /**
     * Returns true if both tasks have the same description and
     * This defines a stronger notion of equality between two persons.
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
                && otherTask.getDescription().equals(this.getDescription());
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
                .append(hasDate() ? " Time: " : "")
                .append(hasTime() ? getDateTime() : getDate());
        return builder.toString();
    }
}
