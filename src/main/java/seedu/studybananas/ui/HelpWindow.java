package seedu.studybananas.ui;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import seedu.studybananas.commons.core.LogsCenter;
import seedu.studybananas.ui.commons.CommandHelpLabel;

/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {
    class CommandInfo {
        private String command;
        private String argument;
        private String description;
        CommandInfo(String command, String argument, String description) {
            this.command = command;
            this.argument = argument;
            this.description = description;
        }
    }

    public static final String USERGUIDE_URL = "https://ay2021s1-cs2103t-f12-2.github.io/tp/UserGuide.html";
    public static final String HELP_MESSAGE = "Refer to the user guide for more details: " + USERGUIDE_URL;

    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";

    private final List<CommandInfo> commands = Arrays.asList(
           new CommandInfo("list task", null, "list all the task in the schedule"),
            new CommandInfo("add task", "T: <title>\nd: <description>\n"
                    + "t: <time>\ndur:<duration>", "add a new task to your schedule"),
            new CommandInfo("delete task", "<index>", "delete your task by index"),
            new CommandInfo("search task", "queryKey", "search tasks by their title"),
            new CommandInfo("edit task", "<index>\nT: <title>\nd: <description>\n"
                    + "t: <time>\ndur:<duration>", "edit task "),
            new CommandInfo("add flset", "name: <setname>", "create a new flashcard set"),
            new CommandInfo("list flset", null, "list all the flashcards that you have"),
            new CommandInfo("delete flset", "<setIndex>", "delete flashcard set by index"),
            new CommandInfo("add fl", "flset: <setindex>\nq: <question>\na: <answer>",
                    "add a flashcard to the flashcard set"),
            new CommandInfo("list fl", "<setindex>",
                    "list all the flashcards from given flashcard set"),
            new CommandInfo("delete fl", "flset: <setindex>\nfl: <flIndex>",
                    "delete flashcard from a given flashcard set"),
            new CommandInfo("quiz flset:", "<setindex>",
                    "start the quiz for given flashcard set"),
            new CommandInfo("quiz score flset:", "<setindex>",
                    "view the quiz score for the given flashcard set in the last attempt"),
            new CommandInfo("flip", null,
                    "view the answer for this flashcard"),
            new CommandInfo("c", null,
                    "mark my answer as correct"),
            new CommandInfo("w", null,
                    "mark my answer as wrong")

    );


    @FXML
    private VBox helpWindow;

    @FXML
    private Button copyButton;

    @FXML
    private Label helpMessage;

    /**
     * Creates a new HelpWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root) {
        super(FXML, root);
        for (CommandInfo commandInfo : commands) {
            CommandHelpLabel commandHelpLabel = new CommandHelpLabel(commandInfo.command,
                    commandInfo.argument, commandInfo.description);
            helpWindow.getChildren().add(1, commandHelpLabel.getRoot());
        }
        helpMessage.setText(HELP_MESSAGE);
    }

    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow() {
        this(new Stage());
    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     * <ul>
     *     <li>
     *         if this method is called on a thread other than the JavaFX Application Thread.
     *     </li>
     *     <li>
     *         if this method is called during animation or layout processing.
     *     </li>
     *     <li>
     *         if this method is called on the primary stage.
     *     </li>
     *     <li>
     *         if {@code dialogStage} is already showing.
     *     </li>
     * </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(USERGUIDE_URL);
        clipboard.setContent(url);
    }
}
