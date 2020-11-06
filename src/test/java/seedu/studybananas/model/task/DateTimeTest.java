package seedu.studybananas.model.task;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.studybananas.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import seedu.studybananas.model.task.exceptions.TimeFormatException;

import java.sql.Time;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTimeTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new DateTime(null));
    }

    @Test
    public void isValidDateTime() {
        // null date time
        assertThrows(NullPointerException.class, () -> DateTime.isValidDateTime(null));

        // invalid date time
        assertFalse(DateTime.isValidDateTime(" ")); // spaces only
        assertFalse(DateTime.isValidDateTime("10/12/2020 12:00")); // wrong format in dd/MM/yyyy hh:mm
        assertFalse(DateTime.isValidDateTime("date")); // non-numeric
        assertFalse(DateTime.isValidDateTime("2020/03/20")); // wrong format
        assertFalse(DateTime.isValidDateTime("Tusday")); // wrong spelling
        assertFalse(DateTime.isValidDateTime("Tuesday 8:00")); // wrong time format

        // valid date time
        assertTrue(DateTime.isValidDateTime("2020-10-10")); // correct format
        assertTrue(DateTime.isValidDateTime("2020-11-10 09:00")); // correct format
        assertTrue(DateTime.isValidDateTime("Thursday, Oct 29 2020 08:00")); // correct format
        assertTrue(DateTime.isValidDateTime("Friday, Nov 06 2020 21:00")); // correct format
        assertTrue(DateTime.isValidDateTime("today 12:00"));
        assertTrue(DateTime.isValidDateTime("tomorrow 13:00"));
        assertTrue(DateTime.isValidDateTime("wed 23:00"));
        assertTrue(DateTime.isValidDateTime("Sunday 06:00"));
    }

    @Test
    public void equals() {
        String sampleValidDateTime1 = "2020-11-06 16:00";
        String sampleValidDateTime2 = "Thursday, Nov 05 2020 12:00";

        DateTime firstDateTime = new DateTime(sampleValidDateTime1);
        DateTime secondDateTime = new DateTime(sampleValidDateTime2);

        // Same object -> returns true
        assertTrue(firstDateTime.equals(firstDateTime));

        // Same value -> returns true
        assertTrue(firstDateTime.equals(new DateTime(sampleValidDateTime1)));

        // Different objects -> returns false
        assertFalse(firstDateTime.equals(secondDateTime));

        // Different types -> returns false
        assertFalse(firstDateTime.equals(1));

        // null -> returns false
        assertFalse(firstDateTime.equals(null));
    }

    @Test
    public void getToday() {
        DateTime todayDateTime = DateTime.getToday(12, 30);
        LocalDate expectedLocalDate = LocalDate.now();
        String expectedLocalDateTimeString = expectedLocalDate.toString() + " 12:30";
        DateTime expectedTodayDateTime = new DateTime(expectedLocalDateTimeString);
        assertEquals(expectedTodayDateTime, todayDateTime);
    }

    @Test
    public void getYesterday() {
        DateTime yesterdayDateTime = DateTime.getYesterday(12, 30);
        LocalDate expectedLocalDate = LocalDate.now().minusDays(1);
        String expectedLocalDateTimeString = expectedLocalDate.toString() + " 12:30";
        DateTime expectedYesterdayDateTime = new DateTime(expectedLocalDateTimeString);
        assertEquals(expectedYesterdayDateTime, yesterdayDateTime);
    }

    @Test
    public void isToday_todayDate_returnsTrue() {
        String todayDateString = LocalDate.now().toString();
        DateTime dateTime = new DateTime(todayDateString);
        assertTrue(dateTime.isToday());
    }

    @Test
    public void isToday_notTodayDate_returnsFalse() {
        String dateString = LocalDate.now().minusDays(2).toString();
        DateTime dateTime = new DateTime(dateString);
        assertFalse(dateTime.isToday());
    }

    @Test
    public void getUiFormatDateNoPunctuation() {
        String dateTimeString = "2020-11-06 13:00";
        String expectedUiDateTimeString = "Friday  Nov 06 2020";
        DateTime dateTime = new DateTime(dateTimeString);
        assertEquals(expectedUiDateTimeString, dateTime.getUiFormatDateNoPunctuation());
    }

    @Test
    public void getUiFormatDate() {
        String dateTimeString = "2020-11-06 13:00";
        String expectedUiDateTimeString = "Friday, Nov 06 2020";
        DateTime dateTime = new DateTime(dateTimeString);
        assertEquals(expectedUiDateTimeString, dateTime.getUiFormatDate());
    }

    @Test
    public void getStandardFormatTime() {
        String dateTimeString = "2020-11-06 13:00";
        String expectedTimeString = "13:00";
        DateTime dateTime = new DateTime(dateTimeString);
        assertEquals(dateTime.getStandardFormatTime(), expectedTimeString);
    }
}
