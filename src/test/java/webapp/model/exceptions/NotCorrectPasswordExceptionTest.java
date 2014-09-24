package webapp.model.exceptions;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for NotCorrectPasswordException
 */
public class NotCorrectPasswordExceptionTest extends Assert {

    @Test
    public void testExceptionWithMessage() {
        NotCorrectPasswordException exception = new NotCorrectPasswordException("Password too short");
        assertNotNull(exception);
        assertEquals("Password too short", exception.getMessage());
        assertTrue(exception instanceof Exception);
    }

    @Test
    public void testExceptionThrown() {
        try {
            throw new NotCorrectPasswordException("Test message");
        } catch (NotCorrectPasswordException e) {
            assertEquals("Test message", e.getMessage());
        }
    }
}
