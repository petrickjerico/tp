package seedu.address.model.task;


import seedu.address.model.person.*;
import seedu.address.model.tag.Tag;

import java.util.Objects;
import java.util.Optional;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Task in the StudyBananas.
 */
public class Task {
    private final Description description;
    private final Optional<Date> date;
    private final Optional<DateTime> dateTime;

    public Task(Description description, Date date, DateTime dateTime) {
        requireNonNull(description);
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
        return otherTask.getDescription().equals(this.getDescription())
                && otherTask.date.equals(this.date)
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
        builder.append(getDescription())
                .append(hasDate() ? " Time: " : "")
                .append(hasTime() ? getDateTime() : getDate());
        return builder.toString();
    }
}
