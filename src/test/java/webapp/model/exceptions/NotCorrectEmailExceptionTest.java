package webapp.model.exceptions;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for NotCorrectEmailException
 */
public class NotCorrectEmailExceptionTest extends Assert {

    @Test
    public void testExceptionCreation() {
        NotCorrectEmailException exception = new NotCorrectEmailException();
        assertNotNull(exception);
        assertTrue(exception instanceof Exception);
    }

    @Test
    public void testExceptionThrown() {
        try {
            throw new NotCorrectEmailException();
        } catch (NotCorrectEmailException e) {
            assertNotNull(e);
        }
    }
}
