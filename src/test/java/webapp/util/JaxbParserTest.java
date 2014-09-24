package webapp.util;

import org.junit.Assert;
import org.junit.Test;
import webapp.model.Link;
import webapp.model.Organization;
import webapp.model.Period;
import webapp.web.WebAppException;

import java.io.StringReader;
import java.io.StringWriter;

/**
 * Tests for JaxbParser
 */
public class JaxbParserTest extends Assert {

    @Test
    public void testJaxbParserCreation() {
        JaxbParser parser = new JaxbParser(Link.class, Organization.class, Period.class);
        assertNotNull(parser);
    }

    @Test
    public void testMarshallAndUnmarshall() {
        JaxbParser parser = new JaxbParser(Link.class);

        Link link = new Link("Test", "http://test.com");
        StringWriter writer = new StringWriter();

        parser.marshall(link, writer);
        String xml = writer.toString();

        assertNotNull(xml);
        assertTrue(xml.contains("Test"));
        assertTrue(xml.contains("http://test.com"));

        StringReader reader = new StringReader(xml);
        Link unmarshalled = parser.unmarshall(reader);

        assertEquals(link, unmarshalled);
    }

    @Test
    public void testMarshallOrganization() {
        JaxbParser parser = new JaxbParser(Organization.class, Link.class, Period.class);

        Organization org = new Organization("Company", "http://company.com");
        StringWriter writer = new StringWriter();

        parser.marshall(org, writer);
        String xml = writer.toString();

        assertNotNull(xml);
        assertTrue(xml.contains("Company"));
    }

    @Test
    public void testUnmarshallInvalidXml() {
        JaxbParser parser = new JaxbParser(Link.class);
        StringReader reader = new StringReader("invalid xml");

        try {
            parser.unmarshall(reader);
            fail("Expected WebAppException");
        } catch (WebAppException e) {
            assertTrue(e.getMessage().contains("Jaxb unmarshall failed"));
        }
    }

    @Test(expected = WebAppException.class)
    public void testMarshallWithInvalidClass() {
        // Try to create parser with a class that doesn't have JAXB annotations
        new JaxbParser(String.class);
    }
}
