package webapp.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for Link
 */
public class LinkTest extends Assert {

    @Test
    public void testEmptyConstructor() {
        Link link = new Link();
        assertEquals("", link.getName());
        assertNull(link.getUrl());
    }

    @Test
    public void testConstructorWithParameters() {
        Link link = new Link("Test", "http://test.com");
        assertEquals("Test", link.getName());
        assertEquals("http://test.com", link.getUrl());
    }

    @Test
    public void testEquals() {
        Link link1 = new Link("Test", "http://test.com");
        Link link2 = new Link("Test", "http://test.com");
        Link link3 = new Link("Other", "http://other.com");

        assertEquals(link1, link2);
        assertNotEquals(link1, link3);
        assertEquals(link1, link1);
        assertNotEquals(link1, null);
        assertNotEquals(link1, "string");
    }

    @Test
    public void testEqualsWithNulls() {
        Link link1 = new Link(null, null);
        Link link2 = new Link(null, null);
        Link link3 = new Link("Test", null);
        Link link4 = new Link(null, "http://test.com");

        assertEquals(link1, link2);
        assertNotEquals(link1, link3);
        assertNotEquals(link1, link4);
    }

    @Test
    public void testHashCode() {
        Link link1 = new Link("Test", "http://test.com");
        Link link2 = new Link("Test", "http://test.com");

        assertEquals(link1.hashCode(), link2.hashCode());
    }

    @Test
    public void testHashCodeWithNulls() {
        Link link1 = new Link(null, null);
        Link link2 = new Link(null, null);

        assertEquals(link1.hashCode(), link2.hashCode());
    }

    @Test
    public void testToString() {
        Link link = new Link("Test", "http://test.com");
        String str = link.toString();
        assertTrue(str.contains("Test"));
        assertTrue(str.contains("http://test.com"));
        assertTrue(str.contains("Link{"));
    }

    @Test
    public void testEmptyConstant() {
        assertNotNull(Link.EMPTY);
        assertEquals("", Link.EMPTY.getName());
        assertNull(Link.EMPTY.getUrl());
    }
}
