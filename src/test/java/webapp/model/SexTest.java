package webapp.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for Sex enum
 */
public class SexTest extends Assert {

    @Test
    public void checkTitle() {
        assertEquals("Мужской", Sex.MAN.getName());
        assertEquals("Женский", Sex.WOMAN.getName());
    }

    @Test
    public void userSex() {
        User user = new User();
        user.setSex(Sex.WOMAN);
    }

    @Test
    public void testEnumValues() {
        Sex[] values = Sex.values();
        assertEquals(2, values.length);
        assertEquals(Sex.MAN, Sex.valueOf("MAN"));
        assertEquals(Sex.WOMAN, Sex.valueOf("WOMAN"));
    }
}
