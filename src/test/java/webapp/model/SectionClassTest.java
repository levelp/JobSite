package webapp.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for SectionClass
 */
public class SectionClassTest extends Assert {

    @Test
    public void testTextCreate() {
        Section section = SectionClass.TEXT.create();
        assertNotNull(section);
        assertTrue(section instanceof TextSection);
    }

    @Test
    public void testOrganizationCreate() {
        Section section = SectionClass.ORGANIZATION.create();
        assertNotNull(section);
        assertTrue(section instanceof OrganizationSection);
    }

    @Test
    public void testTextGetEmptySection() {
        Section section = SectionClass.TEXT.getEmptySection();
        assertNotNull(section);
        assertEquals(TextSection.EMPTY, section);
    }

    @Test
    public void testOrganizationGetEmptySection() {
        Section section = SectionClass.ORGANIZATION.getEmptySection();
        assertNotNull(section);
        assertEquals(OrganizationSection.EMPTY, section);
    }

    @Test
    public void testTextAddEmptyValue() {
        TextSection section = new TextSection();
        SectionClass.TEXT.addEmptyValue(section);
        assertEquals(1, section.getValues().size());
        assertEquals("", section.getValues().iterator().next());
    }

    @Test
    public void testOrganizationAddEmptyValue() {
        OrganizationSection section = new OrganizationSection();
        SectionClass.ORGANIZATION.addEmptyValue(section);
        assertEquals(1, section.getValues().size());
    }

    @Test
    public void testOrganizationAddEmptyValueWithExistingOrganization() {
        Period period = new Period();
        Organization org = new Organization("Test", "http://test.com", period);
        OrganizationSection section = new OrganizationSection(org);

        int initialPeriods = org.getPeriods().size();
        SectionClass.ORGANIZATION.addEmptyValue(section);

        // Should add Period.EMPTY to existing organizations and add Organization.EMPTY
        assertEquals(2, section.getValues().size());
        assertEquals(initialPeriods + 1, org.getPeriods().size());
    }
}
