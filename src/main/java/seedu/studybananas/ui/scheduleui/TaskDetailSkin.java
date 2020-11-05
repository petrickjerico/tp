package seedu.studybananas.ui.scheduleui;

import static seedu.studybananas.ui.util.ScheduleUiUtil.constructQuizDescription;
import static seedu.studybananas.ui.util.ScheduleUiUtil.replaceComponent;
import static seedu.studybananas.ui.util.ScheduleUiUtil.toAmPmTime;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.studybananas.logic.Logic;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.model.task.Task;
import seedu.studybananas.ui.UiPart;
import seedu.studybananas.ui.util.Observable;
import seedu.studybananas.ui.util.Observer;
import seedu.studybananas.ui.util.SingletonClickedTaskState;

public class TaskDetailSkin extends UiPart<Region> implements Observer<Task> {
    private static final String FXML = "TaskDetailSkin.fxml";

    private SingletonClickedTaskState taskState;

    @FXML
    private VBox cardPane;
    @FXML
    private Label title;
    @FXML
    private Label description;
    @FXML
    private Label date;
    @FXML
    private Label time;
    @FXML
    private Label duration;
    private Logic logic;
    private Node currentDescription;

    /**
     * Default constructor for TaskDetailSkin
     */
    public TaskDetailSkin(Logic logic) {
        super(FXML);
        this.logic = logic;

        title.setText("");
        description.setText("Click on the task on the time scale to view its detail");
        duration.setText("");
        date.setText("Date: ");
        taskState = SingletonClickedTaskState.getInstance();

        // subscribe to the Task State
        subscribe(taskState);

        // handle wrap text
        description.setWrapText(true);

        // set current description for future replacement
        currentDescription = description;
    }

    public void setTask(Task task) {
        title.setText(task.getTitle().title);
        date.setText(task.getDateTime().map(time -> time.getUiFormatDate()).orElse(""));
        time.setText(task.getDateTime().map(time -> toAmPmTime(time.getStandardFormatTime())).orElse(""));
        duration.setText(task.getDuration().map(dur -> String.valueOf(dur.duration) + " minutes").orElse("minutes"));

        String descriptionText = task.getDescription().map(des-> des.description).orElse(
                "Add description by edit command");
        try {
            QuizDescription quizDescription = constructQuizDescription(descriptionText, logic);
            replaceComponent(currentDescription, quizDescription.getRoot(), cardPane);
            currentDescription = quizDescription.getRoot();
        } catch (ParseException e) {
            description.setText(descriptionText);
            replaceComponent(currentDescription, description, cardPane);
            currentDescription = description;
        }
    }

    @Override
    public void subscribe(Observable news) {
        news.register(this);
    }

    @Override
    public void update(Task state) {
        setTask(state);
    }

}
