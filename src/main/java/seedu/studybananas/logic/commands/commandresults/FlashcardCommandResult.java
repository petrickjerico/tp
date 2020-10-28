package seedu.studybananas.logic.commands.commandresults;

public class FlashcardCommandResult extends CommandResult {

    public FlashcardCommandResult(String feedbackToUser) {
        super(feedbackToUser);
    }

    @Override
    public CommmandResultType getCommandResultType() {
        return CommmandResultType.Flashcard;
    }
}
