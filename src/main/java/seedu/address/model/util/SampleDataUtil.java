package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.systemlevelmodel.AddressBook;
import seedu.address.model.systemlevelmodel.ReadOnlyAddressBook;
import seedu.address.model.systemlevelmodel.ReadOnlySchedule;
import seedu.address.model.systemlevelmodel.Schedule;
import seedu.address.model.tag.Tag;
import seedu.address.model.task.DateTime;
import seedu.address.model.task.Description;
import seedu.address.model.task.Task;
import seedu.address.model.task.Title;

/**
 * Contains utility methods for populating {@code StudyBananas} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                getTagSet("friends")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                getTagSet("neighbours")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"),
                getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"),
                getTagSet("colleagues"))
        };
    }

    public static Task[] getSampleTasks() {
        return new Task[] {
            new Task(new Title("CS2103T"), new Description("Week 8 topics quiz."),
                    new DateTime("2020-10-09 23:59")),
            new Task(new Title("CS2103T"), new Description("Week 9 topics quiz."),
                    new DateTime("2020-10-16 23:59")),
            new Task(new Title("CS2103T"), new Description("Popping dance lecture."),
                    new DateTime("2020-10-23 23:59")),
            new Task(new Title("CCA"), new Description("Week 10 topics quiz."),
                    new DateTime("2020-10-08 13:00")),
            new Task(new Title("Household"), null,
                    new DateTime("2020-11-11 12:30")),
            new Task(new Title("Job"), new Description(""),
                    new DateTime("2020-09-29 22:00"))
        };
    }


    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    public static ReadOnlySchedule getSampleSchedule() {
        Schedule sampleSchedule = new Schedule();
        for (Task sampleTask : getSampleTasks()) {
            sampleSchedule.addTask(sampleTask);
        }
        return sampleSchedule;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
