package webapp.model;

import org.junit.Assert;
import org.junit.Test;
import webapp.util.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * Tests for Period
 */
public class PeriodTest extends Assert {

    @Test
    public void testEmptyConstructor() {
        Period period = new Period();
        assertNotNull(period);
        assertNull(period.getStartDate());
        assertNull(period.getEndDate());
        assertNull(period.getPosition());
        assertNull(period.getContent());
    }

    @Test
    public void testConstructorWithDates() {
        Date start = DateUtil.getDate(2020, Calendar.JANUARY);
        Date end = DateUtil.getDate(2021, Calendar.DECEMBER);
        Period period = new Period(start, end, "Developer", "Description");

        assertEquals(start, period.getStartDate());
        assertEquals(end, period.getEndDate());
        assertEquals("Developer", period.getPosition());
        assertEquals("Description", period.getContent());
    }

    @Test
    public void testConstructorWithYearMonth() {
        Period period = new Period(2020, Calendar.JANUARY, 2021, Calendar.DECEMBER, "Developer", "Description");

        assertNotNull(period.getStartDate());
        assertNotNull(period.getEndDate());
        assertEquals("Developer", period.getPosition());
        assertEquals("Description", period.getContent());

        Calendar cal = Calendar.getInstance();
        cal.setTime(period.getStartDate());
        assertEquals(2020, cal.get(Calendar.YEAR));
        assertEquals(Calendar.JANUARY, cal.get(Calendar.MONTH));

        cal.setTime(period.getEndDate());
        assertEquals(2021, cal.get(Calendar.YEAR));
        assertEquals(Calendar.DECEMBER, cal.get(Calendar.MONTH));
    }

    @Test
    public void testEquals() {
        Date start = DateUtil.getDate(2020, Calendar.JANUARY);
        Date end = DateUtil.getDate(2021, Calendar.DECEMBER);
        Period period1 = new Period(start, end, "Developer", "Description");
        Period period2 = new Period(start, end, "Developer", "Description");
        Period period3 = new Period(start, end, "Manager", "Other");

        assertEquals(period1, period2);
        assertNotEquals(period1, period3);
        assertEquals(period1, period1);
        assertNotEquals(period1, null);
        assertNotEquals(period1, "string");
    }

    @Test
    public void testEqualsWithNulls() {
        Period period1 = new Period(null, null, null, null);
        Period period2 = new Period(null, null, null, null);

        assertEquals(period1, period2);
    }

    @Test
    public void testHashCode() {
        Date start = DateUtil.getDate(2020, Calendar.JANUARY);
        Date end = DateUtil.getDate(2021, Calendar.DECEMBER);
        Period period1 = new Period(start, end, "Developer", "Description");
        Period period2 = new Period(start, end, "Developer", "Description");

        assertEquals(period1.hashCode(), period2.hashCode());
    }

    @Test
    public void testToString() {
        Date start = DateUtil.getDate(2020, Calendar.JANUARY);
        Date end = DateUtil.getDate(2021, Calendar.DECEMBER);
        Period period = new Period(start, end, "Developer", "Description");
        String str = period.toString();

        assertTrue(str.contains("Period{"));
        assertTrue(str.contains("Developer"));
        assertTrue(str.contains("Description"));
    }

    @Test
    public void testEmptyConstant() {
        assertNotNull(Period.EMPTY);
    }
}
