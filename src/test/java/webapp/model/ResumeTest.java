package webapp.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by dimashilin on 26.09.14.
 */
public class ResumeTest extends Assert {
    @Test
    public void Test() {
        User user = new User().createMale("GlobalBubble", "GlobalBubble@mail.ru", "11111");
    }
}
