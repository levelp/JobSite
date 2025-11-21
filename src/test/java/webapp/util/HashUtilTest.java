package webapp.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for HashUtil
 */
public class HashUtilTest extends Assert {

    @Test
    public void testMd5() throws Exception {
        String hash = HashUtil.md5("test");
        assertNotNull(hash);
        assertEquals(32, hash.length());
        assertEquals("098f6bcd4621d373cade4e832627b4f6", hash);
    }

    @Test
    public void testMd5WithEmptyString() throws Exception {
        String hash = HashUtil.md5("");
        assertNotNull(hash);
        assertEquals(32, hash.length());
        assertEquals("d41d8cd98f00b204e9800998ecf8427e", hash);
    }

    @Test
    public void testMd5WithDifferentStrings() throws Exception {
        String hash1 = HashUtil.md5("test1");
        String hash2 = HashUtil.md5("test2");
        assertNotEquals(hash1, hash2);
    }

    @Test
    public void testMd5Consistency() throws Exception {
        String hash1 = HashUtil.md5("test");
        String hash2 = HashUtil.md5("test");
        assertEquals(hash1, hash2);
    }

    @Test
    public void testMd5WithUnicodeCharacters() throws Exception {
        String hash = HashUtil.md5("тест");
        assertNotNull(hash);
        assertEquals(32, hash.length());
    }

    @Test
    public void testMd5LeadingZeros() throws Exception {
        // Test a string that produces a hash with leading zeros
        String hash = HashUtil.md5("00000");
        assertNotNull(hash);
        assertEquals(32, hash.length());
    }
}
