package webapp.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Проверка сложности пароля
 */
public class PasswordComplexity extends Assert {

    /**
     * Проверка сложности пароля
     * null если пароль подходит
     * Или строка с сообщением об ошибке (почему не подходит)
     */
    @Test
    public void testPassword() {
        assertEquals("Пароль слишком короткий, должен быть не менее 8 символов",
                testUserWithPassword("test"));
        assertEquals("Пароль слишком короткий, должен быть не менее 8 символов",
                testUserWithPassword("test23"));
        assertEquals("Пароль слишком короткий, должен быть не менее 8 символов",
                testUserWithPassword("test123"));
    }

    /**
     * Проверка на наличие групп символов
     */
    @Test
    public void testGroupsOfSymbols() {
        assertEquals(User.PASSWORD_NOT_CONTAIN_UPPERCASE_AND_DIGITS,
                testUserWithPassword("testtest"));
        assertEquals("Пароль не содержит строчных букв и цифр",
                testUserWithPassword("TESTTEST"));
        assertEquals("Пароль не содержит цифр",
                testUserWithPassword("testTest"));
        assertEquals("Пароль состоит только из цифр",
                testUserWithPassword("32532523"));
    }

    private String testUserWithPassword(String newPassword) {
        User user = new User();
        user.setNewPassword(newPassword);
        return user.checkPasswordComplexity();
    }
}
