package seedu.studybananas.logic.commands.commandresults;

import static seedu.studybananas.logic.commands.commandresults.QuizCommandResultType.ERROR;

public class QuizErrorCommandResult extends QuizCommandResult {


    public QuizErrorCommandResult(String feedbackToUser) {
        super(feedbackToUser, ERROR);
    }
}
