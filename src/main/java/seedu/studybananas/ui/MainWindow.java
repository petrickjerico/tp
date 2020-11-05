package seedu.studybananas.ui;

import java.util.logging.Logger;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import seedu.studybananas.commons.core.GuiSettings;
import seedu.studybananas.commons.core.LogsCenter;
import seedu.studybananas.logic.Logic;
import seedu.studybananas.ui.commons.ResponsePopUp;
import seedu.studybananas.ui.quizui.QuizUi;
import seedu.studybananas.ui.sidebar.SideBar;
import seedu.studybananas.ui.util.GlobalState;
import seedu.studybananas.ui.util.Observable;
import seedu.studybananas.ui.util.Observer;
import seedu.studybananas.ui.util.SingletonUiState;
import seedu.studybananas.ui.util.UiStateType;

/**
 * The Main Window. Provides the basic application layout containing
 * a menu bar and space where other JavaFX elements can be placed.
 */
public class MainWindow extends UiPart<Stage> implements Observer<UiStateType> {

    private static final String FXML = "MainWindow.fxml";

    private final Logger logger = LogsCenter.getLogger(getClass());

    private final Stage primaryStage;
    private final Logic logic;

    private SingletonUiState uiState;
    private ScheduleUi scheduleUi;
    private FlashcardUi flashcardUi;
    private QuizUi quizUi;
    private ResponsePopUp responsePopUp;

    @FXML
    private BorderPane mainWindow;



    /**
     * Creates a {@code MainWindow} with the given {@code Stage} and {@code Logic}.
     */
    public MainWindow(Stage primaryStage, Logic logic) {
        super(FXML, primaryStage);

        // set global state
        // must handle the first, Logic is used by UI components later.
        GlobalState.getInstance().setPrimaryStage(primaryStage);
        GlobalState.getInstance().setLogic(logic);

        // Set dependencies
        this.primaryStage = primaryStage;
        this.logic = logic;

        // Init the component.
        responsePopUp = new ResponsePopUp(primaryStage);
        scheduleUi = new ScheduleUi(responsePopUp);
        flashcardUi = new FlashcardUi();
        quizUi = new QuizUi(responsePopUp);

        // Configure the UI
        setWindowDefaultSize(logic.getGuiSettings());
        primaryStage.setResizable(false);

        //subscribe to UiState
        uiState = SingletonUiState.getInstance();
        subscribe(uiState);

    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }


    /**
     * Fills up all the placeholders of this window.
     */
    void fillInnerParts() {
        mainWindow.setLeft(new SideBar(primaryStage, logic).getRoot());

        //default center view
        handleStateChange(this.uiState.getUiState());
    }

    /**
     * Sets the default size based on {@code guiSettings}.
     */
    private void setWindowDefaultSize(GuiSettings guiSettings) {
        primaryStage.setHeight(guiSettings.getWindowHeight());
        primaryStage.setWidth(guiSettings.getWindowWidth());
        if (guiSettings.getWindowCoordinates() != null) {
            primaryStage.setX(guiSettings.getWindowCoordinates().getX());
            primaryStage.setY(guiSettings.getWindowCoordinates().getY());
        }
    }

    void show() {
        primaryStage.show();
    }


    private void handleStateChange(UiStateType state) {
        ScaleTransition animation = handleSwitchAnimation();
        GlobalState globalState = GlobalState.getInstance();
        switch (state) {
        case SCHEDULE:
            mainWindow.setCenter(scheduleUi.getRoot());
            animation.setNode(scheduleUi.getRoot());
            globalState.focusScheduleCommandBox();
            break;
        case FLASHCARD:
            animation.setNode(flashcardUi.getRoot());
            mainWindow.setCenter(flashcardUi.getRoot());
            globalState.focusFlashcardCommandBox();
            break;
        case QUIZ:
            animation.setNode(quizUi.getRoot());
            mainWindow.setCenter(quizUi.getRoot());
            globalState.focusQuizCommandBox();
            break;
        default:
            throw new IllegalArgumentException();
        }

        // try to resolve lag; still need some tuning
        Thread thread = new Thread() {
            public void run() {
                animation.play();
            }
        };
        thread.start();
    }

    @Override
    public void subscribe(Observable news) {
        news.register(this);
    }

    @Override
    public void update(UiStateType state) {
        handleStateChange(state);
    }

    private ScaleTransition handleSwitchAnimation() {
        ScaleTransition switchAnimation = new ScaleTransition(Duration.millis(100));
        switchAnimation.setFromX(0.8);
        switchAnimation.setFromY(0.8);
        switchAnimation.setToX(1.0);
        switchAnimation.setToY(1.0);
        return switchAnimation;
    }




}
