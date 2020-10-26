package seedu.studybananas.ui.scheduleui;

import static seedu.studybananas.ui.util.ScheduleUiUtil.getMarginFromTime;
import static seedu.studybananas.ui.util.ScheduleUiUtil.toAmPmTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.studybananas.logic.Logic;
import seedu.studybananas.ui.UiPart;

public class UpcomingSchedule extends UiPart<Region> {
    private static final String FXML = "UpcomingSchedule.fxml";

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    @FXML
    private VBox schedule;

    @FXML
    private Label date;

    @FXML
    private Label year;

    @FXML
    private Label day;

    private CurrentTimePointer currentTimePointer;
    private TimeScale timeScale;

    private Logic logic;

    /**
     * Constructor for the UpcomingSchedulePanel, which is the left panel of the {@ScheduleUi}.
     * @param logic
     */
    public UpcomingSchedule(Logic logic) {
        super(FXML);
        this.logic = logic;
        fillInner();
    }

    private void fillInner() {
        LocalDate today = LocalDate.now();

        timeScale = new TimeScale(logic.getUpcomingTaskList());

        schedule.getChildren().add(timeScale.getRoot());

        // Fill the label with date of "TODAY"
        year.setText(String.valueOf(today.getYear()));
        date.setText(getDateString(today));
        day.setText(getDayString(today));

        // Add the currentTimePointer to the TimeScale
        String currentTime = getCurrentTime();
        double marginTop = getMarginFromTime(currentTime);
        currentTimePointer = new CurrentTimePointer(toAmPmTime(currentTime));
        // The sequence matters, tasks must be on top.
        timeScale.placeCurrentTime(currentTimePointer, marginTop);
        timeScale.addInitialTasksToTimeScale();

        // Open a new thread to handle the position of the currentTimePointer
        Thread timerThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000 * 60); // a minute
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(() -> {
                    String newCurrentTime = getCurrentTime();
                    //update the position of the currentTimePointer
                    currentTimePointer.updateTime(toAmPmTime(newCurrentTime));
                    timeScale.updateCurrentTimePosition(getMarginFromTime(newCurrentTime));
                });
            }
        });

        timerThread.start();


    }

    private String getDateString(LocalDate date) {
        String month = date.getMonth().toString();
        String dayOfMonth = String.valueOf(date.getDayOfMonth());
        String dateString = month + " " + dayOfMonth + ",";
        return dateString;
    }

    private String getDayString(LocalDate date) {
        String dayString = date.getDayOfWeek().toString();
        return dayString.substring(0, 1) + dayString.substring(1).toLowerCase();
    }

    /**
     * Returns time in the format of "HH:mm"
     */
    private String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        return TIME_FORMATTER.format(now);
    }



}
