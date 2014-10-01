package model;

import org.junit.Test;
import sun.jvm.hotspot.utilities.Assert;

import static org.junit.Assert.assertEquals;

/**
 * Created by dimashilin on 26.09.14.
 */
public class ResumeTest extends Assert {
    @Test
    public void Test() {
        User user = new User().createMale("GlobalBubble", "GlobalBubble@mail.ru", "11111");
    }
}
