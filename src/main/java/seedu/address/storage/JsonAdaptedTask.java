package seedu.address.storage;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.task.DateTime;
import seedu.address.model.task.Description;
import seedu.address.model.task.Task;
import seedu.address.model.task.Title;

public class JsonAdaptedTask {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Task's %s field is missing!";

    private final String title;
    private final Optional<String> description;
    private Optional<JsonAdaptedDateTime> dateTime;

    /**
     * Constructs a {@code JsonAdaptedTask} with the given task details.
     */
    @JsonCreator
    public JsonAdaptedTask(@JsonProperty("title") String title,
                           @JsonProperty("description") String description,
                             @JsonProperty("dateTime") String dateTime) {
        this.title = title;
        this.description = Optional.ofNullable(description);
        this.dateTime = Optional.ofNullable(new JsonAdaptedDateTime(dateTime));
    }

    /**
     * Converts a given {@code Task} into this class for Jackson use.
     */
    public JsonAdaptedTask(Task source) {
        title = source.getTitle().title;
        description = source.getDescription().map(description -> description.toString());
        dateTime = source.getDateTime().map(JsonAdaptedDateTime::new);
    }

    /**
     * Converts this Jackson-friendly adapted task object into the model's {@code Task} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted task.
     */
    public Task toModelType() throws IllegalValueException {

        if (title == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Title.class.getSimpleName()));
        }
        final Title modelTitle = new Title(title);
        final Description modelDescription = description.map(Description::new).orElse(null);
        final DateTime modelDateTime = dateTime.map(jsonDateTime -> {
            try {
                return jsonDateTime.toModelType();
            } catch (IllegalValueException e) {
                return null;
            }
        }).orElse(null);

        return new Task(modelTitle, modelDescription, modelDateTime);
    }

}
