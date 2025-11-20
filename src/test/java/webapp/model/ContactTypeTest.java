package webapp.model;

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

    @Test
    public void testToHtmlPhone() {
        String result = ContactType.PHONE.toHtml("123456");
        assertEquals("Тел.: 123456", result);
    }

    @Test
    public void testToHtmlMobile() {
        String result = ContactType.MOBILE.toHtml("987654");
        assertEquals("Мобильный: 987654", result);
    }

    @Test
    public void testToHtmlHomePhone() {
        String result = ContactType.HOME_PHONE.toHtml("111222");
        assertEquals("Домашний тел.: 111222", result);
    }

    @Test
    public void testToHtmlSkype() {
        String result = ContactType.SKYPE.toHtml("user123");
        assertEquals("<a href='skype:user123'>user123</a>", result);
    }

    @Test
    public void testToHtmlMail() {
        String result = ContactType.MAIL.toHtml("test@example.com");
        assertEquals("<a href='mailto:test@example.com'>test@example.com</a>", result);
    }

    @Test
    public void testToHtmlIcq() {
        String result = ContactType.ICQ.toHtml("123456789");
        assertEquals("ICQ: 123456789", result);
    }
}
