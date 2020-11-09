package seedu.studybananas.ui.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.studybananas.model.task.DateTime;

public class ScheduleUiUtilTest {
    @Test
    public void checkTimePatternTest() {
        // EP1 1:00 ~ 12:59 (AM | PM)
        // test AM
        assertTrue(ScheduleUiUtil.checkTimePattern("6:00 AM"));
        // test PM
        assertTrue(ScheduleUiUtil.checkTimePattern("6:00 PM"));
        // test am
        assertFalse(ScheduleUiUtil.checkTimePattern("6:00 am"));
        // test pm
        assertFalse(ScheduleUiUtil.checkTimePattern("6:00 pm"));
        // test BVs
        assertTrue(ScheduleUiUtil.checkTimePattern("12:59 AM"));
        assertTrue(ScheduleUiUtil.checkTimePattern("1:00 AM"));
        // test BV for hour
        assertFalse(ScheduleUiUtil.checkTimePattern("0:30 AM"));
        // test BV for minute
        assertFalse(ScheduleUiUtil.checkTimePattern("6:60 AM"));

        //EP 2 13:00~
        assertFalse(ScheduleUiUtil.checkTimePattern("13:30 AM"));
    }

    @Test
    public void toAmPmTimeTest() {
        // EP1 00:00 ~ 23:59 (AM | PM)
        assertEquals(ScheduleUiUtil.toAmPmTime("06:00"), "6:00 AM");
        // test BVs
        assertEquals(ScheduleUiUtil.toAmPmTime("00:00"), "12:00 AM");
        assertEquals(ScheduleUiUtil.toAmPmTime("23:59"), "11:59 PM");
        assertEquals(ScheduleUiUtil.toAmPmTime("12:00"), "12:00 PM");
    }

    @Test
    public void getMarginFromTimeTest() {
        assertEquals(ScheduleUiUtil.getMarginFromTime("06:30"), ScheduleUiUtil.INITIAL_PADDING
                + 6 * ScheduleUiUtil.MARGIN_PER_HOUR + ScheduleUiUtil.MARGIN_PER_MINUTE * 30);
    }

    @Test
    public void getMarginFromDateTimeTest() {
        DateTime dateTime = DateTime.getToday(6, 30);
        assertEquals(ScheduleUiUtil.getMarginFromDateTime(dateTime), ScheduleUiUtil.INITIAL_PADDING
                + 6 * ScheduleUiUtil.MARGIN_PER_HOUR + ScheduleUiUtil.MARGIN_PER_MINUTE * 30);
    }
}
