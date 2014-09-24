package webapp.model;

import org.junit.Assert;
import org.junit.Test;
import webapp.util.DateUtil;

import java.util.Calendar;

/**
 * Tests for OrganizationSection
 */
public class OrganizationSectionTest extends Assert {

    @Test
    public void testEmptyConstructor() {
        OrganizationSection section = new OrganizationSection();
        assertNotNull(section);
        assertNotNull(section.getValues());
        assertEquals(0, section.getValues().size());
    }

    @Test
    public void testConstructorWithOrganizations() {
        Period period = new Period(2020, Calendar.JANUARY, 2021, Calendar.DECEMBER, "Developer", "Desc");
        Organization org1 = new Organization("Company1", "http://company1.com", period);
        Organization org2 = new Organization("Company2", "http://company2.com", period);

        OrganizationSection section = new OrganizationSection(org1, org2);

        assertEquals(2, section.getValues().size());
        assertTrue(section.getValues().contains(org1));
        assertTrue(section.getValues().contains(org2));
    }

    @Test
    public void testAdd() {
        OrganizationSection section = new OrganizationSection();
        Period period = new Period(2020, Calendar.JANUARY, 2021, Calendar.DECEMBER, "Developer", "Desc");
        Organization org = new Organization("Company", "http://company.com", period);

        section.add(org);

        assertEquals(1, section.getValues().size());
        assertTrue(section.getValues().contains(org));
    }

    @Test
    public void testAddFirst() {
        Period period = new Period(2020, Calendar.JANUARY, 2021, Calendar.DECEMBER, "Developer", "Desc");
        Organization org1 = new Organization("Company1", "http://company1.com", period);
        Organization org2 = new Organization("Company2", "http://company2.com", period);

        OrganizationSection section = new OrganizationSection(org1);
        section.addFirst(org2);

        assertEquals(2, section.getValues().size());
        // Check that org2 is first
        assertEquals(org2, section.getValues().iterator().next());
    }

    @Test
    public void testEquals() {
        Period period = new Period(2020, Calendar.JANUARY, 2021, Calendar.DECEMBER, "Developer", "Desc");
        Organization org = new Organization("Company", "http://company.com", period);

        OrganizationSection section1 = new OrganizationSection(org);
        OrganizationSection section2 = new OrganizationSection(org);
        OrganizationSection section3 = new OrganizationSection();

        assertEquals(section1, section2);
        assertNotEquals(section1, section3);
        assertEquals(section1, section1);
        assertNotEquals(section1, null);
    }

    @Test
    public void testHashCode() {
        Period period = new Period(2020, Calendar.JANUARY, 2021, Calendar.DECEMBER, "Developer", "Desc");
        Organization org = new Organization("Company", "http://company.com", period);

        OrganizationSection section1 = new OrganizationSection(org);
        OrganizationSection section2 = new OrganizationSection(org);

        assertEquals(section1.hashCode(), section2.hashCode());
    }

    @Test
    public void testEmptyConstant() {
        assertNotNull(OrganizationSection.EMPTY);
        assertEquals(1, OrganizationSection.EMPTY.getValues().size());
        assertEquals(Organization.EMPTY, OrganizationSection.EMPTY.getValues().iterator().next());
    }

    @Test
    public void testSerialVersionUID() {
        assertEquals(1L, OrganizationSection.serialVersionUID);
    }

    @Test
    public void testGetContent() {
        Period period = new Period(2020, Calendar.JANUARY, 2021, Calendar.DECEMBER, "Developer", "Desc");
        Organization org = new Organization("Company", "http://company.com", period);
        OrganizationSection section = new OrganizationSection(org);

        assertEquals(section.getValues(), section.getContent());
    }
}
