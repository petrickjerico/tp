package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.TaskBuilder;

public class InfoContainsKeywordsPredicateTest {

    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("first");
        List<String> secondPredicateKeywordList = Arrays.asList("first", "second");

        InfoContainsKeywordsPredicate firstPredicate = new InfoContainsKeywordsPredicate(firstPredicateKeywordList);
        InfoContainsKeywordsPredicate secondPredicate = new InfoContainsKeywordsPredicate(secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        InfoContainsKeywordsPredicate firstPredicateCopy = new InfoContainsKeywordsPredicate(
                firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different person -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_titleContainsKeywords_returnsTrue() {
        // One keyword
        InfoContainsKeywordsPredicate predicate = new InfoContainsKeywordsPredicate(
                Collections.singletonList("CS2100"));
        assertTrue(predicate.test(new TaskBuilder().withTitle("CS2100").build()));

        // Multiple keywords
        predicate = new InfoContainsKeywordsPredicate(Arrays.asList("CS2100", "Homework"));
        assertTrue(predicate.test(new TaskBuilder().withTitle("CS2100 Homework").build()));

        // Only one matching keyword
        predicate = new InfoContainsKeywordsPredicate(Arrays.asList("CS2103T", "Homework"));
        assertTrue(predicate.test(new TaskBuilder().withTitle("CS2100 Homework").build()));

        // Mixed-case keywords
        predicate = new InfoContainsKeywordsPredicate(Arrays.asList("cS2103t", "qUiz"));
        assertTrue(predicate.test(new TaskBuilder().withTitle("CS2103T Quiz").build()));
    }

    @Test
    public void test_titleDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        InfoContainsKeywordsPredicate predicate = new InfoContainsKeywordsPredicate(Collections.emptyList());
        assertFalse(predicate.test(new TaskBuilder().withTitle("CS2100").build()));

        // Non-matching keyword
        predicate = new InfoContainsKeywordsPredicate(Arrays.asList("CS2103T"));
        assertFalse(predicate.test(new TaskBuilder().withTitle("CS2100 Homework").build()));
    }
}
