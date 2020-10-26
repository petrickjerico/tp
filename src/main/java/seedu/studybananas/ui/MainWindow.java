package seedu.studybananas.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import seedu.studybananas.commons.core.GuiSettings;
import seedu.studybananas.commons.core.LogsCenter;
import seedu.studybananas.logic.Logic;
import seedu.studybananas.ui.commons.ResponsePopUp;
import seedu.studybananas.ui.quizui.QuizUi;
import seedu.studybananas.ui.sidebar.SideBar;
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

        // Set dependencies
        this.primaryStage = primaryStage;
        this.logic = logic;

        // Init the component.
        responsePopUp = new ResponsePopUp(primaryStage);
        scheduleUi = new ScheduleUi(logic, responsePopUp);
        flashcardUi = new FlashcardUi(logic);
        quizUi = new QuizUi(logic);

        // Configure the UI
        setWindowDefaultSize(logic.getGuiSettings());

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
        switch (state) {
        case SCHEDULE:
            mainWindow.setCenter(scheduleUi.getRoot());
            break;
        case FLASHCARD:
            mainWindow.setCenter(flashcardUi.getRoot());
            break;
        case QUIZ:
            mainWindow.setCenter(quizUi.getRoot());
            break;
        default:
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void subscribe(Observable news) {
        news.register(this);
    }

    @Override
    public void update(UiStateType state) {
        handleStateChange(state);
    }



}
