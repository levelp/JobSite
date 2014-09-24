package webapp.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for TextSection
 */
public class TextSectionTest extends Assert {

    @Test
    public void testEmptyConstructor() {
        TextSection section = new TextSection();
        assertNotNull(section);
        assertNotNull(section.getValues());
        assertEquals(0, section.getValues().size());
    }

    @Test
    public void testConstructorWithContent() {
        TextSection section = new TextSection("Text1", "Text2", "Text3");
        assertEquals(3, section.getValues().size());
        assertTrue(section.getValues().contains("Text1"));
        assertTrue(section.getValues().contains("Text2"));
        assertTrue(section.getValues().contains("Text3"));
    }

    @Test
    public void testAdd() {
        TextSection section = new TextSection();
        section.add("Text1");
        assertEquals(1, section.getValues().size());
        assertTrue(section.getValues().contains("Text1"));
    }

    @Test
    public void testAddFirst() {
        TextSection section = new TextSection("Text1");
        section.addFirst("Text2");
        assertEquals(2, section.getValues().size());
        // Check that Text2 is first
        assertEquals("Text2", section.getValues().iterator().next());
    }

    @Test
    public void testGetContent() {
        TextSection section = new TextSection("Text1", "Text2");
        assertEquals(section.getValues(), section.getContent());
    }

    @Test
    public void testEquals() {
        TextSection section1 = new TextSection("Text1", "Text2");
        TextSection section2 = new TextSection("Text1", "Text2");
        TextSection section3 = new TextSection("Text3");

        assertEquals(section1, section2);
        assertNotEquals(section1, section3);
        assertEquals(section1, section1);
        assertNotEquals(section1, null);
        assertNotEquals(section1, "string");
    }

    @Test
    public void testHashCode() {
        TextSection section1 = new TextSection("Text1", "Text2");
        TextSection section2 = new TextSection("Text1", "Text2");

        assertEquals(section1.hashCode(), section2.hashCode());
    }

    @Test
    public void testToString() {
        TextSection section = new TextSection("Text1");
        String str = section.toString();
        assertTrue(str.contains("Section"));
        assertTrue(str.contains("Text1"));
    }

    @Test
    public void testEmptyConstant() {
        assertNotNull(TextSection.EMPTY);
        assertEquals(1, TextSection.EMPTY.getValues().size());
        assertEquals("", TextSection.EMPTY.getValues().iterator().next());
    }

    @Test
    public void testSerialVersionUID() {
        assertEquals(1L, TextSection.serialVersionUID);
    }

    @Test
    public void testEqualsDifferentClass() {
        TextSection textSection = new TextSection("Text1");
        OrganizationSection orgSection = new OrganizationSection();
        assertNotEquals(textSection, orgSection);
    }
}
