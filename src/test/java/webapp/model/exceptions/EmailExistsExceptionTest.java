package webapp.model.exceptions;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for EmailExistsException
 */
public class EmailExistsExceptionTest extends Assert {

    @Test
    public void testExceptionWithMessage() {
        EmailExistsException exception = new EmailExistsException("Email already exists");
        assertNotNull(exception);
        assertEquals("Email already exists", exception.getMessage());
        assertTrue(exception instanceof Exception);
    }

    @Test
    public void testExceptionThrown() {
        try {
            throw new EmailExistsException("Test message");
        } catch (EmailExistsException e) {
            assertEquals("Test message", e.getMessage());
        }
    }
}
