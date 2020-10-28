package seedu.studybananas.testutil;

import static seedu.studybananas.testutil.TypicalFlashcardSets.ECONOMICS;
import static seedu.studybananas.testutil.TypicalFlashcardSets.ICEBREAKER_JOKES;
import static seedu.studybananas.testutil.TypicalFlashcardSets.PHYSICS;

import java.util.HashMap;
import java.util.Map;

import seedu.studybananas.model.flashcard.FlashcardSetName;
import seedu.studybananas.model.quiz.Quiz;
import seedu.studybananas.model.systemlevelmodel.QuizRecords;

public class TypicalQuizzes {

    public static final Quiz QUIZ_PHYSICS = new QuizBuilder()
            .withFlashcardSet(PHYSICS)
            .buildDefaultQuiz();
    public static final Quiz QUIZ_ECONOMICS = new QuizBuilder()
            .withFlashcardSet(ECONOMICS)
            .build();
    public static final Quiz QUIZ_ICEBREAKER_JOKES = new QuizBuilder()
            .withFlashcardSet(ICEBREAKER_JOKES)
            .buildDefaultQuiz();

    private TypicalQuizzes() {} // prevents instantiation

    /**
     * Returns a {@code QuizRecords} with all the typical quizzes.
     */
    public static QuizRecords getTypicalQuizRecords() {
        QuizRecords quizRecords = new QuizRecords();
        for (Quiz quiz : getTypicalQuizzes().values()) {
            quizRecords.addQuiz(quiz);
        }
        return quizRecords;
    }

    public static Map<FlashcardSetName, Quiz> getTypicalQuizzes() {
        Quiz quizPhysics = new QuizBuilder().withFlashcardSet(PHYSICS).build();
        Quiz quizEconomics = new QuizBuilder().withFlashcardSet(ECONOMICS).build();
        Quiz quizIcebreakerJokes = new QuizBuilder().withFlashcardSet(ICEBREAKER_JOKES).build();

        Map<FlashcardSetName, Quiz> map = new HashMap<>();
        map.put(quizPhysics.getFlsetName(), quizPhysics);
        map.put(quizEconomics.getFlsetName(), quizEconomics);
        map.put(quizIcebreakerJokes.getFlsetName(), quizEconomics);

        return map;
    }
}
