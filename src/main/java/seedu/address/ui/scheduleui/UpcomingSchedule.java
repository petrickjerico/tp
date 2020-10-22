package seedu.address.ui.scheduleui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import seedu.address.logic.Logic;
import seedu.address.ui.UiPart;

public class UpcomingSchedule extends UiPart<Region> {
    private static final String FXML = "UpcomingSchedule.fxml";

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    // This part needs to synchronize with TimeScaleCell
    public static final double INITIAL_PADDING = 5;
    public static final double MARGIN_PER_HOUR = 40;
    public static final double MARGIN_PER_MINUTE = MARGIN_PER_HOUR/60.0;


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

    public UpcomingSchedule(Logic logic) {
        super(FXML);
        this.logic = logic;
        fillInner();
    }

    private void fillInner() {
        LocalDate today = LocalDate.now();

        timeScale = new TimeScale(logic.getFilteredTaskList());

        schedule.getChildren().add(timeScale.getRoot());

        // Fill the label with date of "TODAY"
        year.setText(String.valueOf(today.getYear()));
        date.setText(getDateString(today));
        day.setText(getDayString(today));

        // Add the currentTimePointer to the TimeScale
        String currentTime = getCurrentTime();
        double marginTop = getMarginFromTime(currentTime);
        currentTimePointer = new CurrentTimePointer(toAmPmTime(currentTime));
        timeScale.placeCurrentTime(currentTimePointer, marginTop);

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
        String dateString = month + " " +dayOfMonth + ",";
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

    /**
     * This method transforms "HH:mm" to "hh:mm AM/PM"
     */
    private String toAmPmTime(String formattedTime) {
        String[] splitTime = formattedTime.split(":");
        int hour = Integer.parseInt(splitTime[0]);
        //make sure that minutes have a trailing 0.
        String minute = splitTime[1];

        if (hour >= 12) {
            hour -= 12;
            return String.format("%d:%s PM", hour, minute);
        } else {
            return String.format("%d:%s AM", hour, minute);
        }
    }

    /**
     * This method calculates the margin from "HH:mm";
     * Still need to check if it is accurate.
     */
    private double getMarginFromTime(String primitiveTime) {
        String[] splitTime = primitiveTime.split(":");
        int hour = Integer.parseInt(splitTime[0]);
        int minute = Integer.parseInt(splitTime[1]);

        return INITIAL_PADDING + hour * MARGIN_PER_HOUR + minute * MARGIN_PER_MINUTE;

    }


}
