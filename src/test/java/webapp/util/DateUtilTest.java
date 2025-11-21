package webapp.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Tests for DateUtil
 */
public class DateUtilTest extends Assert {

    @Test
    public void testGetDate() {
        Date date = DateUtil.getDate(2023, Calendar.MARCH);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        assertEquals(2023, cal.get(Calendar.YEAR));
        assertEquals(Calendar.MARCH, cal.get(Calendar.MONTH));
    }

    @Test
    public void testGetYear() {
        Date date = DateUtil.getDate(2023, Calendar.MARCH);
        String year = DateUtil.getYear(date);
        assertEquals("2023", year);
    }

    @Test
    public void testGetYearWithNull() {
        String year = DateUtil.getYear(null);
        assertEquals("", year);
    }

    @Test
    public void testGetMonth() {
        Date date = DateUtil.getDate(2023, Calendar.MARCH);
        int month = DateUtil.getMonth(date);
        assertEquals(Calendar.MARCH, month);
    }

    @Test
    public void testGetMonthWithNull() {
        int month = DateUtil.getMonth(null);
        assertEquals(-1, month);
    }

    @Test
    public void testFormatWithDate() {
        Date date = DateUtil.getDate(2023, Calendar.MARCH);
        String formatted = DateUtil.format(date);
        assertEquals("03/2023", formatted);
    }

    @Test
    public void testFormatWithNull() {
        String formatted = DateUtil.format(null);
        assertEquals(DateUtil.NOW, formatted);
    }

    @Test
    public void testMonthConstants() {
        assertEquals("", DateUtil.MONTH[0]);
        assertEquals("JANUARY", DateUtil.MONTH[1]);
        assertEquals("FEBRUARY", DateUtil.MONTH[2]);
        assertEquals("MARCH", DateUtil.MONTH[3]);
        assertEquals("APRIL", DateUtil.MONTH[4]);
        assertEquals("MAY", DateUtil.MONTH[5]);
        assertEquals("JUNE", DateUtil.MONTH[6]);
        assertEquals("JULY", DateUtil.MONTH[7]);
        assertEquals("AUGUST", DateUtil.MONTH[8]);
        assertEquals("SEPTEMBER", DateUtil.MONTH[9]);
        assertEquals("OCTOBER", DateUtil.MONTH[10]);
        assertEquals("NOVEMBER", DateUtil.MONTH[11]);
        assertEquals("DECEMBER", DateUtil.MONTH[12]);
    }
}
