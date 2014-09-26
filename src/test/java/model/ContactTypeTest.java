package model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Контактные данные
 */
public class ContactTypeTest extends Assert {
    /**
     * Виды контактных данных
     */
    @Test
    public void contactTypes() {
        assertEquals("Домашний тел.", ContactType.HOME_PHONE.getTitle());
        assertEquals("Тел.", ContactType.PHONE.getTitle());
        assertEquals("Мобильный", ContactType.MOBILE.getTitle());
        assertEquals("Skype", ContactType.SKYPE.getTitle());
        assertEquals("Почта", ContactType.MAIL.getTitle());
        assertEquals("ICQ", ContactType.ICQ.getTitle());
    }

}
