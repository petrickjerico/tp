package seedu.studybananas.ui.commons;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.Region;
import javafx.util.Duration;
import seedu.studybananas.ui.UiPart;

public abstract class Response extends UiPart<Region> {
    private Timeline timeline;

    /**
     * Constructor for response.
     * @param fxmlFileName
     */
    public Response(String fxmlFileName) {
        super(fxmlFileName);
        setAnimation();
    }

    protected void setAnimation() {
        timeline = new Timeline();

        KeyValue transparent  = new KeyValue(this.getRoot().opacityProperty(), 0.0);
        KeyValue opaque       = new KeyValue(this.getRoot().opacityProperty(), 1.0);

        KeyFrame startFadeIn  = new KeyFrame(Duration.ZERO, transparent);
        KeyFrame endFadeIn    = new KeyFrame(Duration.millis(1000), opaque);
        KeyFrame startFadeOut = new KeyFrame(Duration.millis(3000), opaque);
        KeyFrame endFadeOut   = new KeyFrame(Duration.millis(4000), transparent);

        timeline.getKeyFrames().addAll(startFadeIn, endFadeIn, startFadeOut, endFadeOut);

    }

    public void play() {
        timeline.play();
    }
}
