package seedu.studybananas.ui.commons;

import javafx.animation.FadeTransition;
import javafx.scene.layout.Region;
import javafx.util.Duration;
import seedu.studybananas.ui.UiPart;

public abstract class Response extends UiPart<Region> {
    private FadeTransition fadeIn;

    /**
     * Constructor for response.
     * @param fxmlFileName
     */
    public Response(String fxmlFileName) {
        super(fxmlFileName);
        setAnimation();
    }

    protected void setAnimation() {
        this.fadeIn = new FadeTransition(Duration.millis(1000), this.getRoot());
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
    }

    public void play() {
        fadeIn.play();
    }
}
