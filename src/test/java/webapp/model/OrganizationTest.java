package webapp.model;

import org.junit.Assert;
import org.junit.Test;
import webapp.util.DateUtil;

import java.util.Calendar;
import java.util.LinkedList;

/**
 * Tests for Organization
 */
public class OrganizationTest extends Assert {

    @Test
    public void testEmptyConstructor() {
        Organization org = new Organization();
        assertNotNull(org);
        assertEquals(Link.EMPTY, org.getLink());
        assertNotNull(org.getPeriods());
        assertEquals(0, org.getPeriods().size());
    }

    @Test
    public void testConstructorWithPeriodsArray() {
        Period period1 = new Period(2020, Calendar.JANUARY, 2021, Calendar.DECEMBER, "Developer", "Desc1");
        Period period2 = new Period(2021, Calendar.JANUARY, 2022, Calendar.DECEMBER, "Senior", "Desc2");

        Organization org = new Organization("Company", "http://company.com", period1, period2);

        assertEquals("Company", org.getLink().getName());
        assertEquals("http://company.com", org.getLink().getUrl());
        assertEquals(2, org.getPeriods().size());
    }

    @Test
    public void testConstructorWithPeriodsList() {
        Period period1 = new Period(2020, Calendar.JANUARY, 2021, Calendar.DECEMBER, "Developer", "Desc1");
        LinkedList<Period> periods = new LinkedList<>();
        periods.add(period1);

        Organization org = new Organization("Company", "http://company.com", periods);

        assertEquals("Company", org.getLink().getName());
        assertEquals("http://company.com", org.getLink().getUrl());
        assertEquals(1, org.getPeriods().size());
    }

    @Test
    public void testAdd() {
        Organization org = new Organization();
        Period period = new Period(2020, Calendar.JANUARY, 2021, Calendar.DECEMBER, "Developer", "Desc");

        org.add(period);

        assertEquals(1, org.getPeriods().size());
        assertTrue(org.getPeriods().contains(period));
    }

    @Test
    public void testAddFirstPeriod() {
        Organization org = new Organization();
        Period period1 = new Period(2020, Calendar.JANUARY, 2021, Calendar.DECEMBER, "Developer", "Desc1");
        Period period2 = new Period(2021, Calendar.JANUARY, 2022, Calendar.DECEMBER, "Senior", "Desc2");

        org.add(period1);
        org.addFirstPeriod(period2);

        assertEquals(2, org.getPeriods().size());
        // Check that period2 is first
        LinkedList<Period> periodsList = new LinkedList<>(org.getPeriods());
        assertEquals(period2, periodsList.get(0));
    }

    @Test
    public void testEquals() {
        Period period = new Period(2020, Calendar.JANUARY, 2021, Calendar.DECEMBER, "Developer", "Desc");
        Organization org1 = new Organization("Company", "http://company.com", period);
        Organization org2 = new Organization("Company", "http://company.com", period);
        Organization org3 = new Organization("Other", "http://other.com", period);

        assertEquals(org1, org2);
        assertNotEquals(org1, org3);
        assertEquals(org1, org1);
        assertNotEquals(org1, null);
        assertNotEquals(org1, "string");
    }

    @Test
    public void testHashCode() {
        Period period = new Period(2020, Calendar.JANUARY, 2021, Calendar.DECEMBER, "Developer", "Desc");
        Organization org1 = new Organization("Company", "http://company.com", period);
        Organization org2 = new Organization("Company", "http://company.com", period);

        assertEquals(org1.hashCode(), org2.hashCode());
    }

    @Test
    public void testToString() {
        Period period = new Period(2020, Calendar.JANUARY, 2021, Calendar.DECEMBER, "Developer", "Desc");
        Organization org = new Organization("Company", "http://company.com", period);
        String str = org.toString();

        assertTrue(str.contains("Organization{"));
        assertTrue(str.contains("link="));
        assertTrue(str.contains("periods="));
    }

    @Test
    public void testEmptyConstant() {
        assertNotNull(Organization.EMPTY);
        assertEquals(Link.EMPTY, Organization.EMPTY.getLink());
        // EMPTY should have one EMPTY period added
        assertEquals(1, Organization.EMPTY.getPeriods().size());
    }
}
