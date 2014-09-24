package webapp.model.exceptions;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for ProfessionalArea enum
 */
public class ProfessionalAreaTest extends Assert {

    @Test
    public void testEnumValues() {
        // ProfessionalArea is an empty enum
        ProfessionalArea[] values = ProfessionalArea.values();
        assertEquals(0, values.length);
    }

    @Test
    public void testValueOf() {
        // Test that valueOf works on the enum (even if empty)
        try {
            ProfessionalArea.valueOf("NONEXISTENT");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected for non-existent value
            assertNotNull(e);
        }
    }
}
