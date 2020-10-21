package seedu.address.ui.scheduleui;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.address.ui.UiPart;

public class TimeScale extends UiPart<Region> {
    private static final String FXML = "TimeScale.fxml";

    private List<TimeScaleCell> timeScaleCells = new ArrayList<>();

    @FXML
    private StackPane timeScale;

    public TimeScale() {
        super(FXML);
        init();
        setMargin();
    }

    private void init() {
        //set morning
        timeScaleCells.add(new TimeScaleCell( "12 AM"));
        for (int i = 1; i < 12; i++) {
            timeScaleCells.add(new TimeScaleCell( i + " AM"));
        }

        //set noon
        timeScaleCells.add(new TimeScaleCell("Noon"));

        //set afternnon
        for (int i = 1; i < 12; i++) {
            timeScaleCells.add(new TimeScaleCell(i + " PM"));
        }

        //repeat 12 AM
        timeScaleCells.add(new TimeScaleCell("12 AM"));
    }

    /**
     * Stackpane would squeeze everything in the same place, time function is used to list the timeScaleCells.
     */
    private void setMargin() {
        for (int i = 0; i < timeScaleCells.size(); i++) {
            timeScale.getChildren().add(timeScaleCells.get(i).getRoot());
            timeScale.setMargin(timeScaleCells.get(i).getRoot(), new Insets(i * 40, 0, 0, 0));
        }
    }
}
