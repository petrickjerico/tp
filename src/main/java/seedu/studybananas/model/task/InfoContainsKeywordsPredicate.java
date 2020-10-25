package seedu.studybananas.model.task;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import seedu.studybananas.commons.util.StringUtil;

public class InfoContainsKeywordsPredicate implements Predicate<Task> {
    private final List<String> keywords;

    public InfoContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    private boolean isEmptyKeyword(List<String> keywords) {
        return keywords.size() == 0;
    }

    private boolean doesTitleContainKeywords(Task task) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(task.getTitle().title, keyword));
    }

    private boolean doesDescriptionContainKeywords(Task task) {
        Optional<Description> description = task.getDescription();
        return !isEmptyKeyword(keywords) && keywords.stream()
                .allMatch(keyword -> description.map(desc ->
                        StringUtil.containsWordIgnoreCase(desc.toString(), keyword)).orElse(false));
    }

    private boolean doesDateTimeContainKeywords(Task task) {
        Optional<DateTime> dateTime = task.getDateTime();
        return !isEmptyKeyword(keywords) && keywords.stream()
                .allMatch(keyword -> dateTime.map(date ->
                        StringUtil.containsWordIgnoreCase(date.toString(), keyword)).orElse(false));
    }

    @Override
    public boolean test(Task task) {
        return doesDateTimeContainKeywords(task) || doesDescriptionContainKeywords(task)
                || doesTitleContainKeywords(task);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof InfoContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((InfoContainsKeywordsPredicate) other).keywords)); // state check
    }
}
