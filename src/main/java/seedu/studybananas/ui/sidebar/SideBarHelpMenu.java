package seedu.studybananas.ui.sidebar;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import seedu.studybananas.commons.core.GuiSettings;
import seedu.studybananas.logic.Logic;
import seedu.studybananas.ui.commons.HelpWindow;
import seedu.studybananas.ui.UiPart;
import seedu.studybananas.ui.util.GlobalState;

public class SideBarHelpMenu extends UiPart<Region> {
    private static final String FXML = "SideBarHelpMenu.fxml";

    // Independent Ui parts residing in this Ui container
    private final HelpWindow helpWindow;
    private Stage primaryStage;
    private Logic logic;

    /**
     * Constructor SideBarHelpMenu from the {@Code logic} and {@Code primaryStage}
     */
    public SideBarHelpMenu(Stage primaryStage, Logic logic) {
        super(FXML);
        helpWindow = new HelpWindow();
        this.primaryStage = primaryStage;
        this.logic = logic;

        // set global state
        GlobalState.getInstance().setHelpWindow(helpWindow);
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        GuiSettings guiSettings = new GuiSettings(primaryStage.getWidth(), primaryStage.getHeight(),
                (int) primaryStage.getX(), (int) primaryStage.getY());
        logic.setGuiSettings(guiSettings);
        helpWindow.hide();
        primaryStage.hide();
    }

    /**
     * Opens the help window or focuses on it if it's already opened.
     */
    @FXML
    public void handleHelp() {
        if (!helpWindow.isShowing()) {
            helpWindow.show();
        } else {
            helpWindow.focus();
        }
    }
}
