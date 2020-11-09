package seedu.studybananas.model.task;

import static java.util.Objects.requireNonNull;

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

    private boolean doesKeywordMatchesTitle(Task task, String keyword) {
        return StringUtil.containsWordIgnoreCase(task.getTitle().title, keyword);
    }

    private boolean doesKeywordMatchesDescription(Optional<Description> description, String keyword) {
        return description.map(desc -> StringUtil.containsWordIgnoreCase(
                desc.toStringNoPunctuation(),
                StringUtil.getStringNoPunctuation(keyword)
        )).orElse(false);
    }

    private boolean doesKeywordMatchesDateTime(Optional<DateTime> dateTime, String keyword) {
        return dateTime.map(date ->
                StringUtil.containsWordIgnoreCase(date.toString(), (keyword)) || StringUtil.containsWordIgnoreCase(
                        date.getUiFormatDateNoPunctuation(),
                        StringUtil.getStringNoPunctuation(keyword)))
                .orElse(false);
    }

    private boolean doesTitleContainKeywords(Task task) {
        requireNonNull(task);
        return keywords.stream()
                .anyMatch(keyword -> doesKeywordMatchesTitle(task, keyword));
    }

    private boolean doesDescriptionContainKeywords(Task task) {
        requireNonNull(task);
        Optional<Description> description = task.getDescription();
        return !isEmptyKeyword(keywords) && keywords.stream()
                .allMatch(keyword -> doesKeywordMatchesDescription(description, keyword));
    }

    private boolean doesDateTimeContainKeywords(Task task) {
        requireNonNull(task);
        Optional<DateTime> dateTime = task.getDateTime();
        return !isEmptyKeyword(keywords) && keywords.stream()
                .allMatch(keyword -> doesKeywordMatchesDateTime(dateTime , keyword));
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
