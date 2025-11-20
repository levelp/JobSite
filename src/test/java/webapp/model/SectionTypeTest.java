package webapp.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for SectionType
 */
public class SectionTypeTest extends Assert {

    @Test
    public void testObjective() {
        assertEquals("Позиция", SectionType.OBJECTIVE.getTitle());
        assertEquals(SectionClass.TEXT, SectionType.OBJECTIVE.getSectionClass());
    }

    @Test
    public void testAchievement() {
        assertEquals("Достижения", SectionType.ACHIEVEMENT.getTitle());
        assertEquals(SectionClass.TEXT, SectionType.ACHIEVEMENT.getSectionClass());
    }

    @Test
    public void testQualifications() {
        assertEquals("Квалификация", SectionType.QUALIFICATIONS.getTitle());
        assertEquals(SectionClass.TEXT, SectionType.QUALIFICATIONS.getSectionClass());
    }

    @Test
    public void testExperience() {
        assertEquals("Опыт работы", SectionType.EXPERIENCE.getTitle());
        assertEquals(SectionClass.ORGANIZATION, SectionType.EXPERIENCE.getSectionClass());
    }

    @Test
    public void testEducation() {
        assertEquals("Образование", SectionType.EDUCATION.getTitle());
        assertEquals(SectionClass.ORGANIZATION, SectionType.EDUCATION.getSectionClass());
    }

    @Test
    public void testAddEmptyValueForObjective() {
        TextSection section = new TextSection();
        int initialSize = section.getValues().size();
        SectionType.OBJECTIVE.addEmptyValue(section);
        // OBJECTIVE overrides to do nothing
        assertEquals(initialSize, section.getValues().size());
    }

    @Test
    public void testAddEmptyValueForAchievement() {
        TextSection section = new TextSection();
        SectionType.ACHIEVEMENT.addEmptyValue(section);
        assertEquals(1, section.getValues().size());
        assertEquals("", section.getValues().iterator().next());
    }

    @Test
    public void testAddEmptyValueForExperience() {
        OrganizationSection section = new OrganizationSection();
        SectionType.EXPERIENCE.addEmptyValue(section);
        assertEquals(1, section.getValues().size());
    }
}
