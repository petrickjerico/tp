package seedu.studybananas.model.util;

import java.util.ArrayList;
import java.util.List;

import seedu.studybananas.model.flashcard.Answer;
import seedu.studybananas.model.flashcard.Flashcard;
import seedu.studybananas.model.flashcard.FlashcardSet;
import seedu.studybananas.model.flashcard.FlashcardSetName;
import seedu.studybananas.model.flashcard.Question;
import seedu.studybananas.model.quiz.Quiz;
import seedu.studybananas.model.systemlevelmodel.FlashcardBank;
import seedu.studybananas.model.systemlevelmodel.QuizRecords;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyFlashcardBank;
import seedu.studybananas.model.systemlevelmodel.ReadOnlyQuizRecords;
import seedu.studybananas.model.systemlevelmodel.ReadOnlySchedule;
import seedu.studybananas.model.systemlevelmodel.Schedule;
import seedu.studybananas.model.task.DateTime;
import seedu.studybananas.model.task.Description;
import seedu.studybananas.model.task.Duration;
import seedu.studybananas.model.task.Task;
import seedu.studybananas.model.task.Title;

/**
 * Contains utility methods for populating {@code StudyBananas} with sample data.
 */
public class SampleDataUtil {

    public static Task[] getSampleTasks() {
        return new Task[] {
            new Task(new Title("CS2103T"), new Description("quiz flset:1"),
                    DateTime.getYesterday(23, 0), new Duration(120)),
            new Task(new Title("CS2103T"), new Description("Week 8 topics quiz."),
                    DateTime.getToday(11, 30), new Duration(60)),
            new Task(new Title("CS2103T"), new Description("Week 9 topics quiz."),
                    new DateTime("2020-10-16 23:59"), new Duration(60)),
            new Task(new Title("CS2103T"), new Description("Popping dance lecture."),
                    new DateTime("2020-10-23 23:59"), new Duration(60)),
            new Task(new Title("CCA"), new Description("Week 10 topics quiz."),
                    DateTime.getToday(13, 0), new Duration(120)),
            new Task(new Title("Household"), null,
                    new DateTime("2020-11-11 12:30"), new Duration(60)),
            new Task(new Title("Job"), new Description(""),
                    new DateTime("2020-09-29 22:00"), new Duration(60))
        };
    }

    public static List<Flashcard> getSampleFlashcardCS2040() {
        List<Flashcard> flashcards = new ArrayList<>();
        flashcards.add(new Flashcard(new Question("Time complexity of binary search?"),
                new Answer("O(logn)")));
        flashcards.add(new Flashcard(new Question("What are conditions for binary search?"),
                new Answer("It has to be a sorted array")));
        return flashcards;
    }

    public static List<Flashcard> getSampleFlashcardPhysics() {
        List<Flashcard> flashcards = new ArrayList<>();
        flashcards.add(new Flashcard(new Question("Formula to show Newton's Second Law of Motion"),
                new Answer("F = ma [where m = mass (in kg) and a = acceleration (in ms^-2)]")));
        flashcards.add(new Flashcard(new Question("Formula for GPE"),
                new Answer("GPE = mgh [where m = mass (in kg), g = 9.81ms^-2 and h = height (in m)]")));
        return flashcards;
    }

    public static List<Flashcard> getSampleFlashcardCS2103T() {
        List<Flashcard> flashcards = new ArrayList<>();
        flashcards.add(new Flashcard(new Question("What is an advantage of defensive programming?"),
                new Answer("Improves software and source code quality and comprehensibility, " +
                        "for software to behave in a predictable manner despite unexpected inputs or user actions")));
        flashcards.add(new Flashcard(new Question("Why are sequence diagrams important?"),
                new Answer("It is useful to show shows the interaction logic between the objects in the system " +
                        "in the time order that the interactions take place")));
        flashcards.add(new Flashcard(new Question("What UML diagram should we use to describe an object instance?"),
                new Answer("Object Diagram")));
        return flashcards;
    }

    public static FlashcardSet[] getSampleFlashcardSets() {
        return new FlashcardSet[] {
                new FlashcardSet(new FlashcardSetName("CS2103T"), getSampleFlashcardCS2103T()),
                new FlashcardSet(new FlashcardSetName("CS2040"), getSampleFlashcardCS2040()),
                new FlashcardSet(new FlashcardSetName("Physics"), getSampleFlashcardPhysics())
        };
    }

    private static Quiz[] getSampleQuizzes() {
        return new Quiz[] {
            new Quiz(new FlashcardSet(new FlashcardSetName("CS2103T"), getSampleFlashcardCS2103T()),
                    3, 2, new boolean[]{true, true, false},
                    new String[]{"improves software code quality", "shows interaction logic", "class diagram"}),
            new Quiz(new FlashcardSet(new FlashcardSetName("CS2040"), getSampleFlashcardCS2040()),
                    2, 2, new boolean[]{true, true},
                    new String[]{"o(logn)", "must be sorted"}),
            new Quiz(new FlashcardSet(new FlashcardSetName("Physics"), getSampleFlashcardPhysics()),
                    2, 1, new boolean[] {true, false},
                    new String[]{"F = ma", "hmm i forgot"})
        };
    }

    public static ReadOnlySchedule getSampleSchedule() {
        Schedule sampleSchedule = new Schedule();
        for (Task sampleTask : getSampleTasks()) {
            sampleSchedule.addTask(sampleTask);
        }
        return sampleSchedule;
    }

    public static ReadOnlyFlashcardBank getSampleFlashcardBank() {
        FlashcardBank sampleFlashcardBank = new FlashcardBank();
        for (FlashcardSet sampleFlashcardSet : getSampleFlashcardSets()) {
            sampleFlashcardBank.addFlashcardSet(sampleFlashcardSet);
        }
        return sampleFlashcardBank;
    }

    public static ReadOnlyQuizRecords getSampleQuizRecords() {
        QuizRecords quizRecords = new QuizRecords();
        for (Quiz sampleQuiz: getSampleQuizzes()) {
            quizRecords.addQuiz(sampleQuiz);
        }
        return quizRecords;
    }

}
