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
    private final String description;
    private final JsonAdaptedDateTime dateTime;

    /**
     * Constructs a {@code JsonAdaptedTask} with the given task details.
     */
    @JsonCreator
    public JsonAdaptedTask(@JsonProperty("title") String title,
                           @JsonProperty("description") String description,
                             @JsonProperty("dateTime") String dateTime) {
        this.title = title;
        this.description = description;
        this.dateTime = new JsonAdaptedDateTime(dateTime);
    }

    /**
     * Converts a given {@code Task} into this class for Jackson use.
     */
    public JsonAdaptedTask(Task source) {
        title = source.getTitle().title;
        description = source.getDescription().map(description -> description.toString()).orElse("");
        dateTime = source.getDateTime().map(dateTime -> dateTime.toString()).map(JsonAdaptedDateTime::new).get();
    }

    /**
     * Converts this Jackson-friendly adapted task object into the model's {@code Task} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted task.
     */
    public Task toModelType() throws IllegalValueException {

        if (title == null || title.equals("")) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Title.class.getSimpleName()));
        }
        final Title modelTitle = new Title(title);
        if (!Description.isValidDescription(description)) {
            throw new IllegalValueException(Description.MESSAGE_CONSTRAINTS);
        }
        final Description modelDescription = new Description(description);
        DateTime modelDateTime;
        try {
            modelDateTime = dateTime.toModelType();
            if (modelDateTime.toString().equals("")) {
                modelDateTime = null;
            }
        } catch (IllegalValueException e) {
            throw new IllegalValueException(DateTime.MESSAGE_CONSTRAINTS);
        }
        return new Task(modelTitle, modelDescription, modelDateTime);
    }

}
