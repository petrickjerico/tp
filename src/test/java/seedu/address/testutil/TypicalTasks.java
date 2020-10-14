package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.systemlevelmodel.Schedule;
import seedu.address.model.task.Task;

/**
 * A utility class containing a list of {@code Task} objects to be used in tests.
 */
public class TypicalTasks {

    public static final Task CS2103T_WEEK8_QUIZ = new TaskBuilder().withTitle("CS2103T")
            .withDescription("Week 8 Quiz").withDateTime("2020-09-27 12:00")
            .build();
    public static final Task CS2100_TUTORIAL_HOMEWORK = new TaskBuilder().withTitle("CS2100")
            .withDescription("Pipeline homework")
            .withDateTime("2020-10-04 10:00")
            .build();
    public static final Task ST2334_ASSIGNMENT = new TaskBuilder().withTitle("ST2334")
            .withDescription("Chapter 2 Quiz")
            .withDateTime("2020-10-01 23:00")
            .build();

    // Manually added with no Description
    public static final Task CS2100_FINAL = new TaskBuilder().withTitle("CS2100 Final")
            .withDescription("")
            .withDateTime("2020-11-30 13:00")
            .build();

    // Manually added with no DateTime
    public static final Task CS2101_FEEDBACK = new TaskBuilder().withTitle("CS2101")
            .withDescription("Luminus Feedback")
            .withDateTime("")
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalTasks() {} // prevents instantiation

    /**
     * Returns an {@code Schedule} with all the typical tasks.
     */
    public static Schedule getTypicalSchedule() {
        Schedule sc = new Schedule();
        for (Task task : getTypicalTasks()) {
            sc.addTask(task);
        }
        return sc;
    }

    public static List<Task> getTypicalTasks() {
        return new ArrayList<>(Arrays.asList(CS2103T_WEEK8_QUIZ,
                CS2100_TUTORIAL_HOMEWORK,
                ST2334_ASSIGNMENT,
                CS2100_FINAL,
                CS2101_FEEDBACK));
    }
}
