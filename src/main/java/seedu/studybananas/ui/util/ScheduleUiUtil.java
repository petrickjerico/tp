package seedu.studybananas.ui.util;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import seedu.studybananas.logic.Logic;
import seedu.studybananas.logic.commands.Command;
import seedu.studybananas.logic.commands.quizcommands.StartCommand;
import seedu.studybananas.logic.parser.exceptions.ParseException;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.task.DateTime;
import seedu.studybananas.ui.scheduleui.QuizDescription;

public class ScheduleUiUtil {

    // This part needs to synchronize with TimeScaleCell
    public static final double INITIAL_PADDING = 9.0; //The paddingTop is set to 10, but 9 is more accurate.
    public static final double MARGIN_PER_HOUR = 40.0;
    public static final double MARGIN_PER_MINUTE = MARGIN_PER_HOUR / 60.0;
    public static final double CURRENT_TIME_POINTER_PADDING = 5.0;


    /**
     * Method used to check if the time format is hh:mm AM/PM
     * @return
     */
    public static boolean checkTimePattern(String time) {
        String[] splitTime = time.split(" ");
        String[] splitHourMinute = splitTime[0].split(":");
        String hour = splitHourMinute[0];
        String minute = splitHourMinute[1];
        return splitTime[1].matches("(AM)|(PM)") && hour.matches("(1[0-2])|[1-9]")
                && minute.matches("(0[0-9])|([0-5][0-9])");
    }

    /**
     * This method transforms "HH:mm" to "hh:mm AM/PM"
     */
    public static String toAmPmTime(String formattedTime) {
        String[] splitTime = formattedTime.split(":");
        int hour = Integer.parseInt(splitTime[0]);
        //make sure that minutes have a trailing 0.
        String minute = splitTime[1];

        if (hour > 12) {
            hour -= 12;
            return String.format("%d:%s PM", hour, minute);
        } else if (hour == 12) {
            return String.format("%d:%s PM", hour, minute);
        } else if (hour == 0) {
            return String.format("%d:%s AM", 12, minute);
        } else {
            return String.format("%d:%s AM", hour, minute);
        }
    }

    /**
     * This method calculates the margin from "HH:mm";
     * Still need to check if it is accurate.
     */
    public static double getMarginFromTime(String primitiveTime) {
        String[] splitTime = primitiveTime.split(":");
        int hour = Integer.parseInt(splitTime[0]);
        int minute = Integer.parseInt(splitTime[1]);

        return INITIAL_PADDING + hour * MARGIN_PER_HOUR + minute * MARGIN_PER_MINUTE;

    }

    /**
     * This method calculates the margin from "HH:mm";
     * Still need to check if it is accurate.
     */
    public static double getMarginFromDateTime(DateTime time) {
        if (!time.isToday()) {
            return INITIAL_PADDING;
        }

        int hour = time.dateTime.getHour();
        int minute = time.dateTime.getMinute();
        return INITIAL_PADDING + hour * MARGIN_PER_HOUR + minute * MARGIN_PER_MINUTE;

    }

    /**
     * Check if the description is {@StartCommand}
     */
    public boolean isStartQuizDescription(String description, Logic logic) {
        try {
            Command command = logic.parse(description);
            if (!(command instanceof StartCommand)) {
                throw new ParseException("Not a start command.");
            }
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * Constructs quiz description from description and {@Code Logic}.
     * @throws ParseException if the description is not valid command.
     * @throws IndexOutOfBoundsException if the flashcardSet index or name is not valid;
     */
    public static QuizDescription constructQuizDescription(String description, Logic logic)
            throws ParseException, IndexOutOfBoundsException {
        Command command = logic.parse(description.trim());
        if (!(command instanceof StartCommand)) {
            throw new ParseException("Not a start command.");
        }

        StartCommand quizStartCommand = (StartCommand) command;
        try {
            FlashcardSet flashcardSet = logic.getFlashcardSetFromIndex(quizStartCommand.getQuizIndex());
            String text = "Quiz: " + flashcardSet.getFlashcardSetName();
            return new QuizDescription(text, quizStartCommand, logic);

        } catch (IndexOutOfBoundsException e) { // handles case where quiz is stored by name
            FlashcardSet flashcardSet = logic.getFlashcardSetFromName(quizStartCommand.getFlashcardSetName());

            if (flashcardSet == null) { // if flashcard set name is invalid
                throw new IndexOutOfBoundsException("Flashcard set is non-existent.");
            }

            String text = "Quiz: " + flashcardSet.getFlashcardSetName();
            return new QuizDescription(text, quizStartCommand, logic);
        }
    }

    /**
     * Replaces one component with another component within parent.
     * @param beReplaced the component to be replaced.
     * @param toReplace the component to show.
     * @param parent the parent Node.
     */
    public static void replaceComponent(Node beReplaced, Node toReplace, Pane parent) {
        int idx = parent.getChildren().indexOf(beReplaced);
        parent.getChildren().remove(idx);
        parent.getChildren().add(idx, toReplace);
    }
}
