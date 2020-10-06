package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* AB3 Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");

    /* StudyBananas Prefix definitions */
    public static final Prefix PREFIX_FLASHCARDSET = new Prefix("flset:");
    public static final Prefix PREFIX_FLASHCARD = new Prefix("fl:");
    public static final Prefix PREFIX_QUESTION = new Prefix("q:");
    public static final Prefix PREFIX_ANSWER = new Prefix("a:");
}
