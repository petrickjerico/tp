package seedu.studybananas.model.systemlevelmodel;

import javafx.collections.ObservableMap;
import seedu.studybananas.model.flashcard.FlashcardSetName;
import seedu.studybananas.model.quiz.Quiz;

public interface ReadOnlyQuizRecords {

    /**
     * Returns an unmodifiable view of the list of quiz records.
     * This list will not contain any duplicate quiz records.
     */
    ObservableMap<FlashcardSetName, Quiz> getQuizRecordsMap();
}
