package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* StudyBananas Schedule Prefix definitions */
    public static final Prefix PREFIX_TITLE = new Prefix("T:");
    public static final Prefix PREFIX_DESCRIPTION = new Prefix("d:");
    public static final Prefix PREFIX_TIME = new Prefix("t:");
    public static final Prefix PREFIX_DURATION = new Prefix("dur:");


    /* StudyBananas Prefix definitions */
    public static final Prefix PREFIX_FLASHCARDSET = new Prefix("flset:");
    public static final Prefix PREFIX_FLASHCARDSET_NAME = new Prefix("name:");
    public static final Prefix PREFIX_FLASHCARD = new Prefix("fl:");
    public static final Prefix PREFIX_QUESTION = new Prefix("q:");
    public static final Prefix PREFIX_ANSWER = new Prefix("a:");
}
