package seedu.address.model.util;

import java.util.ArrayList;
import java.util.List;

import seedu.address.model.flashcard.Answer;
import seedu.address.model.flashcard.Flashcard;
import seedu.address.model.flashcard.FlashcardSet;
import seedu.address.model.flashcard.FlashcardSetName;
import seedu.address.model.flashcard.Question;
import seedu.address.model.quiz.Quiz;
import seedu.address.model.systemlevelmodel.FlashcardBank;
import seedu.address.model.systemlevelmodel.QuizRecords;
import seedu.address.model.systemlevelmodel.ReadOnlyFlashcardBank;
import seedu.address.model.systemlevelmodel.ReadOnlyQuizRecords;
import seedu.address.model.systemlevelmodel.ReadOnlySchedule;
import seedu.address.model.systemlevelmodel.Schedule;
import seedu.address.model.task.DateTime;
import seedu.address.model.task.Description;
import seedu.address.model.task.Duration;
import seedu.address.model.task.Task;
import seedu.address.model.task.Title;

/**
 * Contains utility methods for populating {@code StudyBananas} with sample data.
 */
public class SampleDataUtil {

    public static Task[] getSampleTasks() {
        return new Task[] {
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
                new Answer("It has to be sorted array")));
        return flashcards;
    }

    public static FlashcardSet[] getSampleFlashcardSets() {
        return new FlashcardSet[] {new FlashcardSet(new FlashcardSetName("CS2040"), getSampleFlashcardCS2040())};
    }

    private static Quiz[] getSampleQuizzes() {
        return new Quiz[] {
            new Quiz(1, new FlashcardSet(new FlashcardSetName("CS2040"),
                    getSampleFlashcardCS2040()))
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
