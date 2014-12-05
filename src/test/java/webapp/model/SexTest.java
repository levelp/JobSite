package webapp.model;

import org.junit.Assert;
import org.junit.Test;

/**
 *
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
}
