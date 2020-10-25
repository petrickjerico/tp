package seedu.studybananas.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.studybananas.model.systemlevelmodel.Schedule;
import seedu.studybananas.model.task.Task;

/**
 * A utility class containing a list of {@code Task} objects to be used in tests.
 */
public class SampleTasks {

    public static final Task CS2103T_WEEK8_QUIZ = new TaskBuilder().withTitle("CS2103T")
            .withDescription("Week 8 Quiz").withDateTime("2020-09-27 12:00").withDuration("30")
            .build();
    public static final Task CS2100_TUTORIAL_HOMEWORK = new TaskBuilder().withTitle("CS2100")
            .withDescription("Pipeline homework")
            .withDateTime("2020-10-04 10:00").withDuration("40")
            .build();
    public static final Task ST2334_ASSIGNMENT = new TaskBuilder().withTitle("ST2334")
            .withDescription("Chapter 2 Quiz")
            .withDateTime("2020-10-01 23:00").withDuration("50")
            .build();
    public static final Task CS2101_OP2 = new TaskBuilder().withTitle("CS2101")
            .withDescription("Oral Presentation 2")
            .withDateTime("2020-10-25 10:00").withDuration("60")
            .build();

    // Manually added with no Description
    public static final Task CS2100_FINAL = new TaskBuilder().withTitle("CS2100")
            .withDescription("")
            .withDateTime("2020-11-30 13:00").withDuration("60")
            .build();

    // Manually added with no DateTime
    public static final Task CS2101_FEEDBACK = new TaskBuilder().withTitle("CS2101")
            .withDescription("Luminus Feedback")
            .withDateTime("").withDuration("60")
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private SampleTasks() {} // prevents instantiation

    /**
     * Returns an {@code Schedule} with all the typical tasks.
     */
    public static Schedule getSampleSchedule() {
        Schedule sc = new Schedule();
        for (Task task : getSampleTasks()) {
            sc.addTask(task);
        }
        return sc;
    }

    public static List<Task> getSampleTasks() {
        return new ArrayList<>(Arrays.asList(CS2103T_WEEK8_QUIZ,
                CS2100_TUTORIAL_HOMEWORK,
                ST2334_ASSIGNMENT,
                CS2100_FINAL,
                CS2101_FEEDBACK));
    }
}
