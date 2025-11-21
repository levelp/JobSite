package webapp.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for Util
 */
public class UtilTest extends Assert {

    @Test
    public void testMaskWithNull() {
        String result = Util.mask(null);
        assertEquals("", result);
    }

    @Test
    public void testMaskWithString() {
        String result = Util.mask("test");
        assertEquals("test", result);
    }

    @Test
    public void testMaskWithEmptyString() {
        String result = Util.mask("");
        assertEquals("", result);
    }

    @Test
    public void testIsEmptyArrayWithNull() {
        assertTrue(Util.isEmpty((Object[]) null));
    }

    @Test
    public void testIsEmptyArrayWithEmptyArray() {
        assertTrue(Util.isEmpty(new Object[]{}));
    }

    @Test
    public void testIsEmptyArrayWithNonEmptyArray() {
        assertFalse(Util.isEmpty(new Object[]{"test"}));
    }

    @Test
    public void testIsEmptyStringWithNull() {
        assertTrue(Util.isEmpty((String) null));
    }

    @Test
    public void testIsEmptyStringWithEmptyString() {
        assertTrue(Util.isEmpty(""));
    }

    @Test
    public void testIsEmptyStringWithWhitespace() {
        assertTrue(Util.isEmpty("   "));
    }

    @Test
    public void testIsEmptyStringWithNonEmptyString() {
        assertFalse(Util.isEmpty("test"));
    }

    @Test
    public void testIsEmptyStringWithWhitespaceAndText() {
        assertFalse(Util.isEmpty("  test  "));
    }
}
