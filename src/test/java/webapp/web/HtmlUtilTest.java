package webapp.web;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for HtmlUtil
 */
public class HtmlUtilTest extends Assert {

    @Test
    public void testMaskWithNull() {
        String result = HtmlUtil.mask(null);
        assertEquals(HtmlUtil.EMPTY_TD, result);
    }

    @Test
    public void testMaskWithEmptyString() {
        String result = HtmlUtil.mask("");
        assertEquals(HtmlUtil.EMPTY_TD, result);
    }

    @Test
    public void testMaskWithWhitespace() {
        String result = HtmlUtil.mask("   ");
        assertEquals(HtmlUtil.EMPTY_TD, result);
    }

    @Test
    public void testMaskWithValue() {
        String result = HtmlUtil.mask("test");
        assertEquals("test", result);
    }

    @Test
    public void testGetUtlWithNull() {
        String result = HtmlUtil.getUtl(null);
        assertEquals("", result);
    }

    @Test
    public void testGetUtlWithEmptyString() {
        String result = HtmlUtil.getUtl("");
        assertEquals("", result);
    }

    @Test
    public void testGetUtlWithWhitespace() {
        String result = HtmlUtil.getUtl("   ");
        assertEquals("", result);
    }

    @Test
    public void testGetUtlWithHttp() {
        String result = HtmlUtil.getUtl("http://example.com");
        assertEquals("http://example.com", result);
    }

    @Test
    public void testGetUtlWithHttps() {
        String result = HtmlUtil.getUtl("https://example.com");
        assertEquals("https://example.com", result);
    }

    @Test
    public void testGetUtlWithoutProtocol() {
        String result = HtmlUtil.getUtl("example.com");
        assertEquals("http://example.com", result);
    }

    @Test
    public void testEmptyTdConstant() {
        assertEquals("<img src='img/s.gif'>", HtmlUtil.EMPTY_TD);
    }
}
