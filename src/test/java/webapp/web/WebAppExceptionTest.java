package webapp.web;

import org.junit.Assert;
import org.junit.Test;
import webapp.model.Resume;
import webapp.model.User;

/**
 * Tests for WebAppException
 */
public class WebAppExceptionTest extends Assert {

    @Test
    public void testConstructorWithMessage() {
        WebAppException exception = new WebAppException("Test message");
        assertEquals("Test message", exception.getMessage());
        assertNull(exception.getResume());
        assertNull(exception.getUuid());
    }

    @Test
    public void testConstructorWithMessageAndThrowable() {
        Throwable cause = new RuntimeException("Cause");
        WebAppException exception = new WebAppException("Test message", cause);
        assertEquals("Test message", exception.getMessage());
        assertEquals(cause, exception.getCause());
        assertNull(exception.getResume());
        assertNull(exception.getUuid());
    }

    @Test
    public void testConstructorWithMessageAndResume() {
        User user = new User();
        Resume resume = new Resume(user, "123456");
        WebAppException exception = new WebAppException("Test message", resume);
        assertEquals("Test message", exception.getMessage());
        assertEquals(resume, exception.getResume());
        assertNull(exception.getUuid());
    }

    @Test
    public void testConstructorWithMessageResumeAndThrowable() {
        User user = new User();
        Resume resume = new Resume(user, "123456");
        Throwable cause = new RuntimeException("Cause");
        WebAppException exception = new WebAppException("Test message", resume, cause);
        assertEquals("Test message", exception.getMessage());
        assertEquals(resume, exception.getResume());
        assertEquals(cause, exception.getCause());
        assertNull(exception.getUuid());
    }

    @Test
    public void testConstructorWithMessageAndUuid() {
        WebAppException exception = new WebAppException("Test message", "uuid-123");
        assertEquals("Test message", exception.getMessage());
        assertEquals("uuid-123", exception.getUuid());
        assertNull(exception.getResume());
    }
}
