package seedu.studybananas.model.task;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.studybananas.testutil.TaskBuilder;

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

        // different predicates -> returns false
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

    @Test
    public void test_descriptionContainsKeywords_returnsTrue() {
        // One keyword
        InfoContainsKeywordsPredicate predicate = new InfoContainsKeywordsPredicate(
                Collections.singletonList("Pipeline"));
        assertTrue(predicate.test(new TaskBuilder().withDescription("Pipeline tutorial HomeWork").build()));

        // Multiple keywords
        predicate = new InfoContainsKeywordsPredicate(Arrays.asList("CS2100", "Homework"));
        assertTrue(predicate.test(new TaskBuilder().withDescription("CS2100 pipeline tutorial HomeWork").build()));

        // Mixed-case keywords
        predicate = new InfoContainsKeywordsPredicate(Arrays.asList("tuToriaL", "HomEWorK"));
        assertTrue(predicate.test(new TaskBuilder().withDescription("Pipeline tutorial Homework").build()));
    }

    @Test
    public void test_descriptionDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        InfoContainsKeywordsPredicate predicate = new InfoContainsKeywordsPredicate(Collections.emptyList());
        assertFalse(predicate.test(new TaskBuilder().withDescription("CS2100 Homework").build()));

        // Non-matching keyword
        predicate = new InfoContainsKeywordsPredicate(Arrays.asList("CS2103"));
        assertFalse(predicate.test(new TaskBuilder().withDescription("CS2100 Homework").build()));
    }

    @Test
    public void test_dateTimeContainsKeywords_returnsTrue() {
        // Matching dateTime
        InfoContainsKeywordsPredicate predicate = new InfoContainsKeywordsPredicate(
                Arrays.asList("2020-10-10", "14:00"));
        assertTrue(predicate.test(new TaskBuilder().withDateTime("2020-10-10 14:00").build()));
    }

    @Test
    public void test_dateTimeDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        InfoContainsKeywordsPredicate predicate = new InfoContainsKeywordsPredicate(Collections.emptyList());
        assertFalse(predicate.test(new TaskBuilder().withDateTime("2020-10-10 14:00").build()));

        // Non-matching keyword
        predicate = new InfoContainsKeywordsPredicate(Arrays.asList("2020-10-10", "12:00"));
        assertFalse(predicate.test(new TaskBuilder().withDateTime("2020-10-10 14:00").build()));
    }
}
